
/**
 * Write a description of class Testa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Testa
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Informe uma palavra: ");
        String umaPalavra = in.nextLine();
        
        //int posicao = umaPalavra.length()-1;
        int totalLetrasA = Operacoes.contagemDeLetrasA(umaPalavra);
        //int totalLetrasA = Operacoes.contaLetrasA(umaPalavra,posicao);
        System.out.println("Total de letras A: " + totalLetrasA);
        System.out.println("Invertida: " + Operacoes.fazInversao(umaPalavra));
        System.out.println("Sem as vogais: " + Operacoes.removeVogais(umaPalavra)); 
    }
}
