import java.util.Scanner;
public class Exem2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme um valor: ");
        int maior = in.nextInt();
        int cont = 2, num;
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