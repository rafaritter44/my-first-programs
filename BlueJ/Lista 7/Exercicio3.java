import java.util.Scanner;
public class Exercicio3
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a, b, aux, cont = 0, cont2 = 0;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            a = in.nextInt();
        }
        while(a<=0);
        do
        {
            System.out.print("Informe outro valor inteiro e positivo: ");
            b = in.nextInt();
        }
        while(b<=0);
        if(a>b)
        {
            aux = a;
            a = b;
            b = aux;
        }
        if(a%2==0 && b%2==0)cont++;
        int [] vetor = new int[(b-a)/2-cont];
        if(a%2==0)cont2 += 2;
        else cont2++;
        int n = a+cont2;
        for(int pos = 0; pos<vetor.length; pos++)
        {
            vetor[pos] = n;
            n += 2;
        }
        System.out.println("\nVetor criado:");
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.println(vetor[pos]);
        }
    }
}