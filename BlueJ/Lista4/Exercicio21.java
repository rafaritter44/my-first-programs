import java.util.Scanner;
public class Exercicio21
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe 3 valores inteiros: ");
        int valor1 = in.nextInt();
        int valor2 = in.nextInt();
        int valor3 = in.nextInt();
        System.out.println(crescente2(valor1,valor2,valor3));
    }
    public static String crescente2(int v1, int v2, int v3)
    {
        int maior = v1;
        if(v2>maior)maior=v2;
        if(v3>maior)maior=v3;
        int menor = v1;
        if(v2<menor)menor=v2;
        if(v3<menor)menor=v3;
        int meio = v1 + v2 + v3 - maior - menor;
        return "Ordem crescente: " + menor + ", " + meio + ", " + maior;
    }
}