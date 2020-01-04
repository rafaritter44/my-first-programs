public class Exercicio35
{
    public static void main(String args[])
    {
        int cont = 1, num = 2, divisor, cont2;
        while(cont<=100)
        {
            divisor = 0;
            cont2 = 2;
            while(divisor==0&&cont2<=num/2)
            {
                if(num%cont2==0)divisor=1;
                cont2++;
            }
            if(divisor==0)
            {
                System.out.println(num);
                cont++;
            }
            num++;
        }
    }
}