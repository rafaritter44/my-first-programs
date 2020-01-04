import java.util.Scanner;
public class Exercicio19
{
    public static void main(String[] args)
    {
        int[] vetor = new int[30];
        leitura(vetor);
        organizacao(vetor);
        System.out.println("\nVetor ordenado:");
        escrita(vetor);
    }
    
    public static void leitura(int[] vet)
    {
        Scanner in = new Scanner(System.in);
        
        for(int i = 0; i<vet.length; i++)
        {
            System.out.print("Informe um valor inteiro e positivo para a posição " + i + ": ");
            vet[i] = in.nextInt();
            if(vet[i]<=0)i--;
        }
    }
    
    public static void organizacao(int[] vet)
    {
        int aux;
        boolean ordenado;
        do
        {
            ordenado = true;
            for(int i = 1; i<vet.length; i++)
            {
                if(vet[i]%2==0 && vet[i-1]%2==1)
                {
                    aux = vet[i];
                    vet[i] = vet[i-1];
                    vet[i-1] = aux;
                    ordenado = false;
                }
            }
        }
        while(!ordenado);
    }
    
    public static void escrita(int[] vet)
    {
        for(int i = 0; i<vet.length; i++)
        {
            System.out.println(vet[i]);
        }
    }
}