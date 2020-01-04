import java.util.Scanner;
public class Exercicio11
{
    public static void main(String args[])
    {
        double[] fahrenheit = new double[30];
        leitura(fahrenheit);
        double[] celsius = conversao(fahrenheit);
        System.out.println("\nTemperaturas em Fahrenheit:");
        escrita(fahrenheit);
        System.out.println("\nTemperaturas em Celsius:");
        escrita(celsius);
    }
    public static void leitura(double[] vetor)
    {
        Scanner in = new Scanner(System.in);
        
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.print("Informe a temperatura, em Fahrenheit, da posição " + pos + ": ");
            vetor[pos] = in.nextDouble();
        }
    }
    public static double[] conversao(double[] fah)
    {
        double[] cel = new double[fah.length];
        for(int pos = 0; pos<fah.length; pos++)
        {
            cel[pos] = 5.0/9 * (fah[pos] - 32);
        }
        return cel;
    }
    public static void escrita(double[] vetor)
    {
        for(int i = 0; i<vetor.length; i++)
        {
            System.out.println(vetor[i]);
        }
    }
}