
/**
 * Write a description of class Agenda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class AgendaTelefonica
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        ListaDeContatos telefones = new ListaDeContatos(30);
        
        String opcao;
        do{
            System.out.println(" 1 - Insere ");
            System.out.println(" 2 - Lista todos");
            System.out.println(" 3 - Altera telefone pessoal");
            System.out.println(" 4 - Altera telefone comercial");
            System.out.println(" 5 - Exclui");
            System.out.println(" 6 - Busca contato");
            System.out.println(" 0 - Sai");
            System.out.print("Informe a opção: ");
            opcao = in.nextLine();
            
            switch(opcao){
                case "0": System.out.println("Fim do programa"); break;
                
                case "1": insere(telefones);
                          break;
                          
                case "2" : telefones.ordena();
                           System.out.println("Contatos:\n" + telefones.toString());
                           break;
                       
                case "3": System.out.print("Informe o nome do contato cujo telefone pessoal será alterado: ");
                          String nome = in.nextLine();
                          Contato contatoEncontrado = telefones.buscaContato(nome);
                          if(contatoEncontrado==null) System.out.println("Contato não encontrado");
                          else {
                              System.out.print("Informe o telefone pessoal: ");
                              String telefone = in.nextLine();
                              contatoEncontrado.setTelefonePessoal(telefone);
                              System.out.println("Telefone pessoal alterado");
                          }
                          break;
                
                case "4": System.out.print("Informe o nome do contato cujo telefone comercial será alterado: ");
                          nome = in.nextLine();
                          contatoEncontrado = telefones.buscaContato(nome);
                          if(contatoEncontrado==null) System.out.println("Contato não encontrado");
                          else{
                               System.out.print("Informe o telefone comercial: ");
                               String telefone = in.nextLine();
                               contatoEncontrado.setTelefoneComercial(telefone);
                               System.out.println("Telefone comercial atualizado");
                          }
                          break;
                case "5": System.out.print("Informe o nome do contato a excluir: ");
                          nome = in.nextLine();       
                          contatoEncontrado = telefones.buscaContato(nome);
                          if(contatoEncontrado==null) System.out.println("Contato não encontrado");
                          else{
                              System.out.println(contatoEncontrado.toString());
                              System.out.println("Confirma (S/N)?");
                              String resp = in.nextLine();
                              if(resp.equalsIgnoreCase("S")){
                                   telefones.excluiContato(nome);   
                                   System.out.println("Contato excluido");
                              }
                          }
                          break;
                          
                case "6": System.out.print("Informe o nome do contato a excluir: ");
                          nome = in.nextLine();       
                          contatoEncontrado = telefones.buscaContato(nome);
                          if(contatoEncontrado==null) System.out.println("Contato não encontrado");
                          else{
                              System.out.println(contatoEncontrado.toString());
                          }
                          break;
                default: System.out.println("Opção inválida");
            }
            
        }while(!opcao.equals("0"));
        
    }
    
    public static void insere(ListaDeContatos telefones){
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o novo nome: ");
        String nome = in.nextLine();
                          
        Contato umContato = new Contato(nome);
        boolean resultado = telefones.insere(umContato);
        if(resultado==true) System.out.println("Cadastro realizado com sucesso");
        else System.out.println("Cadastro não realizado");
                          
                          //boolean resultado = telefones.cadastra(nome);
                          //if(resultado==true) System.out.println("Cadastro realizado com sucesso");
                          //else System.out.println("Cadastro não realizado");
    }
}
