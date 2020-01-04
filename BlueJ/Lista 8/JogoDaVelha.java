
/**
 * Write a description of class JogoDaVelha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Random;
public class JogoDaVelha
{
    public static void main(String args[]){
        Tabuleiro jogo = new Tabuleiro();
        
        String msg = "Empate"; 
        jogo.inicializa();
        System.out.println("\f"+jogo);
        jogaUsuario(jogo);
        for(int ciclo=1; ciclo<=4; ciclo++){
            jogaComputador(jogo);
            if(jogo.verificaVitoria('O')){
                msg = "Computador ganhou";
                break;
            }
            System.out.println(jogo);
            jogaUsuario(jogo);
            if(jogo.verificaVitoria('X')){
                msg = "Usuário ganhou";
                break;
            }
        }
        System.out.println(jogo);
        System.out.println("FIM: " + msg);
    }
    
    public static void jogaComputador(Tabuleiro jogo){
        Random gera = new Random();
        int lin, col;
        do{
            lin = gera.nextInt(3);
            col = gera.nextInt(3);
        }while(jogo.posicaoOcupada(lin,col)==1);
        jogo.alteraPosicao(lin,col,'O');
    }
    
    public static void jogaUsuario(Tabuleiro jogo){
        Scanner in = new Scanner(System.in);
        int lin, col, estado;
        do{
            System.out.println("Informe a linha (0,1,2) e a coluna (0,1,2): ");
            lin = in.nextInt();
            col = in.nextInt();
            estado = jogo.posicaoOcupada(lin,col);
            System.out.println(defineEstado(estado));
        }while(estado<0 || estado==1);
        jogo.alteraPosicao(lin,col,'X');
    }
    public static String defineEstado(int estado){
        switch(estado){
            case -1: return "Linha incorreta";
            case -2: return "Coluna incorreta";
            case 1: return "Posição ocupada";
        }
        return "Posicao válida";
    }
}
