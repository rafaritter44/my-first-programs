public class Exercicios
{
    public static void main(String args[]){
        
        
        OperacoesComMatriz matrizA = new OperacoesComMatriz(6,6);
        matrizA.preenche();
        System.out.println("\f"+matrizA);
        
        //34 - lista V
        System.out.println("Soma dos elementos: " + matrizA.soma());
        //35 - lista V
        System.out.println("Soma das diagonais: " + matrizA.somaDiagonais());
        //42 - lista V
        matrizA.trocaLinha(2,4);
        System.out.println("Matriz após troca da linha 2 com a 4:\n"+ matrizA);
        matrizA.trocaColuna(1,3);
        System.out.println("Matriz após troca da coluna 1 com a 3:\n"+ matrizA);
        matrizA.trocaDiagonal();
        System.out.println("Matriz após troca de diagonais:\n"+ matrizA);
        //46 - lista V
        System.out.println("Elemento minimax: " + matrizA.valorMinimax());
        System.out.println("Posição minimax: (" + matrizA.linhaDoMaior() + ";" + matrizA.colunaMinimax()
        + ")");
        //48 - lista V
        OperacoesComMatriz matrizB = new OperacoesComMatriz(4,4);
        OperacoesComMatriz matrizC = new OperacoesComMatriz(5,5);
        matrizB.preenche();
        matrizC.preenche();
        
        System.out.println("\f"+matrizB);
        
        System.out.println("Média aritmética dos elementos abaixo da diagonal principal: " +
        matrizB.mediaAbaixoDP());
        System.out.println("Soma dos elementos acima da diagonal principal: " +
        matrizB.somaAcimaDP());
        System.out.println("Menor dos elementos abaixo da diagonal secundária: " +
        matrizB.menorAbaixoDS());
        System.out.println("Maior dos elementos acima da diagonal secundária: " +
        matrizB.maiorAcimaDS());
        System.out.println("Média dos elementos abaixo da diagonal principal e da secundária: " +
        matrizB.mediaAbaixoDPS());
        System.out.println("Produto dos elementos acima da diagonal principal e da secundária: " +
        matrizB.produtoAcimaDPS());
        
        System.out.println("\n" + matrizC);
        
        System.out.println("Média aritmética dos elementos abaixo da diagonal principal: " +
        matrizC.mediaAbaixoDP());
        System.out.println("Soma dos elementos acima da diagonal principal: " +
        matrizC.somaAcimaDP());
        System.out.println("Menor dos elementos abaixo da diagonal secundária: " +
        matrizC.menorAbaixoDS());
        System.out.println("Maior dos elementos acima da diagonal secundária: " +
        matrizC.maiorAcimaDS());
        System.out.println("Média dos elementos abaixo da diagonal principal e da secundária: " +
        matrizC.mediaAbaixoDPS());
        System.out.println("Produto dos elementos acima da diagonal principal e da secundária: " +
        matrizC.produtoAcimaDPS());
    }
}