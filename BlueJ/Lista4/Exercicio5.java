import java.util.Scanner;
public class Exercicio5
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double x1, x2, y1, y2;
        System.out.print("Informe as coordenadas de um ponto no plano.\nx: ");
        x1 = in.nextDouble();
        System.out.print("y: ");
        y1 = in.nextDouble();
        System.out.print("Informe as coordenadas de outro ponto no plano.\nx: ");
        x2 = in.nextDouble();
        System.out.print("y: ");
        y2 = in.nextDouble();
        System.out.println("Distância euclidiana: " + distanciaE(x1,y1,x2,y2));
        System.out.println("Distância de Manhattan: " + distanciaM(x1,y1,x2,y2));
    }
    public static double distanciaE(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
    public static double distanciaM(double x1, double y1, double x2, double y2)
    {
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}