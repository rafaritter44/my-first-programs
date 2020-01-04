public class Exercicio7
{
    public static void main(String args[])
    {
        int cont = 105;
        System.out.println("\fPrimeiros 50 números acima de 100 que são divisíveis por 7:");
        while(cont<=105+7*49)
        {
            System.out.println(cont);
            cont = cont + 7;
        }
    }
}