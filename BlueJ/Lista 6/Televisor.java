public class Televisor
{
    //Atributos: propriedades, características que definem os objetos da classe
    private int canal, volume;
    private String marca;
    
    //Método Construtor
    public Televisor()
    {
        marca = "Sony";
        canal = 15;
        volume = 3;
    }
    
    public Televisor(String marcaInicial, int volumeInicial, int canalInicial)
    {
        if(marcaInicial != null)marca = marcaInicial;
        else marca = "Nao Informada";
        if(volumeInicial>=0 && volumeInicial<=100)volume = volumeInicial;
        else volume = 0;
        if(canalInicial>=1 && canalInicial<=700)canal = canalInicial;
        else canal = 1;
    }
    
    //Métodos de consulta (de acesso)
    public String getMarca()
    {
        return marca;
    }
    public int getVolume()
    {
        return volume;
    }
    public int getCanal()
    {
        return canal;
    }
    
    //Métodos modificadores
    public void setMarca(String novaMarca)
    {
        if(novaMarca!=null)marca = novaMarca;
    }
    public void setCanal(int novoCanal)
    {
        if(novoCanal>=1 && novoCanal<=700)canal = novoCanal;
    }
    
    //Outros métodos
    public void aumentarVolume()
    {
        if(volume<100)volume++;
    }
    public void diminuirVolume()
    {
        if(volume>0)volume--;
    }
    public void aumentarCanal()
    {
        if(canal<700)canal++;
        else canal = 1;
    }
    public void diminuirCanal()
    {
        if(canal>1)canal--;
        else canal = 700;
    }
}