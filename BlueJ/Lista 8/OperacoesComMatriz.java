import java.util.Random;
public class OperacoesComMatriz
{
    private int [][]matriz;
    
    public OperacoesComMatriz(int dLin, int dCol){
        if(dLin<2) dLin = 2;
        if(dCol<2) dCol = 2;
        matriz = new int [dLin][dCol];
    }
    
    public void preenche(){
        Random gera = new Random();
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                matriz[i][j] = gera.nextInt(10);
            }
        }
    }
    public int soma(){
        int s = 0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                s = s + matriz[i][j];
            }
        }
        return s;
    }
    public int somaDiagonais()
    {
        int s = 0;
        for(int i=0; i<matriz.length; i++)
        {
            s += matriz[i][i] + matriz[i][matriz.length-1-i];
        }
        return s;
    }
    public void trocaLinha(int linhaA, int linhaB)
    {
        if(linhaA<0 || linhaA>=matriz.length) return;
        if(linhaB<0 || linhaB>=matriz.length) return;
        int aux;
        for(int j=0; j<matriz[0].length; j++)
        {
            aux = matriz[linhaA][j];
            matriz[linhaA][j] = matriz[linhaB][j];
            matriz[linhaB][j] = aux;
        }
    }
    public void trocaColuna(int colunaA, int colunaB)
    {
        if(colunaA<0 || colunaA>=matriz[0].length) return;
        if(colunaB<0 || colunaB>=matriz[0].length) return;
        int aux;
        for(int i=0; i<matriz[0].length; i++)
        {
            aux = matriz[i][colunaA];
            matriz[i][colunaA] = matriz[i][colunaB];
            matriz[i][colunaB] = aux;
        }
    }
    public void trocaDiagonal()
    {
        if(matriz.length!=matriz[0].length)return;
        int aux;
        for(int i=0; i<matriz.length; i++)
        {
            aux = matriz[i][i];
            matriz[i][i] = matriz[i][matriz.length-1-i];
            matriz[i][matriz.length-1-i] = aux;
        }
    }
    public int linhaDoMaior()
    {
        int maior = Integer.MIN_VALUE;
        int ret = 0;
        for(int i=0; i<matriz.length; i++)
        {
            for(int j=0; j<matriz[i].length; j++)
            {
                if(matriz[i][j]>maior)
                {
                    maior = matriz[i][j];
                    ret = i;
                }
            }
        }
        return ret;
    }
    public int valorMinimax()
    {
        int linha = linhaDoMaior();
        int menor = Integer.MAX_VALUE;
        for(int i=0; i<matriz[linha].length; i++)
        {
            if(matriz[linha][i]<menor) menor = matriz[linha][i];
        }
        return menor;
    }
    public int colunaMinimax()
    {
        int linha = linhaDoMaior();
        int menor = valorMinimax();
        for(int i=0; i<matriz[linha].length; i++)
        {
            if(matriz[linha][i]==menor)return i;
        }
        return -1;
    }
    public double mediaAbaixoDP()
    {
        int s = 0;
        double cont = 0;
        for(int i=1; i<matriz.length; i++)
        {
            for(int j=0; j<i; j++)
            {
                s += matriz[i][j];
                cont++;
            }
        }
        return s/cont;
    }
    public int somaAcimaDP()
    {
        int s = 0;
        for(int i=0; i<matriz.length; i++)
        {
            for(int j=i+1; j<matriz[i].length; j++)
            {
                s += matriz[i][j];
            }
        }
        return s;
    }
    public int menorAbaixoDS()
    {
        int m = Integer.MAX_VALUE;
        for(int i=1; i<matriz.length; i++)
        {
            for(int j=matriz.length-i; j<matriz[i].length; j++)
            {
                if(matriz[i][j] < m) m = matriz[i][j];
            }
        }
        return m;
    }
    public int maiorAcimaDS()
    {
        int m = Integer.MIN_VALUE;
        for(int i=0; i<matriz.length-1; i++)
        {
            for(int j=0; j<matriz[i].length-i-1; j++)
            {
                if(matriz[i][j]>m) m = matriz[i][j];
            }
        }
        return m;
    }
    public double mediaAbaixoDPS()
    {
        int s = 0;
        double cont = 0;
        for(int i=matriz.length/2+1; i<matriz.length; i++)
        {
            for(int j=matriz[i].length-i; j<i; j++)
            {
                s += matriz[i][j];
                cont++;
            }
        }
        return s/cont;
    }
    public int produtoAcimaDPS()
    {
        int p = 1;
        for(int i=0; i<Math.ceil(matriz.length/2.0)-1; i++)
        {
            for(int j=i+1; j<matriz[i].length-i-1; j++)
            {
                p *= matriz[i][j];
            }
        }
        return p;
    }
    public String toString(){
        String msg = "  ";
        for(int lin=0; lin<matriz.length; lin++){ msg = msg + lin + " ";}
        msg = msg + "\n";
        for(int lin=0; lin<matriz.length; lin++){
            msg = msg + lin + " ";
            for(int col=0; col<matriz[lin].length; col++){
                msg = msg + matriz[lin][col] + " ";
            }
            msg = msg + "\n";
        }
        return msg;
    }
}