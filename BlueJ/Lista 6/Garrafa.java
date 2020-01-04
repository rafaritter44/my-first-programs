public class Garrafa
{
    private double r1, r2, h1, h2, h3;
    public Garrafa(double r1, double r2, double h1, double h2, double h3)
    {
        this.r1 = 1;
        this.r2 = 1;
        this.h1 = 1;
        this.h2 = 1;
        this.h3 = 1;
        setR1(r1);
        setR2(r2);
        setH1(h1);
        setH2(h2);
        setH3(h3);
    }
    public double getR1()
    {
        return r1;
    }
    public double getR2()
    {
        return r2;
    }
    public double getH1()
    {
        return h1;
    }
    public double getH2()
    {
        return h2;
    }
    public double getH3()
    {
        return h3;
    }
    public void setR1(double r1)
    {
        if(r1>0)this.r1=r1;
    }
    public void setR2(double r2)
    {
        if(r2>0)this.r2=r2;
    }
    public void setH1(double h1)
    {
        if(h1>0)this.h1=h1;
    }
    public void setH2(double h2)
    {
        if(h2>0)this.h2=h2;
    }
    public void setH3(double h3)
    {
        if(h3>0)this.h3=h3;
    }
    public double calculaVolume()
    {
        return Math.PI*(Math.pow(r1,2)*h1 + Math.pow(r2,2)*h2 + (Math.pow(r1,2)+r1*r2+Math.pow(r2,2))*h3/3);
    }
    public String toString()
    {
        return "Raio 1: " + r1 + " — Altura 1: " + h1 + "\nRaio 2: " + r2 + " — Altura 2: " + h2 +
        "\nAltura 3: " + h3 + "\nVolume: " + calculaVolume();
    }
}