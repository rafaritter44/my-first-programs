public class Exercicio48
{
    public static void main(String args[])
    {
        for(int i = 1000; i<=9999; i++)
        {
            if(caracteristica(i))System.out.println(i);
        }
    }
    public static boolean caracteristica(int valor)
    {
        int a = valor/100, b = valor%100, c = a + b;
        if(Math.pow(c,2)==valor)return true;
        return false;
    }
}