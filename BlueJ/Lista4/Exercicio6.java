import java.util.Scanner;
public class Exercicio6
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double fahrenheit;
        for(int i = 1; i<=30; i++)
        {
            System.out.print("Informe a temperatura em Fahrenheit: ");
            fahrenheit = in.nextDouble();
            System.out.println("Temperatura em Celsius: " + conversao(fahrenheit));
        }
    }
    public static double conversao(double fahrenheit)
    {
        return 5.0/9 * (fahrenheit - 32);
    }
}