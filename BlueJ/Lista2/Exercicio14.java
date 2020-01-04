import java.util.Scanner;
public class Exercicio14
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fEscreva um valor inteiro de 4 dígitos: ");
        int valor = in.nextInt();
        if(Math.abs(valor)<1000||Math.abs(valor)>9999)System.out.println("ERRO: valor inválido");
        else
        {
            int milhar = valor/1000; int centena = valor%1000/100;
            int dezena = valor%1000%100/10; int unidade = valor%1000%100%10;
            if(milhar==unidade&&centena==dezena)System.out.println("O número é capicua");
            else System.out.println("O número não é capicua");
        }
    }
}