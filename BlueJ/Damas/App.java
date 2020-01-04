import java.util.Scanner;
public class App
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        Jogo jogo = new Jogo();
        System.out.println("\f----- DAMAS -----");
        
        String opcao;
        char vencedor = 'n';
        do
        {
            System.out.println("(1) – Jogador vs Jogador");
            System.out.println("(2) – Jogador vs Computador");
            System.out.println("(3) – Computador vs Computador");
            System.out.print("\nInforme a opção: ");
            opcao = in.nextLine();
            switch(opcao)
            {
                case "1": vencedor = pVp(jogo); break;
                case "2":
                do
                {
                    System.out.println("Deseja jogar como (o) ou como (x)?");
                    System.out.print("\nInforme a opção: ");
                    opcao = in.nextLine();
                    if(opcao.equalsIgnoreCase("o"))
                    {
                        vencedor = pVpc(jogo);
                    }
                    else if(opcao.equalsIgnoreCase("x"))
                    {
                        vencedor = pcVp(jogo);
                    }
                    else
                    {
                        System.out.println("\nOPÇÃO INVÁLIDA\n");
                    }
                }
                while(vencedor=='n');
                break;
                case "3": vencedor = pcVpc(jogo); break;
                default: System.out.println("\nOPÇÃO INVÁLIDA\n");
            }
        }
        while(vencedor=='n');
        
        jogo.estadoAtual();
        System.out.println("\n----- Vitória de (" + vencedor + ") -----\n");
    }
    
    public static char pVp(Jogo jogo)
    {
        char vencedor;
        do
        {
            jogo.estadoAtual();
            vencedor = jogo.proximaJogada();
        }
        while(vencedor=='n');
        return vencedor;
    }
    
    public static char pVpc(Jogo jogo)
    {
        char vencedor;
        do
        {
            jogo.estadoAtual();
            vencedor = jogo.proximaJogada();
            if(vencedor=='n') vencedor = jogo.proximoComputador();
        }
        while(vencedor=='n');
        return vencedor;
    }
    
    public static char pcVp(Jogo jogo)
    {
        char vencedor;
        do
        {
            vencedor = jogo.proximoComputador();
            if(vencedor=='n')
            {
                jogo.estadoAtual();
                vencedor = jogo.proximaJogada();
            }
        }
        while(vencedor=='n');
        return vencedor;
    }
    
    public static char pcVpc(Jogo jogo)
    {
        char vencedor;
        do
        {
            jogo.estadoAtual();
            vencedor = jogo.proximoComputador();
        }
        while(vencedor=='n');
        return vencedor;
    }
}