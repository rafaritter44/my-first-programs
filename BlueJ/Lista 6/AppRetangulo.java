import java.util.Scanner;
public class AppRetangulo
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double base, altura;
        do
        {
            System.out.print("Informe a base: ");
            base = in.nextDouble();
        }
        while(base<=0);
        do
        {
            System.out.print("Informe a altura: ");
            altura = in.nextDouble();
        }
        while(altura<=0);
        Retangulo retangulo1 = new Retangulo(base, altura);
        System.out.println(retangulo1);
    }
}