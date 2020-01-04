/**
 * Representa uma Carta.
 * 
 * @author Rafael Ritter 
 * @version 19/11/2016
 */
import java.util.Random;
public class Carta
{
    private int valor;
    private int numero;
    private String naipe;
    
    /**
     * Cria uma carta com número e naipe aleatórios.
     */
    public Carta()
    {
        Random gera = new Random();
        
        numero = gera.nextInt(10)+1;
        if(numero>=8)numero+=2;
        
        if(numero==4)valor=0;
        else if(numero==5)valor=1;
        else if(numero==6)valor=2;
        else if(numero==7)valor=3;
        else if(numero==10)valor=4;
        else if(numero==11)valor=5;
        else if(numero==12)valor=6;
        else if(numero==1)valor=7;
        else if(numero==2)valor=8;
        else valor=9;
        
        int naipe = gera.nextInt(4);
        if(naipe==0)this.naipe="ouros";
        else if(naipe==1)this.naipe="espadas";
        else if(naipe==2)this.naipe="copas";
        else this.naipe="paus";
    }
    
    /**
     * Cria uma carta com número e naipe informados por parâmetro.
     * @param numero número da carta.
     * @param naipe naipe da carta.
     */
    public Carta(int numero, String naipe)
    {
        this.numero = numero;
        this.naipe = naipe;
        
        if(numero==4)valor=0;
        else if(numero==5)valor=1;
        else if(numero==6)valor=2;
        else if(numero==7)valor=3;
        else if(numero==10)valor=4;
        else if(numero==11)valor=5;
        else if(numero==12)valor=6;
        else if(numero==1)valor=7;
        else if(numero==2)valor=8;
        else valor=9;
    }
    
    /**
     * Devolve o valor da carta.
     */
    public int getValor()
    {
        return valor;
    }
    
    /**
     * Devolve o número da carta.
     */
    public int getNumero()
    {
        return numero;
    }
    
    /**
     * Devolve o naipe da carta.
     */
    public String getNaipe()
    {
        return naipe;
    }
    
    /**
     * Informa o número e o naipe da carta.
     */
    public String toString()
    {
        return numero + " de " + naipe;
    }
}