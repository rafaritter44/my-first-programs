import java.util.Scanner;
public class AppGarrafa
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o raio 1: ");
        double r1 = in.nextDouble();
        System.out.print("Informe a altura 1: ");
        double h1 = in.nextDouble();
        System.out.print("Informe o raio 2: ");
        double r2 = in.nextDouble();
        System.out.print("Informe a altura 2: ");
        double h2 = in.nextDouble();
        System.out.print("Informe a altura 3: ");
        double h3 = in.nextDouble();
        Garrafa garrafa1 = new Garrafa(r1, r2, h1, h2, h3);
        System.out.println(garrafa1);
    }
}