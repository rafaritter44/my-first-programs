import java.util.Scanner;
public class AppListaDeLivros
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Informe com quantos livros pretende preencher a lista: ");
        String qt = in.nextLine();
        
        ListaDeLivros lista = new ListaDeLivros(Integer.parseInt(qt));
        
        String opcao;
        do
        {
            System.out.println("---------- MENU ----------");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Buscar livro por código");
            System.out.println("3 - Buscar livro por autor(es)");
            System.out.println("4 - Excluir livro por código");
            System.out.println("5 - Exibir lista");
            System.out.println("0 - Sair");
            System.out.println("Informe a opção: ");
            opcao = in.nextLine();
            
            switch(opcao)
            {
                case "1": System.out.print("Por favor, informe o título do livro: ");
                String titulo = in.nextLine();
                System.out.print("Agora informe o nome do(s) autor(es): ");
                String autores = in.nextLine();
                
                boolean resultado = lista.cadastra(titulo, autores);
                if(resultado)System.out.println("Livro cadastrado com sucesso!");
                else System.out.println("Não há espaço na lista!");
                break;
                
                case "2": System.out.print("Informe o código do livro: ");
                String codigo = in.nextLine();
                Livro livroBuscado = lista.buscaPorCodigo(Integer.parseInt(codigo));
                if(livroBuscado==null)System.out.println("Livro não encontrado!");
                else System.out.println(livroBuscado);
                break;
                
                case "3": System.out.print("Informe o nome do(s) autor(es): ");
                autores = in.nextLine();
                lista.buscaPorAutores(autores);
                break;
                
                case "4": System.out.print("Informe o código do livro a ser excluído: ");
                codigo = in.nextLine();
                String simNao;
                do
                {
                    System.out.println("Tem certeza? (S/N)");
                    System.out.print("Informe a opção: ");
                    simNao = in.nextLine();
                }
                while(!simNao.equalsIgnoreCase("S") && !simNao.equalsIgnoreCase("N"));
                
                if(simNao.equalsIgnoreCase("N"))System.out.println("Operação cancelada");
                else
                {
                    resultado = lista.excluiPorCodigo(Integer.parseInt(codigo));
                    if(resultado)System.out.println("Livro excluído com sucesso!");
                    else System.out.println("Livro não encontrado!");
                }
                break;
                
                case "5": System.out.println(lista);
                break;
                
                case "0": System.out.println("---------- FIM ----------");
                break;
                
                default: System.out.println("OPÇÃO INVÁLIDA");
            }
        }
        while(!opcao.equals("0"));
    }    
}