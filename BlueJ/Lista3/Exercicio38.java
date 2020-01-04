import java.util.Scanner;
public class Exercicio38
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n, k, q1, q2, saida=0;
        double media = 0;
        do
        {
            System.out.print("Informe um valor inteiro: ");
            n = in.nextInt();
        }
        while(n<0);
        do
        {
            System.out.print("Informe o número de interações: ");
            k = in.nextInt();
        }
        while(k<=0);
        for(int cont = n-1; cont>=1 && saida==0; cont--)
        {
            if(Math.pow((int)Math.sqrt(cont),2)==cont)
            {
                q1=cont;
                for(int cont2 = q1-1; cont2>=1 && saida==0; cont--)
                {
                    if(Math.pow((int)Math.sqrt(cont2),2)==cont2)
                    {
                        saida = 1;
                        q2=cont2;
                        media = (q1+q2)/2.0;
                        for(int cont3 = 1; cont3<=k; cont3++)
                        {
                            media = (media + n/media)/2;
                        }
                    }
                }
            }
        }
        System.out.println(media);
    }
}