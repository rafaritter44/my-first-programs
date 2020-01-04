import java.util.Random;
import java.util.Scanner;
public class Jogo
{
    private Scanner in;
    private Tabuleiro tab;
    public Jogo()
    {
        in = new Scanner(System.in);
        tab = new Tabuleiro();
    }
    public void exibe()
    {
        System.out.println(tab);
    }
    public void jogadaEscolhida()
    {
        String erro = "";
        boolean pecaValida;
        int i=0, j=0;
        String roque = "";
        int r = tab.roques();
        if(r==1)
        {
            roque = "(r) – Roque Menor ou\n";
        }
        else if(r==2)
        {
            roque = "(R) – Roque Maior ou\n";
        }
        else if(r==3)
        {
            roque = "(R) – Roque Maior ou\n(r) – Roque Menor ou\n";
        }
        do
        {
            System.out.print("\f"+tab);
            System.out.println("\n----- Jogam as " + tab.getVez() + "s -----" + erro);
            System.out.print(roque + "Posição da peça: ");
            String pos = in.nextLine();
            if(r==1 && pos.equals("r"))
            {
                tab.roqueMenor();
                return;
            }
            if(r==2 && pos.equals("R"))
            {
                tab.roqueMaior();
                return;
            }
            if(r==3 && pos.equals("r"))
            {
                tab.roqueMenor();
                return;
            }
            if(r==3 && pos.equals("R"))
            {
                tab.roqueMaior();
                return;
            }
            int[] ij = posicao(pos);
            if(ij==null)
            {
                pecaValida = false;
                erro = "\nESCOLHA INVÁLIDA";
            }
            else
            {
                pecaValida = tab.pecaValida(ij[0],ij[1]);
                if(!pecaValida) erro = "\nESCOLHA INVÁLIDA";
                else
                {
                    erro = "";
                    i = ij[0];
                    j = ij[1];
                }
            }
        }
        while(!pecaValida);
        do
        {
            System.out.print("\f"+tab);
            System.out.println("\n----- Jogam as " + tab.getVez() + "s -----" + erro);
            System.out.print("Posição da jogada: ");
            String pos = in.nextLine();
            int[] ij = posicao(pos);
            if(ij==null || !tab.jogadaValida(i,j,ij[0],ij[1]))
            {
                pecaValida = false;
                erro = "\nESCOLHA INVÁLIDA";
            }
            else
            {
                pecaValida = true;
                tab.jogada(i,j,ij[0],ij[1]);
                Peca peao = tab.promocao();
                if(peao!=null)
                {
                    erro = "";
                    boolean promoveu;
                    do
                    {
                        promoveu = true;
                        System.out.print("\f"+tab);
                        System.out.println("\n----- Jogam as " + tab.getVez() + "s -----" + erro);
                        if(tab.getVez().equals("preta"))
                        {
                            System.out.println("(1) – ♕");
                            System.out.println("(2) – ♖");
                            System.out.println("(3) – ♗");
                            System.out.println("(4) – ♘");
                            System.out.print("Promoção: ");
                            String promo = in.nextLine();
                            switch(promo)
                            {
                                case "1": peao.setFigura('♕'); break;
                                case "2": peao.setFigura('♖'); break;
                                case "3": peao.setFigura('♗'); break;
                                case "4": peao.setFigura('♘'); break;
                                default: erro = "\nESCOLHA INVÁLIDA"; promoveu = false;
                            }
                        }
                        else
                        {
                            System.out.println("(1) – ♛");
                            System.out.println("(2) – ♜");
                            System.out.println("(3) – ♝");
                            System.out.println("(4) – ♞");
                            String promo = in.nextLine();
                            switch(promo)
                            {
                                case "1": peao.setFigura('♛'); break;
                                case "2": peao.setFigura('♜'); break;
                                case "3": peao.setFigura('♝'); break;
                                case "4": peao.setFigura('♞'); break;
                                default: erro = "\nESCOLHA INVÁLIDA"; promoveu = false;
                            }
                        }
                    }
                    while(!promoveu);
                }
            }
        }
        while(!pecaValida);
    }
    public void jogadaAleatoria()
    {
        if(tab.roques()==1 || tab.roques()==3) 
        {
            tab.roqueMenor();
            return;
        }
        if(tab.roques()==2)
        {
            tab.roqueMaior();
            return;
        }
        Random gera = new Random();
        
        int i,j,i2,j2;
        boolean jogadaValida;
        do
        {
            i = gera.nextInt(8);
            j = gera.nextInt(8);
            
            jogadaValida = tab.pecaValida(i,j);
        }
        while(!jogadaValida);
        do
        {
            i2 = gera.nextInt(8);
            j2 = gera.nextInt(8);
            
            jogadaValida = tab.jogadaValida(i,j,i2,j2);
        }
        while(!jogadaValida);
        tab.jogada(i,j,i2,j2);
        
        Peca peao = tab.promocao();
        if(peao!=null)
        {
            if(tab.getVez().equals("preta")) peao.setFigura('♕');
            else peao.setFigura('♛');
        }
    }
    public int[] posicao(String pos)
    {
        if(pos==null) return null;
        if(pos.length()!=2) return null;
        int linha = Character.getNumericValue(pos.charAt(1));
        if(linha<1 || linha>8) return null;
        int coluna;
        char c = Character.toLowerCase(pos.charAt(0));
        if(c=='a') coluna = 0;
        else if(c=='b') coluna = 1;
        else if(c=='c') coluna = 2;
        else if(c=='d') coluna = 3;
        else if(c=='e') coluna = 4;
        else if(c=='f') coluna = 5;
        else if(c=='g') coluna = 6;
        else if(c=='h') coluna = 7;
        else return null;
        linha--;
        int[] ret = {linha,coluna};
        return ret;
    }
    public String vencedor()
    {
        if(tab.xequeMate())
        {
            if(tab.getVez().equals("branca")) return "XEQUE-MATE! Vencem as pretas!";
            return "XEQUE-MATE! Vencem as brancas!";
        }
        if(tab.empate()) return "EMPATE! Ninguém venceu!";
        return null;
    }
}