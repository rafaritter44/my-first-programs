
/**
 * Write a description of class Interface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class InterfaceComUsuario
{
    private Scanner in;
    private ListaDeContatos telefones;
    
    public InterfaceComUsuario(){
        in = new Scanner(System.in);
        telefones = new ListaDeContatos(30);
    }
    
    public void menu(){
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
                
                case "1": insere(); break;
                
                case "2": telefones.ordena();
                           System.out.println("Contatos:\n" + telefones.toString());
                           break;
                default: System.out.println("Opção imvalida");
            }
        }while(!opcao.equals("0"));
    }
    public void insere(){
        System.out.print("Informe o novo nome: ");
        String nome = in.nextLine();
                          
        Contato umContato = new Contato(nome);
        boolean resultado = telefones.insere(umContato);
        if(resultado==true) System.out.println("Cadastro realizado com sucesso");
        else System.out.println("Cadastro não realizado");
    }
}
