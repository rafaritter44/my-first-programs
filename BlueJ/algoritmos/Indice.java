import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Indice
{
    private int stopWords;
    private int totalPalavras;
    private Lista lista;
    private String arquivo;
    
    public Indice()
    {
        stopWords = 0;
        totalPalavras = 0;
    }
    
    public void leitura(String arquivo)
    {
        lista = new Lista();
        this.arquivo = arquivo;
        Path path = Paths.get(arquivo);
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset()))
        {
            String linha = null;
            int contLinha = 1;
            while((linha = br.readLine()) != null)
            {
                Scanner sc = new Scanner(linha);
                String pal;
                while(sc.hasNext())
                {
                    pal = sc.next().toLowerCase();
                    pal = pal.replace(",", "");
                    pal = pal.replace(".", "");
                    pal = pal.replace(":", "");
                    pal = pal.replace(";", "");
                    pal = pal.replace("!", "");
                    pal = pal.replace("?", "");
                    pal = pal.replace("(", "");
                    pal = pal.replace(")", "");
                    pal = pal.replace("-", "");
                    pal = pal.replace("'", "");
                    pal = pal.replace("\"", "");
                    pal = pal.replace("*", "");
                    pal = pal.replace("[", "");
                    pal = pal.replace("]", "");
                    pal = pal.replace("_", "");
                    pal = pal.replace("0", "");
                    pal = pal.replace("1", "");
                    pal = pal.replace("2", "");
                    pal = pal.replace("3", "");
                    pal = pal.replace("4", "");
                    pal = pal.replace("5", "");
                    pal = pal.replace("6", "");
                    pal = pal.replace("7", "");
                    pal = pal.replace("8", "");
                    pal = pal.replace("9", "");
                    if(isSWord(pal))
                    {
                        stopWords++;
                        totalPalavras++;
                    }
                    else if(pal.length()>0)
                    {
                        lista.add(pal, contLinha);
                        totalPalavras++;
                    }
                }
                contLinha++;
            }
        }
        catch (IOException x)
        {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
    
    public void exibirPagina(int pagina, String palavra)
    {
        int primeiraLinha = pagina*40 - 39;
        int ultimaLinha = pagina*40;
        
        Path path = Paths.get(arquivo);
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset()))
        {
            String linha = null;
            int contLinha = 1;
            while((linha = br.readLine()) != null)
            {
                Scanner sc = new Scanner(linha);
                String pal;
                while(sc.hasNext())
                {
                    pal = sc.next();
                    if(contLinha>=primeiraLinha && contLinha<=ultimaLinha) 
                    {
                        if(pal.equals(palavra)) pal = "[" + pal + "]";
                        System.out.print(pal + " ");
                    }
                }
                contLinha++;
                if(contLinha>ultimaLinha) break;
                System.out.println();
            }
        }
        catch (IOException x)
        {
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
    
    public int[] buscaPalavra(String pal)
    {
        return lista.buscaPalavra(pal);
    }
    
    public void maisIndex()
    {
        int[] a = lista.paginaMaisComplexa();
        System.out.println("\nA página mais complexa é a " + a[0] + ", com " + a[1] + " palavras indexadas.");
    }
    
    public double porcentagemStopWords()
    {
        return 100.0*stopWords/totalPalavras;
    }
    
    public String palavraMaisFrequente()
    {
        return lista.palavraMaisFrequente();
    }
    
    public void exibir()
    {
        System.out.println(lista);
    }
    
    public boolean isSWord(String palavra)
    {
        Path path = Paths.get("stopwords.txt"); 
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("utf8"))))
        {
            String pal = null;
            while (sc.hasNext())
            {
                pal = sc.next();
                if (pal.equals(palavra))
                {
                    return true;
                }
            }
        }
        catch (IOException x)
        {
            System.err.format("Erro de E/S: %s%n", x);
        }
        return false;
    }
}