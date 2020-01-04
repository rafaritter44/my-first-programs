import java.util.Scanner;
public class Ex14
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int qt;
        double valor, custo;
        System.out.print("\fInforme a quantidade de sacos a serem comprados: ");
        qt = in.nextInt();
        System.out.print("Informe o preço unitário de cada saco: ");
        valor = in.nextDouble();
        custo = qt/10*10*valor*0.95+qt%10*valor;
        System.out.print("Custo da compra: " + custo);
    }
}