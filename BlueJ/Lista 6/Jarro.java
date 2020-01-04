
/**
 * Representa um(a) Jarro.
 * 
 * @author Silvia
 * @version 05/12/2012
 */
public class Jarro
{
    // atributos
    private int capacidade;  //capacidade máxima do jarro em litros
    private int litros;      //quantidade atual de litros no jarro

    /**
     * Construtor
     * @param capacidade capacidade máxima do jarro (em litros) 
     */
    public Jarro(int capacidade)
    {
        if(capacidade<1) capacidade = 1;
        this.capacidade = capacidade;
    }

    /**
     * Devolve a capacidade em litros de um jarro
     * @return capacidade do jarro
     */ 
    public int getCapacidade()
    {
        return capacidade;
    }

    /**
     * Devolve a quantidade atual de litros de um jarro
     * @return litros no jarro
     */ 
    public int getLitros()
    {
        return litros;
    }
    /**
     * Enche totalmente o jarro
     */
    public void encher(){
        litros = capacidade;
    }
    /**
     * Esvazia o jarro completamente
     */
    public void esvaziar(){
        litros = 0;
    }
   
    /**
     * Despeja o conteúdo de um jarro em outro jarro sem ultrapassar a capacidade desse outro jarro. 
     * Ex: se o jarro origem tiver a capacidade para 3 litros e estiver cheio, 
     * e o jarro destino tiver a capacidade de 4 litros e tiver apenas 2 litros, 
     * após despejar jarro origem em jarro destino, jarro origem ficará com 1 litro e jarro destino com 4 litros. 
     * @param quantidade quantidade em litros
     * @return devolve os litros restantes
     */
    private int despejar(int quantidade){
        if(quantidade>0 && capacidade!=litros){
            if(quantidade + litros <= capacidade) {
                litros = litros + quantidade;
                return 0;
            }
            else {
                int tmp = capacidade - litros;
                litros = capacidade;
                quantidade = quantidade - tmp;
                return quantidade;
            }
        }
        return litros;
    }

    /**
     * Despeja o conteúdo de um jarro em outro jarro sem ultrapassar a capacidade desse outro jarro. 
     * Ex: se o jarro origem tiver a capacidade para 3 litros e estiver cheio, 
     * e o jarro destino tiver a capacidade de 4 litros e tiver apenas 2 litros, 
     * após despejar jarro origem em jarro destino, 
     * jarro origem ficará com 1 litro e jarro destino com 4 litros. 
     * @param outroJarro jarro destino
     */
    public void despejar(Jarro outroJarro){
        litros = outroJarro.despejar(litros);
    }
}
