import java.util.Scanner;
public class Exercicio15
{    
    public static void main(String[] args)
    {
        int[] a = new int[20];
        leitura(a);
        int[] s = vetorSomatorio(a);
        escrita(s);
    }
    public static void leitura(int[] vet)
    {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i<vet.length; i++)
        {
            System.out.print("Informe o valor inteiro e não negativo da posição " + i + ": ");
            vet[i] = in.nextInt();
            if(vet[i]<0)i--;
        }
    }
    public static int somatorio(int n)
    {
        if(n<=0)return 0;
        return n + somatorio(n-1);
    }
    public static int[] vetorSomatorio(int[] vet)
    {
        int[] ret = new int[vet.length];
        for(int i = 0; i<vet.length; i++)
        {
            ret[i] = somatorio(vet[i]);
        }
        return ret;
    }
    public static void escrita(int[] vet)
    {
        for(int i = 0; i<vet.length; i++)
        {
            System.out.println(vet[i]);
        }
    }
}