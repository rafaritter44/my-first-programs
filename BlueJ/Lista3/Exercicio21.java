public class Exercicio21
{
    public static void main(String args[])
    {
        int n1, n2, soma, pow;
        for(int cont=1000; cont<=9999; cont++)
        {
            n1 = cont/100;
            n2 = cont%100;
            soma = n1+n2;
            pow = soma*soma;
            if(cont==pow)
            {
                System.out.println(n1 + " + " + n2 + " = " + soma);
                System.out.println(soma + "² = " + cont);
            }
        }
    }
}