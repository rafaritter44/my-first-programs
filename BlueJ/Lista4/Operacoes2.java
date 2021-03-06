
/**
 * Write a description of class Operacoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Operacoes2
{
    /**
     * Fibonacci - Versão iterativa (Termos da série: 1,1,2,3,5,8,13,... 
     * @param n - indica o termo da série de fibonacci (valor inteiro)
     * @return devolve o inteiro correspondente ao n-ésimo termo
     */
    public static int fibonacci(int n){
        if(n<=2) return 1;
        int n1 = 1;
        int n2 = 1;
        int soma;
        for(int cont=3; cont <= n; cont++){
            soma = n1+n2;
            n1 = n2;
            n2 = soma;
        }
        return n2;
    }
    /**
     * Fibonacci - Versão recursiva(Termos da série: 1,1,2,3,5,8,13,... 
     * @param n - indica o termo da série de fibonacci (valor inteiro)
     * @return devolve o inteiro correspondente ao n-ésimo termo
     */
    public static int fibo(int n){
        if(n<3) return 1;
        return fibo(n-1) + fibo(n-2);
    }
    
    /**
     * Somatório -  Versão Recursiva. Ex: somatorio(3) corresponde a 0+1+2+3
     * @param n - valor inteiro para o qual o somatório deve ser calculado
     * @return devolve o valor correspondente ao somatório
     */
    public static int somatorio(int n){
        if(n<=0) return 0;
        return n + somatorio(n-1);
    }
    /**
     * Versão recursiva - série correspondente ao exercicio 7 da lista sobre recursão. Ex: 1 + 1/2 + 1/3 + ... + 1/n
     * @param n - valor inteiro que indica quantos termos da série devem ser somados
     * @return devolve a soma da série (valor double)
     */
    public static double serie7(int n){
        if(n<=1) return 1;
        return 1.0/n + serie7(n-1);
    }
    
    /**
     * Versão recursiva - série correspondente ao exercicio 8 da lista sobre recursão. Ex: 2 + 6/2 + 10/3 + ... + 1/n
     * @param n - valor inteiro que indica quantos termos da série devem ser somados
     * @return devolve a soma da série (valor double)
     */
    public static double serie8(int n){
        if(n<=1) return 2;
        return (4.0*(n-1)+2)/n + serie8(n-1);
    }
}




