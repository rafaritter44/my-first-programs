import java.util.Scanner;
public class Exercicio22
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int x, y, z=1;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            x = in.nextInt();
        }
        while(x<=0);
        do
        {
            System.out.print("Informe outro valor inteiro e positivo: ");
            y = in.nextInt();
        }
        while(y<=0);
        for(int cont = 1; cont<=y; cont++)
        {
            z = z*x;
        }
        System.out.println(x + "^" + y + " = " + z);
    }
}