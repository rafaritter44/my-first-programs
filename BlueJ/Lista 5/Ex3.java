import java.util.Scanner;
public class Ex3
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe uma string: ");
        String palavra = in.nextLine();
        System.out.println("String invertida: " + inverte(palavra));
    }
    private static String inv(String nome, int pos)
    {
        if(pos<0)return "";
        return nome.charAt(pos) + inv(nome, pos-1);
    }
    public static String inverte(String nome)
    {
        return inv(nome, nome.length()-1);
    }
}