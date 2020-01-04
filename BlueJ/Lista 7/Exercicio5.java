import java.util.Scanner;
public class Exercicio5
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        while(n<=0);
        int [] vetor = new int[n];
        for(int pos = 0; pos<vetor.length; pos++)
        {
            vetor[pos] = fibo(pos+1);
        }
        System.out.println("\nVetor:");
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.println(vetor[pos]);
        }
    }
    public static int fibo(int termo)
    {
        if(termo<=0)return 0;
        if(termo==1)return 1;
        int soma = 0, a = 0, b = 1;
        for(int cont = 2; cont<=termo; cont++)
        {
            soma = a + b;
            a = b;
            b = soma;
        }
        return soma;
    }
}