import java.util.Scanner;
public class Ex23
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int litros, km;
        double consumo, abastecimento;
        System.out.print("\fInforme a capacidade do carro em litros: ");
        litros = in.nextInt();
        if(litros<=0)System.out.println("ERRO: valor inválido");
        else
        {
            System.out.print("Informe o consumo médio do carro em km/l: ");
            consumo = in.nextDouble();
            if(consumo<=0)System.out.println("ERRO: valor inválido");
            else
            {
                System.out.print("Informe a distância que o carro precisa percorrer: ");
                km = in.nextInt();
                if(km<=0)System.out.println("ERRO: valor inválido");
                else
                {
                    abastecimento = Math.ceil((1.0*km/litros)/consumo);
                    System.out.println("Será necessário abastecer o carro " + abastecimento + " vezes.");
                }
            }
        }
    }
}