import java.util.Scanner;
public class Exercicio1
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int[]a = new int[10];
        for(int pos = 0; pos<a.length; pos++)
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            a[pos] = in.nextInt();
            if(a[pos]<=0)pos--;
        }
        System.out.println("\nValores ímpares: ");
        for(int pos = 0; pos<a.length; pos++)
        {
            if(a[pos]%2==1)System.out.println(a[pos]);
        }
        System.out.println("\nValores das posições ímpares: ");
        for(int pos = 1; pos<a.length; pos+=2)
        {
            System.out.println(a[pos]);
        }
        System.out.println("\nValores ímpares em posições pares: ");
        for(int pos = 0; pos<a.length; pos+=2)
        {
            if(a[pos]%2==1)System.out.println(a[pos]);
        }
        System.out.println("\nVetor na ordem inversa: ");
        for(int pos = a.length-1; pos>=0; pos--)
        {
            System.out.println(a[pos]);
        }
    }
}