import java.util.Scanner;
public class Exercicio27
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme 3 cartas: ");
        String carta1 = in.nextLine();
        int compCarta1 = carta1.length();
        if(compCarta1<2||compCarta1>3)System.out.println("Comprimento incorreto");
        else
        {
        String carta2 = in.nextLine();
        int compCarta2 = carta2.length();
        if(compCarta2<2||compCarta2>3)System.out.println("Comprimento incorreto");
        else
        {
        String carta3 = in.nextLine();
        int compCarta3 = carta3.length();
        if(compCarta3<2||compCarta3>3)System.out.println("Comprimento incorreto");
        else
        {
        char valorCarta1 = carta1.charAt(0);
        char valorCarta2 = carta2.charAt(0);
        char valorCarta3 = carta3.charAt(0);
        if(valorCarta1==valorCarta2&&valorCarta2==valorCarta3)
        {
            char naipeCarta1 = carta1.charAt(1);
            char naipeCarta2 = carta2.charAt(1);
            char naipeCarta3 = carta3.charAt(1);
            if(naipeCarta1!=naipeCarta2&&naipeCarta1!=naipeCarta3&&naipeCarta2!=naipeCarta3)
            System.out.println("As cartas formam uma trinca");
            else System.out.println("As cartas não formam uma trinca: naipes iguais");
        }
        else System.out.println("As cartas não formam uma trinca: valores diferentes");
    }
    }
    }
    }
}