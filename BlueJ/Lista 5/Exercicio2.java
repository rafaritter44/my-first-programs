/**
 * Write a description of class Exemplo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.File; //Necessário para trabalhar com arquivos (File)
import java.io.FileNotFoundException; //Necessário em razão da excessão gerada quando o arquivo não é encontrado.
import java.io.PrintWriter; //Necessário para gravar em arquivo
import java.util.Scanner; //Necessário para leitura de arquivos
public class Exercicio2
{
   public static void main(String args[]) throws FileNotFoundException {    
       leitura("reais.txt");    
   }
   
   public static void leitura(String nomeArquivo)throws FileNotFoundException {
       File origem = new File(nomeArquivo);
       Scanner arquivo = new Scanner(origem);
       
       double maior = 0;
       while(arquivo.hasNextLine()){
           String linha = arquivo.nextLine();
           double valor = Double.parseDouble(linha);
           if(valor>maior) maior = valor;
       }
       arquivo.close();
       System.out.println("\fMaior: " + maior);
   }
}