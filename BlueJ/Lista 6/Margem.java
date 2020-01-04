
/**
 * Representa um(a) Margem.
 * 
 * @author Sílvia
 * @version 06/12/2012
 */
import java.util.ArrayList;
public class Margem
{
    // atributos
    private String lado;
    private ArrayList<Character> pessoas;
    private int maximo;

    /**
     * Cria uma margem identificada com o string informado como parâmetro
     * @param lado string identificando a margem
     */
    public Margem(String lado)
    {
        this.lado = lado;
        pessoas = new ArrayList<Character>();
        maximo = 6;
    }
    
    /**
     * Devolve o identificador da margem
     */
    public String getLado(){
        return lado;
    }
     
    /**
     * Inicializa a margem com [m,m,m,c,c,c]
     */
    public void inicializa(){
        pessoas.clear();
        int metade = maximo/2;
        for(int i=1; i<=metade; i++) pessoas.add('m');
        for(int i=1; i<=metade; i++) pessoas.add('c');
    }
       
    /**
     * Recebe as pessoas do barco para a margem.
     * @param elemento elemento desembarcado
     */
    public boolean recebePessoas(Character elemento){
        if(pessoas.size()>=maximo) return false;
        if(elemento.equals('c') || elemento.equals('m')) return pessoas.add(elemento);
        return false;
    }
    
    /**
     * Despacha as pessoas da margem para o barco.
     * @param elemento elemento embarcado
     */
    public boolean despachaPessoas(Character elemento){
       return pessoas.remove(elemento); 
    }
    
    /**
     * Estado da margem
     * @return devolve o identificador da margem e as pessoas que estão na margem.
     */
    public String toString(){
        return "margem " + lado + ": " + pessoas;
    }
    
    /**
     * Devolve a quantidade de canibais na margem
     */
    public int getQuantidadeCanibais(){
        int canibais = 0;
        for(Character elem: pessoas)
            if(elem.equals('c')) canibais++;
            
        return canibais;
    }

    /**
     * Devolve a quantidade de missionários na margem
     */
    public int getQuantidadeMissionarios(){
        int missionarios = 0;
        for(Character elem: pessoas)
            if(elem.equals('m')) missionarios++;
            
        return missionarios;
    }

    /**
     * Devolve true se o elemento passado por parâmetro está na margem.
     * @param elemento elemento cuja presença será verificada na margem
     */
    public boolean contains(Character elemento){
        return pessoas.contains(elemento);
    }
    
    /**
     * Elimina todos os missionários da margem
     */
    public void eliminaMissionarios(){
        for(int pos=0; pos<pessoas.size(); pos++){
                if(pessoas.get(pos).equals('m')){
                    pessoas.remove(pessoas.get(pos));
                    pos--;
                }
            }
    }
}
