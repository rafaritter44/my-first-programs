import java.util.Scanner;
public class Exercicio21
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme a quantidade de bolinhas: ");
        int bol = in.nextInt();
        if(bol<=0)System.out.println("ERRO: valor inválido");
        else
        {
            System.out.print("Informe o tamanho das bolinhas:\n(1)Pequena\t(2)Média\t(3)Grande\n");
            int size = in.nextInt();
            switch(size)
            {
                case 1: System.out.println("Caixas necessárias: " + Math.ceil(bol/550.0)); break;
                case 2: System.out.println("Caixas necessárias: " + Math.ceil(bol/300.0)); break;
                case 3: System.out.println("Caixas necessárias: " + Math.ceil(bol/150.0)); break;
                default: System.out.println("ERRO: tamanho inválido");
            }
        }
    }
}