import java.util.Scanner;
public class Exercicio45
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
        int limite = n*2, sinal = 1;
        for(int i = 1; i<limite; i+=2)
        {
            s+=sinal*Math.pow(x,i)/i;
            sinal*=-1;
        }
        return s;
    }
}