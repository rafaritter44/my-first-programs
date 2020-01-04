import java.util.Scanner;
public class Exercicio6
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int n;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        while(n<=0);
        
        double[] serie = new double[n];
        preenchimento(serie);
        System.out.println("\nTermos do vetor:");
        escrita(serie);
        System.out.println("\nSoma: " + soma(serie));
    }
    public static void preenchimento(double[] vetor)
    {
        for(int i = 1; i<=vetor.length; i++)
        {
            vetor[i-1] = 1.0/i;
        }
    }
    public static double soma(double[] vetor)
    {
        double s = 0;
        for(int pos = 0; pos<vetor.length; pos++)
        {
            s+=vetor[pos];
        }
        return s;
    }
    public static void escrita(double[] vetor)
    {
        for(int i = 0; i<vetor.length; i++)
        {
            System.out.println(vetor[i]);
        }
    }
}