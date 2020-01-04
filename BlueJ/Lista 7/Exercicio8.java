import java.util.Scanner;
public class Exercicio8
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int n;
        double x;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        while(n<=0);
        do
        {
            System.out.print("Informe um valor real e positivo: ");
            x = in.nextDouble();
        }
        while(x<=0);
        
        double[] serie = new double[n];
        preenchimento(serie,x);
        System.out.println("\nTermos:");
        escrita(serie);
        System.out.println("\nSoma: " + soma(serie));
    }
    public static void preenchimento(double[] vetor, double x)
    {
        int cont = 1;
        for(int pos = 0; pos<vetor.length; pos++)
        {
            vetor[pos] = Math.sqrt(x+pos+1)/cont;
            cont+=2;
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