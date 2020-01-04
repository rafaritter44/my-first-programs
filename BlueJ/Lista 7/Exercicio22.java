import java.util.Scanner;
public class Exercicio22
{
    public static void main(String[] args)
    {
        double[] vetor = new double[20];
        leitura(vetor);
        substituicao(vetor);
        System.out.println("\nVetor substituído:");
        escrita(vetor);
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
    public static void substituicao(double[] vet)
    {
        for(int i=0; i<vet.length; i++)
        {
            if(vet[i]<0)vet[i]=0;
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