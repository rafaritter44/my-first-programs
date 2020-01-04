import java.util.Scanner;
public class Exercicio11
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme em que hora(s) inteira(s) o jogo começa: ");
        int hora1 = in.nextInt();
        if(hora1<0||hora1>=24)System.out.println("ERRO: horário inválido");
        else
        {
            System.out.print("Informe em que minuto(s) o jogo começa: ");
            int min1 = in.nextInt();
            if(min1<0||min1>=60)System.out.println("ERRO: horário inválido");
            else
            {
                System.out.print("Informe em que hora(s) inteira(s) o jogo acaba: ");
                int hora2 = in.nextInt();
                if(hora2<0||hora2>=24)System.out.println("ERRO: horário inválido");
                else
                {
                    System.out.print("Informe em que minuto(s) o jogo acaba: ");
                    int min2 = in.nextInt();
                    if(min2<0||min2>=60)System.out.println("ERRO: horário inválido");
                    else
                    {
                        if(hora1==hora2&&min1==min2)System.out.println("O jogo dura 24 horas");
                        else if(hora1==hora2&&min1>min2)System.out.println("O jogo dura 23 horas e "
                        + (60-(min1-min2)) + " minuto(s).");
                        else if(hora1==hora2)System.out.println("O jogo dura " + (min2-min1) + " minuto(s).");
                        else if(hora1>hora2&&min1<=min2)System.out.println("O jogo dura " +
                        (24-hora1+hora2) + " hora(s) e " + (min2-min1) + " minuto(s).");
                        else if(hora1>hora2)System.out.println("O jogo dura " +
                        (23-hora1+hora2) + " hora(s) e " + (60-min1+min2) + " minuto(s).");
                        else if(min1<=min2)System.out.println("O jogo dura " +
                        (hora2-hora1) + " hora(s) e " + (min2-min1) + " minuto(s).");
                        else System.out.println("O jogo dura " + (hora2-hora1-1) + " hora(s) e " +
                        (60-min1+min2) + " minuto(s).");
                    }
                }
            }
        }
    }
}