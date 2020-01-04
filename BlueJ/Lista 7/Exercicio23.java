import java.util.Scanner;
public class Exercicio23
{
    public static void main(String[] args)
    {
        int[] vet = new int[30];
        leitura(vet);
        ordena(vet);
        System.out.println("\nVetor ordenado:");
        escrita(vet);
    }
    public static void leitura(int[] vet)
    {
        Scanner in = new Scanner(System.in);
        
        boolean jaExiste;
        for(int i=0; i<vet.length; i++)
        {
            jaExiste = false;
            System.out.print("Informe o valor inteiro, distinto do resto do vetor, da posição " + i + ": ");
            vet[i] = in.nextInt();
            for(int j=0; j<i && !jaExiste; j++)
            {
                if(vet[i]==vet[j])jaExiste = true;
            }
            if(jaExiste)i--;
        }
    }
    public static void ordena(int[] vet)
    {
        int aux;
        boolean ordenado;
        do
        {
            ordenado = true;
            for(int i=0; i<vet.length-1; i++)
            {
                if(vet[i]>vet[i+1])
                {
                    aux = vet[i];
                    vet[i] = vet[i+1];
                    vet[i+1] = aux;
                    ordenado = false;
                }
            }
        }
        while(!ordenado);
    }
    public static void escrita(int[] vet)
    {
        for(int i=0; i<vet.length; i++)
        {
            System.out.println(vet[i]);
        }
    }
}