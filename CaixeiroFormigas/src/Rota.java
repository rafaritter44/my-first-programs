import java.util.ArrayList;

public class Rota {
	
	private ArrayList<Cidade> cidades;
	private double distancia;
	
	public Rota(Cidade inicial, int numCidades) {
		cidades = new ArrayList<Cidade>(numCidades);
		cidades.add(inicial);
		distancia = 0;
	}
	
	public void add(Cidade cidade) {
		Cidade anterior = cidades.get(cidades.size() - 1);
		cidades.add(cidade);
		distancia += cidade.distancia(anterior);
	}
	
	public void finaliza() {
		distancia += cidades.get(0).distancia(cidades.get(cidades.size() - 1));
	}
	
	public ArrayList<Cidade> getCidades() { return new ArrayList<Cidade>(cidades); }
	
	public double getDistancia() { return distancia; }

}
