public class P2E3
{
    public static int quantidadePrimos(int n)
    {
        int quantidade = 0;
        for(int i = 2; i<=n; i++)
        {
            int divisores = 0;
            for(int j = 2; j<=i; j++)
            {
                if(i%j==0)divisores++;
            }
            if(divisores==1)quantidade++;
        }
        return quantidade;
    }
}
        