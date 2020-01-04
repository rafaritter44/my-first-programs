/**
 * Write a description of class Operacoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Operacoes
{
   /* public static double fatorial(int n){
        if(n<0 || n>170) return -1;
        int f=1;
        for(int c = 2; c<=n; c++){ f = f * c; }
        return f;
    }*/
    public static double fatorial(int n){
        if(n<0 || n>170) return -1;
        if(n==0 || n==1) return 1;
        return n * fatorial(n-1);
    }
}