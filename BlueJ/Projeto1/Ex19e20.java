import java.util.Scanner;
public class Ex19e20
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int caes, diasAlimentados;
        double racao, dias;
        System.out.print("\fInforme quantos cães Maria possui: ");
        caes = in.nextInt();
        if(caes<=0)System.out.println("ERRO: quantidade inválida");
        else
        {
            System.out.print("Informe quantos gramas de ração, em média, os cães de Maria comem: ");
            racao = in.nextDouble();
            if(racao<=0)System.out.println("ERRO: quantidade inválida");
            else
            {
                dias = Math.floor(25000/(3*caes*racao));
                System.out.println("Um saco de ração é suficiente para alimentar os cães por " + dias + " dias.");
                System.out.print("Informe por quantos dias os cães precisarão ser alimentados: ");
                diasAlimentados = in.nextInt();
                if(diasAlimentados<=0)System.out.println("ERRO: valor inválido");
                else System.out.println("Sacos necessários: " + Math.ceil((diasAlimentados*3*caes*racao)/25000));
            }
        }
    }
}
        