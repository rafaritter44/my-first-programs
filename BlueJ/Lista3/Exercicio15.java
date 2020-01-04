import java.util.Scanner;
public class Exercicio15
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int noFilhos, pessoas=0, pessoasSalario2000=0;
        double salario=0, somaFilhos=0, somaSalario=0, maiorSalario=0;
        while(salario>=0)
        {
            System.out.print("Informe o número de filhos: ");
            noFilhos = in.nextInt();
            while(noFilhos<0||noFilhos>100)
            {
                System.out.print("ERRO: valor inválido\nPor favor, informe a quantidade correta de filhos: ");
                noFilhos = in.nextInt();
            }
            System.out.print("Informe o salário: ");
            salario = in.nextDouble();
            if(salario>maiorSalario)maiorSalario=salario;
            if(salario<=2000&&salario>=0)pessoasSalario2000++;
            somaFilhos+=noFilhos;
            somaSalario+=salario;
            pessoas++;
        }
        System.out.println("Média salarial da população: R$" + (somaSalario-salario)/(pessoas-1));
        System.out.println("Média do número de filhos: " + somaFilhos/pessoas);
        System.out.println("Maior salário: " + maiorSalario);
        System.out.println("Percentual de pessoas com salário até R$2000,00: " +
        100.0*pessoasSalario2000/(pessoas-1) + "%");
    }
}