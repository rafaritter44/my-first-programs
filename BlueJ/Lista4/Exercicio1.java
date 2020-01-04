import java.util.Scanner;
public class Exercicio1
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe 3 valores: ");
        double valor1 = in.nextDouble();
        double valor2 = in.nextDouble();
        double valor3 = in.nextDouble();
        System.out.println("Média: " + media(valor1, valor2, valor3));
    }
    public static double media(double v1, double v2, double v3)
    {
        double m = (v1+v2+v3)/3;
        return m;
    }
}