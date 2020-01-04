import java.util.Scanner;
public class Ex5
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme um valor inteiro: ");
        int valor = in.nextInt();
        if(valor<10&&valor>-10)System.out.println("O valor possui 1 dígito");
        else if(valor<100&&valor>-100)System.out.println("O valor possui 2 dígitos");
        else if(valor<1000&&valor>-1000)System.out.println("O valor possui 3 dígitos");
        else if(valor<10000&&valor>-10000)System.out.println("O valor possui 4 dígitos");
        else if(valor<100000&&valor>-100000)System.out.println("O valor possui 5 dígitos");
        else if(valor<1000000&&valor>-1000000)System.out.println("O valor possui 6 dígitos");
        else if(valor<10000000&&valor>-10000000)System.out.println("O valor possui 7 dígitos");
        else if(valor<100000000&&valor>-100000000)System.out.println("O valor possui 8 dígitos");
        else if(valor<1000000000&&valor>-1000000000)System.out.println("O valor possui 9 dígitos");
        else System.out.println("O valor possui 10 dígitos");
    }
}