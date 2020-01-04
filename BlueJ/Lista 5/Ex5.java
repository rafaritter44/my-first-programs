import java.util.Scanner;
public class Ex5
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe uma string: ");
        String palavra = in.nextLine();
        System.out.println("Quantidade de letras A na string: " + contaA(palavra));
    }
    private static int conta(String nome, int pos)
    {
        if(pos<0)return 0;
        int cont = 0;
        if(nome.charAt(pos)=='a'||nome.charAt(pos)=='A')cont++;
        return cont + conta(nome, pos-1);
    }
    public static int contaA(String nome)
    {
        return conta(nome, nome.length()-1);
    }
}