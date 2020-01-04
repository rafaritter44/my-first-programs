import java.util.Scanner;
public class Exercicio5
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int cont = 1, n;
        System.out.print("\fInforme um valor inteiro: ");
        n = in.nextInt();
        if(n<2)System.out.println("Nenhum quadrado perfeito até " + n);
        else
        {
            System.out.println("Quadrado perfeitos até " + n);
            while(cont*cont<n)
            {
                System.out.println(cont*cont);
                cont = cont + 1;
            }
        }
    }
}