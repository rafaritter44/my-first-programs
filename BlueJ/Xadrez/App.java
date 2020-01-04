import java.util.concurrent.TimeUnit;
import java.util.Scanner;
public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        Scanner in = new Scanner(System.in);
        Jogo jogo = new Jogo();
        String vencedor = null, erro = "";
        do
        {
            System.out.print("\f");
            jogo.exibe();
            System.out.println("----- XADREZ -----" + erro);
            System.out.println("(1) – Jogador vs Jogador");
            System.out.println("(2) – Jogador vs Computador");
            System.out.println("(3) – Computador vs Computador");
            System.out.print("Opção: ");
            String opcao = in.nextLine();
            switch(opcao)
            {
                case "1": vencedor = pVp(jogo); break;
                case "2": erro = "";
                do
                {
                    System.out.print("\f");
                    jogo.exibe();
                    System.out.println("----- XADREZ -----" + erro);
                    System.out.println("(1) – Brancas");
                    System.out.println("(2) – Pretas");
                    System.out.print("Jogar com as: ");
                    opcao = in.nextLine();
                    switch(opcao)
                    {
                        case "1": vencedor = pVpc(jogo); break;
                        case "2": vencedor = pcVp(jogo); break;
                        default: erro = "\nESCOLHA INVÁLIDA";
                    }
                }
                while(vencedor==null);
                break;
                case "3": vencedor = pcVpc(jogo); break;
                default: erro = "\nESCOLHA INVÁLIDA";
            }
        }
        while(vencedor==null);
        System.out.print("\n" + vencedor);
    }
    public static String pVp(Jogo jogo)
    {
        String vencedor;
        do
        {
            jogo.jogadaEscolhida();
            vencedor = jogo.vencedor();
        }
        while(vencedor==null);
        System.out.print("\f");
        jogo.exibe();
        return vencedor;
    }
    public static String pVpc(Jogo jogo)
    {
        String vencedor;
        do
        {
            jogo.jogadaEscolhida();
            vencedor = jogo.vencedor();
            if(vencedor==null)
            {
                jogo.jogadaAleatoria();
                vencedor = jogo.vencedor();
            }
        }
        while(vencedor==null);
        System.out.print("\f");
        jogo.exibe();
        return vencedor;
    }
    public static String pcVp(Jogo jogo)
    {
        String vencedor;
        do
        {
            jogo.jogadaAleatoria();
            vencedor = jogo.vencedor();
            if(vencedor==null)
            {
                jogo.jogadaEscolhida();
                vencedor = jogo.vencedor();
            }
        }
        while(vencedor==null);
        System.out.print("\f");
        jogo.exibe();
        return vencedor;
    }
    public static String pcVpc(Jogo jogo) throws InterruptedException
    {
        String vencedor;
        System.out.print("\f");
        jogo.exibe();
        do
        {
            jogo.jogadaAleatoria();
            TimeUnit.SECONDS.sleep(1);
            System.out.print("\f");
            jogo.exibe();
            vencedor = jogo.vencedor();
        }
        while(vencedor==null);
        return vencedor;
    }
}