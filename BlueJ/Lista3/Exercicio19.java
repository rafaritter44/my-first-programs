import java.util.Scanner;
public class Exercicio19
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n, cont, sinal=1;
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
        for(cont=1; cont<=n; cont+=2)
        {
            soma+=Math.pow(x,cont)/(cont*sinal);
            sinal*=-1;
        }
        System.out.println("Soma: " + soma);
    }
}