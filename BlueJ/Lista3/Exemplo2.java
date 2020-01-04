import java.util.Scanner;
public class Exemplo2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double nota;
        do
        {
            System.out.print("Informe uma nota [0;10]: ");
            nota = in.nextDouble();
        }while(nota<0||nota>10);
    }
}