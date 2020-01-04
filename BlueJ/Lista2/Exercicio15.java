import java.util.Scanner;
public class Exercicio15
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme 3 valores reais: ");
        double valor1 = in.nextDouble();
        double valor2 = in.nextDouble();
        double valor3 = in.nextDouble();
        double maior = valor1;
        if(valor2>maior)maior = valor2;
        if(valor3>maior)maior = valor3;
        double menor = valor1;
        if(valor2<menor)menor = valor2;
        if(valor3<menor)menor = valor3;
        double meio = valor1 + valor2 + valor3 - maior - menor;
        System.out.print("Infome\n1ou5-Ordem Crescente\n2ou6-Ordem Decrescente\n3ou7-Maior no meio: ");
        int opcao = in.nextInt();
        switch(opcao)
        {
        case 1:
        case 5: System.out.println("Crescente: " + menor + " " + meio + " " + maior);
        break;
        case 2:
        case 6: System.out.println("Decrescente: " + maior + " " + meio + " " + menor);
        break;
        case 3:
        case 7: System.out.println("Maior no meio: " + menor + " " + maior + " " + meio);
        break;
        default: System.out.println("Opção inválida");
        }
        }
}
