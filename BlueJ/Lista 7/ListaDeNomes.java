public class ListaDeNomes
{
    private String[] nomes;
    private int posicao;
    public ListaDeNomes(int quantidade)
    {
        if(quantidade<=0)quantidade=10;
        nomes = new String[quantidade];
        posicao = 0;
    }
    public boolean insere(String umNome)
    {
        if(umNome==null)return false;
        if(posicao==nomes.length)return false;
        if(pesquisa(umNome))return false;
        nomes[posicao]=umNome;
        posicao++;
        return true;
    }
    public boolean pesquisa(String umNome)
    {
        for(int i=0; i<posicao; i++)
        {
            if(nomes[i].equalsIgnoreCase(umNome))return true;
        }
        return false;
    }
    public boolean exclui(String umNome)
    {
        int posUmNome = buscaPosicao(umNome);
        if(posUmNome==-1)return false;
        for(int i=posUmNome; i<posicao-1; i++)
        {
            nomes[i]=nomes[i+1];
        }
        posicao--;
        //nomes[posicao]=null;
        return true;
    }
    public int buscaPosicao(String umNome)
    {
        for(int i=0; i<posicao; i++)
        {
            if(nomes[i].equalsIgnoreCase(umNome))return i;
        }
        return -1;
    }
    public void ordena()
    {
        boolean ordenado;
        String aux;
        int r;
        do
        {
            ordenado = true;
            for(int i=0; i<posicao-1; i++)
            {
                r = nomes[i].compareTo(nomes[i+1]);
                if(r>0)
                {
                    aux = nomes[i];
                    nomes[i] = nomes[i+1];
                    nomes[i+1] = aux;
                    ordenado = false;
                }
            }
        }
        while(!ordenado);
    }
    public String[] encontraNomesEmComum(String[] outraLista)
    {
        int tam = outraLista.length;
        if(posicao<tam)tam=posicao;
        String[] comuns = new String[tam];
        for(int i=0; i<outraLista.length; i++)
        {
            if(pesquisa(outraLista[i]))
            {
                comuns[i] = outraLista[i];
            }
        }
        return comuns;
    }
    public String toString()
    {
        String msg = "\nLista de Nomes:\n";
        for(int i = 0; i<posicao; i++)
        {
            msg = msg + nomes[i] + "\n";
        }
        return msg;
    }
}