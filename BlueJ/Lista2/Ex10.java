import java.util.Scanner;
public class Ex10
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme a nota de 0 a 10: ");
        double nota = in.nextDouble();
        if(nota<0||nota>10)System.out.println("ERRO: valor inválido");
        else if(nota<3)System.out.println("Conceito: E");
        else if(nota<5)System.out.println("Conceito: D");
        else if(nota<7)System.out.println("Conceito: C");
        else if(nota<9)System.out.println("Conceito: B");
        else System.out.println("Conceito: A");
    }
}