import java.util.Scanner;
public class Exercicio36v2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme uma palavra: ");
        String palavra = in.nextLine();
        if(palindromeV2(palavra))System.out.println("É palíndrome!");
        else System.out.println("Não é palíndrome.");
    }
    public static boolean palindromeV2(String nome)
    {
        if(nome.equals(Exercicio34.inversao(nome)))return true;
        return false;
    }
}