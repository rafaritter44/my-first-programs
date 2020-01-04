public class Carro
{
    private String placa;
    private double capacidadeTanque, mediaDeConsumo, litros;
    
    public Carro(String placaI, double capacidadeTanqueI, double mediaDeConsumoI)
    {
        setPlaca(placaI);
        setCapacidadeTanque(capacidadeTanqueI);
        setConsumo(mediaDeConsumoI);
        litros = capacidadeTanqueI;
    }
    
    public void setPlaca(String placaI)
    {
        placa = placaI;
    }
    
    public void setCapacidadeTanque(double capacidadeTanqueI)
    {
        if(capacidadeTanqueI<40)capacidadeTanque = 40;
        else capacidadeTanque = capacidadeTanqueI;
    }
    
    public void setConsumo(double mediaDeConsumoI)
    {
        if(mediaDeConsumoI<6)mediaDeConsumo = 6;
        else mediaDeConsumo = mediaDeConsumoI;
    }
    
    public String getPlaca()
    {
        return placa;
    }
    
    public double getLitros()
    {
        return litros;
    }
    
    public double getCapacidadeTanque()
    {
        return capacidadeTanque;
    }
    
    public double getMediaDeConsumo()
    {
        return mediaDeConsumo;
    }
    
    public void abastecer(double quantidade)
    {
        double tanqueAtualizado = litros + quantidade;
        if(tanqueAtualizado<=capacidadeTanque)litros = tanqueAtualizado;
    }
    
    public int preverCombustivel(double distancia)
    {
        double l = distancia/mediaDeConsumo;
        return (int)Math.ceil(l/capacidadeTanque);
    }
    
    public String toString()
    {
        return "carro1";
    }
}