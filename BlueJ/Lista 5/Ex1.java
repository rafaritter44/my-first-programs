import java.util.Scanner;
public class Ex1
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n;
        do
        {
            System.out.print("Informe um valor inteiro e não negativo: ");
            n = in.nextInt();
        }
        while(n<0);
        System.out.println(n + "! = " + fatorial(n));
    }
    public static int fatorial(int n)
    {
        if(n<=1)return 1;
        return n * fatorial(n-1);
    }
}