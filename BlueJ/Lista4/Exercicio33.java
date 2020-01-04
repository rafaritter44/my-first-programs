import java.util.Scanner;
public class Exercicio33
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe uma string: ");
        String entrada = in.nextLine();
        System.out.println(retiraVogais(entrada));
    }
    public static String retiraVogais(String palavra)
    {
        String semVogais = "";
        palavra = palavra.toLowerCase();
        int comprimento = palavra.length();
        for(int pos = 0; pos<comprimento; pos++)
        {
            char letra = palavra.charAt(pos);
            if(letra!='a'&&letra!='e'&&letra!='i'&&letra!='o'&&letra!='u')semVogais+=letra;
        }
        return semVogais;
    }
}