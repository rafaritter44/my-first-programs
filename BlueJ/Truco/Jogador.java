/**
 * Representa um Jogador.
 * 
 * @author Rafael Ritter 
 * @version 19/11/2016
 */
public class Jogador
{
    private String nome;
    private Dupla dupla;
    private Carta[] mao;
    private Carta cartaEscolhida;
    
    /**
     * Cria um jogador com o nome a dupla à qual ele pertence informados por parâmetro.
     * @param nome nome do jogador.
     * @param dupla dupla da qual o jogador faz parte.
     */
    public Jogador(String nome, Dupla dupla)
    {
        if(nome!=null)this.nome = nome;
        else this.nome = "jogador";
        this.dupla = dupla;
        mao = new Carta[3];
        cartaEscolhida = null;
    }
    
    /**
     * Cria um jogador com o nome, sua dupla, as cartas que tem em mão e a carta escolhida
     * passados por parâmetro.
     * @param nome nome do jogador.
     * @param dupla dupla da qual o jogador faz parte.
     * @param mao cartas que o jogador tem em mão.
     * @param cartaEscolhida carta que o jogador escolheu jogar na sua vez.
     */
    public Jogador(String nome, Dupla dupla, Carta[] mao, Carta cartaEscolhida)
    {
        if(nome!=null)this.nome = nome;
        else this.nome = "jogador";
        this.dupla = dupla;
        this.mao = mao;
        this.cartaEscolhida = cartaEscolhida;
    }
    
    /**
     * Devolve o nome do jogador.
     */
    public String getNome()
    {
        return nome;
    }
    
    /**
     * Devolve a dupla à qual o jogador pertence.
     */
    public Dupla getDupla()
    {
        return dupla;
    }
    
    /**
     * Devolve as cartas da mão do jogador.
     */
    public Carta[] getMao()
    {
        return mao;
    }
    
    /**
     * Devolve a carta que o jogador escolheu jogar na sua vez.
     */
    public Carta getCartaEscolhida()
    {
        return cartaEscolhida;
    }
    
    /**
     * Define a carta escolhida pelo jogador.
     * @param cartaEscolhida carta que o jogador escolheu jogar na sua vez.
     */
    public void setCartaEscolhida(Carta cartaEscolhida)
    {
        this.cartaEscolhida = cartaEscolhida;
    }
    
    /**
     * Informa as cartas que o jogador tem em sua mão, excluindo aquelas que ele já jogou.
     */
    public String toString()
    {
        String msg = "";
        for(int i=0; i<3; i++)
        {
            if(mao[i]!=null)msg += "(" + (i+1) + ") " + mao[i] + "\n";
        }
        return msg;
    }
}