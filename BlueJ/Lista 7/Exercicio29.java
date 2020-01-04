import java.util.Scanner;
public class Exercicio29
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        double[] abscissas = new double[15];
        double[] ordenadas = new double[15];
        
        for(int i=0; i<15; i++)
        {
            System.out.print("Informe o valor da abscissa do ponto " + i + ": ");
            abscissas[i] = in.nextDouble();
            System.out.print("Informe o valor da ordenada do ponto " + i + ": ");
            ordenadas[i] = in.nextDouble();
        }
        
        double[] distancias = new double[14];
        
        for(int i=0; i<distancias.length; i++)
        {
            distancias[i] = distancia(abscissas[i], ordenadas[i], abscissas[i+1], ordenadas[i+1]);
        }
        
        System.out.println("\nDistâncias:");
        
        for(int i=0; i<distancias.length; i++)
        {
            System.out.println(distancias[i]);
        }
    }
    public static double distancia(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
}