public class ListaDeContatos
{
    private Contato[] lista;
    private int posicao;
    
    public ListaDeContatos(int quantidade)
    {
        if(quantidade<10)quantidade = 10;
        lista = new Contato[quantidade];
        posicao = 0;
    }
    
    public boolean cadastra(String nome)
    {
        if(posicao==lista.length)return false;
        Contato umContato = new Contato(nome);
        lista[posicao] = umContato;
        posicao++;
        return true;
    }
    
    public boolean insere(Contato umContato)
    {
        if(posicao==lista.length)return false;
        if(umContato==null)return false;
        lista[posicao] = umContato;
        posicao++;
        return true;
    }
    
    public Contato buscaContato(String nome)
    {
        for(int i=0; i<posicao; i++)
        {
            Contato umContato = lista[i];
            if(umContato.getNome().equalsIgnoreCase(nome))return umContato;
        }
        return null;
    }
    
    public int posContato(String nome)
    {
        for(int i=0; i<posicao; i++)
        {
            Contato umContato = lista[i];
            if(umContato.getNome().equalsIgnoreCase(nome))return i;
        }
        return -1;
    }
    
    public boolean excluiContato(String nome)
    {
        int pos = posContato(nome);
        if(pos==-1)return false;
        for(int i=pos; i<posicao; i++)
        {
            lista[i]=lista[i+1];
        }
        posicao--;
        return true;
    }
    
    public boolean ordena()
    {
        Contato aux;
        boolean ordenado, ordenou = false;
        do
        {
            ordenado=true;
            for(int i=0; i<posicao-1; i++)
            {
                int r = lista[i].getNome().compareTo(lista[i+1].getNome());
                if(r>0)
                {
                    aux = lista[i];
                    lista[i] = lista[i+1];
                    lista[i+1] = aux;
                    ordenado = false;
                    ordenou = true;
                }
            }
        }
        while(!ordenado);
        return ordenou;
    }
    
    public String toString()
    {
        String msg = "";
        for(int i=0; i<posicao; i++)
        {
            msg+=lista[i] + "\n";
        }
        return msg;
    }
}