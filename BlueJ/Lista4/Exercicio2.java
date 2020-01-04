import java.util.Scanner;
public class Exercicio2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe 3 valores reais: ");
        double valor1 = in.nextDouble();
        double valor2 = in.nextDouble();
        double valor3 = in.nextDouble();
        System.out.println("Maior: " + maior(valor1,valor2,valor3));
    }
    public static double maior(double v1, double v2, double v3)
    {
        double m = v1;
        if(v2>m)m = v2;
        if(v3>m)m = v3;
        return m;
    }
}