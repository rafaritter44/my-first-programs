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
    
    public void estadoAtual()
    {
        System.out.print("\n" + tab);
    }
    
    public char proximaJogada()
    {
        char prox = tab.getProximo();
        
        System.out.println("\n----- Vez de (" + prox + ") -----\n");
        
        int i, j;
        
        boolean pecaValida, capturaForcada = false;
        do
        {
            pecaValida = true;
            
            do
            {
                System.out.print("Informe a linha da peça escolhida: ");
                String linha = in.nextLine();
                i = verificaLinha(linha);
                if(i==-1) System.out.println("\nPOSIÇÃO INVÁLIDA\n");
            }
            while(i==-1);
            
            do
            {
                System.out.print("Informe a coluna da peça escolhida: ");
                String coluna = in.nextLine();
                j = verificaColuna(coluna);
                if(j==-1) System.out.println("\nPOSIÇÃO INVÁLIDA\n");
            }
            while(j==-1);
            
            if(!tab.pecaValida(i,j))
            {
                pecaValida = false;
                System.out.println("\nPEÇA INVÁLIDA\n");
            }
            else if(tab.capturaForcada())
            {
                if(!tab.verificaCaptura(i,j))
                {
                    pecaValida = false;
                    System.out.println("\nPEÇA INVÁLIDA (captura forçada)\n");
                }
                else capturaForcada = true;
            }
        }
        while(!pecaValida);
        
        int i2, j2;
        
        boolean jogadaFinalizada;
        do
        {
            jogadaFinalizada = true;
            
            do
            {
                System.out.print("Informe a linha da casa em que deseja pular: ");
                String linha = in.nextLine();
                i2 = verificaLinha(linha);
                if(i2==-1) System.out.println("\nPOSIÇÃO INVÁLIDA\n");
            }
            while(i2==-1);
            
            do
            {
                System.out.print("Informe a coluna da casa em que deseja pular: ");
                String coluna = in.nextLine();
                j2 = verificaColuna(coluna);
                if(j2==-1) System.out.println("\nPOSIÇÃO INVÁLIDA\n");
            }
            while(j2==-1);
            
            if(capturaForcada && Math.abs(i-i2)==1)
            {
                jogadaFinalizada = false;
                System.out.println("\nJOGADA INVÁLIDA (captura forçada)\n");
            }
            else
            {
                boolean jogadaValida = tab.jogadaValida(i,j,i2,j2);
            
                if(!jogadaValida)
                {
                    jogadaFinalizada = false;
                    System.out.println("\nJOGADA INVÁLIDA\n");
                }
                else if(tab.verificaCaptura(i2,j2))
                {
                    jogadaFinalizada = false;
                    estadoAtual();
                    System.out.println("\nMAIS UMA CAPTURA DISPONÍVEL\n");
                    i = i2;
                    j = j2;
                }
            }
        }
        while(!jogadaFinalizada);
        
        if(tab.verificaVitoria()) return prox;
        return 'n';
    }
    
    public char proximoComputador()
    {
        char prox = tab.getProximo();
        tab.jogadaComputador();
        if(tab.verificaVitoria()) return prox;
        return 'n';
    }
    
    public int verificaLinha(String pos)
    {
        if(pos==null) return -1;
        if(pos.length()!=1) return -1;
        
        int i = Character.getNumericValue(pos.charAt(0));
            
        if (i<1 || i>8)
        {
            return -1;
        }
        
        return i-1;
    }
    
    public int verificaColuna(String pos)
    {
        if(pos==null) return -1;
        if(pos.length()!=1) return -1;
        
        if(pos.equalsIgnoreCase("a")) return 0;
        if(pos.equalsIgnoreCase("b")) return 1;
        if(pos.equalsIgnoreCase("c")) return 2;
        if(pos.equalsIgnoreCase("d")) return 3;
        if(pos.equalsIgnoreCase("e")) return 4;
        if(pos.equalsIgnoreCase("f")) return 5;
        if(pos.equalsIgnoreCase("g")) return 6;
        if(pos.equalsIgnoreCase("h")) return 7;
        
        return -1;
    }
}