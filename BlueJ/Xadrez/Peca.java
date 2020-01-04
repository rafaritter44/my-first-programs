public class Peca
{
    private String cor;
    private char figura;
    private int i, j;
    private boolean jaMoveu;
    public Peca(String cor, char figura, int i, int j)
    {
        this.cor = cor;
        setFigura(figura);
        setI(i);
        setJ(j);
        jaMoveu = false;
    }
    public void setFigura(char figura)
    {
        this.figura = figura;
    }
    public void setI(int i)
    {
        this.i = i;
    }
    public void setJ(int j)
    {
        this.j = j;
    }
    public void jaMoveu()
    {
        jaMoveu = true;
    }
    public String getCor()
    {
        return cor;
    }
    public char getFigura()
    {
        return figura;
    }
    public int getI()
    {
        return i;
    }
    public int getJ()
    {
        return j;
    }
    public boolean getJaMoveu()
    {
        return jaMoveu;
    }
    public String toString()
    {
        return "" + figura;
    }
}