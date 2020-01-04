/**
 * Representa uma Dupla.
 * 
 * @author Rafael Ritter 
 * @version 19/11/2016
 */
public class Dupla
{
    private String nome;
    private int pontos;
    private boolean jaPediu;
    
    /**
     * Cria uma dupla com o nome passado por parâmetro.
     * @param nome nome da dupla.
     */
    public Dupla(String nome)
    {
        if(nome!=null)this.nome = nome;
        else this.nome = "dupla";
        pontos = 0;
        jaPediu = false;
    }
    
    /**
     * Cria uma dupla com o nome, os pontos e a informação de que a dupla já pediu
     * ou não truco passados por parâmetro.
     * @param nome nome da dupla.
     * @param pontos pontuação atual da dupla.
     * @param jaPediu verdadeiro se a dupla já pediu truco na rodada e falso em caso contrário.
     */
    public Dupla(String nome, int pontos, boolean jaPediu)
    {
        if(nome!=null)this.nome = nome;
        else this.nome = "dupla";
        this.pontos = pontos;
        this.jaPediu = jaPediu;
    }
    
    /**
     * Aumenta a pontuação da dupla em n pontos.
     * @param n pontos a serem somados.
     */
    public void aumentaPontos(int n)
    {
        pontos = pontos + n;
    }
    
    /**
     * Devolve a pontuação atual da dupla.
     */
    public int getPontos()
    {
        return pontos;
    }
    
    /**
     * Devolve o nome da dupla.
     */
    public String getNome()
    {
        return nome;
    }
    
    /**
     * Devolve verdadeiro se a dupla já pediu truco na rodada e falso em caso contrário.
     */
    public boolean getJaPediu()
    {
        return jaPediu;
    }
    
    /**
     * Altera a informação de que a dupla já pediu ou não truco na rodada.
     * @param jaPediu verdadeiro se a dupla já pediu truco na rodada e falso em caso contrário.
     */
    public void setJaPediu(boolean jaPediu)
    {
        this.jaPediu = jaPediu;
    }
    
    /**
     * Informa o nome da dupla e sua respectiva pontuação.
     */
    public String toString()
    {
        return nome + ": " + pontos + " pontos";
    }
}