import java.util.Scanner;
public class Exercicio26
{
    public static void main(String[] args)
    {
        double[] vet = new double[40];
        leitura(vet);
        modificacao(vet);
        System.out.println("\nVetor modificado:");
        escrita(vet);
    }
    public static void leitura(double[] vet)
    {
        Scanner in = new Scanner(System.in);
        
        for(int i=0; i<vet.length; i++)
        {
            System.out.print("Informe o valor real da posição " + i + ": ");
            vet[i] = in.nextDouble();
        }
    }
    public static double maior(double[] vet)
    {
        double m = vet[0];
        for(int i=1; i<vet.length; i++)
        {
            if(vet[i]>m)m=vet[i];
        }
        return m;
    }
    public static void modificacao(double[] vet)
    {
        double m = maior(vet);
        for(int i=0; i<vet.length; i++)
        {
            vet[i] = vet[i]/m;
        }
    }
    public static void escrita(double[] vet)
    {
        for(int i=0; i<vet.length; i++)
        {
            System.out.println(vet[i]);
        }
    }
}