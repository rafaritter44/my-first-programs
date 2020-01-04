import java.util.Scanner;
public class Exercicio9
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a, b, menor, maior, soma = 0;
        System.out.print("\fInforme dois valores inteiros e positivos: ");
        a = in.nextInt();
        while(a<=0)
        {
            System.out.print("ERRO: valor inválido\nPor favor, informe dois valores inteiros e positivos: ");
            a = in.nextInt();
        }
        b = in.nextInt();
        while(b<=0)
        {
            System.out.print("ERRO: valor inválido\nPor favor, informe um valor inteiro e positivo: ");
            b = in.nextInt();
        }
        menor = a;
        if(b<menor)menor = b;
        maior = a+b-menor;
        if(menor%2==0)
        {
            while(menor<=maior)
            {
                soma = soma + menor;
                menor = menor + 2;
            }
        }
        else
        {
            menor = menor + 1;
            while(menor<=maior)
            {
                soma = soma + menor;
                menor = menor + 2;
            }
        }
        System.out.println("Soma dos pares entre " + a + " e " + b + ": " + soma);
    }
}