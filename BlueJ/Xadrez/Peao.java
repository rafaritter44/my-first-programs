public class Peao extends Peca
{
    private boolean enPassant;
    public Peao(String cor, char figura, int i, int j)
    {
        super(cor, figura, i, j);
        enPassant = false;
    }
    public void setEnPassant(boolean enPassant)
    {
        this.enPassant = enPassant;
    }
    public boolean getEnPassant()
    {
        return enPassant;
    }
}