import java.util.Scanner;
public class Ex6
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        while(n<=0);
        System.out.println(n + "-ésimo termo da série de Fibonacci: " + fibonacci(n));
    }
    public static int fibonacci(int n)
    {
        if(n<=2)return 1;
        return fibonacci(n-2) + fibonacci(n-1);
    }
}