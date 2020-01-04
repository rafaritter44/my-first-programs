public class Contato
{
    private String nome;
    private String telefonePessoal;
    private String telefoneComercial;
    
    public Contato(String nome)
    {
        this.nome = "Sem Nome";
        setNome(nome);
    }
    
    public void setNome(String nome)
    {
        if(nome!=null)this.nome = nome;
    }
    
    public String getNome(){return nome;}
    
    public void setTelefonePessoal(String telefone)
    {
        this.telefonePessoal = telefone;
    }
    public void setTelefoneComercial(String telefone)
    {
        this.telefoneComercial = telefone;
    }
    public String getTelefonePessoal(){return telefonePessoal;}
    
    public String getTelefoneComercial(){return telefoneComercial;}
    
    public String toString()
    {
        String msg = "Nome: " + nome + " Telefone Pessoal: ";
        if(telefonePessoal!=null)msg = msg + telefonePessoal;
        else msg = msg + " - ";
        if(telefoneComercial!=null)msg = msg + " Telefone Comercial: " + telefoneComercial;
        else msg = msg + " Telefone Comercial: - ";
        return msg;
    }
}