import java.util.Scanner;
public class Exercicio16
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int[] vetor = new int[30];
        System.out.println("\fValores do vetor:");
        leitura(vetor);
        String comando;
        int valor;
        do
        {
            System.out.println("MENU PRINCIPAL — Escolha um comando\n(a) – Remove um elemento do vetor" +
            "\n(b) – Insere um elemento no vetor\n(c) – Substitui um elemento do vetor" +
            "\n(d) – Procura a posição de algum elemento\n(x) – Termina o programa");
            comando = in.next();
            switch(comando)
            {
                case "a":
                do
                {
                    System.out.print("Por favor, informe um valor inteiro e positivo: ");
                    valor = in.nextInt();
                }
                while(valor<=0);
                remocao(vetor, valor); break;
                case "b": insercao(vetor); break;
                case "c": substituicao(vetor); break;
                case "d": pesquisa(vetor); break;
                case "x": System.out.println("Fim de programa."); break;
                default: System.out.println("ERRO: comando inválido.");
            }
        }
        while(!comando.equals("x"));
    }
    public static void leitura(int[] vetor)
    {
        Scanner in = new Scanner(System.in);
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.print("Informe o valor, inteiro e positivo, da posição " + pos + ": ");
            vetor[pos] = in.nextInt();
            if(vetor[pos]<=0)
            {
                System.out.println("ERRO: valor inválido.");
                pos--;
            }
        }
    }
    public static void remocao(int[] vet, int num)
    {
        boolean valorRemovido = false;
        for(int pos = 0; pos<vet.length && !valorRemovido; pos++)
        {
            if(vet[pos]==num)
            {
                for(int i = pos + 1; i<vet.length; i++)
                {
                    vet[i-1] = vet[i];
                }
                vet[vet.length-1] = -1;
                valorRemovido = true;
            }
        }
        if(!valorRemovido)System.out.println("Valor inexistente no vetor.");
        else
        {
            System.out.println("Elemento removido com sucesso!");
            escrita(vet);
        }
    }
    public static void insercao(int[] vet)
    {
        Scanner in = new Scanner(System.in);
        int n;
        do
        {
            System.out.print("Por favor, informe um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        while(n<=0);
        boolean valorInserido = false;
        for(int pos = 0; pos<vet.length && !valorInserido; pos++)
        {
            if(vet[pos]==-1)
            {
                vet[pos] = n;
                valorInserido = true;
            }
        }
        if(!valorInserido)System.out.println("Nenhuma posição livre.");
        else
        {
            System.out.println("Elemento inserido com sucesso!");
            escrita(vet);
        }
    }
    public static void substituicao(int[] vet)
    {
        Scanner in = new Scanner(System.in);
        int n, p;
        do
        {
            System.out.print("Por favor, informe um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        while(n<=0);
        do
        {
            System.out.print("Agora informe alguma posição do vetor [0,29]: ");
            p = in.nextInt();
        }
        while(p<0 || p>29);
        if(vet[p]==n)System.out.println("O valor " + n + " já ocupa a posição " + p + ".");
        else
        {
            vet[p] = n;
            System.out.println("Elemento substituído com sucesso!");
            escrita(vet);
        }
    }
    public static void pesquisa(int[] vet)
    {
        Scanner in = new Scanner(System.in);
        int n;
        boolean valorEncontrado = false;
        do
        {
            System.out.print("Por favor, informe um valor inteiro e positivo: ");
            n = in.nextInt();
        }
        while(n<=0);
        for(int pos = 0; pos<vet.length; pos++)
        {
            if(vet[pos]==n)
            {
                System.out.println("O número " + n + " está na posição " + pos + ".");
                valorEncontrado = true;
            }
        }
        if(!valorEncontrado)System.out.println("Valor inexistente no vetor.");
    }
    public static void escrita(int[] vetor)
    {
        System.out.println("Vetor:");
        for(int pos = 0; pos<vetor.length; pos++)
        {
            System.out.println("Posição " + pos + ": " + vetor[pos]);
        }
    }
}