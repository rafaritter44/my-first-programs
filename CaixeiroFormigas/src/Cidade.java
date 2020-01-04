
public class Cidade {

	private String nome;
	private double x;
	private double y;
	
	public Cidade(String nome, double x, double y) {
		this.nome = nome;
		this.x = x;
		this.y = y;
	}
	
	public String getNome() { return nome; }
	
	public double getX() { return x; }
	
	public double getY() { return y; }
	
	public double distancia(Cidade cidade) {
		return Math.sqrt(Math.pow(cidade.x - x, 2) + Math.pow(cidade.y - y, 2));
	}
	
}
