import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		
		GerenciadorProcessos gp = leitura("trab-so1-teste4.txt");
		gp.ordena();
		
		while(!gp.acabou()) {
			gp.executa();
		}
		
		gp.exibeMedias();
		
	}
	
	private static GerenciadorProcessos leitura(String arquivo) {
		
		GerenciadorProcessos gp = null;
		
		Path path = Paths.get(arquivo);
		try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset()))
		{
			int contador;
			String linha = br.readLine();
			Integer quantidade = Integer.parseInt(linha);
			linha = br.readLine();
			Integer fatiaTempo = Integer.parseInt(linha);
			gp = new GerenciadorProcessos(quantidade, fatiaTempo);
			for(contador = 1; contador <= quantidade; contador++) {
				linha = br.readLine();
				Scanner sc = new Scanner(linha);
				Integer tempoChegada, tempoExecucao, prioridade;
				tempoChegada = sc.nextInt();
				tempoExecucao = sc.nextInt();
				prioridade = sc.nextInt();
				Processo p = new Processo(contador, tempoChegada, tempoExecucao, prioridade);
				while(sc.hasNextInt())
					p.addIO(new InOut(sc.nextInt()));
				gp.addProcesso(p);
				sc.close();
			}
		}
		catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
		return gp;
	}

}
