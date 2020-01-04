import java.util.Scanner;
public class Exercicio37
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n;
        do
        {
            System.out.print("Informe um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        while(n<=0);
        int n2=4+n*2, divisor, primo1, primo2, saida;
        for(int cont = 4; cont<n2; cont+=2)
        {
            for(int cont2 = 2; cont2<=cont/2; cont2++)
            {
                divisor=0;
                saida=0;
                for(int cont3 = 2; cont3<=cont2/2 && divisor==0; cont3++)
                {
                    if(cont2%cont3==0)divisor++;
                }
                if(divisor==0)
                {
                    primo1=cont2;
                    for(int cont4 = cont/2; cont4<cont && saida==0; cont4++)
                    {
                        divisor=0;
                        for(int cont5 = 2; cont5<=cont4/2 && divisor==0; cont5++)
                        {
                            if(cont4%cont5==0)divisor++;
                        }
                        if(divisor==0)
                        {
                            primo2=cont4;
                            if(primo1+primo2==cont)
                            {
                                System.out.println(cont + " pode ser decomposto em " + primo1 + " e " + primo2);
                                saida=1;
                            }
                        }
                    }
                }
            }
        }
    }
}