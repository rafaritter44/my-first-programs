import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Exercicio3
{
    public static void main(String args[])throws FileNotFoundException
    {
        System.out.println("\fPares:");
        pares("inteiros1.txt");
        System.out.println("\nPrimos:");
        primos("inteiros1.txt");
    }
    public static void pares(String nomeArquivo)throws FileNotFoundException
    {
        File origem = new File(nomeArquivo);
        Scanner arquivo = new Scanner(origem);
        
        while(arquivo.hasNextLine())
        {
            int num = Integer.parseInt(arquivo.nextLine());
            if(num%2==0)System.out.println(num);
        }
        arquivo.close();
    }
    public static void primos(String nomeArquivo)throws FileNotFoundException
    {
        File origem = new File(nomeArquivo);
        Scanner arquivo = new Scanner(origem);
        
        while(arquivo.hasNextLine())
        {
            int num = Integer.parseInt(arquivo.nextLine());
            if(isPrime(num))System.out.println(num);
        }
        arquivo.close();
    }
    public static boolean isPrime(int n)
    {
        if(Math.abs(n)<=1)return false;
        int limite = n/2;
        for(int i = 2; i<=limite; i++)
        {
            if(n%i==0)return false;
        }
        return true;
    }
}