public class Esfera
{
    private double raio;
    
    /**
     * Cria uma esfera com raio informado como parâmetro
     * @param raioInicial valor do raio. Deve ser positivo. Se não for, a esfera será criada com raio igual a 1.
     */
    public Esfera(double raioInicial)
    {
        if(raioInicial>0)raio = raioInicial;
        else raio = 1;
    }
    
    /**
     * Devolve o valor atual do raio da esfera
     */
    public double getRaio()
    {
        return raio;
    }
    
    /**
     * Modifica o raio da esfera.
     * @param novoRaio novo valor do raio (deve ser positivo)
     */
    public void setRaio(double novoRaio)
    {
        if(novoRaio>0)raio = novoRaio;
    }
    
    /**
     * Calcula o volume da esfera
     * @return valor double correspondente ao volume
     */
    public double calcularVolume()
    {
        return 4.0/3 * Math.PI * Math.pow(raio,3);
    }
    
     /**
     * Calcula a área da esfera
     * @return valor double correspondente à área
     */
    public double calcularArea()
    {
        return 4 * Math.PI * Math.pow(raio,2);
    }
    
    public String toString()
    {
        return "Raio: " + raio + " Volume: " + calcularVolume() + " Área: " + calcularArea();
    }
}