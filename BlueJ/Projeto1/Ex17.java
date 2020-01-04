import java.util.Scanner;
public class Ex17
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int qtDegraus;
        double alturaDegraus, alturaUser, alturaDesejada, alturaMax, degraus;
        System.out.print("\fInforme a quantidade de degraus da escada: ");
        qtDegraus = in.nextInt();
        if(qtDegraus<=0)System.out.println("ERRO: quantidade inválida de degraus");
        else
        {
            System.out.print("Informe a altura de cada degrau: ");
            alturaDegraus = in.nextDouble();
            if(alturaDegraus<=0)System.out.println("ERRO: altura inválida");
            else
            {
                System.out.print("Informe sua altura: ");
                alturaUser = in.nextDouble();
                if(alturaUser<=0||alturaUser>=3)System.out.println("ERRO: altura inválida");
                else 
                {
                    System.out.print("Informe a altura que deseja atingir: ");
                    alturaDesejada = in.nextDouble();
                    if(alturaDesejada>qtDegraus*alturaDegraus+alturaUser)System.out.println("Altura inatingível");
                    else
                    {
                        if(alturaDesejada<alturaUser)System.out.println("Você não precisa subir nenhum degraus para atingir essa altura");
                        else
                        {
                        degraus = Math.ceil((alturaDesejada-alturaUser)/alturaDegraus);
                        System.out.println("Você deve subir " + degraus + " degraus para atingir a altura desejada");                        
                    }
                }
                    alturaMax = qtDegraus*alturaDegraus+alturaUser;
                    System.out.println("A altura máxima que você pode atingir é: " + alturaMax);
                }
            }
        }
    }
}