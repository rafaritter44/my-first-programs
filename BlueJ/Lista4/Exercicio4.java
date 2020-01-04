import java.util.Scanner;
public class Exercicio4
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int horas, minutos, segundos;
        do
        {
            System.out.print("Informe os segundos: ");
            segundos = in.nextInt();
        }
        while(segundos<0||segundos>59);
        do
        {
            System.out.print("Informe os minutos: ");
            minutos = in.nextInt();
        }
        while(minutos<0||minutos>59);
        do
        {
            System.out.print("Informe as horas: ");
            horas = in.nextInt();
        }
        while(horas<0||horas>23);
        System.out.println("Quanto tempo se passou no dia, em segundos: " + segundos(horas, minutos, segundos));
    }
    public static int segundos(int h, int min, int s)
    {
        return s+min*60+h*3600;
    }
}