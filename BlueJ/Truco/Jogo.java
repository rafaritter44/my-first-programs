/**
 * Representa um Jogo.
 * 
 * @author Rafael Ritter 
 * @version 19/11/2016
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Jogo
{
    private Baralho baralho;
    private Dupla dupla1, dupla2;
    private Jogador jogador1, jogador2, jogador3, jogador4;
    private Jogador iniciadorDaRodada;
    private Jogador proximoJogador;
    private Carta coringa;
    private int valorDaRodada;
    private int levadasDupla1, levadasDupla2;
    
    /**
     * Cria um novo jogo com um baralho, duas duplas com 4 jogadores em cada, as cartas
     * já distribuídas entre os jogadores, o coringa já definido, o valor inicial da
     * rodada (1) estabelecido, o iniciador da rodada e o próximo a jogar como o
     * primeiro jogador, e a quantidade (0) de comparações que cada dupla ganhou.
     */
    public Jogo()
    {
        baralho = new Baralho();
        dupla1 = new Dupla("dupla ímpar");
        dupla2 = new Dupla("dupla par");
        jogador1 = new Jogador("jogador1", dupla1);
        jogador2 = new Jogador("jogador2", dupla2);
        jogador3 = new Jogador("jogador3", dupla1);
        jogador4 = new Jogador("jogador4", dupla2);
        baralho.distribui(jogador1,jogador2,jogador3,jogador4);
        coringa = baralho.getBaralho()[12];
        valorDaRodada = 1;
        iniciadorDaRodada = jogador1;
        proximoJogador = iniciadorDaRodada;
        levadasDupla1 = 0;
        levadasDupla2 = 0;
        
        System.out.println("\n---- COMEÇA O JOGO ----");
        System.out.println("\nPRIMEIRA RODADA! A carta que virou foi " + coringa + ".\n" +
        "Portanto, o coringa da rodada é " + getManilha() + "!\n");
        System.out.println(toString());
    }
    
    /**
     * Retoma um jogo iniciado anteriormente e salvo em arquivo durante o andamento.
     */
    public Jogo(String file)throws FileNotFoundException
    {
        File origem = new File(file);
        Scanner arquivo = new Scanner(origem);
        
        baralho = new Baralho();
        dupla1 = new Dupla("dupla ímpar", Integer.parseInt(arquivo.nextLine()), Boolean.parseBoolean(arquivo.nextLine()));
        dupla2 = new Dupla("dupla par", Integer.parseInt(arquivo.nextLine()), Boolean.parseBoolean(arquivo.nextLine()));
        
        String ver1c0 = arquivo.nextLine();
        Carta j1c0;
        if(ver1c0.equals("null"))
        {
            j1c0 = null;
        }
        else
        {
            j1c0 = new Carta(Integer.parseInt(ver1c0), arquivo.nextLine());
        }
        
        String ver1c1 = arquivo.nextLine();
        Carta j1c1;
        if(ver1c1.equals("null"))
        {
            j1c1 = null;
        }
        else
        {
            j1c1 = new Carta(Integer.parseInt(ver1c1), arquivo.nextLine());
        }
        
        String ver1c2 = arquivo.nextLine();
        Carta j1c2;
        if(ver1c2.equals("null"))
        {
            j1c2 = null;
        }
        else
        {
            j1c2 = new Carta(Integer.parseInt(ver1c2), arquivo.nextLine());
        }

        Carta[] maoJ1 = new Carta[3];
        maoJ1[0] = j1c0;
        maoJ1[1] = j1c1;
        maoJ1[2] = j1c2;
        
        String verE1 = arquivo.nextLine();
        Carta e1;
        if(verE1.equals("null"))
        {
            e1 = null;
        }
        else
        {
            e1 = new Carta(Integer.parseInt(verE1), arquivo.nextLine());
        }
        
        jogador1 = new Jogador("jogador1", dupla1, maoJ1, e1);
        
        String ver2c0 = arquivo.nextLine();
        Carta j2c0;
        if(ver2c0.equals("null"))
        {
            j2c0 = null;
        }
        else
        {
            j2c0 = new Carta(Integer.parseInt(ver2c0), arquivo.nextLine());
        }
        
        String ver2c1 = arquivo.nextLine();
        Carta j2c1;
        if(ver2c1.equals("null"))
        {
            j2c1 = null;
        }
        else
        {
            j2c1 = new Carta(Integer.parseInt(ver2c1), arquivo.nextLine());
        }
        
        String ver2c2 = arquivo.nextLine();
        Carta j2c2;
        if(ver2c2.equals("null"))
        {
            j2c2 = null;
        }
        else
        {
            j2c2 = new Carta(Integer.parseInt(ver2c2), arquivo.nextLine());
        }

        Carta[] maoJ2 = new Carta[3];
        maoJ2[0] = j2c0;
        maoJ2[1] = j2c1;
        maoJ2[2] = j2c2;
        
        String verE2 = arquivo.nextLine();
        Carta e2;
        if(verE2.equals("null"))
        {
            e2 = null;
        }
        else
        {
            e2 = new Carta(Integer.parseInt(verE2), arquivo.nextLine());
        }
        
        jogador2 = new Jogador("jogador2", dupla2, maoJ2, e2);
        
        String ver3c0 = arquivo.nextLine();
        Carta j3c0;
        if(ver3c0.equals("null"))
        {
            j3c0 = null;
        }
        else
        {
            j3c0 = new Carta(Integer.parseInt(ver3c0), arquivo.nextLine());
        }
        
        String ver3c1 = arquivo.nextLine();
        Carta j3c1;
        if(ver3c1.equals("null"))
        {
            j3c1 = null;
        }
        else
        {
            j3c1 = new Carta(Integer.parseInt(ver3c1), arquivo.nextLine());
        }
        
        String ver3c2 = arquivo.nextLine();
        Carta j3c2;
        if(ver3c2.equals("null"))
        {
            j3c2 = null;
        }
        else
        {
            j3c2 = new Carta(Integer.parseInt(ver3c2), arquivo.nextLine());
        }

        Carta[] maoJ3 = new Carta[3];
        maoJ3[0] = j3c0;
        maoJ3[1] = j3c1;
        maoJ3[2] = j3c2;
        
        String verE3 = arquivo.nextLine();
        Carta e3;
        if(verE3.equals("null"))
        {
            e3 = null;
        }
        else
        {
            e3 = new Carta(Integer.parseInt(verE3), arquivo.nextLine());
        }
        
        jogador3 = new Jogador("jogador3", dupla1, maoJ3, e3);
        
        String ver4c0 = arquivo.nextLine();
        Carta j4c0;
        if(ver4c0.equals("null"))
        {
            j4c0 = null;
        }
        else
        {
            j4c0 = new Carta(Integer.parseInt(ver4c0), arquivo.nextLine());
        }
        
        String ver4c1 = arquivo.nextLine();
        Carta j4c1;
        if(ver4c1.equals("null"))
        {
            j4c1 = null;
        }
        else
        {
            j4c1 = new Carta(Integer.parseInt(ver4c1), arquivo.nextLine());
        }
        
        String ver4c2 = arquivo.nextLine();
        Carta j4c2;
        if(ver4c2.equals("null"))
        {
            j4c2 = null;
        }
        else
        {
            j4c2 = new Carta(Integer.parseInt(ver4c2), arquivo.nextLine());
        }

        Carta[] maoJ4 = new Carta[3];
        maoJ4[0] = j4c0;
        maoJ4[1] = j4c1;
        maoJ4[2] = j4c2;
        
        String verE4 = arquivo.nextLine();
        Carta e4;
        if(verE4.equals("null"))
        {
            e4 = null;
        }
        else
        {
            e4 = new Carta(Integer.parseInt(verE4), arquivo.nextLine());
        }
        
        jogador4 = new Jogador("jogador4", dupla2, maoJ4, e4);
        
        String nomeIniciadorDaRodada = arquivo.nextLine();
        if(nomeIniciadorDaRodada.equals("jogador1"))iniciadorDaRodada = jogador1;
        else if(nomeIniciadorDaRodada.equals("jogador2"))iniciadorDaRodada = jogador2;
        else if(nomeIniciadorDaRodada.equals("jogador3"))iniciadorDaRodada = jogador3;
        else iniciadorDaRodada = jogador4;
        
        String nomeProximoJogador = arquivo.nextLine();
        if(nomeProximoJogador.equals("jogador1"))proximoJogador = jogador1;
        else if(nomeProximoJogador.equals("jogador2"))proximoJogador = jogador2;
        else if(nomeProximoJogador.equals("jogador3"))proximoJogador = jogador3;
        else proximoJogador = jogador4;
        
        coringa = new Carta(Integer.parseInt(arquivo.nextLine()), arquivo.nextLine());
        valorDaRodada = Integer.parseInt(arquivo.nextLine());
        levadasDupla1 = Integer.parseInt(arquivo.nextLine());
        levadasDupla2 = Integer.parseInt(arquivo.nextLine());
        
        arquivo.close();
        
        System.out.println("\n---- JOGO RETOMADO ----");
        System.out.println("\nPRÓXIMA RODADA! A carta que virou foi " + coringa + ".\n" +
        "Portanto, o coringa da rodada é " + getManilha() + "!\n");
        System.out.println(toString());
    }
    
    /**
     * Salva o estado atual do jogo em andamento para que ele possa ser retomado no futuro.
     */
    public void salvarJogo()throws FileNotFoundException
    {
        PrintWriter arquivo = new PrintWriter("truco.txt");
        
        arquivo.println(dupla1.getPontos());
        arquivo.println(dupla1.getJaPediu());
        arquivo.println(dupla2.getPontos());
        arquivo.println(dupla2.getJaPediu());
        
        Carta j1c0 = jogador1.getMao()[0];
        if(j1c0!=null)
        {
            arquivo.println(j1c0.getNumero());
            arquivo.println(j1c0.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j1c1 = jogador1.getMao()[1];
        if(j1c1!=null)
        {
            arquivo.println(j1c1.getNumero());
            arquivo.println(j1c1.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j1c2 = jogador1.getMao()[2];
        if(j1c2!=null)
        {
            arquivo.println(j1c2.getNumero());
            arquivo.println(j1c2.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta escolhida1 = jogador1.getCartaEscolhida();
        if(escolhida1!=null)
        {
            arquivo.println(escolhida1.getNumero());
            arquivo.println(escolhida1.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j2c0 = jogador2.getMao()[0];
        if(j2c0!=null)
        {
            arquivo.println(j2c0.getNumero());
            arquivo.println(j2c0.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j2c1 = jogador2.getMao()[1];
        if(j2c1!=null)
        {
            arquivo.println(j2c1.getNumero());
            arquivo.println(j2c1.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j2c2 = jogador2.getMao()[2];
        if(j2c2!=null)
        {
            arquivo.println(j2c2.getNumero());
            arquivo.println(j2c2.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta escolhida2 = jogador2.getCartaEscolhida();
        if(escolhida2!=null)
        {
            arquivo.println(escolhida2.getNumero());
            arquivo.println(escolhida2.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j3c0 = jogador3.getMao()[0];
        if(j3c0!=null)
        {
            arquivo.println(j3c0.getNumero());
            arquivo.println(j3c0.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j3c1 = jogador3.getMao()[1];
        if(j3c1!=null)
        {
            arquivo.println(j3c1.getNumero());
            arquivo.println(j3c1.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j3c2 = jogador3.getMao()[2];
        if(j3c2!=null)
        {
            arquivo.println(j3c2.getNumero());
            arquivo.println(j3c2.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta escolhida3 = jogador3.getCartaEscolhida();
        if(escolhida3!=null)
        {
            arquivo.println(escolhida3.getNumero());
            arquivo.println(escolhida3.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j4c0 = jogador4.getMao()[0];
        if(j4c0!=null)
        {
            arquivo.println(j4c0.getNumero());
            arquivo.println(j4c0.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j4c1 = jogador4.getMao()[1];
        if(j4c1!=null)
        {
            arquivo.println(j4c1.getNumero());
            arquivo.println(j4c1.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta j4c2 = jogador4.getMao()[2];
        if(j4c2!=null)
        {
            arquivo.println(j4c2.getNumero());
            arquivo.println(j4c2.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        Carta escolhida4 = jogador4.getCartaEscolhida();
        if(escolhida4!=null)
        {
            arquivo.println(escolhida4.getNumero());
            arquivo.println(escolhida4.getNaipe());
        }
        else
        {
            arquivo.println("null");
        }
        
        arquivo.println(iniciadorDaRodada.getNome());
        arquivo.println(proximoJogador.getNome());
        arquivo.println(coringa.getNumero());
        arquivo.println(coringa.getNaipe());
        arquivo.println(valorDaRodada);
        arquivo.println(levadasDupla1);
        arquivo.println(levadasDupla2);

        arquivo.close();
    }
    
    /**
     * Começa a próxima rodada após a rodada anterior ter terminado. Embaralha
     * as cartas, distribui-as para os jogadores, define o novo coringa,
     * restabelece o valor inicial da rodada (1), restaura a possibilidade
     * de pedido de truco para ambas as duplas, determina iniciador da rodada,
     * isto é, o próximo jogador da ordem em sequência, zera as comparações
     * vitoriosas de cada dupla e esquece a última carta jogada por cada
     * jogador, dando espaço a uma nova.
     */
    public void proximaRodada()
    {
        baralho.embaralha();
        baralho.distribui(jogador1,jogador2,jogador3,jogador4);
        coringa = baralho.getBaralho()[12];
        valorDaRodada = 1;
        dupla1.setJaPediu(false);
        dupla2.setJaPediu(false);
        if(iniciadorDaRodada==jogador1)iniciadorDaRodada = jogador2;
        else if(iniciadorDaRodada==jogador2)iniciadorDaRodada = jogador3;
        else if(iniciadorDaRodada==jogador3)iniciadorDaRodada = jogador4;
        else iniciadorDaRodada = jogador1;
        proximoJogador = iniciadorDaRodada;
        levadasDupla1 = 0;
        levadasDupla2 = 0;
        jogador1.setCartaEscolhida(null);
        jogador2.setCartaEscolhida(null);
        jogador3.setCartaEscolhida(null);
        jogador4.setCartaEscolhida(null);
        
        if(dupla1.getPontos()<12 && dupla2.getPontos()<12)
        {
            System.out.println("\nPRÓXIMA RODADA! A carta que virou foi " + coringa + ".\n" +
            "Portanto, o coringa da rodada é " + getManilha() + "!\n");
        }
        System.out.println(toString());
    }
    
    /**
     * Analisa a carta da rodada que foi virada e estabelece a próxima
     * na sequência como manilha (ou coringa), devolvendo-a.
     * @return devolve o coringa da rodada.
     */
    public int getManilha()
    {
        int manilha;
        if(coringa.getNumero()>=1 && coringa.getNumero()<=6 || coringa.getNumero()==10 || coringa.getNumero()==11)
        {
            manilha = coringa.getNumero()+1;
        }
        else if(coringa.getNumero()==7)manilha = 10;
        else manilha = 1;
        return manilha;
    }
    
    /**
     * Estabelece o próximo da ordem sequencial a jogar na rodada.
     */
    public void proximoDaRodada()
    {
        if(proximoJogador==jogador1)proximoJogador = jogador2;
        else if(proximoJogador==jogador2)proximoJogador = jogador3;
        else if(proximoJogador==jogador3)proximoJogador = jogador4;
        else proximoJogador = jogador1;
    }
    
    /**
     * Procede a próxima jogada do jogador passado por parâmetro, com as opções de jogar uma
     * carta, trucar, salvar e sair do jogo. Em caso de truco, permite que a dupla oponente
     * aceite o truco, aumentando o valor da rodada, rejeite-o, entregando o ponto à dupla
     * adversária, ou, ainda, aumente a aposta, que poderá ser aumentada por cada dupla
     * até chegar ao valor máximo necessário para vencer o jogo: 12. Além disso, o método
     * também devolve verdadeiro caso o jogo continue e falso caso o usuário tenha decidido
     * interrompê-lo.
     * @param j jogador cuja jogada será feita.
     * @return devolve verdadeiro se o jogo continua e falso se o usuário escolheu pará-lo.
     */
    public boolean proximaJogada(Jogador j)throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);
        Carta cartaEscolhida = null;
        boolean cartaJogada = false;
        Dupla essaDupla = j.getDupla();
        Dupla outraDupla;
        if(essaDupla==dupla1)outraDupla = dupla2;
        else outraDupla = dupla1;
        while(!cartaJogada)
        {
            System.out.println("\n---- Vez do " + j.getNome() + " ----\n");
            System.out.println("Coringa: " + getManilha());
            Carta e1 = jogador1.getCartaEscolhida();
            Carta e2 = jogador2.getCartaEscolhida();
            Carta e3 = jogador3.getCartaEscolhida();
            Carta e4 = jogador4.getCartaEscolhida();
            if(e1==null && e2==null && e3==null && e4==null)
            {
                System.out.println("\nNenhuma carta na mesa.");
            }
            else
            {
                System.out.println("\nCartas na mesa:");
                if(e1!=null)System.out.println(e1 + " do " + jogador1.getNome());
                if(e2!=null)System.out.println(e2 + " do " + jogador2.getNome());
                if(e3!=null)System.out.println(e3 + " do " + jogador3.getNome());
                if(e4!=null)System.out.println(e4 + " do " + jogador4.getNome());
            }
            System.out.println("\nCartas na mão:");
            System.out.println(j);
            if(!essaDupla.getJaPediu())
            {
                if(valorDaRodada==1)System.out.println("(T) Truco!");
                else if(valorDaRodada==3)System.out.println("(T) Seis!");
                else if(valorDaRodada==6)System.out.println("(T) Nove!");
                else if(valorDaRodada==9)System.out.println("(T) Doze!");
            }
            System.out.println("(S) Salvar jogo");
            System.out.println("(X) Sair do jogo");
            System.out.print("\nInforme a opção: ");
            String opcao = in.nextLine();
            if(opcao.equals("1") || opcao.equals("2") || opcao.equals("3"))
            {
                int posicao = Integer.parseInt(opcao)-1;
                cartaEscolhida = j.getMao()[posicao];
                if(cartaEscolhida!=null)
                {
                    j.getMao()[posicao] = null;
                    System.out.println("\n" + cartaEscolhida + " foi jogado por " + j.getNome());
                    cartaJogada = true;
                }
                else
                {
                    System.out.println("\nOPÇÃO INVÁLIDA");
                }
            }
            else if(opcao.equalsIgnoreCase("T") && !essaDupla.getJaPediu())
            {
                if(valorDaRodada==1)
                {
                    do
                    {
                        System.out.println("\n---- TRUCO! ----\n");
                        System.out.println("A " + essaDupla.getNome() +
                        " pediu truco. Vocês aceitam? (S/N)");
                        System.out.println("(T) Seis!");
                        System.out.print("\nInforme a opção: ");
                        opcao = in.nextLine();
                        if(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                        && !opcao.equalsIgnoreCase("T"))
                        {
                            System.out.println("\nOPÇÃO INVÁLIDA");
                        }
                    }
                    while(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                    && !opcao.equalsIgnoreCase("T"));
                    if(opcao.equalsIgnoreCase("S"))
                    {
                        System.out.println("Desafio aceito! Agora a rodada vale 3 pontos.");
                        aumentaValorDaRodada();
                        essaDupla.setJaPediu(true);
                    }
                    else if(opcao.equalsIgnoreCase("N"))
                    {
                        System.out.println("Desafio recusado. A " + essaDupla.getNome() +
                        " ganhou 1 ponto!");
                        essaDupla.aumentaPontos(1);
                        cartaJogada = true;
                        proximaRodada();
                    }
                    else
                    {
                        aumentaValorDaRodada();
                        do
                        {
                            System.out.println("\n---- SEIS! ----\n");
                            System.out.println("A " + outraDupla.getNome() +
                            " pediu seis. Vocês aceitam? (S/N)");
                            System.out.println("(T) Nove!");
                            System.out.print("\nInforme a opção: ");
                            opcao = in.nextLine();
                            if(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                            && !opcao.equalsIgnoreCase("T"))
                            {
                                System.out.println("\nOPÇÃO INVÁLIDA");
                            }
                        }
                        while(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                        && !opcao.equalsIgnoreCase("T"));
                        if(opcao.equalsIgnoreCase("S"))
                        {
                            System.out.println("Desafio aceito! Agora a rodada vale 6 pontos.");
                            aumentaValorDaRodada();
                            essaDupla.setJaPediu(false);
                            outraDupla.setJaPediu(true);
                        }
                        else if(opcao.equalsIgnoreCase("N"))
                        {
                            System.out.println("Desafio recusado. A " + outraDupla.getNome() +
                            " ganhou 3 pontos!");
                            outraDupla.aumentaPontos(3);
                            cartaJogada = true;
                            proximaRodada();
                        }
                        else
                        {
                            aumentaValorDaRodada();
                            do
                            {
                                System.out.println("\n---- NOVE! ----\n");
                                System.out.println("A " + essaDupla.getNome() +
                                " pediu nove. Vocês aceitam? (S/N)");
                                System.out.println("(T) Doze!");
                                System.out.print("\nInforme a opção: ");
                                opcao = in.nextLine();
                                if(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                                && !opcao.equalsIgnoreCase("T"))
                                {
                                    System.out.println("\nOPÇÃO INVÁLIDA");
                                }
                            }
                            while(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                            && !opcao.equalsIgnoreCase("T"));
                            if(opcao.equalsIgnoreCase("S"))
                            {
                                System.out.println("Desafio aceito! Agora a rodada vale 9 pontos.");
                                aumentaValorDaRodada();
                                essaDupla.setJaPediu(true);
                                outraDupla.setJaPediu(false);
                            }
                            else if(opcao.equalsIgnoreCase("N"))
                            {
                                System.out.println("Desafio recusado. A " + essaDupla.getNome() +
                                " ganhou 6 pontos!");
                                essaDupla.aumentaPontos(6);
                                cartaJogada = true;
                                proximaRodada();
                            }
                            else
                            {
                                aumentaValorDaRodada();
                                do
                                {
                                    System.out.println("\n---- DOZE! ----\n");
                                    System.out.println("A " + outraDupla.getNome() +
                                    " pediu doze. Vocês aceitam? (S/N)");
                                    System.out.print("\nInforme a opção: ");
                                    opcao = in.nextLine();
                                    if(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N"))
                                    {
                                        System.out.println("\nOPÇÃO INVÁLIDA");
                                    }
                                }
                                while(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N"));
                                if(opcao.equalsIgnoreCase("S"))
                                {
                                    System.out.println("Desafio aceito! Agora a rodada vale 12 pontos.");
                                    aumentaValorDaRodada();
                                }
                                else
                                {
                                    System.out.println("Desafio recusado. A " + outraDupla.getNome() +
                                    " ganhou 9 pontos!");
                                    outraDupla.aumentaPontos(9);
                                    cartaJogada = true;
                                    proximaRodada();
                                }
                            }
                        }
                    }
                }
                else if(valorDaRodada==3)
                {
                    do
                    {
                        System.out.println("\n---- SEIS! ----\n");
                        System.out.println("A " + essaDupla.getNome() +
                        " pediu seis. Vocês aceitam? (S/N)");
                        System.out.println("(T) Nove!");
                        System.out.print("\nInforme a opção: ");
                        opcao = in.nextLine();
                        if(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                        && !opcao.equalsIgnoreCase("T"))
                        {
                            System.out.println("\nOPÇÃO INVÁLIDA");
                        }
                    }
                    while(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                    && !opcao.equalsIgnoreCase("T"));
                    if(opcao.equalsIgnoreCase("S"))
                    {
                        System.out.println("Desafio aceito! Agora a rodada vale 6 pontos.");
                        aumentaValorDaRodada();
                        essaDupla.setJaPediu(true);
                        outraDupla.setJaPediu(false);
                    }
                    else if(opcao.equalsIgnoreCase("N"))
                    {
                        System.out.println("Desafio recusado. A " + essaDupla.getNome() +
                        " ganhou 3 pontos!");
                        essaDupla.aumentaPontos(3);
                        cartaJogada = true;
                        proximaRodada();
                    }
                    else
                    {
                        aumentaValorDaRodada();
                        do
                        {
                            System.out.println("\n---- NOVE! ----\n");
                            System.out.println("A " + outraDupla.getNome() +
                            " pediu nove. Vocês aceitam? (S/N)");
                            System.out.println("(T) Doze!");
                            System.out.print("\nInforme a opção: ");
                            opcao = in.nextLine();
                            if(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                            && !opcao.equalsIgnoreCase("T"))
                            {
                                System.out.println("\nOPÇÃO INVÁLIDA");
                            }
                        }
                        while(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                        && !opcao.equalsIgnoreCase("T"));
                        if(opcao.equalsIgnoreCase("S"))
                        {
                            System.out.println("Desafio aceito! Agora a rodada vale 9 pontos.");
                            aumentaValorDaRodada();
                            essaDupla.setJaPediu(false);
                            outraDupla.setJaPediu(true);
                        }
                        else if(opcao.equalsIgnoreCase("N"))
                        {
                            System.out.println("Desafio recusado. A " + outraDupla.getNome() +
                            " ganhou 6 pontos!");
                            outraDupla.aumentaPontos(6);
                            cartaJogada = true;
                            proximaRodada();
                        }
                        else
                        {
                            aumentaValorDaRodada();
                            do
                            {
                                System.out.println("\n---- DOZE! ----\n");
                                System.out.println("A " + essaDupla.getNome() +
                                " pediu doze. Vocês aceitam? (S/N)");
                                System.out.print("\nInforme a opção: ");
                                opcao = in.nextLine();
                                if(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N"))
                                {
                                    System.out.println("\nOPÇÃO INVÁLIDA");
                                }
                            }
                            while(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N"));
                            if(opcao.equalsIgnoreCase("S"))
                            {
                                System.out.println("Desafio aceito! Agora a rodada vale 12 pontos.");
                                aumentaValorDaRodada();
                            }
                            else
                            {
                                System.out.println("Desafio recusado. A " + essaDupla.getNome() +
                                " ganhou 9 pontos!");
                                essaDupla.aumentaPontos(9);
                                cartaJogada = true;
                                proximaRodada();
                            }
                        }                  
                    }
                }
                else if(valorDaRodada==6)
                {
                    do
                    {
                        System.out.println("\n---- NOVE! ----\n");
                        System.out.println("A " + essaDupla.getNome() +
                        " pediu nove. Vocês aceitam? (S/N)");
                        System.out.println("(T) Doze!");
                        System.out.print("\nInforme a opção: ");
                        opcao = in.nextLine();
                        if(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                        && !opcao.equalsIgnoreCase("T"))
                        {
                            System.out.println("\nOPÇÃO INVÁLIDA");
                        }
                    }
                    while(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N")
                    && !opcao.equalsIgnoreCase("T"));
                    if(opcao.equalsIgnoreCase("S"))
                    {
                        System.out.println("Desafio aceito! Agora a rodada vale 9 pontos.");
                        aumentaValorDaRodada();
                        essaDupla.setJaPediu(true);
                        outraDupla.setJaPediu(false);
                    }
                    else if(opcao.equalsIgnoreCase("N"))
                    {
                        System.out.println("Desafio recusado. A " + essaDupla.getNome() +
                        " ganhou 6 pontos!");
                        essaDupla.aumentaPontos(6);
                        cartaJogada = true;
                        proximaRodada();
                    }
                    else
                    {
                        aumentaValorDaRodada();
                        do
                        {
                            System.out.println("\n---- DOZE! ----\n");
                            System.out.println("A " + outraDupla.getNome() +
                            " pediu doze. Vocês aceitam? (S/N)");
                            System.out.print("\nInforme a opção: ");
                            opcao = in.nextLine();
                            if(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N"))
                            {
                                System.out.println("\nOPÇÃO INVÁLIDA");
                            }
                        }
                        while(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N"));
                        if(opcao.equalsIgnoreCase("S"))
                        {
                            System.out.println("Desafio aceito! Agora a rodada vale 12 pontos.");
                            aumentaValorDaRodada();
                        }
                        else
                        {
                            System.out.println("Desafio recusado. A " + outraDupla.getNome() +
                            " ganhou 9 pontos!");
                            outraDupla.aumentaPontos(9);
                            cartaJogada = true;
                            proximaRodada();
                        }
                    }
                }
                else
                {
                    do
                    {
                        System.out.println("\n---- DOZE! ----\n");
                        System.out.println("A " + essaDupla.getNome() +
                        " pediu doze. Vocês aceitam? (S/N)");
                        System.out.print("\nInforme a opção: ");
                        opcao = in.nextLine();
                        if(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N"))
                        {
                            System.out.println("\nOPÇÃO INVÁLIDA");
                        }
                    }
                    while(!opcao.equalsIgnoreCase("S") && !opcao.equalsIgnoreCase("N"));
                    if(opcao.equalsIgnoreCase("S"))
                    {
                        System.out.println("Desafio aceito! Agora a rodada vale 12 pontos.");
                        aumentaValorDaRodada();
                    }
                    else
                    {
                        System.out.println("Desafio recusado. A " + essaDupla.getNome() +
                        " ganhou 9 pontos!");
                        essaDupla.aumentaPontos(9);
                        cartaJogada = true;
                        proximaRodada();
                    }
                }
            }
            else if(opcao.equalsIgnoreCase("S"))
            {
                salvarJogo();
                System.out.println("\nJogo salvo com sucesso!");
            }
            else if(opcao.equalsIgnoreCase("X"))
            {
                System.out.println("\n---- JOGO INTERROMPIDO ----\n");
                return false;
            }
            else System.out.println("\nOPÇÃO INVÁLIDA");
        }
        if(cartaEscolhida!=null)proximoDaRodada();
        j.setCartaEscolhida(cartaEscolhida);
        return true;
    }
    
    /**
     * Aumenta o valor da rodada caso truco tenha sido pedido e aceito.
     */
    public void aumentaValorDaRodada()
    {
        if(valorDaRodada==1)valorDaRodada = 3;
        else if(valorDaRodada==3)valorDaRodada = 6;
        else if(valorDaRodada==6)valorDaRodada = 9;
        else valorDaRodada = 12;
    }
    
    /**
     * Compara os valores das 4 cartas jogadas, uma de cada jogador, e devolve
     * o jogador que venceu a comparação. Em caso de empate entre as duplas, devolve nulo.
     * @return devolve o jogador com a carta de maior valor — ou nulo, em caso de
     * empate entre as duplas.
     */
    public Jogador comparaValor()
    {
        Carta c1 = jogador1.getCartaEscolhida();
        int valor1 = c1.getValor();
        String naipe1 = c1.getNaipe();
        
        Carta c2 = jogador2.getCartaEscolhida();
        int valor2 = c2.getValor();
        String naipe2 = c2.getNaipe();
        
        Carta c3 = jogador3.getCartaEscolhida();
        int valor3 = c3.getValor();
        String naipe3 = c3.getNaipe();
        
        Carta c4 = jogador4.getCartaEscolhida();
        int valor4 = c4.getValor();
        String naipe4 = c4.getNaipe();
        
        int valorMax;
        if(coringa.getValor()==9)valorMax = 0;
        else valorMax = coringa.getValor()+1;
        
        if(valor1==valorMax && naipe1.equals("paus"))return jogador1;
        if(valor2==valorMax && naipe2.equals("paus"))return jogador2;
        if(valor3==valorMax && naipe3.equals("paus"))return jogador3;
        if(valor4==valorMax && naipe4.equals("paus"))return jogador4;
        if(valor1==valorMax && naipe1.equals("copas"))return jogador1;
        if(valor2==valorMax && naipe2.equals("copas"))return jogador2;
        if(valor3==valorMax && naipe3.equals("copas"))return jogador3;
        if(valor4==valorMax && naipe4.equals("copas"))return jogador4;
        if(valor1==valorMax && naipe1.equals("espadas"))return jogador1;
        if(valor2==valorMax && naipe2.equals("espadas"))return jogador2;
        if(valor3==valorMax && naipe3.equals("espadas"))return jogador3;
        if(valor4==valorMax && naipe4.equals("espadas"))return jogador4;
        if(valor1==valorMax && naipe1.equals("ouros"))return jogador1;
        if(valor2==valorMax && naipe2.equals("ouros"))return jogador2;
        if(valor3==valorMax && naipe3.equals("ouros"))return jogador3;
        if(valor4==valorMax && naipe4.equals("ouros"))return jogador4;
        
        int maior1 = valor1;
        if(valor3>maior1)maior1 = valor3;
        int maior2 = valor2;
        if(valor4>maior2)maior2 = valor4;
        
        if(maior1>maior2)
        {
            if(maior1==valor1)return jogador1;
            return jogador3;
        }
        if(maior2>maior1)
        {
            if(maior2==valor2)return jogador2;
            return jogador4;
        }
        
        return null;
    }
    
    /**
     * Estabelece qual das duas duplas levou a comparação e, caso uma delas
     * tenha levado comparações o suficiente, atribui à vencedora a pontuação
     * equivalente ao valor da rodada e passa para a próxima rodada. Caso as
     * três comparações tenham sido feitas e as duplas tenham empatados as três,
     * passa para a próxima rodada e ninguém pontua. Também esquece a última carta
     * jogada por cada jogador, dando lugar à próxima que será escolhida.
     */
    public void levada()
    {
        Jogador vencedor = comparaValor();
        
        if(vencedor==null)
        {
            levadasDupla1++;
            levadasDupla2++;
            System.out.println("\nEmpate! Ninguém levou.");
        }
        else if(vencedor==jogador1)
        {
            proximoJogador = jogador1;
            levadasDupla1++;
            System.out.println("\nA " + dupla1.getNome() + " levou!");
        }
        else if(vencedor==jogador2)
        {
            proximoJogador = jogador2;
            levadasDupla2++;
            System.out.println("\nA " + dupla2.getNome() + " levou!");
        }
        else if(vencedor==jogador3)
        {
            proximoJogador = jogador3;
            levadasDupla1++;
            System.out.println("\nA " + dupla1.getNome() + " levou!");
        }
        else
        {
            proximoJogador = jogador4;
            levadasDupla2++;
            System.out.println("\nA " + dupla2.getNome() + " levou!");
        }
        
        jogador1.setCartaEscolhida(null);
        jogador2.setCartaEscolhida(null);
        jogador3.setCartaEscolhida(null);
        jogador4.setCartaEscolhida(null);
        
        if(levadasDupla1==2 && levadasDupla2<2 || levadasDupla1==3 && levadasDupla2<3)
        {
            dupla1.aumentaPontos(valorDaRodada);
            System.out.println("\nA " + dupla1.getNome() + " venceu a rodada e ganhou " + valorDaRodada + " ponto(s)!");
            proximaRodada();
        }
        else if(levadasDupla1<2 && levadasDupla2==2 || levadasDupla1<3 && levadasDupla2==3)
        {
            dupla2.aumentaPontos(valorDaRodada);
            System.out.println("\nA " + dupla2.getNome() + " venceu a rodada e ganhou " + valorDaRodada + " ponto(s)!");
            proximaRodada();
        }
        else if(levadasDupla1==3 && levadasDupla2==3)
        {
            System.out.println("\nA rodada empatou e ninguém pontuou.");
            proximaRodada();
        }
        else if(jogador1.getMao()[0]==null && jogador1.getMao()[1]==null && jogador1.getMao()[2]==null
        && levadasDupla1==2 && levadasDupla2==2)
        {
            System.out.println("\nA rodada empatou e ninguém pontuou.");
            proximaRodada();
        }
    }
    
    /**
     * Devolve o próximo jogador cuja jogada será feita.
     */
    public Jogador getProximoJogador()
    {
        return proximoJogador;
    }
    
    /**
     * Devolve a primeira dupla.
     */
    public Dupla getDupla1()
    {
        return dupla1;
    }
    
    /**
     * Devolve a segunda dupla.
     */
    public Dupla getDupla2()
    {
        return dupla2;
    }
    
    /**
     * Devolve o primeiro jogador.
     */
    public Jogador getJogador1()
    {
        return jogador1;
    }
    
    /**
     * Devolve o segundo jogador.
     */
    public Jogador getJogador2()
    {
        return jogador2;
    }
    
    /**
     * Devolve o terceiro jogador.
     */
    public Jogador getJogador3()
    {
        return jogador3;
    }
    
    /**
     * Devolve o quarto jogador.
     */
    public Jogador getJogador4()
    {
        return jogador4;
    }
    
    /**
     * Devolve o valor da rodada.
     */
    public int getValorDaRodada()
    {
        return valorDaRodada;
    }
    
    /**
     * Devolve o iniciador da rodada.
     */
    public Jogador getIniciadorDaRodada()
    {
        return iniciadorDaRodada;
    }
    
    /**
     * Exibe o nome de cada dupla seguido das respectivas pontuações.
     */
    public String toString()
    {
        return dupla1 + "\n" + dupla2;
    }
}