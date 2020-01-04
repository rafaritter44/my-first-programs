import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Exercicio4
{
    public static void main(String args[])throws FileNotFoundException
    {
        File origem = new File("inteiros2.txt");
        Scanner arquivo = new Scanner(origem);
        PrintWriter gravador = new PrintWriter("exercicio.txt");
        
        while(arquivo.hasNextLine())
        {
            int n = Integer.parseInt(arquivo.nextLine());
            if(n<17)gravador.println("Σ" + n + " = " + somatorio(n) + ", " + n + "! = " + fatorial(n));
            else gravador.println("Σ" + n + " = " + somatorio(n));
        }
        arquivo.close();
        gravador.close();
    }
    public static int somatorio(int n)
    {
        if(n<=0)return 0;
        return n + somatorio(n-1);
    }
    public static int fatorial(int n)
    {
        if(n<=1)return 1;
        return n * fatorial(n-1);
    }
}