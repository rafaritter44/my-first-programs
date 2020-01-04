import java.util.Scanner;
public class Exercicio20
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
        int num1=0, num2=0, num3=1;
        for(int cont = 1; cont<=n; cont++)
        {
            System.out.println(num3);
            num1=num2;
            num2=num3;
            num3=num1+num2;
        }
    }
}