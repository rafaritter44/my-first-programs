
public class InOut {
	
	public final Integer momento; //momento na execução em que o processo faz IO
	private Integer tempoExecutado; //tempo que a operação de IO executou até dado momento
	
	public InOut(Integer momento) {
		this.momento = momento;
		tempoExecutado = 0;
	}
	
	public Integer getTempoExecutado() {
		return tempoExecutado;
	}
	
	public Integer getMomento() {
		return momento;
	}
	
	public void executa() {
		tempoExecutado++;
	}

}
