import java.util.Scanner;
public class Exercicio9
{
    public static void main(String args[])
    {
        int vet [] = new int[20];
        leitura(vet);
        System.out.println("Soma: " + soma(vet) + "\nMaior: " + maior(vet) + "\nQuantidade de pares: "
        + pares(vet));
    }
    public static void leitura(int [] vetor)
    {
        Scanner in = new Scanner(System.in);
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            vetor[pos] = in.nextInt();
            if(vetor[pos]<=0)
            {
                System.out.println("ERRO: valor inválido.");
                pos--;
            }
        }
    }
    public static int soma(int [] vetor)
    {
        int s = 0;
        for(int pos = 0; pos<vetor.length; pos++)
        {
            s += vetor[pos];
        }
        return s;
    }
    public static int maior(int [] vetor)
    {
        int m = vetor[0];
        for(int pos = 1; pos<vetor.length; pos++)
        {
            if(vetor[pos]>m)m = vetor[pos];
        }
        return m;
    }
    public static int pares(int [] vetor)
    {
        int cont = 0;
        for(int pos = 0; pos<vetor.length; pos++)
        {
            if(vetor[pos]%2==0)cont++;
        }
        return cont;    
    }
}