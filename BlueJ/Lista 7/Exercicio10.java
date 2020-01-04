import java.util.Scanner;
public class Exercicio10
{
    public static void main(String args[])
    {
        double[] a = new double [10];
        double[] b = new double [10];
        System.out.println("Dez valores do vetor A:");
        leitura(a);
        System.out.println("Dez valores do vetor B:");
        leitura(b);
        double[] c = soma(a, b);
        System.out.println("Vetor C (soma dos vetores A e B):");
        escrita(c);
    }
    public static void leitura(double[] vetor)
    {
        Scanner in = new Scanner(System.in);
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.print("Informe um valor real: ");
            vetor[pos] = in.nextDouble();
        }
    }
    public static double[] soma(double[] vet1, double[] vet2)
    {
        double[] vet = new double [vet1.length];
        for(int pos = 0; pos<vet.length; pos++)
        {
            vet[pos] = vet1[pos] + vet2[pos];
        }
        return vet;
    }
    public static void escrita(double[] vetor)
    {
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.println(vetor[pos]);
        }
    }
}