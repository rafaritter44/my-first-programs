public class Exercicio13
{
    public static void main(String args[])
    {
        int[] primos = new int[100];
        leitura(primos);
        escrita(primos);
    }
    public static void leitura(int[] vet)
    {
        vet[0] = 2;
        for(int i = 1, cont = 3; i<vet.length; cont+=2)
        {
            if(isPrime(cont))
            {
                vet[i] = cont;
                i++;
            }
        }
    }
    public static boolean isPrime(int n)
    {
        if(n<=1)return false;
        if(n%2==0 && n !=2)return false;
        int limite = (int)Math.sqrt(n);
        for(int i = 3; i<=limite; i+=2)
        {
            if(n%i==0)return false;
        }
        return true;
    }
    public static void escrita(int[] vet)
    {
        for(int i = 0; i<vet.length; i++)
        {
            System.out.println(vet[i]);
        }
    }
}