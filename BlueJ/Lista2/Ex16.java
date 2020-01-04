import java.util.Scanner;
public class Ex16
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        double n1, n2, n3, n4, p, s, t, q;
        System.out.print("\fInforme o primeiro valor real: ");
        n1 = in.nextDouble();
        System.out.print("Informe o segundo valor: ");
        n2 = in.nextDouble();
        System.out.print("Informe o terceiro: ");
        n3 = in.nextDouble();
        System.out.print("E o quarto: ");
        n4 = in.nextDouble();
        p = Math.min(Math.min(n1,n2),Math.min(n3,n4));
        q = Math.max(Math.max(n1,n2),Math.max(n3,n4));
        if(n1==p||n1==q)
        {
            if(n2==p||n2==q)
            {
                if(n3<n4)
                {
                    s = n3;
                    t = n4;
                }
                else
                {
                    s = n4;
                    t = n3;
                }
            }
            else
            {
                if(n3==p||n3==q)
                {
                    if(n2<n4)
                    {
                        s = n2;
                        t = n4;
                    }
                    else
                    {
                        s = n4;
                        t = n2;
                    }
                }
                else
                {
                    if(n2<n3)
                    {
                        s = n2;
                        t = n3;
                    }
                    else
                    {
                        s = n3;
                        t = n2;
                    }
                }
            }
        }
        else
        {
            if(n2==p||n2==q)
            {
                if(n3==p||n3==q)
                {
                    if(n1<n4)
                    {
                        s = n1;
                        t = n4;
                    }
                    else
                    {
                        s = n4;
                        t = n1;
                    }
                }
                else
                {
                    if(n1<n3)
                    {
                        s = n1;
                        t = n3;
                    }
                    else
                    {
                        s = n3;
                        t = n1;
                    }
                }
            }
            else
            {
                if(n1<n2)
                {
                    s = n1;
                    t = n2;
                }
                else
                {
                    s = n2;
                    t = n1;
                }
            }
        }
        System.out.println("Ordem crescente: " + p + ", " + s + ", " + t + ", " + q + ".");
   }
}