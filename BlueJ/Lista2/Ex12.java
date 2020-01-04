import java.util.Scanner;
public class Ex12
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme um mês (escreva valores de 1 a 12): ");
        int mes = in.nextInt();
        switch(mes)
            {
                case 1: System.out.println("31 dias"); break;
                case 2: System.out.println("28 dias (29 em anos bissextos)"); break;
                case 3: System.out.println("31 dias"); break;
                case 4: System.out.println("30 dias"); break;
                case 5: System.out.println("31 dias"); break;
                case 6: System.out.println("30 dias"); break;
                case 7: System.out.println("31 dias"); break;
                case 8: System.out.println("31 dias"); break;
                case 9: System.out.println("30 dias"); break;
                case 10: System.out.println("31 dias"); break;
                case 11: System.out.println("30 dias"); break;
                case 12: System.out.println("31 dias"); break;
                default: System.out.println("ERRO: mês inválido");
            }
        }
    }