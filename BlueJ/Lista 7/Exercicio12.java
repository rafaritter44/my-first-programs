import java.util.Scanner;
public class Exercicio12
{
    public static void main(String[] args)
    {
        double[] saldos = new double[30];
        leitura(saldos);
        double[] creditos = credito(saldos);
        System.out.println("\nSaldos:");
        escrita(saldos);
        System.out.println("\nCréditos:");
        escrita(creditos);
    }
    public static void leitura(double[] vet)
    {
        Scanner in = new Scanner(System.in);
        
        for(int i = 0; i<vet.length; i++)
        {
            System.out.print("Informe o saldo médio, cliente " + i + ": ");
            vet[i] = in.nextDouble();
        }
    }
    public static double[] credito(double[] saldo)
    {
        double[] ret = new double[saldo.length];
        for(int i = 0; i<saldo.length; i++)
        {
            if(saldo[i]<=500)ret[i]=0;
            else if(saldo[i]<=1500)ret[i]=saldo[i]*0.1;
            else if(saldo[i]<=2500)ret[i]=saldo[i]*0.15;
            else if(saldo[i]<=4000)ret[i]=saldo[i]*0.2;
            else ret[i]=saldo[i]*0.25;
        }
        return ret;
    }
    public static void escrita(double[] vet)
    {
        for(int i = 0; i<vet.length; i++)
        {
            System.out.println(vet[i]);
        }
    }
}