import java.util.Scanner;
public class Exercicio2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double [] a = new double[30];
        for(int pos = 0; pos<a.length; pos++)
        {
            do
            {
                System.out.print("Informe um valor real entre 0 e 10, inclusive: ");
                a[pos] = in.nextDouble();
            }
            while(a[pos]<0||a[pos]>10);
        }
        double soma = 0;
        for(int pos = 0; pos<a.length; pos++)
        {
            soma += a[pos];
        }
        double media = soma/a.length;
        System.out.println("Média: " + media);
        double soma2 = 0;
        for(int pos = 0; pos<a.length; pos++)
        {
            soma2 += Math.pow(a[pos]-media,2);
        }
        System.out.println("Desvio padrão: " + Math.sqrt(soma2/(a.length-1)));
    }
}