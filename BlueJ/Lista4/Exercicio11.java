import java.util.Scanner;
public class Exercicio11
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double saldoMedio;
        do
        {
            System.out.print("Informe o saldo médio: ");
            saldoMedio = in.nextDouble();
        }
        while(saldoMedio<0);
        System.out.println("Saldo médio: " + saldoMedio);
        System.out.println("Crédito: " + credito(saldoMedio));
    }
    public static double credito(double saldo)
    {
        if(saldo>4000)return 0.25*saldo;
        if(saldo>2500)return 0.2*saldo;
        if(saldo>1500)return 0.15*saldo;
        if(saldo>500)return 0.1*saldo;
        return 0;
    }
}