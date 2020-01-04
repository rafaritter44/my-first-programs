import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Exercicio1v2
{
    public static void main(String args[])throws FileNotFoundException
    {
        leitura1("frutas.txt");
        leitura2("frutas.txt");
        leitura3("frutas.txt");
    }
    public static void leitura1(String nomeArquivo)throws FileNotFoundException
    {
        File origem = new File(nomeArquivo);
        Scanner arquivo = new Scanner(origem);
        
        System.out.println("\fFrutas que iniciam com a letra A:");
        while(arquivo.hasNextLine())
        {
            String linha = arquivo.nextLine();
            if(iniciaA(linha))System.out.println(linha);
        }
        arquivo.close();
    }
    public static void leitura2(String nomeArquivo)throws FileNotFoundException
    {
        File origem = new File(nomeArquivo);
        Scanner arquivo = new Scanner(origem);
        
        System.out.println("\nFrutas que possuem pelo menos duas letras A:");
        while(arquivo.hasNextLine())
        {
            String linha = arquivo.nextLine();
            if(doisAs(linha))System.out.println(linha);
        }
        arquivo.close();
    }
    public static void leitura3(String nomeArquivo)throws FileNotFoundException
    {
        File origem = new File(nomeArquivo);
        Scanner arquivo = new Scanner(origem);
        
        System.out.println("\nFrutas que não possuem a letra A:");
        while(arquivo.hasNextLine())
        {
            String linha = arquivo.nextLine();
            if(nenhumA(linha))System.out.println(linha);
        }
        arquivo.close();
    }
    public static boolean iniciaA(String fruta)throws FileNotFoundException
    {
        if(fruta.charAt(0)=='a')return true;
        return false;
    }
    public static boolean doisAs(String fruta)throws FileNotFoundException
    {
        int cont = 0;
        for(int i = 0; i<fruta.length(); i++)
        {
            if(fruta.charAt(i)=='a')cont++;
        }
        if(cont>=2)return true;
        return false;
    }
    public static boolean nenhumA(String fruta)throws FileNotFoundException
    {
        for(int i = 0; i<fruta.length(); i++)
        {
            if(fruta.charAt(i)=='a')return false;
        }
        return true;
    }
}