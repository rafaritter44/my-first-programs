import java.util.Scanner;
public class AppSinaleira
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o estado da sinaleira: ");
        String estado = in.nextLine();
        Sinaleira sinaleira1 = new Sinaleira(estado);
        System.out.println(sinaleira1);
        for(int i = 1; i<=2; i++)
        {
            System.out.println("Próximo estado!");
            sinaleira1.proximoEstado();
        }
        System.out.println(sinaleira1);
    }
}