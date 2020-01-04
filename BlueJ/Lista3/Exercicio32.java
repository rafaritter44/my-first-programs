import java.util.Scanner;
public class Exercicio32
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int m, n;
        while(1==1)
        {
            do
            {
                System.out.print("Informe dois valores inteiros e positivos: ");
                m = in.nextInt();
                n = in.nextInt();
            }
            while(m<=0||n<=0);
            int soma = 0;
            for(int cont = m; cont<m+n; cont++)
            {
                soma+=cont;
            }
            System.out.println("Soma dos " + n + " inteiros consecutivos a partir de " + m + ": " + soma);
        }
    }
}