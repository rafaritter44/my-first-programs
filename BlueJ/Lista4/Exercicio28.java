import java.util.Scanner;
public class Exercicio28
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a, b;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            a = in.nextInt();
        }
        while(a<=0);
        do
        {
            System.out.print("Informe outro valor inteiro e positivo: ");
            b = in.nextInt();
        }
        while(b<=0);
        System.out.println("Soma: " + soma(a,b));
    }
    public static int soma(int valor1, int valor2)
    {
        int soma = 0, maior, menor = valor1;
        if(valor2<menor)menor=valor2;
        maior = valor1 + valor2 - menor;
        if(menor%2==0)
        {
            for(int cont = menor; cont<=maior; cont+=2)
            {
                soma += cont;
            }
        }
        else
        {
            for(int cont = menor+1; cont<=maior; cont+=2)
            {
                soma += cont;
            }
        }
        return soma;
    }
}