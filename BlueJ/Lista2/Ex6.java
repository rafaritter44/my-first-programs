import java.util.Scanner;
public class Ex6
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int saldo;
        System.out.print("Informe o saldo médio: ");
        saldo = in.nextInt();
        if(saldo<500)System.out.println("Não há limite.");
        else
        {
            if(saldo<1000)System.out.println("Limite = " + (saldo*0.08));
            else System.out.println("Limite = " + (saldo*0.15));
        }
    }
}