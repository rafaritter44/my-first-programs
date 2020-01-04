import java.util.Scanner;
public class Exercicio3
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double largCasa, compCasa, largTerr, compTerr;
        do
        {
            System.out.print("Informe a largura da casa: ");
            largCasa = in.nextInt();
        }
        while(largCasa<=0);
        do
        {
            System.out.print("Informe o comprimento da casa: ");
            compCasa = in.nextInt();
        }
        while(compCasa<=0);
        do
        {
            System.out.print("Informe a largura do terreno: ");
            largTerr = in.nextInt();
        }
        while(largTerr<=0);
        do
        {
            System.out.print("Informe o comprimento do terreno: ");
            compTerr = in.nextInt();
        }
        while(compTerr<=0);
        System.out.println("Área da casa: " + area(largCasa, compCasa));
        System.out.println("Área do terreno: " + area(largTerr, compTerr));
        System.out.println("Área livre: " + (area(largTerr, compTerr) - area(largCasa, compCasa)));
    }
    public static double area(double larg, double comp)
    {
        return larg*comp;
    }
}