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
public class Exercicio1
{
   public static void main(String args[]) throws FileNotFoundException {
       System.out.println("\fExibe frutas que iniciam por A: ");
       exibeFrutascomA("frutas.txt");  
       System.out.println("\nExibe frutas que possuem ao menos 2 A's: ");
       exibeFrutascomAoMenos2A("frutas.txt");
       System.out.println("\nExibe frutas sem A: ");
       exibeFrutasSemA("frutas.txt");
   }
     
   public static void exibeFrutascomA(String nomeArquivo)throws FileNotFoundException {
       File origem = new File(nomeArquivo);
       Scanner arquivo = new Scanner(origem);
       
       while(arquivo.hasNextLine()){
           String linha = arquivo.nextLine();
           char letra = linha.charAt(0);
           if(letra=='a' || letra =='A') {
                System.out.println(linha);
           }
       }
       arquivo.close();
   }
   public static void exibeFrutascomAoMenos2A(String nomeArquivo)throws FileNotFoundException {
       File origem = new File(nomeArquivo);
       Scanner arquivo = new Scanner(origem);
       
       while(arquivo.hasNextLine()){
           String linha = arquivo.nextLine();
           int quant = contaA(linha);
           if(quant>=2) System.out.println(linha);
          
       }
       arquivo.close();
   }
   public static int contaA(String palavra){
       int cont = 0;
       for(int pos=0; pos<palavra.length(); pos++){
           char letra = palavra.charAt(pos);
           if(letra=='a' || letra=='A') cont++;
       }
       return cont;
   }
   public static void exibeFrutasSemA(String nomeArquivo)throws FileNotFoundException {
       File origem = new File(nomeArquivo);
       Scanner arquivo = new Scanner(origem);
       
       while(arquivo.hasNextLine()){
           String linha = arquivo.nextLine();
           int quant = contaA(linha);
           if(quant==0) System.out.println(linha);
          
       }
       arquivo.close();
   }
}