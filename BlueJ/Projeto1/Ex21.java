import java.util.Scanner;
public class Ex21
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int conta, digito, inverso, c, d, u, soma, m, c2, d2, u2, soma2;
        System.out.print("\fInforme o número de três dígitos da conta corrente: ");
        conta = in.nextInt();
        if(conta>999||conta<100)System.out.println("ERRO: senha inválida");
        else
        {
            u = conta/100;
            d = conta%100/10;
            c = conta%100%10;
            inverso = c*100+d*10+u;
            soma = conta+inverso;
            if(soma>999)
            {
                m = soma/1000;
                c2 = soma%1000/100;
                d2 = soma%1000%100/10;
                u2 = soma%1000%100%10;
                soma2 = u2+d2*2+c2*3+m*4;
            }
            else
            {
                c2 = soma/100;
                d2 = soma%100/10;
                u2 = soma%100%10;
                soma2 = u2+d2*2+c2*3;
            }
            if(soma2<10)digito=soma2;
            else digito = soma2%10;
            System.out.println("Conta: " + conta + " Dígito verificador: " + digito);
        }
    }
}