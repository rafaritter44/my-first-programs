import java.util.Scanner;
public class Ex25
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme a renda, em reais: ");
        double renda = in.nextDouble();
        if(renda<0)System.out.println("ERRO: valor inválido");
        else if(renda<=1868.22)System.out.println("Isento");
        else if(renda<=2799.86)System.out.printf("Imposto de Renda: %.2f", (renda*0.075-140.12));
        else if(renda<=3733.19)System.out.printf("Imposto de Renda: %.2f", (renda*0.15-350.11));
        else if(renda<=4664.68)System.out.printf("Imposto de Renda: %.2f", (renda*0.225-630.10));
        else System.out.printf("Imposto de Renda: %.2f", (renda*0.275-863.33));
    }
}