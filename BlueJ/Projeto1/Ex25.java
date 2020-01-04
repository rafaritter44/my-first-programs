import java.util.Scanner;
public class Ex25
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int custo, poltronas, qtShows;
        double lucroPercent, poltronasPercent, valor;
        System.out.print("\fInforme o custo total do espetáculo: ");
        custo = in.nextInt();
        if(custo<=0)System.out.println("ERRO: valor inválido");
        else
        {
            System.out.print("Informe o número de poltronas no teatro: ");
            poltronas = in.nextInt();
            if(poltronas<=0)System.out.println("ERRO: valor inválido");
            else
            {
                System.out.print("Informe quantos shows serão realizados: ");
                qtShows = in.nextInt();
                if(qtShows<=0)System.out.println("ERRO: valor inválido");
                else
                {
                    System.out.print("Informe a porcentagem de lucro desejada: ");
                    lucroPercent = in.nextDouble();
                    if(lucroPercent<=0)System.out.println("ERRO: valor inválido");
                    else
                    {
                        System.out.print("Informe a porcentagem mínima de ocupação esperada: ");
                        poltronasPercent = in.nextDouble();
                        if(poltronasPercent<=0||poltronasPercent>100)System.out.println("ERRO: valor inválido");
                        else
                        {
                            valor = Math.ceil((custo+lucroPercent*custo/100)/(qtShows*poltronas*poltronasPercent/100));
                            System.out.println("O valor do ingresso deverá ser: " + valor);
                        }
                    }
                }
            }
        }
    }
}