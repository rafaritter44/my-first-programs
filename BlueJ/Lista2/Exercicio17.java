import java.util.Scanner;
public class Exercicio17
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme 5 valores reais: ");
        double n1 = in.nextDouble();
        double n2 = in.nextDouble();
        double n3 = in.nextDouble();
        double n4 = in.nextDouble();
        double n5 = in.nextDouble();
        double maior = Math.max(Math.max(n1, n2), Math.max(Math.max(n3, n4), n5));
        double menor = Math.min(Math.min(n1, n2), Math.min(Math.min(n3, n4), n5));
        double media1 = (n1+n2+n3+n4+n5-maior-menor)/3;
        System.out.println("Média sem o maior e o menor: " + media1);
        double menor2;
        if(n1==menor)menor2 = Math.min(Math.min(n2, n3), Math.min(n4, n5));
        else if(n2==menor)menor2 = Math.min(Math.min(n1, n3), Math.min(n4, n5));
        else if(n3==menor)menor2 = Math.min(Math.min(n1, n2), Math.min(n4, n5));
        else if(n4==menor)menor2 = Math.min(Math.min(n1, n2), Math.min(n3, n5));
        else menor2 = Math.min(Math.min(n1, n2), Math.min(n3, n4));
        double media2 = (n1+n2+n3+n4+n5-menor-menor2)/3;
        System.out.println("Média sem os dois menores: " + media2);
    }
}