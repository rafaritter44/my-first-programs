import java.util.Scanner;
public class Exercicio25
{
    public static void main(String args[])
    {
    }
    public static void leitura(int[] vetor)
    {
        Scanner in = new Scanner(System.in);
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.print("Informe um valor inteiro: ");
            vetor[pos] = in.nextInt();
        }
    }
}
    