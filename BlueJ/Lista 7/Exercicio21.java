import java.util.Scanner;
public class Exercicio21
{
    public static void main(String args[])
    {
        int[] vetor = new int[20];
        leitura(vetor);
        System.out.println("\nVetor:");
        escrita(vetor);
        System.out.println("\nVetor rotacionado:");
        rotacao(vetor);
        escrita(vetor);
    }
    public static void leitura(int[] vet)
    {
        Scanner in = new Scanner(System.in);
        
        for(int i=0; i<vet.length; i++)
        {
            System.out.print("Informe o valor inteiro da posição " + i + ": ");
            vet[i] = in.nextInt();
        }
    }
    public static void rotacao(int[] vet)
    {
        int aux;
        for(int i=0; i<vet.length-1; i++)
        {
            aux = vet[i];
            vet[i] = vet[i+1];
            vet[i+1] = aux;
        }
    }
    public static void escrita(int[] vet)
    {
        for(int i=0; i<vet.length; i++)
        {
            System.out.println(vet[i]);
        }
    }
}