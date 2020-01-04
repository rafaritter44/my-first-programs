import java.util.Scanner;
public class Exercicio31
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
        
        int[] aux = new int[a.length/2];
        int pos = 0;
        boolean existe;
        
        for(int i=0; i<a.length-1; i++)
        {
            existe = false;
            for(int j=0; j<pos && !existe; j++)
            {
                if(a[i]==aux[j])existe = true;
            }
            if(a[i]==a[i+1] && !existe)
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