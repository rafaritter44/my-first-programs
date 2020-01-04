import java.util.Scanner;
public class Combinacao2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o n: ");
        int n = in.nextInt();
        System.out.print("Informe o p: ");
        int p = in.nextInt();
        double combinacao = fatorial(n)/(fatorial(p) * fatorial(n-p));
        System.out.println("Combinacao: " + combinacao);
    }
    public static double fatorial(int valor)
    {
        double f = 1;
        for(int cont=2; cont<=valor; cont++){
            f = f * cont;
        }
        return f;        
    }
}