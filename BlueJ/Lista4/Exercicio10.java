import java.util.Scanner;
public class Exercicio10
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double altura;
        int sexo;
        do
        {
            System.out.print("Informe a altura: ");
            altura = in.nextDouble();
        }
        while(altura<=0||altura>3);
        do
        {
            System.out.print("Informe se é homem(1) ou mulher(2): ");
            sexo = in.nextInt();
        }
        while(sexo!=1&&sexo!=2);
        System.out.println("Peso ideal: " + pesoIdeal(altura, sexo));
    }
    public static double pesoIdeal(double altura, int sexo)
    {
        double p=0;
        switch(sexo)
        {
            case 1: p = 72.7*altura-58; break;
            case 2: p = 62.1*altura-44.7; break;
        }
        return p;
    }
}