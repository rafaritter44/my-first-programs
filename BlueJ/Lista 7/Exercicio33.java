import java.util.Scanner;
public class Exercicio33
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int[] a = new int[50];
        
        System.out.println("\fVetor A:");
        for(int i=0; i<a.length; i++)
        {
            System.out.print("Informe o valor inteiro e positivo da posição " + i + ": ");
            a[i] = in.nextInt();
            if(a[i]<=0)i--;
        }
        
        int[] aux = new int[a.length+a.length/2-1];
        int pos = 0;
        
        for(int i=0; i<a.length-1; i++)
        {
            int j=i;
            boolean repetiu = false, ultimo = false;
            while(!ultimo && a[j]==a[j+1])
            {
                aux[pos]=a[j];
                pos++;
                j++;
                repetiu = true;
                if(j==a.length-1)ultimo = true;
            }
            if(repetiu)
            {
                aux[pos]=a[j];
                pos++;
                aux[pos]=-1;
                pos++;
            }
            i+=j-i;
        }
        
        if(pos!=0)
        {
            int[] b = new int[pos-1];
            
            for(int i=0; i<b.length; i++)
            {
                b[i]=aux[i];
            }
            
            System.out.println("\nVetor B:");
            for(int i=0; i<b.length; i++)
            {
                System.out.println(b[i]);
            }
        }
    }
}