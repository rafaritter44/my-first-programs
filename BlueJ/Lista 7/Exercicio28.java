import java.util.Scanner;
import java.util.Random;
public class Exercicio28
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        double totalArrecadado;
        do
        {
            System.out.print("Informe o total arrecadado em apostas da Mega Sena: ");
            totalArrecadado = in.nextDouble();
        }
        while(totalArrecadado<=0);
        
        double premios = totalArrecadado * 0.46;
        double premioPrincipal = premios * 0.35;
        double quina = premios * 0.19;
        double quadra = quina;
        double outrosConcursos = premios * 0.27;
        
        Random gera = new Random();
        int[] numeros = new int[6];
        boolean numeroValido;
        
        for(int i=0; i<numeros.length; i++)
        {
            numeroValido = true;
            numeros[i] = gera.nextInt(60);
            if(numeros[i]==0)
            {
                numeroValido = false;
                i--;
            }
            for(int j=0; j<i && numeroValido; j++)
            {
                if(numeros[i]==numeros[j])
                {
                    i--;
                    numeroValido = false;
                }
            }
        }
        
        int[] apostas = new int[300];
        
        /*
        for(int i=0, j=1, k=1; i<apostas.length; i++, j++)
        {
            if(j==7)
            {
                j=1;
                k++;
            }
            do
            {
                System.out.print("Informe o " + j + "º número do apostador " + k + ": ");
                apostas[i] = in.nextInt();
            }
            while(apostas[i]<1 || apostas[i]>60);
        }
        */
       
        for(int i=0; i<apostas.length; i++)
        {
            apostas[i] = gera.nextInt(60);
            if(apostas[i]==0)i--;
        }
       
        int qtPremiosPrincipais = 0, qtQuinas = 0, qtQuadras = 0;
        for(int i=0; i<apostas.length; i+=6)
        {
            int cont = 0;
            for(int j=i; j<6+i; j++)
            {
                if(apostas[j]==numeros[j-i])cont++;
            }
            if(cont==4)qtQuadras++;
            else if(cont==5)qtQuinas++;
            else if(cont==6)qtPremiosPrincipais++;
        }
        
        System.out.println("\nQuantidade de vencedores: " + (qtQuadras+qtQuinas+qtPremiosPrincipais));
        System.out.println("Prêmio principal: R$" + premioPrincipal + "\tCada vencedor receberá: " +
        premioPrincipal/qtPremiosPrincipais);
        System.out.println(qtQuinas + " apostadores fizeram a quina.");
        System.out.println("Quina: R$" + quina + "\tCada vencedor receberá: " + quina/qtQuinas);
        System.out.println(qtQuadras + " apostadores fizeram a quadra.");
        System.out.println("Quadra: R$" + quadra + "\tCada vencedor receberá: " + quadra/qtQuadras);
    }
}