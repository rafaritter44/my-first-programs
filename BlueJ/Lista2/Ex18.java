import java.util.Scanner;
public class Ex18
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a, b, c, d;
        System.out.print("\fInforme o primeiro valor inteiro: ");
        a = in.nextInt();
        System.out.print("Informe o segundo valor: ");
        b = in.nextInt();
        System.out.print("Informe o terceiro: ");
        c = in.nextInt();
        System.out.print("E o quarto: ");
        d = in.nextInt();
        if(a==b&&c==d)System.out.println("Há dois pares.");
        else
        {
            if(a==c&&b==d)System.out.println("Há dois pares.");
            else
            {
                if(a==d&&b==c)System.out.println("Há dois pares.");
                else System.out.println("Não há dois pares.");
            }
        }
    }
}