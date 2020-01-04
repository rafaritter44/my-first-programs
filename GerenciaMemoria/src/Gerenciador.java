import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Gerenciador {
	
	private static int tamPagina; //Número de endereços que cada página possui 
	private int numPaginasMemoria;
	private int numPaginasDisco;
	private Queue<Pagina> paginasMemoria; //Fila de páginas na ordem de menos recentemente usada (LRU)
	private ArrayList<Pagina> paginasDisco;
	private ArrayList<Processo> processos;
	private Algoritmo algoritmo; //LRU ou aleatório
	private Random seletor; //Objeto que seleciona aleatoriamente
	private boolean[] posicoes; //Representa a ordem das páginas na memória física
	//Se a posição 0 é true, então a primeira página da memória está ocupada, e assim por diante
	private static List<String> comandos; //Lista de comandos a serem executados
	private int numThreads = 5; //Número de threads criadas para o caso do modo aleatório
	public static final int enderecoLimite = 32; //Número máximo de endereços solicitados pela thread aleatória
	private ArrayList<Thread> threads;
	private static int threadsTerminadas; //Número de threads que já terminaram
	
	public Gerenciador(int tamPagina, int tamMemoria, int tamDisco, String algoritmo) {
		Gerenciador.tamPagina = tamPagina;
		this.numPaginasMemoria = tamMemoria/tamPagina;
		paginasMemoria = new LinkedList<Pagina>();
		paginasDisco = new ArrayList<Pagina>(numPaginasDisco = tamDisco/tamPagina);
		processos = new ArrayList<Processo>();
		if(algoritmo.equalsIgnoreCase("lru"))
			this.algoritmo = Algoritmo.LRU;
		else {
			this.algoritmo = Algoritmo.ALEATORIO;
			seletor = new Random();
		}
		posicoes = new boolean[numPaginasMemoria];
	}
	
	/*
	 * Método que faz a execução dos comandos
	 * tanto no modo aleatório quanto no sequencial
	 */
	public void executa() {
		if(comandos != null) //Se já existe uma lista de comando pré-definida 
			for(String comando: comandos) //Então é o modo sequencial
				executaComando(comando); //Executa todos os comandos em sequência
		else { //Caso contrário
			threads = new ArrayList<Thread>(numThreads); //Cria threads
			int limite = numThreads;
			for(int i = 1; i <= limite; i++) {
				String id = "p" + i;
				int numProcessos = processos.size();
				executaComando("C " + id + " " + (seletor.nextInt(enderecoLimite) + 1));
				if(processos.size() > numProcessos) //Só cria a thread se o processo pode ser criado
					threads.add(new Thread(new ProcessoThread(id)));
				else
					numThreads--;
			}
			inicializaComandos();
			for(Thread thread: threads)
				thread.start(); //E as executa
			while(threadsTerminadas < numThreads || !comandos.isEmpty()) { //Até que todas terminem
				if(!comandos.isEmpty()) { //e não haja mais comandos para executar
					String comando = comandos.get(0);
					executaComando(comando);
					comandos.remove(0);
				}
			}
		}
	}
	
	/*
	 * Indica que uma thread terminou
	 */
	public static void terminaThread() { threadsTerminadas++; }
	
	/*
	 * Método que recebe o comando e chama os outros métodos que o executam
	 * de acordo com o processo informado, e com tamanho/endereço, se for o caso
	 */
	private void executaComando(String comando) {
		System.out.print(comando + ": ");
		Scanner sc = new Scanner(comando);
		String selecao = sc.next();
		switch(selecao) {
		case "C":
			String processo = sc.next();
			int enderecos = sc.nextInt();
			String estadoAnterior = estado();
			Resultado resultado = criaProcesso(processo, enderecos);
			switch(resultado) {
			case SUCESSO:
				System.out.println(paginasNecessarias(enderecos) +
						" página(s) alocada(s) para o processo " + processo);
				break;
			case PAGE_FAULT:
				System.out.print("PAGE FAULT" +
						"\nAntes:\n" + estadoAnterior +
						"Estado atual:\n" + estado());
				break;
			case NO_MEMORY:
				System.out.println("NO MEMORY");
				default:
			}
			break;
		case "A":
			processo = sc.next();
			int endereco = sc.nextInt();
			estadoAnterior = estado();
			resultado = acessa(processo, endereco);
			switch(resultado) {
			case SUCESSO:
				System.out.println("Endereço " + endereco + " do processo " + processo + " acessado");
				break;
			case PAGE_FAULT:
				System.out.print("PAGE FAULT" +
						"\nAntes:\n" + estadoAnterior +
						"Estado atual:\n" + estado());
				break;
			case SEGMENTATION_FAULT:
				System.out.println("SEGMENTATION FAULT");
				default:
			}
			break;
		case "M":
			processo = sc.next();
			enderecos = sc.nextInt();
			Processo p = getProcesso(processo);
			int numPaginas = p.getPaginas().size();
			estadoAnterior = estado();
			resultado = aloca(processo, enderecos);
			switch(resultado) {
			case SUCESSO:
				System.out.println((p.getPaginas().size() - numPaginas) +
						" página(s) alocada(s) para o processo " + processo);
				break;
			case PAGE_FAULT:
				System.out.print("PAGE FAULT" +
						"\nAntes:\n" + estadoAnterior +
						"Estado atual:\n" + estado());
				break;
			case NO_MEMORY:
				System.out.println("NO MEMORY");
				default:
			}
			break;
		case "T":
			processo = sc.next();
			terminaProcesso(processo);
			System.out.println("Processo " + processo + " terminado");
		}
		sc.close();
	}
	
	/*
	 * Retorna o estado atual da memória e do disco
	 */
	private String estado() {
		String memoria = "Memória:\n";
		for(int i = 0; i < numPaginasMemoria; i++) {
			memoria += "Página " + i + ": ";
			if(posicoes[i]) { //Se a posição i da memória está ocupada
				boolean paginaEncontrada = false;
				for(Processo processo: processos) { //Procura em qual processo
					ArrayList<Pagina> paginas = processo.getPaginas();
					for(int j = 0; j < paginas.size(); j++) { //e em qual página está
						Pagina pagina = paginas.get(j);
						if(pagina.isEmMemoria() && pagina.getPosicao() == i) { //Deve estar em memória
							memoria += "página " + j + " do processo " + processo.getId();
							paginaEncontrada = true;
							break;
						}
					}
					if(paginaEncontrada)
						break;
				}
			}
			else //Se não está ocupada
				memoria += "-";
			memoria += "\n";
		}
		String disco = "Disco:\n";
		int contador;
		for(contador = 0; contador < paginasDisco.size(); contador++) { //Para cada página que está em disco 
			disco += "Página " + contador + ": ";
			Pagina pagina = paginasDisco.get(contador);
			boolean paginaEncontrada = false;
			for(Processo processo: processos) { //Procura em qual processo
				ArrayList<Pagina> paginas = processo.getPaginas();
				for(int i = 0; i < paginas.size(); i++) { //e em qual página está
					Pagina candidata = paginas.get(i); //A página deve estar em disco
					if(!candidata.isEmMemoria() && candidata.getPosicao() == pagina.getPosicao()) {
						disco += "página " + i + " do processo " + processo.getId() + "\n";
						paginaEncontrada = true;
						break;
					}
				}
				if(paginaEncontrada)
					break;
			}
		}
		for(; contador < numPaginasDisco; contador++) //Para as páginas em disco não ocupadas
			disco += "Página " + contador + ": -\n";
		return memoria + disco;
	}
	
	public static void addComando(String comando) { comandos.add(comando); }
	
	public void inicializaComandos() { comandos = Collections.synchronizedList(new LinkedList<String>()); }
	
	private Resultado acessa(String id, int endereco) {
		Processo processo = getProcesso(id);
		if(endereco >= processo.getTamanho()) //Endereço fora da área de acesso
			return Resultado.SEGMENTATION_FAULT;
		Pagina pagina = processo.getPagina(endereco);
		if(pagina.isEmMemoria()) { //Se página está em memória, acessa endereço e atualiza fila,
			paginasMemoria.remove(pagina); //realocando a página para o fim da fila
			paginasMemoria.add(pagina);
			return Resultado.SUCESSO;
		}
		trazParaMemoria(pagina); //Se a página está em disco, traz para a memória
		return Resultado.PAGE_FAULT;
	}
	
	/*
	 * Método que traz a página informado do disco para a memória
	 */
	private void trazParaMemoria(Pagina pagina) {
		paginasDisco.remove(pagina);
		if(paginasMemoria.size() == numPaginasMemoria) { //Se memória está cheia,
			Pagina vitima = vitima(); //retira a vítima da memória,
			paginasDisco.add(vitima); //coloca a vítima em disco
			int posicao = vitima.getPosicao();
			pagina.setPosicao(posicao); //A página recebe o lugar da vítima
			posicoes[posicao] = true;
		} else { //Se há espaço na memória
			int posicao;
			for(posicao = 0; posicao < posicoes.length; posicao++)
				if(posicoes[posicao] == false) //Encontra o primeiro lugar livre
					break;
			pagina.setPosicao(posicao);
			posicoes[posicao] = true;
		}
		paginasMemoria.add(pagina);
		pagina.setEmMemoria(true);
	}
	
	/*
	 * Retorna o número de páginas necessárias para alocar n endereços de memória
	 */
	private int paginasNecessarias(int enderecos) {
		return (int) Math.ceil((double) enderecos/tamPagina);
	}
	
	/*
	 * Retorna o número restante de páginas em memória
	 */
	private int paginasRestantes() { return numPaginasMemoria - paginasMemoria.size(); }
	
	/*
	 * Seleciona e remove a vítima da fila de páginas, com base ou no LRU, ou no algoritmo
	 * aleatório, dependendo do que tiver sido determinado inicialmente
	 */
	private Pagina vitima() {
		Pagina vitima = null;
		if(algoritmo == Algoritmo.LRU)
			vitima = paginasMemoria.poll();
		else {
			int escolha = seletor.nextInt(paginasMemoria.size());
			int contador = 0;
			for(Pagina pagina: paginasMemoria) {
				if(contador == escolha) {
					vitima = pagina;
					paginasMemoria.remove(pagina);
					break;
				}
				contador++;
			}
		}
		vitima.setEmMemoria(false);
		posicoes[vitima.getPosicao()] = false;
		return vitima;
	}
	
	private Resultado alocacao(Processo processo, int espaco) {
		int paginasNecessariasInicialmente = paginasNecessarias(espaco);
		int paginasNecessarias = paginasNecessariasInicialmente;
		int paginasRestantes = paginasRestantes();
		if(paginasNecessarias > paginasRestantes) { //Se não há páginas suficientes em memória
			for(int i = 0; i < paginasRestantes; i++) { //Aloca todas as páginas disponíveis em memória
				Pagina pagina = criaPagina();
				processo.addPagina(pagina);
				paginasMemoria.add(pagina);
			}
			paginasNecessarias -= paginasRestantes;
			while(paginasDisco.size() < numPaginasDisco) { //Seleciona vítima e manda para o disco
				paginasDisco.add(vitima()); //até encher o disco
				Pagina pagina = criaPagina();
				processo.addPagina(pagina);
				paginasMemoria.add(pagina);
				paginasNecessarias--;
				if(paginasNecessarias == 0) { //ou até alocar o número necessário de páginas
					processo.aloca(espaco); //Atualiza o espaço alocado e
					return Resultado.PAGE_FAULT; //avisa page fault
				}
			} //Se não alocou todas as páginas necessárias, então faltou memória
			processo.aloca((paginasNecessariasInicialmente - paginasNecessarias)
					* tamPagina); //Aloca o máximo que foi possível
			return Resultado.NO_MEMORY; //e avisa que faltou memória
		}
		for(int i = 0; i < paginasNecessarias; i++) { //Se há páginas suficientes em memória,
			Pagina pagina = criaPagina(); //apenas as aloca e avisa que a operação foi bem-sucedida
			processo.addPagina(pagina);
			paginasMemoria.add(pagina);
		}
		processo.aloca(espaco);
		return Resultado.SUCESSO;
	}
	
	private Resultado criaProcesso(String id, int tamanho) {
		if(paginasMemoria.size() == numPaginasMemoria //Se memória está cheia
				&& paginasDisco.size() == numPaginasDisco) //e disco está cheio
			return Resultado.NO_MEMORY; //Avisa que não tem memória
		Processo processo = new Processo(id);
		processos.add(processo);
		return alocacao(processo, tamanho);
	}
	
	/*
	 * Retorna o processo com o ID informado
	 */
	private Processo getProcesso(String id) {
		for(Processo processo: processos)
			if(processo.getId().equals(id)) {
				return processo;
			}
		return null;
	}
	
	private Resultado aloca(String id, int espaco) {
		Processo processo = getProcesso(id);
		if(processo.isFragmentado()) { //Se o número de endereços alocados pelo processo não é múltiplo do
			Pagina pagina = processo.getPagina(processo.getTamanho()); //tamanho da página, então aloca
			if(pagina.isEmMemoria()) { //memória até que seja, ou até alocar todo o espaço desejado
				paginasMemoria.remove(pagina); //Atualiza posição da página na fila
				paginasMemoria.add(pagina); //caso esteja em memória
			} else { //Caso contrário
				trazParaMemoria(pagina); //Traz a página para a memória
			}
			int enderecosFragmentados = processo.enderecosFragmentados();
			if(enderecosFragmentados >= espaco) {
				processo.aloca(espaco);
				return Resultado.SUCESSO;
			}
			processo.aloca(enderecosFragmentados);
			return alocacao(processo, espaco - enderecosFragmentados);
		}
		return alocacao(processo, espaco);
	}
	
	/*
	 * Retira o processo da lista de processos, bem como suas respectivas páginas
	 */
	private void terminaProcesso(String id) {
		Processo processo = null;
		for(int i = 0; i < processos.size(); i++)
			if(processos.get(i).getId().equals(id)) {
				processo = processos.remove(i);
				break;
			}
		for(Pagina pagina: processo.getPaginas()) {
			if(paginasMemoria.remove(pagina))
				posicoes[pagina.getPosicao()] = false;
			paginasDisco.remove(pagina);
		}
	}
	
	/*
	 * Cria nova página na primeira posição de memória física que estiver livre
	 */
	private Pagina criaPagina() {
		int posicao;
		for(posicao = 0; posicao < posicoes.length; posicao++)
			if(posicoes[posicao] == false)
				break;
		Pagina pagina = new Pagina(posicao);
		posicoes[posicao] = true;
		return pagina;
	}
	
	public static int getTamPagina() { return tamPagina; }
	
}
