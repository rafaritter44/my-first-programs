import java.util.Scanner;
public class Ex24
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme, em reais, o salário de contribuição: ");
        double salario = in.nextDouble();
        if(salario<=0)System.out.println("ERRO: valor inválido");
        else if(salario<=1317.07)System.out.printf("Alíquota INSS: %.2f", (salario*0.08));
        else if(salario<=2195.12)System.out.printf("Alíquota INSS: %.2f", (salario*0.09));
        else if(salario<=4390.24)System.out.printf("Alíquota INSS: %.2f", (salario*0.11));
        else System.out.printf("Alíquota INSS: %.2f", (4390.24*0.11));
    }
}