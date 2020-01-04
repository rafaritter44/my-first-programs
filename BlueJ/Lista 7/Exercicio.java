import java.util.Scanner;
public class Exercicio
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int[] a = new int[8];
        for(int pos = 0; pos<a.length; pos++)
        {
            System.out.print("Informe um inteiro: ");
            a[pos] = in.nextInt();
        }
        for(int pos = 0; pos<a.length; pos++)
        {
            System.out.println(a[pos]);
        }
        for(int pos = 0; pos<a.length; pos++)
        {
            if(a[pos]%2==0)System.out.println(a[pos]);
        }
        for(int pos = 0; pos<a.length; pos+=2)
        {
            System.out.println(a[pos]);
        }
        int soma = 0;
        for(int pos = 0; pos<a.length; pos+=2)
        {
            if(a[pos]%2==1)soma += a[pos];
        }
        System.out.println(soma);
    }
}