public class Retangulo
{
    private double base, altura;
    public Retangulo(double base, double altura)
    {
        this.base = 1;
        this.altura = 1;
        setBase(base);
        setAltura(altura);
    }
    public double getBase()
    {
        return base;
    }
    public double getAltura()
    {
        return altura;
    }
    public void setBase(double base)
    {
        if(base>0)this.base = base;
    }
    public void setAltura(double altura)
    {
        if(altura>0)this.altura = altura;
    }
    public double calculaArea()
    {
        return base*altura;
    }
    public double calculaPerimetro()
    {
        return 2*(base+altura);
    }
    public double calculaDiagonal()
    {
        return Math.sqrt(Math.pow(base,2)+Math.pow(altura,2));
    }
    public String toString()
    {
        return "Base: " + base + "\nAltura: " + altura + "\nÁrea: " + calculaArea() +
        "\nPerímetro: " + calculaPerimetro() + "\nDiagonal: " + calculaDiagonal();
    }
}