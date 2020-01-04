import java.util.Scanner;
public class Exemplo
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\fInforme um nome: ");
        String nome = in.nextLine();
        int comprimento = nome.length();
        System.out.println("Quantidade de caracteres: " + comprimento);
        char primeiraLetra = nome.charAt(0);
        char segundaLetra = nome.charAt(1);
        char ultimaLetra = nome.charAt(comprimento-1);
        System.out.println("Primeira Letra: " + primeiraLetra);
        System.out.println("Segunda Letra: " + segundaLetra);
        System.out.println("Última Letra: " + ultimaLetra);
        System.out.print("Informe outro nome: ");
        String nome2 = in.nextLine();
        if(nome.equals(nome2))System.out.println("Nomes idênticos");
        else System.out.println("Nomes diferentes");
        if(nome.equalsIgnoreCase(nome2))System.out.println("Nomes iguais independentemente da caixa");
        else System.out.println("Nomes diferentes");
        //int r = nome.compareTo(nome2);
        int r = nome.compareToIgnoreCase(nome2);
        if(r==0)System.out.println("CompareTo (==0) - Nomes idênticos");
        if(r>0)System.out.println("CompareTo (>0) - Ordem Alfabética: " + nome2 + " " + nome);
        if(r<0)System.out.println("CompareTo (<0) - Ordem Alfabética: " + nome + " " + nome2);
        String nomeCaixaAlta = nome.toUpperCase();
        String nome2CaixaBaixa = nome2.toLowerCase();
        System.out.println("Nome em Caixa Alta: " + nomeCaixaAlta);
        System.out.println("Outro nome em Caixa Baixa: " + nome2CaixaBaixa);
    }
}