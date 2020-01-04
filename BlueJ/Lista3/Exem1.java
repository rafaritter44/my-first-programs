import java.util.Scanner;
public class Exem1
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int cont = 1, num, maior = Integer.MIN_VALUE;
        while(cont<=5)
        {
            System.out.print("Informe um valor: ");
            num = in.nextInt();
            cont = cont + 1;
            if(num>maior)maior = num;
        }
        System.out.println("Maior = " + maior);
    }
}