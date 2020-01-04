import java.util.Scanner;
public class Exercicio22
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int num;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            num = in.nextInt();
        }
        while(num<=0);
        System.out.println("Somatório: " + somatorio(num));
    }
    public static int somatorio(int valor)
    {
        int soma = 0;
        for(int cont=1; cont<=valor; cont++)
        {
            soma += cont;
        }
        return soma;
    }
}