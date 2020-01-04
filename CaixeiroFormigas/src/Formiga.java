import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Formiga {
	
	private Rota rota;
	private LinkedList<Cidade> restantes;
	private Cidade inicial;
	
	public Formiga(Cidade inicial) {
		this.inicial = inicial;
	}
	
	public Rota getRota() { return rota; }
	
	public double distancia() { return rota.getDistancia(); }
	
	public boolean passouPor(Cidade cidade1, Cidade cidade2) {
		ArrayList<Cidade> cidades = rota.getCidades();
		int limite = cidades.size() - 1;
		for(int i = 0; i < limite; i++) {
			if(cidades.get(i).equals(cidade1) || cidades.get(i).equals(cidade2)) {
				Cidade proxima = cidades.get(i+1);
				if(cidade1.equals(proxima) || cidade2.equals(proxima))
					return true;
			}
		}
		Cidade primeira = cidades.get(0);
		Cidade ultima = cidades.get(cidades.size() - 1);
		if(cidade1.equals(primeira) && cidade2.equals(ultima))
			return true;
		if(cidade2.equals(primeira) && cidade1.equals(ultima))
			return true;
		return false;
	}
	
	public void setRota() {
		restantes = Colonia.getCidades();
		Cidade atual = inicial;
		rota = new Rota(atual, restantes.size());
		restantes.remove(atual);
		int limite = restantes.size() - 1;
		for(int i = 0; i < limite; i++) {
			atual = proxima(atual);
			rota.add(atual);
		}
		rota.finaliza();
	}
	
	private Cidade proxima(Cidade atual) {
		ArrayList<Double> probabilidades = new ArrayList<Double>(restantes.size());
		double somaProbabilidades = 0.0;
		for(Cidade cidade: restantes) {
			double probabilidade = Math.pow(Colonia.getFeromonio(atual, cidade), Colonia.getAlfa())
					* Math.pow(1.0/atual.distancia(cidade), Colonia.getBeta());
			probabilidades.add(probabilidade);
			somaProbabilidades += probabilidade;
		}
		Random gerador = new Random();
		double escolha = gerador.nextDouble();
		double probabilidade = 0;
		for(int i = 0; i < probabilidades.size(); i++) {
			probabilidade += probabilidades.get(i) / somaProbabilidades;
			if(probabilidade > escolha)
				return restantes.remove(i);
		}
		return null;
	}
	

}
