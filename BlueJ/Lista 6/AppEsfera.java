import java.util.Scanner;
public class AppEsfera
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Informe o raio: ");
        double r = in.nextDouble();
        Esfera esfera1 = new Esfera(r);
        /*System.out.println("Valor atual do raio: " + esfera1.getRaio());
        System.out.println("Área: " + esfera1.calcularArea());
        System.out.println("Volume: " + esfera1.calcularVolume());*/
        System.out.println("Dados atuais:\n" + esfera1.toString());
        
        System.out.print("Informe o novo valor do raio: ");
        r = in.nextDouble();
        esfera1.setRaio(r);
        /*System.out.println("Novo valor do raio: " + esfera1.getRaio());
        System.out.println("Área: " + esfera1.calcularArea());
        System.out.println("Volume: " + esfera1.calcularVolume());*/
        System.out.println("Dados após alteração do raio:\n" + esfera1);
    }
}