import java.util.Random;
public class ExemploOrdenacao
{
    public static void main(String args[])
    {
        int[] vetor = new int[30];
        preenche(vetor);
        System.out.println("\fValores do vetor: ");
        escreve(vetor);
        //ordena(vetor);
        ordena2(vetor);
        System.out.println("Valores ordenados: ");
        escreve(vetor);
    }
    public static void preenche(int[] v)
    {
        Random gera = new Random();
        for(int i=0; i<v.length; i++)
        {
            v[i] = gera.nextInt(10);
        }
    }
    public static void escreve(int[] v)
    {
        for(int i=0; i<v.length; i++)
        {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
    public static void ordena(int[] v)
    {
        int aux;
        for(int i=0; i<v.length-1; i++)
        {
            for(int pos=0; pos<v.length-1-i; pos++)
            {
                if(v[pos]>v[pos+1])
                {
                    aux = v[pos];
                    v[pos] = v[pos+1];
                    v[pos+1] = aux;
                }
            }
        }
    }
    public static void ordena2(int[] v)
    {
        boolean ordenado = false;
        int aux;
        while(!ordenado)
        {
            ordenado = true;
            for(int pos=0; pos<v.length-1; pos++)
            {
                if(v[pos]>v[pos+1])
                {
                    aux = v[pos];
                    v[pos] = v[pos+1];
                    v[pos+1] = aux;
                    ordenado = false;
                }
            }
        }
    }
}