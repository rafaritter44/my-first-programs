import java.util.Scanner;
public class Fatorial
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int valor;
        do
        {
            System.out.print("\fInforme um valor natural: ");
            valor = in.nextInt();
        }while(valor<0);
        double fat = 1, cont;
        for(cont=2; cont<=valor; cont=cont+1)
        {
            fat = fat * cont;
        }
        System.out.println("Fatorial: " + fat);
   }
}