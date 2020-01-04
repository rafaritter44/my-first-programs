import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class GerenciadorProcessos {
	
	private Processo[] processos; //lista de todos os processos
	private FilaPrioridade filas; //lista dos processos que estão sendo ou já podem ser processados
	private Integer quantidade; //número total de processos
	private static Integer fatiaTempo;
	private Integer contador; //contador de quantos processos há no vetor "processos"
	private Integer contador2; //contador de quantos processos entraram na fila de prioridade
	public final int duracaoIO = 4;
	private static Integer tempo;
	private LinkedList<InOut> operacoesIO; //lista de operações de IO em execução
	
	public GerenciadorProcessos(Integer quantidade, Integer fatiaTempo) {
		this.quantidade = quantidade;
		processos = new Processo[quantidade];
		filas = new FilaPrioridade();
		GerenciadorProcessos.fatiaTempo = fatiaTempo;
		contador = 0;
		contador2 = 0;
		tempo = 1;
		operacoesIO = new LinkedList<InOut>();
	}
	
	public boolean acabou() { //retorna true se tanto a lista de processos quando a fila estiverem vazias
		return contador2 == quantidade && filas.isEmpty(); // i.e., todos os processos executaram
	}
	
	public void exibeMedias() {
		
		int somaTR = 0;
		int somaTE = 0;
		
		System.out.print("\nTR = (");
		for(int i=0; i < quantidade; i++) {
			somaTR += processos[i].tempoResposta();
			System.out.print(processos[i].tempoResposta());
			if(i < quantidade - 1)
				System.out.print(" + ");
		}
		System.out.println(")/" + quantidade + " = " + somaTR + "/" + quantidade + " = " + (double) somaTR / quantidade);
		
		System.out.print("TE = (");
		for(int i=0; i < quantidade; i++) {
			somaTE += processos[i].tempoEspera();
			System.out.print(processos[i].tempoEspera());
			if(i < quantidade - 1)
				System.out.print(" + ");
		}
		System.out.print(")/" + quantidade + " = " + somaTE + "/" + quantidade + " = " + (double) somaTE / quantidade);
		
	}
	
	public void executa() {
		
		int melhorPrioridade = 0;
		Processo processoAnterior = null; //processo de melhor prioridade antes de entrarem novos processos
		if(filas.consulta() != null) {
			melhorPrioridade = filas.consulta().getPrioridade();
			processoAnterior = filas.consulta();
		}

		while(contador2 != quantidade && //se ainda existem processos a serem colocados na fila de prioridade
				(proximoProcesso().getTempoChegada() == tempo - 1 //para todos os processos que chegam no tempo atual
				|| proximoProcesso().getTempoChegada() == tempo)) //OU no tempo anterior, para os casos em que há troca
			chamaProcesso(); //de contexto, e o algoritmo pula 2 tempos de uma vez (tempo += 2;)
		
		if(filas.consulta() == null) { //se não houver nenhum processo para ser executado
			System.out.print("-");
			tempo++;
			return;
		}
		
		boolean novaMelhorPrioridade = false; //caso um novo processo de prioridade superior tenha entrado
		if(filas.consulta().getPrioridade() < melhorPrioridade) //aquele que estava executando perde o processador
			novaMelhorPrioridade = true; //foi decidido que o processo que perde o processador
		//não é jogado para o fim de sua fila, mas permanece no lugar em que estava quando foi removido do processador
		
		Queue<Processo> aux = new LinkedList<Processo>();
		while(fazendoIO(filas.consulta())) { //se o primeiro processo da fila está fazendo IO
			
			aux.add((filas.remove())); //coloca o processo em uma fila auxiliar
			
			if(filas.consulta() == null) { //se não há nenhum processo que não esteja fazendo IO
				
				executaIOs();
				
				boolean algumIOrecemFinalizado = false;
				while(!aux.isEmpty()) {//coloca todos os processos de volta na fila de prioridade (em ordem)
					
					Processo p = aux.remove();
					for(InOut io: p.getOperacoesIO()) { //para todos os IOs desse processo
						if(io.getTempoExecutado() == duracaoIO) { //se o IO foi recém finalizado
							algumIOrecemFinalizado = true; //deverá ser feita a troca de contexto
							operacoesIO.remove(io); //e o IO removido da lista
							p.removeIO(io); //e do processo
						}
					}
					filas.insereOrdenado(p);
				}
				
				if(algumIOrecemFinalizado)
					System.out.print("T");
				else
					System.out.print("-");
				
				tempo++;
				return;
			}
			
		}
		
		//se chegamos nesse ponto, então existem processos para serem executados que não estão fazendo IO
		
		Processo p;
		if(novaMelhorPrioridade)
			p = processoAnterior;
		else
			p = filas.consulta();
		
		
		boolean voltarParaFim = false; //true se o processo deve voltar ao fim da fila
		if(p.ultimaExecucao()) { //se for a última unidade da fatia de tempo
			voltarParaFim = true;
			if(p.finalizado()) {
				p.setFinalExecucao(tempo + 1);
				filas.remove(p);
				voltarParaFim = false; //se o processo acabou e foi removido, não pode voltar para a fila
			}
			
			for(InOut io: p.getOperacoesIO())
				if(p.getTempoExecutado() == io.momento) //se houver operação de IO nesse momento, atendê-la
					addIO(io); //adiciona IO à lista de IOs em execução
			
			executaIOs();
			System.out.print(p.getId() + "T");
			tempo += 2;
		} else {
		
			boolean nenhumIO = true;
			for(InOut io: p.getOperacoesIO())
				if(p.getTempoExecutado() == io.momento) { //se houver operação de IO nesse momento, atendê-la
					voltarParaFim = true;
					if(p.finalizado()) {
						p.setFinalExecucao(tempo + 1);
						filas.remove(p);
						voltarParaFim = false; //se o processo acabou e foi removido, não pode voltar para a fila
					}
					addIO(io); //adiciona IO à lista de IOs em execução
					executaIOs();
					System.out.print(p.getId() + "T");
					tempo += 2;
					nenhumIO = false;
				}
			
			if(nenhumIO) {
				
				executaIOs();
				
				if(novaMelhorPrioridade) {
					if(p.finalizado()) {
						p.setFinalExecucao(tempo + 1);
						filas.remove(p);
					}
					System.out.print(p.getId() + "T");
					tempo += 2;
				} else {
					
					if(p.finalizado()) {
						p.setFinalExecucao(tempo + 1);
						filas.remove(p);
						System.out.print(p.getId() + "T");
						tempo += 2;
						
					} else {
						System.out.print(p.getId());
						tempo++;
					}
					
				}
				
			}
				
		}
		
		//coloca processos que estão fazendo IO de volta na fila
		while(!aux.isEmpty()) //isso teve que ser feito agora caso houvesse um processo de maior prioridade fazendo IO
			filas.insereOrdenado(aux.remove()); //se ele voltasse à fila antes, seria colocado na frente dos outros
		// que não estão fazendo IO e seria executado
		
		if(voltarParaFim)
			filas.insereOrdenado(filas.remove(p)); //volta para o fim da fila
	}
	
	private boolean fazendoIO(Processo p) { //verifica se o processo está fazendo alguma operação de IO
		for(InOut ioExecutando: operacoesIO)
			for(InOut ioDoProcesso: p.getOperacoesIO())
				if(ioExecutando == ioDoProcesso) { //se o IO do processo está na lista de execução
					if(ioExecutando.getTempoExecutado() > duracaoIO) { //se o IO já executou o suficiente
						operacoesIO.remove(ioExecutando); //removê-lo da lista
						p.getOperacoesIO().remove(ioExecutando); //e do processo
					}
					else return true; //senão, o IO ainda está em execução
				}
		return false;
	}
	
	private void executaIOs() {
		for(InOut io: operacoesIO)
			io.executa();
	}
	
	public void ordena() { //ordem em que os processos vão sair da coleção "processos" e entrar na coleção "filas"
		Arrays.sort(processos,
				Comparator.comparing(Processo::getTempoChegada)
				.thenComparing(Processo::getPrioridade)
				.thenComparing(Processo::getId));
		
		ordenaIO();
	}
	
	private void ordenaIO() { //ordena os IOs de todos os processos
		for(Processo p: processos)
			p.ordenaIOs();
	}
	
	public void addProcesso(Processo p) {
		processos[contador] = p;
		contador++;
	}
	
	public void chamaProcesso() { //coloca próximo processo da lista na fila de prioridade
		filas.insereOrdenado(processos[contador2]);
		contador2++;
	}
	
	public Processo proximoProcesso() { //consulta o próximo processo da lista de processos sem movê-lo para a fila
		return processos[contador2];
	}
	
	public Processo[] getProcessos() {
		return processos.clone();
	}
	
	public FilaPrioridade getFilas() {
		return filas;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public static Integer getFatiaTempo() {
		return fatiaTempo;
	}
	
	public static Integer getTempo() {
		return tempo;
	}
	
	public LinkedList<InOut> getOperacoesIO() {
		return new LinkedList<InOut>(operacoesIO);
	}
	
	public void addIO(InOut io) {
		operacoesIO.add(io);
	}
	
	public void removeIO(InOut io) {
		operacoesIO.remove(io);
	}

}
