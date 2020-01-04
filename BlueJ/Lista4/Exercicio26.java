import java.util.Scanner;
public class Exercicio26
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int valor;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            valor = in.nextInt();
        }
        while(valor<=0);
        if(isPrime(valor))System.out.println("É primo.");
        else System.out.println("Não é primo.");
    }
    public static boolean isPrime(int numero)
    {
        if(numero<2)return false;
        if(numero==2)return true;
        if(numero%2==0)return false;
        double limite = Math.sqrt(numero);
        for(int d=3; d<=limite; d+=2)
        {
            if(numero%d==0)return false;
        }
        return true;
    }
}