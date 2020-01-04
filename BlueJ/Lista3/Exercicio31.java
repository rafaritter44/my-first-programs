import java.util.Scanner;
public class Exercicio31
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int qnt=0, intervalo1=0, intervalo2=0, intervalo3=0, intervalo4=0;
        double num;
        do
        {
            System.out.print("Informe um valor: ");
            num = in.nextDouble();
            if(num>=0&&num<=25)intervalo1++;
            else if(num>=26&&num<=50)intervalo2++;
            else if(num>=51&&num<=75)intervalo3++;
            else if(num>=76&&num<=100)intervalo4++;
            qnt++;
        }
        while(num>=0);
        System.out.println("Quantidade de valores pertencentes ao intervalo [0;25]: " + intervalo1);
        System.out.println("Quantidade de valores pertencentes ao intervalo [26;50]: " + intervalo2);
        System.out.println("Quantidade de valores pertencentes ao intervalo [51;75]: " + intervalo3);
        System.out.println("Quantidade de valores pertencentes ao intervalo [76;100]: " + intervalo4);
        System.out.println("Quantidade de números lidos: " + qnt);
    }
}