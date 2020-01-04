import java.util.Scanner;
public class Ex19
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fForneça a altura em metros: ");
        double altura = in.nextDouble();
        if(altura<=0)System.out.println("ERRO: valor inválido");
        else
        {
            System.out.print("Forneça o peso em quilos: ");
            double peso = in.nextDouble();
            if(peso<=0)System.out.println("ERRO: valor inválido");
            else
            {
                double imc = peso/Math.pow(altura, 2);
                System.out.println("IMC = " + imc);
                if(imc<20)System.out.println("Abaixo do peso");
                else if(imc<=25)System.out.println("Normal");
                else if(imc<=30)System.out.println("Excesso de peso");
                else if(imc<=35)System.out.println("Obesidade");
                else System.out.println("Obesidade mórbida");
            }
        }
    }
}