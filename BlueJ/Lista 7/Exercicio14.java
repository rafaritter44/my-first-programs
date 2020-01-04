import java.util.Scanner;
public class Exercicio14
{
    public static void main(String args[])
    {
        int[] a = new int[20];
        System.out.println("\fVetor A:");
        leitura(a);
        int[] f = vetorFatorial(a);
        System.out.println("\nVetor F:");
        escrita(f);
    }
    public static void leitura(int[] vetor)
    {
        Scanner in = new Scanner(System.in);
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.print("Informe o valor, inteiro e não negativo, da posição " + pos + ": ");
            vetor[pos] = in.nextInt();
            if(vetor[pos]<0)
            {
                System.out.println("ERRO: valor inválido.");
                pos--;
            }
        }
    }
    public static int fat(int n)
    {
        if(n<=1)return 1;
        return n * fat(n-1);
    }
    public static int[] vetorFatorial(int[] vetor)
    {
        int[] vetFat = new int[vetor.length];
        for(int pos = 0; pos<vetFat.length; pos++)
        {
            vetFat[pos] = fat(vetor[pos]);
        }
        return vetFat;
    }
    public static void escrita(int[] vetor)
    {
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.println(vetor[pos]);
        }
    }
}