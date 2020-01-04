import java.util.Scanner;
public class Exercicio34
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme uma string: ");
        String nome = in.nextLine();
        System.out.println("String invertida: " + inversao(nome));
    }
    public static String inversao(String nome)
    {
        int comprimento = nome.length();
        String inverso = "";
        for(int pos = comprimento - 1; pos>=0; pos--)
        {
            char letra = nome.charAt(pos);
            inverso+=letra;
        }
        return inverso;
    }
}