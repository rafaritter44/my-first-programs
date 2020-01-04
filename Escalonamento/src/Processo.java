import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Processo {
	
	private Integer id;
	private Integer tempoChegada;
	private Integer tempoExecucao;
	private Integer prioridade;
	private LinkedList<InOut> operacoesIO;
	private Integer tempoExecutado;
	private Integer fatiaTempoAtual;
	private Integer inicioExecucao; //momento em que o processo começou a executar
	private Integer finalExecucao; //momento em que o processo terminou

	public Processo(Integer id, Integer tempoChegada, Integer tempoExecucao, Integer prioridade) {
		this.id = id;
		this.tempoChegada = tempoChegada;
		this.tempoExecucao = tempoExecucao;
		this.prioridade = prioridade;
		operacoesIO = new LinkedList<InOut>();
		tempoExecutado = 0;
		fatiaTempoAtual = GerenciadorProcessos.getFatiaTempo();
	}
	
	public boolean ultimaExecucao() { //executa e returna true caso seja a última unidade da fatia de tempo

		if(tempoExecutado == 0)
			inicioExecucao = GerenciadorProcessos.getTempo();
		
		tempoExecutado++;
		
		if(fatiaTempoAtual == 1) { //reinicia a fatia de tempo
			fatiaTempoAtual = GerenciadorProcessos.getFatiaTempo();
			return true;
		}
		
		fatiaTempoAtual--;
		return false;
	}
	
	public Integer getInicioExecucao() {
		return inicioExecucao;
	}
	
	public boolean finalizado() { //retorna true se o tempo executado equivale ao tempo total de execução
		return tempoExecucao == tempoExecutado;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getTempoChegada() {
		return tempoChegada;
	}
	
	public Integer getTempoExecucao() {
		return tempoExecucao;
	}
	
	public Integer getPrioridade() {
		return prioridade;
	}
	
	public Integer getTempoExecutado() {
		return tempoExecutado;
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
	
	public void ordenaIOs() {
		Collections.sort(operacoesIO,
				Comparator.comparing(InOut::getMomento));
	}
	
	public Integer getFatiaTempoAtual() {
		return fatiaTempoAtual;
	}
	
	public void setFinalExecucao(Integer finalExecucao) {
		this.finalExecucao = finalExecucao;
	}
	
	public Integer getFinalExecucao() {
		return finalExecucao;
	}
	
	public Integer tempoResposta() {
		return inicioExecucao - tempoChegada;
	}
	
	public Integer tempoEspera() {
		return finalExecucao - tempoChegada - tempoExecucao;
	}

}
