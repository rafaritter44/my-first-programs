import java.util.Scanner;
public class Exercicio24
{
    public static void main(String[] args)
    {
        double[] vet = new double[50];
        leitura(vet);
        dezMaiores(vet);
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
    public static void dezMaiores(double[] vet)
    {
        double aux;
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<vet.length-1-i; j++)
            {
                if(vet[j]>vet[j+1])
                {
                    aux = vet[j];
                    vet[j] = vet[j+1];
                    vet[j+1] = aux;
                }
            }
        }
        
        System.out.println("\nDez maiores valores:");
        for(int i=vet.length-10; i<vet.length; i++)
        {
            System.out.println(vet[i]);
        }
    }
}