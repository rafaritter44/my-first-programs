import java.util.Scanner;
public class Exercicio11
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fEscreva um valor inteiro e positivo: ");
        int num = in.nextInt();
        while(num<=0)
        {
            System.out.print("ERRO: valor inválido\nEscreva um valor inteiro e positivo: ");
            num = in.nextInt();
        }
        int cont = 2;
        System.out.println("Divisores de " + num + ":\n1");
        while(cont<=num/2)
        {
            if(num%cont==0)System.out.println(cont);
            cont = cont + 1;
        }
        if(num!=1)System.out.println(num);
    }
}