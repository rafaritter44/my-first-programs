import java.util.Scanner;
public class Exercicio23
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme o saldo médio: ");
        double saldo = in.nextDouble();
        System.out.print("1 — Sacar\n2 – Depositar\n3 — Exibir limite\n");
        int opcao = in.nextInt();
        switch(opcao)
        {
            case 1: System.out.print("Informe o valor que deseja sacar: ");
            double saque = in.nextDouble();
            if(saque<=0)System.out.println("ERRO: valor inválido");
            else if(saque>saldo)System.out.println("ERRO: valor indisponível");
            else if(saldo>=1000&&saque>0.15*saldo)System.out.println("ERRO: valor excede limite");
            else if(saldo>=500&&saldo<1000&&saque>0.08*saldo)System.out.println("ERRO: valor excede limite");
            else System.out.println("Saque efetuado com sucesso! Saldo médio atual: " + (saldo-saque));
            break;
            case 2: System.out.print("Informe o valor que deseja depositar: ");
            double deposito = in.nextDouble();
            if(deposito<=0)System.out.println("ERRO: valor inválido");
            else System.out.println("Depósito efetuado com sucesso! Saldo médio atual: " + (saldo+deposito));
            break;
            case 3: if(saldo<500)System.out.println("Não há limite");
            else if(saldo<1000)System.out.println("Limite em reais: " + 0.08*saldo);
            else System.out.println("Limite em reais: " + 0.15*saldo); break;
            default: System.out.println("ERRO: opção inválida");
        }
    }
}