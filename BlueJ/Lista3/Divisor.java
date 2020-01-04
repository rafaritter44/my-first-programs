import java.util.Scanner;
public class Divisor
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int valor;
        do
        {
            System.out.print("\fInforme um valor natural: ");
            valor = in.nextInt();
        }
        while(valor<0);
        int d;
        System.out.println("Divisores de " + valor + ":");
        System.out.println("1");
        int lim = valor/2;
        for(d=2; d<=lim; d++)
        {
            if(valor%d==0)System.out.println(d);
        }
        System.out.println(valor);
    }
}