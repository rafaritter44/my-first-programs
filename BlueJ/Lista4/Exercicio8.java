import java.util.Scanner;
public class Exercicio8
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int valor;
        do
        {
            System.out.print("Informe um valor inteiro de 4 dígitos: ");
            valor = in.nextInt();
        }
        while(Math.abs(valor)<1000||Math.abs(valor)>9999);
        System.out.println("Valor invertido: " + inversao(valor));
    }
    public static int inversao(int num)
    {
        int u, d, c, m;
        u = num/1000;
        d = num%1000/100;
        c = num%100/10;
        m = num%10;
        return m*1000+c*100+d*10+u;
    }
}