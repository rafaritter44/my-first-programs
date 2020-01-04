
/**
 * Representa um(a) Barco.
 * 
 * @author Sílvia
 * @version 06/12/2012
 */
import java.util.ArrayList;
public class Barco
{
    private ArrayList<Character> embarcados;
    private Margem margem;
    private int maximo;
    
    /**
     * Cria um barco com capacidade = 2, ou seja, transporta no máximo 2 pessoas.
     * O barco inicia atracado na margem informada como parâmetro.
     * @param margem objeto margem
     */
    public Barco(Margem margem){
        maximo = 2;
        embarcados = new ArrayList<Character>();
        setMargem(margem);
    }
    
    /**
     * Define a margem em que o barco está atracado.
     * @param margem objeto margem (esquerda ou direita)
     */
    private void setMargem(Margem margem){
        this.margem = margem;
    }
    
    /**
     * Verifica se o número de canibais não supera o número de missionários.
     * Nesse cálculo são contabilizados os missionários e canibais que estão no barco e 
     * na margem em que o barco está atracado.
     * @return devolve true se tudo estiver ok e devolve false se os canibais tiverem 
     * devorado os missionários.
     */
    private boolean verifica(){
        int canibais = 0;
        int missionarios = 0;
        
        for(Character elem: embarcados){
            if(elem.equals('c')) canibais++;
            else missionarios++;
        }
       
        canibais = canibais + margem.getQuantidadeCanibais();
        missionarios = missionarios + margem.getQuantidadeMissionarios();
       
        if(missionarios>0 && canibais>missionarios){
            margem.eliminaMissionarios();
            eliminaMissionarios();
            return false;
        }
        return true;
    }
    
    /**
     * Verifica se o número de canibais não supera o número de missionários.
     * Nesse cálculo são contabilizados os missionários e canibais que estão no barco e 
     * na margem em que o barco está atracado.
     * @return devolve true se tudo estiver ok e devolve false se os canibais tiverem 
     * devorado os missionários.
     */
    private boolean verificaMargemOposta(Margem margem){
       int canibais = margem.getQuantidadeCanibais();
       int missionarios = margem.getQuantidadeMissionarios();
       
        if(missionarios>0 && canibais>missionarios){
            margem.eliminaMissionarios();
            return false;
        }
        return true;
    }
    /**
     * Elimina os missionários.
     */
    private void eliminaMissionarios(){
        for(int pos=0; pos<embarcados.size(); pos++){
                if(embarcados.get(pos).equals('m')){
                    embarcados.remove(embarcados.get(pos));
                    pos--;
                }
            }
    }
    /**
     * Navega o barco da margem atual para a margem destino.
     * @param destino margem destino do barco
     * @return devolve verdadeiro se a operação ocorreu com sucesso.
     */
    public String navegarPara(Margem destino){
        if(embarcados.size()==0) return "Barco não pode navegar sem tripulantes.";
        if(margem==null) return "Margem não informada";
        if(destino==margem) return "O barco já está na margem destino " + destino.getLado();
        Margem anterior = margem;
        setMargem(destino);
        if(!verificaMargemOposta(anterior)){
            anterior.eliminaMissionarios();
            return "Ops! Missionários da margem " + anterior.getLado() + " não existem mais. O barco: " + 
                   embarcados + " navegou de " + anterior + " para " + destino;
        }
       
        return "O barco: " + embarcados + " navegou de " + anterior + " para " + destino;
    }
    
    /**
     * Embarca as pessoas da margem em que o barco está atracado para o barco.
     * @param elemento elemento pode ser um canibal (c) ou um missionário (m).
     * @return devolve uma mensagem indicando se o embarque foi bem sucedido ou não.
     */
    public String embarcar(Character elemento){
        if(embarcados.size()==maximo) return "Elemento " + elemento + " não embarcado. Barco lotado.";
        if(!margem.contains(elemento)) return "Elemento " + elemento + " não existe na margem.";
        if(!verifica()) return "Ops! Canibais acabaram com os missionários do barco e margem " + margem.getLado();
        embarcados.add(elemento);
        margem.despachaPessoas(elemento);
       return "Embarque de " + elemento + " OK.";
    }

    /**
     * Desembarca elemento do barco para a margem em que o barco está atracado.
     * @param elemento elemento pode ser um canibal (c) ou um missionário (m).
     * @return devolve uma mensagem indicando se o desembarque foi bem sucedido ou não.
     */
    public String desembarcar(Character elemento){
        if(!embarcados.contains(elemento)) return "Elemento " + elemento + " não existe no barco.";
        if(!verifica()) return "Ops! Canibais acabaram com os missionários.";
        embarcados.remove(elemento);
        margem.recebePessoas(elemento);
        return "Desembarque de " + elemento + " OK.";
    }
    
    /**
     * Exibe o estado atual do barco
     * @return devolve um string com o estado do objeto barco
     */
    public String toString(){
        return "barco atracado na margem " + margem.getLado() + ": " + embarcados;
    }
}
