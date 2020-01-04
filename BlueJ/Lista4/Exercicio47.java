import java.util.Scanner;
public class Exercicio47
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
        System.out.println(fibonacci(n));
    }
    public static int fibonacci(int n)
    {
        int a = 0, b = 0, c = 1;
        for(int i = 1; i<n; i++)
        {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}