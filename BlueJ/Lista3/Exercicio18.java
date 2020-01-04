import java.util.Scanner;
public class Exercicio18
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n, cont, denominador=1;
        double x, soma=0;
        System.out.print("\fEscreva um valor inteiro e positivo: ");
        n = in.nextInt();
        while(n<=0)
        {
            System.out.print("ERRO: valor inválido\nPor favor, escreva um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        System.out.print("Agora escreva um valor real: ");
        x = in.nextDouble();
        for(cont=1; cont<=n; cont++)
        {
            soma+=Math.pow(x,cont)/denominador;
            denominador+=4;
        }
        System.out.println("Soma: " + soma);
    }
}