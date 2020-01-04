/**
 * Representa um Baralho.
 * 
 * @author Rafael Ritter 
 * @version 19/11/2016
 */
public class Baralho
{
    private Carta[] baralho;
    
    /**
     * Cria um baralho com 40 cartas embaralhadas.
     */
    public Baralho()
    {
        baralho = new Carta[40];
        embaralha();
    }
    
    /**
     * Embaralha as cartas do baralho.
     */
    public void embaralha()
    {
        for(int i=0; i<40; i++)
        {
            baralho[i] = new Carta();
            for(int j=0; j<i; j++)
            {
                if(baralho[i].getNumero()==baralho[j].getNumero() &&
                baralho[i].getNaipe().equals(baralho[j].getNaipe()))i--;
            }
        }
    }
    
    /**
     * Distribui 3 cartas para cada um dos 4 jogadores passados por parâmetro.
     * @param j1 primeiro jogador.
     * @param j2 segundo jogador.
     * @param j3 terceiro jogador.
     * @param j4 quarto jogador.
     */
    public void distribui(Jogador j1, Jogador j2, Jogador j3, Jogador j4)
    {
        for(int i=0, j=0; i<3; i++, j+=4)
        {
            j1.getMao()[i] = baralho[j];
            j2.getMao()[i] = baralho[j+1];
            j3.getMao()[i] = baralho[j+2];
            j4.getMao()[i] = baralho[j+3];
        }
    }
    
    /**
     * Devolve o baralho.
     */
    public Carta[] getBaralho()
    {
        return baralho;
    }
    
    /**
     * Exibe as 40 cartas do baralho na ordem em que estão dispostas.
     */
    public String toString()
    {
        String msg = "";
        for(int i=0; i<40; i++)
        {
            msg+=baralho[i]+"\n";
        }
        return msg;
    }
}