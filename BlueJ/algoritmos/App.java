import java.util.Scanner;
public class App
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Indice indice = new Indice();
        
        System.out.print("\fInforme o nome do arquivo a ser processado: ");
        indice.leitura(in.nextLine());
        
        String opcao = "";
        do
        {
            System.out.print("\n- - - - - MENU - - - - -\n\n" +
            "1. Exibir todo o índice remissivo (em ordem alfabética)\n" +
            "2. Exibir o percentual de stopwords do texto (quanto % do texto é formado por stopwords)\n" +
            "3. Encontrar a palavra mais frequente, isto é, com maior número de ocorrências\n" +
            "4. Pesquisar palavra\n" +
            "5. Encontrar página complexa\n" +
            "0. Sair\n\n" +
            "Informe a opção: ");
            
            opcao = in.next();
            
            switch(opcao)
            {
                case "1": indice.exibir();
                break;
                
                case "2": System.out.println("\nO texto é formado por " + indice.porcentagemStopWords()
                + "% de stopwords.");
                break;
                
                case "3": System.out.println("\nA palavra mais frequente é \"" +
                indice.palavraMaisFrequente() + "\"");
                break;
                
                case "4": System.out.print("\nInforme a palavra: ");
                String pal = in.next();
                int[] pags = indice.buscaPalavra(pal);
                
                System.out.println("\nPáginas em que \"" + pal + "\" ocorre:");
                for(int i=0; i<pags.length; i++)
                {
                    System.out.println(pags[i]);
                }
                
                System.out.print("Informe a página: ");
                int pag = in.nextInt();
                
                boolean paginaValida = false;
                for(int i=0; i<pags.length; i++)
                {
                    if(pags[i]==pag)
                    {
                        indice.exibirPagina(pag, pal);
                        paginaValida = true;
                        break;
                    }
                }
                
                if(!paginaValida) System.out.println("\nPágina inválida!!");
                
                break;
                
                case "5": indice.maisIndex();
                break;
                
                case "0": System.out.println("\nFIM DE PROGRAMA");
                break;
                
                default: System.out.println("\nOPÇÃO INVÁLIDA");
            }
        }
        while(!opcao.equals("0"));
    }
}