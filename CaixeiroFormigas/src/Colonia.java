import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Colonia {

	private ArrayList<Formiga> formigas;
	private static ArrayList<Cidade> cidades;
	private static HashMap<String, Double> feromonios; //chave = cidade1 + " " + cidade2 (por ordem alfabética)
	private static double alfa;
	private static double beta;
	private double rho;
	private double q;
	private Rota melhor;
	
	public Colonia(int numCidades) {
		formigas = new ArrayList<Formiga>(numCidades); //Uma formiga para cada cidade
		cidades = new ArrayList<Cidade>(numCidades);
		feromonios = new HashMap<String, Double>((((int) Math.ceil(numCidades * (numCidades - 1) / 1.5))));
		//Dados n nodos, haverá n * (n - 1) / 2 arestas no grafo, uma vez que o grafo não é dirigido
		//e todos nodos conectam com todos. Divide-se o resultado por 0.75 para otimizar o HashMap
		melhor = new Rota(new Cidade(null, Double.MAX_VALUE, 0), 2);
		melhor.add(new Cidade(null, 0, 0));
	}
	
	public double iteracao() {
		double menorDistancia = Double.MAX_VALUE;
		for(Formiga formiga: formigas) {
			formiga.setRota();
			if(formiga.distancia() < menorDistancia) {
				menorDistancia = formiga.distancia();
				if(menorDistancia < melhor.getDistancia())
					melhor = formiga.getRota();
			}
		}
		atualizaFeromonios();
		return menorDistancia;
	}
	
	public void inicializaFeromonios(double feromonio) {
		for(Cidade cidade1: cidades)
			for(Cidade cidade2: cidades)
				if(cidade1 != cidade2)
					setFeromonio(cidade1, cidade2, feromonio);
	}
	
	private void atualizaFeromonios() {
		for(Cidade cidade1: cidades)
			for(Cidade cidade2: cidades)
				if(cidade1 != cidade2) {
					double feromonio = rho * getFeromonio(cidade1, cidade2);
					for(Formiga formiga: formigas) {
						if(formiga.passouPor(cidade1, cidade2))
							feromonio += q / formiga.distancia();
					}
					setFeromonio(cidade1, cidade2, feromonio);
				}
	}
	
	public static double getFeromonio(Cidade cidade1, Cidade cidade2) {
		String nomeCidade1 = cidade1.getNome();
		String nomeCidade2 = cidade2.getNome();
		if(nomeCidade1.compareTo(nomeCidade2) > 0) {
			String aux = nomeCidade1;
			nomeCidade1 = nomeCidade2;
			nomeCidade2 = aux;
		}
		return feromonios.get(nomeCidade1 + " " + nomeCidade2);
	}
	
	public void setFeromonio(Cidade cidade1, Cidade cidade2, double valor) {
		String nomeCidade1 = cidade1.getNome();
		String nomeCidade2 = cidade2.getNome();
		if(nomeCidade1.compareTo(nomeCidade2) > 0) {
			String aux = nomeCidade1;
			nomeCidade1 = nomeCidade2;
			nomeCidade2 = aux;
		}
		String chave = nomeCidade1 + " " + nomeCidade2;
		feromonios.put(chave, valor);
	}
	
	public static double getAlfa() { return alfa; }
	
	public static double getBeta() { return beta; }
	
	public void setAlfa(double alfa) { Colonia.alfa = alfa; }
	
	public void setBeta(double beta) { Colonia.beta = beta; }
	
	public void setRho(double rho) { this.rho = rho; }
	
	public void setQ(double q) { this.q = q; }
	
	public void addFormiga(Formiga formiga) { formigas.add(formiga); }
	
	public void addCidade(Cidade cidade) { cidades.add(cidade); }
	
	public static LinkedList<Cidade> getCidades() { return new LinkedList<Cidade>(cidades); }
	
	public Rota getMelhor() { return melhor; }
	
}
