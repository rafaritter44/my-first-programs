import java.util.Scanner;
public class Exercicio37
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String senha;
        do
        {
            System.out.print("Informe uma senha de no mínimo 8 caracteres, sem espaços em branco, com letras maiúsculas, minúsculas e dígitos: ");
            senha = in.nextLine();
        }
        while(!senhaValida(senha));
        System.out.println("Senha escolhida com sucesso!");
    }
    public static boolean senhaValida(String senha)
    {
        int comprimento = senha.length();
        boolean caixaAlta = false, caixaBaixa = false, digito = false;
        if(comprimento<8)return false;
        for(int i = 0; i<comprimento; i++)
        {
            if(senha.charAt(i)==' ')return false;
            if(Character.isUpperCase(senha.charAt(i)))caixaAlta = true;
            if(Character.isLowerCase(senha.charAt(i)))caixaBaixa = true;
            if(Character.isDigit(senha.charAt(i)))digito = true;
        }
        if(caixaAlta&&caixaBaixa&&digito)return true;
        return false;
    }
}