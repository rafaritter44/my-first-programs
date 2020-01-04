import java.util.Scanner;
public class Ex4
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe uma string: ");
        String palavra = in.nextLine();
        System.out.println("String sem vogais: " + semVogais(palavra));
    }
    private static String sem(String nome, int pos)
    {
        if(pos<0)return "";
        if(nome.charAt(pos)=='a'||nome.charAt(pos)=='A'||nome.charAt(pos)=='e'||nome.charAt(pos)=='E'||
        nome.charAt(pos)=='i'||nome.charAt(pos)=='I'||nome.charAt(pos)=='o'||nome.charAt(pos)=='o'||
        nome.charAt(pos)=='u'||nome.charAt(pos)=='U')return sem(nome, pos-1);
        return sem(nome, pos-1) + nome.charAt(pos);
    }
    public static String semVogais(String nome)
    {
        return sem(nome, nome.length()-1);
    }
}