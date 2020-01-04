import java.util.Scanner;
public class Exercicio12
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int num, soma = 0, digitos, cont = 1, unidade;
        System.out.print("\fInforme um valor inteiro e positivo: ");
        num = in.nextInt();
        while(num<=0)
        {
            System.out.print("ERRO: valor inválido\nPor favor, informe um valor inteiro e positivo: ");
            num = in.nextInt();
        }
        digitos = (int)Math.log10(num)+1;
        while(cont<=digitos)
        {
            unidade = num/(int)Math.pow(10,digitos-cont);
            num = num%(int)Math.pow(10,digitos-cont);
            if(unidade%2==1)soma = soma + unidade;
            cont = cont + 1;
        }
        System.out.println("Soma dos dígitos ímpares: " + soma);
    }
}