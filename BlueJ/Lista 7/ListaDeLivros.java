public class ListaDeLivros
{
    private Livro[] lista;
    private int posicao;
    
    public ListaDeLivros(int tamanho)
    {
        if(tamanho<=0)lista = new Livro[10];
        else lista = new Livro[tamanho];
        
        posicao = 0;
    }
    
    public boolean cadastra(String titulo, String autores)
    {
        if(posicao>=lista.length)return false;
        else
        {
            boolean codigoInvalido = false;
            do
            {
                lista[posicao] = new Livro(titulo, autores);
                for(int i=0; i<posicao; i++)
                {
                    if(lista[i].getCodigo()==lista[posicao].getCodigo())
                    {
                        codigoInvalido = true;
                        break;
                    }
                }   
            }
            while(codigoInvalido);
        }
        posicao++;
        return true;
    }
    
    public Livro buscaPorCodigo(int codigo)
    {
        for(int i=0; i<posicao; i++)
        {
            if(lista[i].getCodigo()==codigo)return lista[i];
        }
        return null;
    }
    
    public void buscaPorAutores(String autores)
    {
        boolean algumLivro = false;
        for(int i=0; i<posicao; i++)
        {
            if(lista[i].getAutores().equals(autores))
            {
                System.out.println(lista[i]);
                algumLivro = true;
            }
        }
        if(!algumLivro)System.out.println("Nenhum livro de " + autores + " encontrado.");
    }
    
    public boolean excluiPorCodigo(int codigo)
    {
        for(int i=0; i<posicao; i++)
        {
            if(lista[i].getCodigo()==codigo)
            {
                for(int j=i; j<posicao-1; j++)
                {
                    lista[j] = lista[j+1];
                }
                posicao--;
                return true;
            }
        }
        return false;
    }
    
    public String toString()
    {
        String msg = "";
        for(int i=0; i<posicao; i++)
        {
            msg += lista[i] + "\n";
        }
        return msg;
    }
}