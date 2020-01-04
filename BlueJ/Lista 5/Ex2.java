import java.util.Scanner;
public class Ex2
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
        System.out.println("Somatório de " + n + ": " + somatorio(n));
    }
    public static int somatorio(int n)
    {
        if(n<=0)return 0;
        return n + somatorio(n-1);
    }
}