import java.util.Scanner;
public class Exercicio10
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int num, somatorio = 0, fatorial = 1, cont = 1;
        System.out.print("\fInforme um valor inteiro e não negativo: ");
        num = in.nextInt();
        while(num<0)
        {
            System.out.print("ERRO: valor inválido\nPor favor, informe um valor inteiro e não negativo: ");
            num = in.nextInt();
        }
        while(cont<=num)
        {
            somatorio = somatorio + cont;
            fatorial = fatorial*cont;
            cont = cont + 1;
        }
        System.out.println("Somatório de " + num + ":\t" + somatorio + "\nFatorial de " + num + ":\t" +
        fatorial);
    }
}