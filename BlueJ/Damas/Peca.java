public class Peca
{
    private char tipo;
    public Peca(char tipo)
    {
        setTipo(tipo);
    }
    
    public void setTipo(char tipo)
    {
        this.tipo = tipo;
    }
    
    public char getTipo()
    {
        return tipo;
    }
    
    public boolean promocao()
    {
        if(tipo=='o')
        {
            tipo = 'O';
            return true;
        }
        if(tipo=='x')
        {
            tipo = 'X';
            return true;
        }
        return false;
    }
    
    public String toString()
    {
        return "" + tipo;
    }
}