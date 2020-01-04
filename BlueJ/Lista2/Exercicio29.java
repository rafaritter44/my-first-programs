import java.util.Scanner;
public class Exercicio29
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String nome1, nome2, nome3;
        System.out.print("\fInforme três nomes: ");
        nome1 = in.nextLine();
        nome2 = in.nextLine();
        nome3 = in.nextLine();
        int r = nome1.compareTo(nome2);
        int s = nome1.compareTo(nome3);
        int t = nome2.compareTo(nome3);
        if(r<0)
        {
            if(s<0&&t<0)System.out.println("Ordem alfabética:\n" + nome1 + "\n" + nome2 + "\n" + nome3);
            else if(s<0) System.out.println("Ordem alfabética:\n" + nome1 + "\n" + nome3 + "\n" + nome2);
            else System.out.println("Ordem alfabética:\n" + nome3 + "\n" + nome1 + "\n" + nome2);
        }
        else
        {
            if(s<=0)System.out.println("Ordem alfabética:\n" + nome2 + "\n" + nome1 + "\n" + nome3);
            else if(t>=0)System.out.println("Ordem alfabética:\n" + nome3 + "\n" + nome2 + "\n" + nome1);
            else System.out.println("Ordem alfabética:\n" + nome2 + "\n" + nome3 + "\n" + nome1);
        }
    }
}