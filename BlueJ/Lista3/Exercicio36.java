public class Exercicio36
{
    public static void main(String args[])
    {
        int cont = 1, num = 6, soma, cont2;
        while(cont<=5)
        {
            soma = 1;
            cont2 = 2;
            while(cont2<=num/2)
            {
                if(num%cont2==0)soma=soma+cont2;
                cont2++;
            }
            if(num==soma)
            {
                System.out.println(num);
                cont++;
            }
            num++;
        }
    }
}