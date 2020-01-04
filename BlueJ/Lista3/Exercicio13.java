public class Exercicio13
{
    public static void main(String args[])
    {
        int cont = 0;
        System.out.println("\fCelsius\tFahrenheit");
        while(cont<101)
        {
            System.out.println(cont + "\t" + (cont*1.8+32));
            cont = cont + 10;
        }
    }
}