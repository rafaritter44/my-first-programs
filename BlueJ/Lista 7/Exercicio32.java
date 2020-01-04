import java.util.Scanner;
public class Exercicio32
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int[] a = new int[50];
        
        System.out.println("\fVetor A:");
        for(int i=0; i<a.length; i++)
        {
            System.out.print("Informe o valor inteiro da posição " + i + ": ");
            a[i] = in.nextInt();
        }
        
        int x;
        
        do
        {
            System.out.print("Agora informe a quantidade mínima de repetições (ao menos 2): ");
            x = in.nextInt();
        }
        while(x<=1);
        
        int[] aux = new int[a.length/2];
        int pos = 0;
        
        for(int i=0; i<a.length-1; i++)
        {
            boolean existe = false;
            int repeticoes = 0;
            for(int j=0; j<pos && !existe; j++)
            {
                if(a[i]==aux[j])existe = true;
            }
            for(int k=i; k<i+x-1 && !existe; k++)
            {
                if(a[k]==a[k+1])
                {
                    repeticoes++;
                }
            }
            if(repeticoes==x-1)
            {
                aux[pos]=a[i];
                pos++;
            }
        }
        
        int[] b = new int[pos];
        
        for(int i=0; i<pos; i++)
        {
            b[i]=aux[i];
        }
        
        System.out.println("\nVetor B:");
        for(int i=0; i<pos; i++)
        {
            System.out.println(b[i]);
        }
    }
}