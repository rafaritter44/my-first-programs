public class Lista
{
    private class Node
    {
        public String palavra;
        public int ocorrencias;
        public int[] linhas;
        public Node next;
        
        public Node(String palavra, int linha)
        {
            this.palavra = palavra;
            ocorrencias = 1;
            linhas = new int[100];
            linhas[0] = linha;
            next = null;
        }
        
        public void addOcorrencia(int linha)
        {
            if(linhas.length == ocorrencias)
            {
                int[] aux = new int[ocorrencias*2];
                for(int i=0; i<ocorrencias; i++)
                {
                    aux[i] = linhas[i];
                }
                linhas = aux;
            }
            linhas[ocorrencias] = linha;
            ocorrencias++;
        }
    }
    
    private Node head;
    private Node tail;
    private int count;
    private int[] paginas;
    
    public Lista()
    {
        head = null;
        tail = null;
        count = 0;
        paginas = new int[2000];
    }
    
    public void add(String palavra, int linha)
    {
        
        if(count==0)
        {
            head = new Node(palavra, linha);
            tail = head;
            count++;
            
            paginas[linha/40]++;
        }
        else if(palavra.compareTo(head.palavra)<0)
        {
            Node nodo = new Node(palavra, linha);
            nodo.next = head;
            head = nodo;
            count++;
            
            paginas[linha/40]++;
        }
        else if(palavra.compareTo(head.palavra)==0)
        {
            head.addOcorrencia(linha);
        }
        else
        {
            Node ant = head;
            Node aux = head.next;
            while(aux!=null)
            {
                int comparacao = palavra.compareTo(aux.palavra);
                if(comparacao<0)
                {
                    Node nodo = new Node(palavra, linha);
                    nodo.next = aux;
                    ant.next = nodo;
                    count++;
                    
                    paginas[linha/40]++;
                    
                    break;
                }
                else if(comparacao==0)
                {
                    aux.addOcorrencia(linha);
                    break;
                }
                ant = aux;
                aux = aux.next;
            }
            
            if(palavra.compareTo(ant.palavra)>0)
            {
                tail.next = new Node(palavra, linha);
                tail = tail.next;
                count++;
                
                paginas[linha/40]++;
            }
        }
    }
    
    public String palavraMaisFrequente()
    {
        Node aux = head;
        int maisOcorrido = 0;
        String palavra = null;
        
        while(aux!=null)
        {
            if(aux.ocorrencias>maisOcorrido)
            {
                palavra = aux.palavra;
                maisOcorrido = aux.ocorrencias;
            }
            
            aux = aux.next;
        }
        
        return palavra;
    }
    
    public int[] buscaPalavra(String pal)
    {
        Node aux = head;
        int[] pags = new int[2000];
        int j = 0;
        
        while(aux!=null)
        {
            if(aux.palavra.equals(pal))
            {
                for(int i=0; i<pags.length; i++)
                {
                    if(aux.linhas[i]==0) break;
                    
                    int pagina = aux.linhas[i]/40 + 1;
                    if(j==0 || pags[j-1]!=pagina)
                    {
                        pags[j] = pagina;
                        j++;
                    }
                }
            }
            
            aux = aux.next;
        }
        
        int[] ret = new int[j];
        
        for(int i=0; i<j; i++)
        {
            ret[i] = pags[i];
        }
        
        return ret;
    }
    
    public int[] paginaMaisComplexa()
    {
        int maisIndex = 0;
        int pagina = 0;
        for(int i=0; i<paginas.length; i++)
        {
            if(paginas[i]>maisIndex)
            {
                maisIndex = paginas[i];
                pagina = i;
            }
        }
        
        return new int[] {pagina + 1, maisIndex};
    }
    
    public String toString()
    {
            String s = "";
            Node aux = head;
            
            while(aux!=null)
            {
                s = s + aux.palavra + " (" + aux.ocorrencias + " ocorrência(s))" + "\n"
                + "Linhas/Páginas:";
                for(int i=0; i<aux.linhas.length; i++)
                {
                    if(aux.linhas[i]==0) break;
                    s = s + " " + aux.linhas[i] + "/" + (aux.linhas[i]/40 + 1);
                }
                s = s + "\n\n";
                aux = aux.next;
            }
            return s;
    }
}