import java.util.Scanner;
public class Ex9
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme a temperatura da água: ");
        double temp = in.nextDouble();
        System.out.print("Informe a escala — Celsius(1) ou Fahrenheit(2): ");
        int escala = in.nextInt();
        switch(escala)
        {
            case 1: if(temp<-273.15)System.out.println("ERRO: temperatura inválida");
            else if(temp<0)System.out.println("Estado sólido");
            else if(temp>0&&temp<100)System.out.println("Estado líquido");
            else if(temp>100)System.out.println("Estado gasoso");
            else System.out.println("Em transição de estado"); break;
            case 2: if(temp<-459.67)System.out.println("ERRO: temperatura inválida");
            else if(temp<32)System.out.println("Estado sólido");
            else if(temp>32&&temp<212)System.out.println("Estado líquido");
            else if(temp>212)System.out.println("Estado gasoso");
            else System.out.println("Em transição de estado"); break;
            default: System.out.println("ERRO: escala inválida");
        }
    }
}