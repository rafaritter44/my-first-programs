import java.util.Scanner;
public class Combinacao
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o n: ");
        int n = in.nextInt();
        System.out.print("Informe o p: ");
        int p = in.nextInt();
        double fatN = 1;
        for(int cont=2; cont<=n; cont++){
            fatN = fatN * cont;
        }
        double fatP = 1;
        for(int cont=2; cont<=p; cont++){
            fatP = fatP * cont;
        }
        double fatNP = 1;
        for(int cont=2; cont<=(n-p); cont++){
            fatNP = fatNP * cont;
        }
        double combinacao = fatN/(fatP * fatNP);
        System.out.println("Combinacao: " + combinacao);
    }
}
