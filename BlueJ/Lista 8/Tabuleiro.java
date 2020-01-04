
/**
 * Write a description of class Tabuleiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tabuleiro
{
    private char[][]tab;
    
    /**
     * Cria um tabuleiro 3 x 3
     */
    public Tabuleiro(){
        tab = new char[3][3];
    }
    
     /**
     * Cria um tabuleiro dim x dim
     * @param dim dimensão do tabuleiro
     */
    public Tabuleiro(int dim){
        if(dim<3) dim = 3;
        tab = new char[dim][dim];
    }
    /**
     * Inicializa todas as posições do tabuleiro com o caractere '.'
     * Ele indica célula (posição) livre
     */
    public void inicializa(){
        for(int lin=0; lin<tab.length; lin++){
            for(int col=0; col<tab[lin].length; col++){
                tab[lin][col] = '.';
            }
        }
    }
    /**
     * Verifica se a posição (lin,col) informada é válida e está ocupada
     * @param lin linha
     * @param col coluna
     * @return devolve -1 se a linha está incorreta; 
     *                 -2 se a coluna está incorreta; 
     *                 1 se está ocupada e 
     *                 0 se está livre.
     */
    public int posicaoOcupada(int lin, int col){
        if(lin<0 || lin>=tab.length) return -1;
        if(col<0 || col>=tab.length) return -2;
        if(tab[lin][col]!='.') return 1;
        return 0;
    }
    
    /** 
     * Verifica se alguém ganhou em linha
     * @param letra corresponde ao X ou O
     * @return devolve true se a letra informada ocorre em todas as colunas de uma linha;
     * devove false, em caso contrário.
     */
    public boolean ganhaEmLinha(char letra){
        for(int lin=0; lin<tab.length; lin++){
            int cont = 0;
            for(int col=0; col<tab[lin].length; col++){
                if(tab[lin][col]==letra) cont++;
            }
            if(cont==tab.length) return true;
        }
        return false;
    }
    
    /** 
     * Verifica se alguém ganhou em coluna
     * @param letra corresponde ao X ou O
     * @return devolve true se a letra informada ocorre em todas as linhas de uma coluna;
     * devove false, em caso contrário.
     */
    public boolean ganhaEmColuna(char letra){
      // for(int col=0; col<tab[0].length; col++){
          for(int col=0; col<tab.length; col++){
            int cont = 0;            
            for(int lin=0; lin<tab.length; lin++){
                if(tab[lin][col]==letra) cont++;
            }
            if(cont==tab.length) return true;
        }
        return false;
    }
    
    public boolean ganhaEmDiagonal(char letra){
        int cont = 0;
        //Diagonal principal
        for(int i=0; i<tab.length; i++){
            if(tab[i][i]==letra) cont++;
        }
        if(cont==3) return true;
        
        //Diagonal secundaria
        cont = 0;
        //int j=2;
        //for(int i=0; i<tab.length; i++){
        //    if(tab[i][j]==letra) cont++;
         //   j--;
        //}
        for(int i=0; i<tab.length; i++){
            if(tab[i][tab.length-1-i]==letra) cont++;
        }
        if(cont==3) return true;
        
        return false;
    }
    public boolean verificaVitoria(char letra){
        if(ganhaEmDiagonal(letra)) return true;
        if(ganhaEmLinha(letra)) return true;
        if(ganhaEmColuna(letra)) return true;
        return false;
    }
    /**
     * Modifica o contéudo de uma posição (lin,col) com a letra informada
     * @param lin linha do tabuleiro
     * @param col coluna do tabuleiro
     * @param letra letra do jogo (usualmente X ou O)
     * @return devolve true se a alteração foi realizada; devolve false se lin ou col forem inválidos
     */
    public boolean alteraPosicao(int lin, int col, char letra){
        if(lin<0 || lin>=tab.length) return false;
        if(col<0 || col>=tab.length) return false;
        tab[lin][col] = letra;
        return true;
    }
    
    /**
     * Gera uma string do tabuleiro
     * @return string com o estado atual do tabuleiro
     */
    public String toString(){
        String msg = "\nJogo da Velha\n";
        msg = msg + "  ";
        for(int lin=0; lin<tab.length; lin++){ msg = msg + lin + " ";}
        msg = msg + "\n";
        for(int lin=0; lin<tab.length; lin++){
            msg = msg + lin + " ";
            for(int col=0; col<tab[lin].length; col++){
                msg = msg + tab[lin][col] + " ";
            }
            msg = msg + "\n";
        }
        return msg;
    }
}
