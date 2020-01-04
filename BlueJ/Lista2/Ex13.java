import java.util.Scanner;
public class Ex13
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fEscreva um número inteiro de 4 dígitos: ");
        int valor = in.nextInt();
        if(valor>9999||valor<1000)System.out.println("ERRO: valor inválido");
        else
        {
            System.out.println(valor/100 + " + " + (valor-valor/100*100) + " = " + (valor/100+valor-valor/100*100));
            System.out.println((valor/100+valor-valor/100*100) + "² = " + Math.pow(valor/100+valor-valor/100*100,2));
            if(Math.pow(valor/100+valor-valor/100*100,2)==valor)System.out.println("O número possui a característica");
            else System.out.println("O número não possui a característica");
        }
    }
}