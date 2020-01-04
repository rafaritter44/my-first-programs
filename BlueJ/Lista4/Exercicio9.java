import java.util.Scanner;
public class Exercicio9
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double nota1, nota2, nota3;
        do
        {
            System.out.print("Informe a primeira nota [0;10]: ");
            nota1 = in.nextDouble();
        }
        while(nota1<0||nota1>10);
        do
        {
            System.out.print("Informe a segunda nota [0;10]: ");
            nota2 = in.nextDouble();
        }
        while(nota2<0||nota2>10);
        do
        {
            System.out.print("Informe a terceira nota [0;10]: ");
            nota3 = in.nextDouble();
        }
        while(nota3<0||nota3>10);
        System.out.println("Média ponderada: " + mediaNotas(nota1, nota2, nota3));
    }
    public static double maiorNota(double n1, double n2, double n3)
    {
        double maior = n1;
        if(n2>maior)maior=n2;
        if(n3>maior)maior=n3;
        return maior;
    }
    public static double mediaNotas(double n1, double n2, double n3)
    {
        double maior = maiorNota(n1, n2, n3);
        return (2*maior + n1 + n2 + n3 - maior)/4;
    }
}