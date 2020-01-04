public class Torre extends Peca
{
    public Torre(String cor, char figura, int i, int j)
    {
        super(cor, figura, i, j);
    }
    public boolean roque()
    {
        if(getJaMoveu()) return false;
        return true;
    }
}