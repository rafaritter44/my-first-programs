import java.util.Scanner;
public class AppListaDeNomes
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Informe a quantidade de elementos da lista de nomes: ");
        String quantidade = in.nextLine();
        int q = Integer.parseInt(quantidade);
        ListaDeNomes lista = new ListaDeNomes(q);
        
        String opcao;
        do
        {
            System.out.println("---- M E N U ----");
            System.out.println(" 1 - Insere");
            System.out.println(" 2 - Lista todos");
            System.out.println(" 3 - Pesquisa");
            System.out.println(" 4 - Exclui");
            System.out.println(" 5 - Lista em ordem alfabética");
            System.out.println(" 0 - Sai");
            System.out.print("Informe a opção: ");
            opcao = in.nextLine();
            switch(opcao)
            {
                case "1": System.out.print("Informe um nome: ");
                          String umNome = in.nextLine();
                          boolean resultado = lista.insere(umNome);
                          if(resultado)System.out.println("Inserção realizada");
                          else System.out.println("Inserção não realizada");
                          break;
                          
                case "2": System.out.println(lista);
                          break;
                          
                case "3": System.out.print("Informe o nome a pesquisar: ");
                          umNome = in.nextLine();
                          resultado = lista.pesquisa(umNome);
                          if(resultado)System.out.println(umNome + " já está na lista");
                          else System.out.println(umNome + " não foi encontrado");
                          break;
                          
                case "4": System.out.print("Informe o nome a excluir: ");
                          umNome = in.nextLine();
                          resultado = lista.exclui(umNome);
                          if(resultado)System.out.println(umNome + " foi excluído da lista");
                          else System.out.println(umNome + " não foi encontrado");
                          break;
                          
                case "5": lista.ordena();
                          System.out.println(lista);
                          break;
                          
                case "0": System.out.println("Fim do programa");
                          break;
                          
                default: System.out.println("Opção inválida");
            }
        }
        while(opcao.equals("0")==false); 
    }
}