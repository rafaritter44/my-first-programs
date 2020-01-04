import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	//Parâmetros
	private static final int iteracoes = 35;
	private static final double alfa = 1.0;
	private static final double beta = 6.0;
	private static final double rho = 0.6;
	private static final double q = 1.0;
	private static final double feromonioInicial = 1.0;

	public static void main(String[] args) {
		
		//criarCasos();
		
		Colonia colonia = ler("caso1.txt");
		double tempoInicial = System.currentTimeMillis();
		inicializa(colonia);
		for(int i = 1; i <= iteracoes; i++)
			System.out.println("Iteração " + i + ": " + colonia.iteracao());
		double tempoFinal = System.currentTimeMillis();
		double tempoTotal = tempoFinal - tempoInicial;
		melhorRota(colonia);
		System.out.println("Tempo de execução: " + tempoTotal + " milissegundos");
		
	}
	
	private static void melhorRota(Colonia colonia) {
		ArrayList<Cidade> cidades = colonia.getMelhor().getCidades();
		System.out.print("Melhor rota encontrada:");
		for(Cidade cidade: cidades)
			System.out.print(" " + cidade.getNome());
		System.out.println("\nDistância total: " + colonia.getMelhor().getDistancia());
	}
	
	static void criarCasos() {
		gerar("caso1.txt", 10);
		gerar("caso2.txt", 25);
		gerar("caso3.txt", 50);
		gerar("caso4.txt", 100);
		gerar("caso5.txt", 200);
	}
	
	private static void inicializa(Colonia colonia) {
		colonia.inicializaFeromonios(feromonioInicial);
		LinkedList<Cidade> cidades = Colonia.getCidades();
		for(Cidade cidade: cidades) //Uma formiga para cada cidade
			colonia.addFormiga(new Formiga(cidade));
		colonia.setAlfa(alfa);
		colonia.setBeta(beta);
		colonia.setRho(rho);
		colonia.setQ(q);
	}
	
	private static Colonia ler(String arquivo) {
		Colonia colonia = null;
		Path path = Paths.get(arquivo);
		try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
			String linha = br.readLine();
			colonia = new Colonia(Integer.parseInt(linha));
			while((linha = br.readLine()) != null) {
				Scanner sc = new Scanner(linha);
				String nome = sc.next();
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				colonia.addCidade(new Cidade(nome, x, y));
				sc.close();
			}
		}
		catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
		catch (IllegalArgumentException x) {
			System.err.format("Argumento inválido: %s%n", x);
		}
		return colonia;
	}
	
	//Formato do arquivo: primeira linha contém o número de cidades
	//Depois disso: cada cidade em uma linha, cada linha contendo nome da cidade, espaço, x, espaço, y
	//Exemplo de linha: c1 10 20
	private static void gerar(String arquivo, int numCidades) {
		Random gerador = new Random();
		Path path = Paths.get(arquivo);
		try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.forName("utf8")))) {
			writer.format("%d%n", numCidades);
			for(int i = 1; i <= numCidades; i++) {
				String nome = "c" + i;
				double x = gerador.nextDouble() * (gerador.nextInt(9999) + 1);
				double y = gerador.nextDouble() * (gerador.nextInt(9999) + 1);
				writer.format(Locale.US, "%s %.2f %.2f%n", nome, x, y);
			}
		}
		catch(IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
	}

}
