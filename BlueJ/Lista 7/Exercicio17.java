import java.util.Scanner;
public class Exercicio17
{
    public static void main(String args[])
    {
        int[] vetor1 = new int[20];
        System.out.println("\fValores do vetor:");
        leitura(vetor1);
        ordenaVetor(vetor1);
        System.out.println("Vetor ordenado:");
        escrita(vetor1);
    }
    public static void leitura(int[] vetor)
    {
        Scanner in = new Scanner(System.in);
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.print("Informe um valor inteiro: ");
            vetor[pos] = in.nextInt();
        }
    }
    public static void ordenaVetor(int[] vet)
    {
        int aux;
        for(int i = 1; i<vet.length; i++)
        {
            for(int pos = i; pos<vet.length; pos++)
            {
                if(vet[pos]<vet[i-1])
                {
                    aux = vet[i-1];
                    vet[i-1] = vet[pos];
                    vet[pos] = aux;
                }
            }
        }
    }
    public static void escrita(int[] vetor)
    {
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.println(vetor[pos]);
        }
    }
}