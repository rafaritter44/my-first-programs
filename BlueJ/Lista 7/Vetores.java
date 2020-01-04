import java.util.Scanner;
public class Vetores
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double[] notas = new double[5];
        
        //escreve
        for(int pos = 0; pos<notas.length; pos++)
        {
            System.out.println(notas[pos]);
        }
        
        //inicialização
        for(int pos = 0; pos<notas.length; pos++)
        {
            //notas[pos] = -1;
            notas[pos] = pos + 1;
        }
        
        for(int pos = 0; pos<notas.length; pos++)
        {
            System.out.println(notas[pos]);
        }
        
        //leitura
        for(int pos = 0; pos<notas.length; pos++)
        {
            System.out.print("Informe a nota da posição " + pos + ": ");
            notas[pos] = in.nextDouble();
        }
        
        for(int pos = 0; pos<notas.length; pos++)
        {
            System.out.println(notas[pos]);
        }
        
        //média
        double soma = 0;
        for(int pos = 0; pos<notas.length; pos++)
        {
            soma += notas[pos];
        }
        System.out.println(soma/notas.length);
        
        //maior
        double maior = notas[0];
        for(int pos = 1; pos<notas.length; pos++)
        {
            if(notas[pos]>maior)maior = notas[pos];
        }
        System.out.println(maior);
    }
}