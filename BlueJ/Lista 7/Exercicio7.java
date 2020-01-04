import java.util.Scanner;
public class Exercicio7
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int n;
        double x;
        do
        {
            System.out.print("Informe um valor inteiro maior que 1: ");
            n = in.nextInt();
        }
        while(n<=1);
        do
        {
            System.out.print("Informe um valor real maior que 1: ");
            x = in.nextDouble();
        }
        while(x<=1);
        
        double[] serie = new double[n];
        preenchimento(serie,x);
        System.out.println("\nTermos:");
        escrita(serie);
        System.out.println("\nSoma: " + soma(serie));
    }
    public static void preenchimento(double[] vetor, double x)
    {
        for(int pos = 0; pos<vetor.length; pos++)
        {
            vetor[pos] = Math.pow(x,pos+1)/(x-pos);
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