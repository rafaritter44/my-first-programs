import java.util.Scanner;
public class Exercicio{
  public static void main(String args[]){
    Scanner entrada = new Scanner(System.in);
    System.out.println("\fInforme um valor positivo: ");
    int valor = entrada.nextInt();
    while(valor<=0)
    {
      System.out.println("\fInforme um valor positivo: ");
      valor = entrada.nextInt();
    }
}
}