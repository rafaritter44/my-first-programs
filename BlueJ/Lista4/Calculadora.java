
/**
 * Write a description of class Calculadora here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Calculadora
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int op;
        double numero1=0, numero2=0;
        boolean inicializados = false;
        
        do{
            exibirMenu();
            System.out.println("Informe a opção: ");
            op = in.nextInt();
            switch(op){
                case 0: System.out.println("Fim do programa"); break;
                
                case 1: System.out.print("Informe o primeiro valor: ");
                        numero1 = in.nextDouble();
                        System.out.print("Informe o segundo valor: ");
                        numero2 = in.nextDouble();
                        inicializados = true;
                        break;
                
                case 2: if(inicializados) System.out.println("Resultado da soma: " + somar(numero1,numero2));  break;
                case 3: if(inicializados) System.out.println("Resultado da subtração: " + subtrair(numero1,numero2));  break;
                case 4: if(inicializados) System.out.println("Resultado da multiplicação: " + multiplicar(numero1,numero2));  break;    
                case 5: if(inicializados){
                              if(numero2!=0) System.out.println("Resultado da divisão: " + dividir(numero1,numero2));  
                              else {
                                  System.out.println("O segundo valor não pode ser zero");
                                  inicializados = false;
                              }
                         }
                         break;   
                default: System.out.println("Opção inválida");
            }
            if(!inicializados && op!=0) System.out.println("É necessário definir os valores válidos antes de calcular");
        }while(op!=0);
        
        
    }
    
    public static void exibirMenu(){
        System.out.println("---- Calculadora ----");
        System.out.println("1 - Ler valores");
        System.out.println("2 - Somar");
        System.out.println("3 - Subtrair");
        System.out.println("4 - Multiplicar");
        System.out.println("5 - Dividir");
        System.out.println("0 - Sair");    
    }
    
    public static double somar(double valor1, double valor2){
        return valor1+valor2;
    }
    
    public static double subtrair(double valor1, double valor2){
        return valor1-valor2;
    }
    
    public static double multiplicar(double valor1, double valor2){
        return valor1*valor2;
    }
    
    public static double dividir(double valor1, double valor2){
        return valor1/valor2;
    }
}