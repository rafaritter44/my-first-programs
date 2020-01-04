import java.util.Scanner;
public class Exercicio16
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
        for(int cont = 1; cont<=num; cont++)soma = soma + 1.0/cont;
        System.out.println("Soma: " + soma);
    }
}