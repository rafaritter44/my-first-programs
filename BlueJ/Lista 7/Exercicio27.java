import java.util.Scanner;
public class Exercicio27
{
    public static void main(String args[])
    {
        int[] games = new int[5];
        leitura(games);
        int[] gratis = promocao(games);
        escrita(gratis);
    }
    public static void leitura(int[] vetor)
    {
        Scanner in = new Scanner(System.in);
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.print("Informe quantos jogos o cliente " + pos + " alugou: ");
            vetor[pos] = in.nextInt();
            if(vetor[pos]<0)
            {
                System.out.println("ERRO: valor inválido;");
                pos--;
            }
        }
    }
    public static int[] promocao(int[] vet)
    {
        int[] ret = new int[vet.length];
        for(int pos = 0; pos<vet.length; pos++)
        {
            ret[pos] = vet[pos]/20;
        }
        return ret;
    }
    public static void escrita(int[] vetor)
    {
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.println("O cliente " + pos + " tem direito a " + vetor[pos] + " locação(ões) gratuita(s).");
        }
    }
}