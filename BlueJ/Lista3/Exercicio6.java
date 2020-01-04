public class Exercicio6
{
    public static void main(String args[])
    {
        int cont = 1000;
        System.out.println("\fNúmeros que divididos por 11 dão resto 5: ");
        while(cont<2000)
        {
            if(cont%11==5)System.out.println(cont);
            cont = cont + 1;
        }
    }
}