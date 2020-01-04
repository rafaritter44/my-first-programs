import java.util.Scanner;
public class Exercicio7
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double a, b, c;
        do
        {
            System.out.print("Informe a medida da primeira aresta do paralelepípedo: ");
            a = in.nextDouble();
        }
        while(a<=0);
        do
        {
            System.out.print("Informe a medida da segunda aresta do paralelepípedo: ");
            b = in.nextDouble();
        }
        while(b<=0);
        do
        {
            System.out.print("Informe a medida da terceira aresta do paralelepípedo: ");
            c = in.nextDouble();
        }
        while(c<=0);
        System.out.println("Diagonal do paralelepípedo: " + diagonal(a, b, c));
    }
    public static double diagonal(double a, double b, double c)
    {
        return Math.sqrt(a*a+b*b+c*c);
    }
}