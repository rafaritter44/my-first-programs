import java.util.Scanner;
public class Exercicio20
{
    public static void main(String args[])
    {
        double[] vetor = new double[30];
        leitura(vetor);
        System.out.println("\nVetor:");
        escrita(vetor);
        troca(vetor);
        System.out.println("\nVetor trocado:");
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
    
    public static void troca(double[] vet)
    {
        double aux;
        for(int i=0; i<vet.length-2; i++)
        {
            aux = vet[i];
            vet[i] = vet[i+2];
            vet[i+2] = aux;
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