import java.util.Scanner;
public class Exercicio8
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int cont = 0, num, soma = 0, maior = 0, menor = Integer.MAX_VALUE, qt = 0;
        while(cont<50)
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            num = in.nextInt();
            while(num<1)
            {
                System.out.print("ERRO: valor inválido! Informe um valor inteiro e positivo: ");
                num = in.nextInt();
            }
            soma = soma + num;
            if(num>maior)maior = num;
            if(num<menor)menor = num;
            if(num<11)qt = qt + 1;
            cont = cont + 1;
        }
        System.out.println("Média: " + (double)soma/cont);
        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);
        System.out.println("Quantidade de valores no intervalo [0;10]: " + qt);
    }
}