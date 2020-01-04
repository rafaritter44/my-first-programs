import java.util.Scanner;
public class Exercicio44
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.print("\fInforme um valor real: ");
        double x = in.nextDouble();
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        while(n<=0);
        System.out.println("Soma: " + soma(n,x));
    }
    public static double soma(int n, double x)
    {
        double s = 0;
        for(int i = 1, j = 1; i<=n; i++, j+=4)
        {
            s+=Math.pow(x,i)/j;
        }
        return s;
    }
}