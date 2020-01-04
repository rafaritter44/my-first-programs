/**
 * Aplicação Truco.
 * 
 * @author Rafael Ritter 
 * @version 19/11/2016
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class App
{
    public static void main(String[] args)throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);
        
        Jogo jogo = null;
        File arquivo = new File("truco.txt");
        
        String opcao;
        do
        {
            System.out.println("\n---- MENU PRINCIPAL ----\n");
            System.out.println("(N) Novo jogo");
            if(arquivo.exists())System.out.println("(R) Retomar último jogo salvo");
            System.out.println("(X) Sair");
            System.out.print("\nInforme a opção: ");
            opcao = in.nextLine();
            
            if(opcao.equalsIgnoreCase("N"))
            {
                novoJogo(jogo);
            }
            else if(opcao.equalsIgnoreCase("R") && arquivo.exists())
            {
                retomarJogo(jogo);
            }
            else if(!opcao.equalsIgnoreCase("X"))
            {
                System.out.println("\nOPÇÃO INVÁLIDA");
            }
            else System.out.println("\n---- FIM DE PROGRAMA ----\n");            
        }
        while(!opcao.equalsIgnoreCase("X"));
    }
    
    public static void novoJogo(Jogo jogo)throws FileNotFoundException
    {
        jogo = new Jogo();
        
        boolean continuar = true;
        while(jogo.getDupla1().getPontos()<12 && jogo.getDupla2().getPontos()<12 && continuar)
        {
            continuar = jogo.proximaJogada(jogo.getProximoJogador());
            if(jogo.getJogador1().getCartaEscolhida()!=null && jogo.getJogador2().getCartaEscolhida()!=null
            && jogo.getJogador3().getCartaEscolhida()!=null && jogo.getJogador4().getCartaEscolhida()!=null)
            {
                jogo.levada();
            }
        }
        
        if(jogo.getDupla1().getPontos()>=12)
        {
            System.out.println("\nA " + jogo.getDupla1().getNome().toUpperCase() + " VENCEU!");
        }
        else if(jogo.getDupla2().getPontos()>=12)
        {
            System.out.println("\nA " + jogo.getDupla2().getNome().toUpperCase() + " VENCEU!");
        }
    }
    
    public static void retomarJogo(Jogo jogo)throws FileNotFoundException
    {
        jogo = new Jogo("truco.txt");
        
        boolean continuar = true;
        while(jogo.getDupla1().getPontos()<12 && jogo.getDupla2().getPontos()<12 && continuar)
        {
            continuar = jogo.proximaJogada(jogo.getProximoJogador());
            if(jogo.getJogador1().getCartaEscolhida()!=null && jogo.getJogador2().getCartaEscolhida()!=null
            && jogo.getJogador3().getCartaEscolhida()!=null && jogo.getJogador4().getCartaEscolhida()!=null)
            {
                jogo.levada();
            }
        }
        
        if(jogo.getDupla1().getPontos()>=12)
        {
            System.out.println("\nA " + jogo.getDupla1().getNome().toUpperCase() + " VENCEU!");
        }
        else if(jogo.getDupla2().getPontos()>=12)
        {
            System.out.println("\nA " + jogo.getDupla2().getNome().toUpperCase() + " VENCEU!");
        }
    }
}