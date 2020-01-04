import java.util.Scanner;
public class Exercicio36
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme uma string: ");
        String nome = in.nextLine();
        if(palindrome(nome))System.out.println("É palíndrome!");
        else System.out.println("Não é palíndrome.");
    }
    public static boolean palindrome(String nome)
    {
        int limite = nome.length()/2;
        for(int i=0, j=nome.length()-1; i<limite; i++, j--)
        {
            if(nome.charAt(i)!=nome.charAt(j))return false;
        }
        return true;
    }
}