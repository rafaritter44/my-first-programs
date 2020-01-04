import java.util.Scanner;
public class Exercicio49
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int altura;
        do
        {
            System.out.print("Informe a altura, em linhas (i.e., inteira), do triângulo: ");
            altura = in.nextInt();
        }
        while(altura<=0);
        triangulo(altura);
    }
    public static void triangulo(int altura)
    {
        String x = "*";
        for(int i = 1; i<=altura; i++)
        {
            System.out.println(x);
            x += "*";
        }
    }
}