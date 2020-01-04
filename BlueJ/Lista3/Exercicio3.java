public class Exercicio3
{
    public static void main(String args[])
    {
        int cont = 501, soma = 0;
        while(cont<700)
        {
            soma = soma + cont;
            cont = cont + 2;
        }
        System.out.println("\fSoma = " + soma);
    }
}
        