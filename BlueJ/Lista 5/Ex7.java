import java.util.Scanner;
public class Ex7
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
        System.out.println("Soma: " + soma(n));
    }
    public static double soma(int termo)
    {
        if(termo<=0)return 0;
        return 1.0/termo + soma(termo-1);
    }
}