import java.util.Scanner;
public class Agenda
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        ListaDeContatos telefones = new ListaDeContatos(30);
        
        String opcao;
        do
        {
            System.out.println(" 1 - Insere");
            System.out.println(" 2 - Lista todos");
            System.out.println(" 3 - Altera telefone pessoal");
            System.out.println(" 4 - Altera telefone comercial");
            System.out.println(" 5 - Exclui contato");
            System.out.println(" 6 - Exibe os dados de um determinado contato");
            System.out.println(" 7 - Ordena a lista de contatos por nome");
            System.out.println(" 0 - Sai");
            System.out.print("Informe a opção: ");
            opcao = in.nextLine();
            
            switch(opcao)
            {
                case "0": System.out.println("Fim do programa"); break;
                
                case "1": System.out.print("Informe o novo nome: ");
                          String nome = in.nextLine();
                          Contato umContato = new Contato(nome);
                          boolean resultado = telefones.insere(umContato);
                          if(resultado)System.out.println("Cadastro realizado com sucesso");
                          else System.out.println("Cadastro não realizado");

                          //boolean resultado = telefones.cadastra(nome);
                          //if(resultado)System.out.println("Cadastro realizado com sucesso");
                          //else System.out.println("Cadastro não realizado");
                          break;
                          
                case "2": System.out.println("Contatos:\n" + telefones.toString());
                          break;
                          
                case "3": System.out.print("Informe o nome do contato cujo telefone será alterado: ");
                          nome = in.nextLine();
                          Contato contatoEncontrado = telefones.buscaContato(nome);
                          if(contatoEncontrado==null)System.out.println("Contato não encontrado");
                          else
                          {
                              System.out.print("Informe o telefone pessoal: ");
                              String telefone = in.nextLine();
                              contatoEncontrado.setTelefonePessoal(telefone);
                              System.out.println("Telefone alterado");
                          }
                          break;
                
                case "4": System.out.print("Informe o nome do contato cujo telefone será alterado: ");
                          nome = in.nextLine();
                          contatoEncontrado = telefones.buscaContato(nome);
                          if(contatoEncontrado==null)System.out.println("Contato não encontrado");
                          else
                          {
                              System.out.print("Informe o telefone comercial: ");
                              String telefone = in.nextLine();
                              contatoEncontrado.setTelefoneComercial(telefone);
                              System.out.println("Telefone alterado");
                          }
                          break;
                          
                case "5": System.out.print("Informe o nome do contato a ser excluído: ");
                          nome = in.nextLine();
                          if(telefones.excluiContato(nome))System.out.println("Contato excluído");
                          else System.out.println("Contato não encontrado");
                          break;
                
                case "6": System.out.print("Informe o nome do contato cujos dados serão exibidos: ");
                          nome = in.nextLine();
                          contatoEncontrado = telefones.buscaContato(nome);
                          if(contatoEncontrado==null)System.out.println("Contato não encontrado");
                          else System.out.println(contatoEncontrado);
                          break;
                case "7": resultado = telefones.ordena();
                          if(resultado)System.out.println("Lista ordenada com sucesso");
                          else System.out.println("Lista já está em ordem");
                          break;
            }
        }
        while(!opcao.equals("0"));
    }
}