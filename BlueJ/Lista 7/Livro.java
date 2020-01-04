import java.util.Random;
public class Livro
{
    private int codigo;
    private String titulo, autores, anoDePublicacao;
    
    public Livro(String titulo, String autores)
    {
        Random gera = new Random();
        
        codigo = Math.abs(gera.nextInt());
        
        this.titulo = "Não informado";
        setTitulo(titulo);
        
        this.autores = "Não informado";
        setAutores(autores);
    }
    
    public int getCodigo()
    {
        return codigo;
    }
    
    public String getAnoDePublicacao()
    {
        return anoDePublicacao;
    }
    
    public String getTitulo()
    {
        return titulo;
    }
    
    public String getAutores()
    {
        return autores;
    }
    
    public void setAnoDePublicacao(String anoDePublicacao)
    {
        if(isInteger(anoDePublicacao))this.anoDePublicacao = anoDePublicacao;
    }
    
    public void setTitulo(String titulo)
    {
        if(titulo!=null)this.titulo = titulo;
    }
    
    public void setAutores(String autores)
    {
        if(autores!=null)this.autores = autores;
    }
    
    public void geraCodigo()
    {
        Random gera = new Random();
        
        codigo = Math.abs(gera.nextInt());
    }
    
    public static boolean isInteger(String str)
    {
        if(str==null)
        {
            return false;
        }
        
        int length = str.length();
        if(length==0)
        {
            return false;
        }
        
        int i = 0;
        if(str.charAt(0)=='-')
        {
            if (length==1)
            {
                return false;
            }
            
            i = 1;
        }
        
        for(; i<length; i++)
        {
            char c = str.charAt(i);
            
            if (c<'0' || c>'9')
            {
                return false;
            }
        }
        
        return true;
    }
    
    public String toString()
    {
        String msg = "Título: " + titulo + "\nAutor(es): " + autores;
        
        if(anoDePublicacao!=null)msg += "\nAno de Publicação: " + anoDePublicacao;
        
        msg += "\nCódigo: " + codigo;
        
        return msg;
    }
}