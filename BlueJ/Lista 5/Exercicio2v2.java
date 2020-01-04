import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Exercicio2v2
{
    public static void main(String args[])throws FileNotFoundException
    {
        System.out.println("\fMaior valor: " + maior("reais.txt"));
        System.out.println("Menor valor: " + menor("reais.txt"));
        System.out.println("Média: " + media("reais.txt"));
    }
    public static double maior(String nomeArquivo)throws FileNotFoundException
    {
        File origem = new File(nomeArquivo);
        Scanner arquivo = new Scanner(origem);
        
        double maior = Double.parseDouble(arquivo.nextLine());
        while(arquivo.hasNextLine())
        {
            double num = Double.parseDouble(arquivo.nextLine());
            if(num>maior)maior=num;
        }
        arquivo.close();
        return maior;
    }
    public static double menor(String nomeArquivo)throws FileNotFoundException
    {
        File origem = new File(nomeArquivo);
        Scanner arquivo = new Scanner(origem);
        
        double menor = Double.parseDouble(arquivo.nextLine());
        while(arquivo.hasNextLine())
        {
            double num = Double.parseDouble(arquivo.nextLine());
            if(num<menor)menor=num;
        }
        arquivo.close();
        return menor;
    }
    public static double media(String nomeArquivo)throws FileNotFoundException
    {
        File origem = new File(nomeArquivo);
        Scanner arquivo = new Scanner(origem);
        
        int cont = 0;
        double soma = 0;
        while(arquivo.hasNextLine())
        {
            double num = Double.parseDouble(arquivo.nextLine());
            soma+=num;
            cont++;
        }
        arquivo.close();
        return soma/cont;
    }
}