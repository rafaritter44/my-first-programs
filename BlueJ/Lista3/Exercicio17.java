import java.util.Scanner;
public class Exercicio17
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme um valor inteiro e positivo: ");
        int num = in.nextInt();
        while(num<=0)
        {
            System.out.print("ERRO: valor inválido\nPor favor, informe um valor inteiro e positivo: ");
            num = in.nextInt();
        }
        double soma = 0;
        for(double cont = 1, cont2 = 1; cont<=num; cont++)
        {
            soma = soma + cont/cont2;
            cont2 = cont2 + 2;
        }
        System.out.println("Soma: " + soma);
    }
}