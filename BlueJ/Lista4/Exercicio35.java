import java.util.Scanner;
public class Exercicio35
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String binario;
        int comprimento;
        boolean isBinary;
        do
        {
            System.out.print("Informe um valor em binário de 8 bits (exemplo: 00000100): ");
            binario = in.nextLine();
            comprimento = binario.length();
            isBinary = true;
            if(comprimento!=8)isBinary = false;
            for(int i = 0; i<=7 && isBinary; i++)
            {
                if(binario.charAt(i)!='0' && binario.charAt(i)!='1')isBinary = false;
            }
        }
        while(!isBinary);
        System.out.println("Valor em decimal: " + binarioDecimal(binario));
    }
    public static short binarioDecimal(String binario)
    {
        short decimal = 0;
        for(short i = 0, j = 128; i<=7; i++, j/=2)
        {
            if(binario.charAt(i)=='1')decimal+=j;
        }
        return decimal;
    }
}