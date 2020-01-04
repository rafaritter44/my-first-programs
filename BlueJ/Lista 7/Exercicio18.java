import java.util.Scanner;
public class Exercicio18
{
    public static void main(String args[])
    {
        double[] vetor1 = new double[20];
        double[] vetor2 = new double[20];
        
        System.out.println("\fVetor 1:");
        leitura(vetor1);
        System.out.println("\nVetor 2:");
        leitura(vetor2);
        
        double[] uniao = uniao(vetor1, vetor2);
        double[] interseccao = interseccao(vetor1, vetor2);
        double[] diferenca = diferenca(vetor1, vetor2);
        
        System.out.println("\nUnião:");
        escrita(uniao);
        System.out.println("\nIntersecção:");
        escrita(interseccao);
        System.out.println("\nDiferença:");
        escrita(diferenca);
    }
    
    public static void leitura(double[] vetor)
    {
        Scanner in = new Scanner(System.in);
        
        for(int pos=0; pos<vetor.length; pos++)
        {
            System.out.print("Informe um valor real para a posição " + pos + ": ");
            vetor[pos] = in.nextDouble();
        }
    }
    
    public static void escrita(double[] vetor)
    {
        for(int pos=0; pos<vetor.length; pos++)
        {
            System.out.println(vetor[pos]);
        }
    }
    
    public static double[] uniao(double[] vet1, double[] vet2)
    {
        double[] u = new double[vet1.length+vet2.length];
        int pos = 0;
        
        for(int i=0; i<vet1.length; i++)
        {
            boolean jaExiste = false;
            for(int j=0; j<pos && !jaExiste; j++)
            {
                if(vet1[i]==u[j])jaExiste = true;
            }
            if(!jaExiste)
            {
                u[pos]=vet1[i];
                pos++;
            }
        }
        
        for(int i=0; i<vet2.length; i++)
        {
            boolean jaExiste = false;
            for(int j=0; j<pos; j++)
            {
                if(vet2[i]==u[j])jaExiste = true;
            }
            if(!jaExiste)
            {
                u[pos]=vet2[i];
                pos++;
            }
        }
        
        double[] ret = new double[pos];
        
        for(int i=0; i<ret.length; i++)
        {
            ret[i]=u[i];
        }
        
        return ret;
    }
    
    public static double[] interseccao(double[] vet1, double[] vet2)
    {
        int menor = vet1.length;
        if(vet2.length<menor)menor=vet2.length;
        double[] u = new double[menor];
        int pos = 0;
        
        for(int i=0; i<vet1.length; i++)
        {
            boolean jaExiste = false;
            for(int j=0; j<pos; j++)
            {
                if(vet1[i]==u[j])jaExiste = true;
            }
            for(int k=0; k<vet2.length && !jaExiste; k++)
            {
                if(vet1[i]==vet2[k])
                {
                    u[pos]=vet1[i];
                    pos++;
                    jaExiste = true;
                }
            }
        }
        
        double[] ret = new double[pos];
        
        for(int i=0; i<ret.length; i++)
        {
            ret[i]=u[i];
        }
        
        return ret;
    }
    
    public static double[] diferenca(double[] vet1, double[] vet2)
    {
        double[] dif = new double[vet1.length];
        int pos = 0;
        
        for(int i=0; i<vet1.length; i++)
        {
            boolean existe = false;
            
            for(int j=0; j<pos; j++)
            {
                if(vet1[i]==dif[j])existe = true;
            }
            
            for(int k=0; k<vet2.length && !existe; k++)
            {
                if(vet1[i]==vet2[k])existe = true;
            }
            
            if(!existe)
            {
                dif[pos]=vet1[i];
                pos++;
            }
        }
        
        double[] ret = new double[pos];
        
        for(int i=0; i<ret.length; i++)
        {
            ret[i]=dif[i];
        }
        
        return ret;
    }
}