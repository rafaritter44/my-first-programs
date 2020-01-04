public class Sinaleira
{
    private String estado;
    public Sinaleira(String estado)
    {
        this.estado = "vermelho";
        setEstado(estado);
    }
    public String getEstado()
    {
        return estado;
    }
    public void setEstado(String estado)
    {
        if(estado.equals("vermelho")||estado.equals("amarelo")||estado.equals("verde"))this.estado=estado;
    }
    public void proximoEstado()
    {
        if(estado.equals("vermelho"))estado="verde";
        else if(estado.equals("amarelo"))estado="vermelho";
        else estado="amarelo";
    }
    public String toString()
    {
        return "Estado atual: " + estado;
    }
}