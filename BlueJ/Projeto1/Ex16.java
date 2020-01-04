import java.util.Scanner;
public class Ex16
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int h, min, s, sTotais, sRestantes;
        System.out.print("\fInforme em qual hora inteira do dia o evento começa: ");
        h = in.nextInt();
        System.out.print("Informe em qual minuto o evento começa: ");
        min = in.nextInt();
        System.out.print("Informe em qual segundo o evento começa: ");
        s = in.nextInt();
        sTotais = h*3600+min*60+s;
        sRestantes = 86400-sTotais;
        if(h>24||h<0||min>60||min<0||s>60||s<0)
        {
            System.out.print("Horário inválido.");
        }
        else
        {
            System.out.println("Horário do evento em segundos: " + sTotais);
            System.out.println("Segundos restantes no dia: " + sRestantes);
        }
    }
}