import java.util.Scanner;
public class Exercicio15v1
{
   public static void main(String args[]){
       Scanner entrada = new Scanner(System.in);
       
       System.out.print("Informe 3 valores reais: ");
       double valor1 = entrada.nextDouble();
       double valor2 = entrada.nextDouble();
       double valor3 = entrada.nextDouble();
       
       double maior = valor1;
       if(valor2>maior) maior = valor2;
       if(valor3>maior) maior = valor3;
       
       double menor = valor1;
       if(valor2<menor) menor = valor2;
       if(valor3<menor) menor = valor3;
       
       double meio = valor1 + valor2 + valor3 - maior - menor;
     int opcao=1;  
     while(opcao!=0){
       System.out.print("Informe\n1-Ordem Crescente\n2-Ordem Decrescente\n3-Maior no meio\n0-Sair\nOpção:");
       opcao = entrada.nextInt();
       
       switch(opcao){
           case 0: System.out.println("Fim do programa");
                    break;
           case 1 :  System.out.println("Crescente: " + menor + " " +
                               meio + " " + maior);
                    break;
           case 2:  System.out.println("Decrescente: " + maior + " " +
                               meio + " " + menor);
                    break;
          
           case 3: System.out.println("Maior no meio: " + menor + " " +
                               maior + " " + meio);
                   break;
           default: System.out.println("Opção inválida");
       }
    }
   }
}