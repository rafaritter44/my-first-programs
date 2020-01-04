import java.util.Scanner;
public class Exercicio26
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme a representação da carta (valor e naipe): ");
        String carta = in.nextLine();
        int compCarta = carta.length();
        if(compCarta<2||compCarta>3)System.out.println("ERRO: carta inválida");
        else
        {
            if(compCarta<3)
            {
                char valor = carta.charAt(0), naipe = carta.charAt(1);
                if(valor=='A')
                {
                    if(naipe=='C')System.out.println("Ás de copas");
                    else if(naipe=='P')System.out.println("Ás de paus");
                    else if(naipe=='E')System.out.println("Ás de espadas");
                    else if(naipe=='O')System.out.println("Ás de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='2')
                {
                    if(naipe=='C')System.out.println("Dois de copas");
                    else if(naipe=='P')System.out.println("Dois de paus");
                    else if(naipe=='E')System.out.println("Dois de espadas");
                    else if(naipe=='O')System.out.println("Dois de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='3')
                {
                    if(naipe=='C')System.out.println("Três de copas");
                    else if(naipe=='P')System.out.println("Três de paus");
                    else if(naipe=='E')System.out.println("Três de espadas");
                    else if(naipe=='O')System.out.println("Três de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='4')
                {
                    if(naipe=='C')System.out.println("Quatro de copas");
                    else if(naipe=='P')System.out.println("Quatro de paus");
                    else if(naipe=='E')System.out.println("Quatro de espadas");
                    else if(naipe=='O')System.out.println("Quatro de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='5')
                {
                    if(naipe=='C')System.out.println("Cinco de copas");
                    else if(naipe=='P')System.out.println("Cinco de paus");
                    else if(naipe=='E')System.out.println("Cinco de espadas");
                    else if(naipe=='O')System.out.println("Cinco de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='6')
                {
                    if(naipe=='C')System.out.println("Seis de copas");
                    else if(naipe=='P')System.out.println("Seis de paus");
                    else if(naipe=='E')System.out.println("Seis de espadas");
                    else if(naipe=='O')System.out.println("Seis de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='7')
                {
                    if(naipe=='C')System.out.println("Sete de copas");
                    else if(naipe=='P')System.out.println("Sete de paus");
                    else if(naipe=='E')System.out.println("Sete de espadas");
                    else if(naipe=='O')System.out.println("Sete de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='8')
                {
                    if(naipe=='C')System.out.println("Oito de copas");
                    else if(naipe=='P')System.out.println("Oito de paus");
                    else if(naipe=='E')System.out.println("Oito de espadas");
                    else if(naipe=='O')System.out.println("Oito de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='9')
                {
                    if(naipe=='C')System.out.println("Nove de copas");
                    else if(naipe=='P')System.out.println("Nove de paus");
                    else if(naipe=='E')System.out.println("Nove de espadas");
                    else if(naipe=='O')System.out.println("Nove de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='J')
                {
                    if(naipe=='C')System.out.println("Valete de copas");
                    else if(naipe=='P')System.out.println("Valete de paus");
                    else if(naipe=='E')System.out.println("Valete de espadas");
                    else if(naipe=='O')System.out.println("Valete de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='Q')
                {
                    if(naipe=='C')System.out.println("Rainha de copas");
                    else if(naipe=='P')System.out.println("Rainha de paus");
                    else if(naipe=='E')System.out.println("Rainha de espadas");
                    else if(naipe=='O')System.out.println("Rainha de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else if(valor=='K')
                {
                    if(naipe=='C')System.out.println("Rei de copas");
                    else if(naipe=='P')System.out.println("Rei de paus");
                    else if(naipe=='E')System.out.println("Rei de espadas");
                    else if(naipe=='O')System.out.println("Rei de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else System.out.println("ERRO: carta inválida");
            }
            else
            {
                char um = carta.charAt(0), zero = carta.charAt(1), naipe = carta.charAt(2);
                if(um=='1'&&zero=='0')
                {
                    if(naipe=='C')System.out.println("Dez de copas");
                    else if(naipe=='P')System.out.println("Dez de paus");
                    else if(naipe=='E')System.out.println("Dez de espadas");
                    else if(naipe=='O')System.out.println("Dez de ouro");
                    else System.out.println("ERRO: carta inválida");
                }
                else System.out.println("ERRO: carta inválida");
            }
        }
    }
}