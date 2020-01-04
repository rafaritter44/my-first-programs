import java.util.Scanner;
public class Exercicio12
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double n1, n2, n3;
        do
        {
            System.out.print("Informe a primeira nota [0;10]: ");
            n1 = in.nextDouble();
        }
        while(n1<0||n1>10);
        do
        {
            System.out.print("Informe a segunda nota [0;10]: ");
            n2 = in.nextDouble();
        }
        while(n2<0||n2>10);
        do
        {
            System.out.print("Informe a terceira nota [0;10]: ");
            n3 = in.nextDouble();
        }
        while(n3<0||n3>10);
        System.out.println("Agora informe o tipo de média desejado:");
        System.out.println("1 – Aritmética\n2 – Ponderada (Pesos: 3, 3, 4)\n3 – Harmônica");
        int tipo = in.nextInt();
        switch(tipo)
        {
            case 1: System.out.println("Média Aritmética: " + aritmetica(n1, n2, n3)); break;
            case 2: System.out.println("Média Ponderada: " + ponderada(n1, n2, n3)); break;
            case 3: System.out.println("Média Harmônica: " + harmonica(n1, n2, n3)); break;
            default: System.out.println("ERRO: comando inválido!");
        }
    }
    public static double aritmetica(double n1, double n2, double n3)
    {
        return (n1+n2+n3)/3;
    }
    public static double ponderada(double n1, double n2, double n3)
    {
        return (3*n1 + 3*n2 + 4*n3)/10;
    }
    public static double harmonica(double n1, double n2, double n3)
    {
        return 3/(1/n1 + 1/n2 + 1/n3);
    }
}