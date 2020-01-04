import java.util.Scanner;
public class Exercicio4
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n, x = 1, y = 1;
        double soma = 0;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        while(n<=0);
        double [] a = new double[n];
        for(int pos = 0; pos<a.length; pos++)
        {
            a[pos] = (double)x/y;
            x += 3;
            y += 2;
        }
        System.out.println("\nTermos da série:");
        for(int pos = 0; pos<a.length; pos++)
        {
            System.out.println(a[pos]);
            soma += a[pos];
        }
        System.out.println("\nSoma: " + soma);
    }
}