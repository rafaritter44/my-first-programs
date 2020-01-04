import java.util.Scanner;
public class Exemplo
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme uma nota [0;10]: ");
        double nota = in.nextDouble();
        while(nota<0||nota>10)
        {
            System.out.println("Nota inválida. Digite novamente");
            System.out.print("Informe uma nota [0;10]: ");
            nota = in.nextDouble();
        }
    }
}