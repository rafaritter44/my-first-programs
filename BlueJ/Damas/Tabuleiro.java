import java.util.Random;
public class Tabuleiro
{
    private Peca[][] tabuleiro;
    private char proximo;
    public Tabuleiro()
    {
        proximo = 'o';
        tabuleiro = new Peca[8][8];
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                tabuleiro[i][j] = new Peca('.');
            }
        }
        for(int i=0; i<3; i++)
        {
            for(int j=1; j<8; j+=2)
            {
                if(j==1 && i==1) j = 0;
                tabuleiro[i][j].setTipo('x');
            }
        }
        for(int i=5; i<8; i++)
        {
            for(int j=0; j<8; j+=2)
            {
                if(j==0 && i==6) j = 1;
                tabuleiro[i][j].setTipo('o');
            }
        }
    }
    
    public boolean verificaVitoria()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                if(Character.toLowerCase(tabuleiro[i][j].getTipo())==proximo)
                {
                    if(pecaValida(i,j)) return false;
                }
            }
        }
        return true;
    }
    
    public void jogadaComputador()
    {
        Random gera = new Random();
        int i,j;
        boolean pecaValida, capturaForcada = false;
        do
        {
            pecaValida = true;
            i = gera.nextInt(8);
            j = gera.nextInt(8);
            if(!pecaValida(i,j)) pecaValida = false;
            else if(capturaForcada())
            {
                if(!verificaCaptura(i,j)) pecaValida = false;
                else capturaForcada = true;
            }
        }
        while(!pecaValida);
        
        int i2,j2;
        boolean jogadaFinalizada;
        do
        {
            jogadaFinalizada = true;
            i2 = gera.nextInt(8);
            j2 = gera.nextInt(8);
            if(capturaForcada && Math.abs(i-i2)==1) jogadaFinalizada = false;
            else
            {
                boolean jogadaValida = jogadaValida(i,j,i2,j2);
                if(!jogadaValida) jogadaFinalizada = false;
                else if(verificaCaptura(i2,j2))
                {
                    jogadaFinalizada = false;
                    i = i2;
                    j = j2;
                }
            }
        }
        while(!jogadaFinalizada);
    }
    
    public boolean pecaValida(int i, int j)
    {
        if(i<0 || i>7 || j<0 || j>7) return false;
        
        char c = tabuleiro[i][j].getTipo();
        if(Character.toLowerCase(c)!=proximo) return false;
        
        char lowL = 'n', lowR = 'n', upL = 'n', upR = 'n';
        char lowL2 = 'n', lowR2 = 'n', upL2 = 'n', upR2 = 'n';
        if(i!=0)
        {
            if(j!=0) upL = tabuleiro[i-1][j-1].getTipo();
            if(j!=7) upR = tabuleiro[i-1][j+1].getTipo();
        }
        if(i!=7)
        {
            if(j!=0) lowL = tabuleiro[i+1][j-1].getTipo();
            if(j!=7) lowR = tabuleiro[i+1][j+1].getTipo();
        }
        if(i>1)
        {
            if(j>1) upL2 = tabuleiro[i-2][j-2].getTipo();
            if(j<6) upR2 = tabuleiro[i-2][j+2].getTipo();
        }
        if(i<6)
        {
            if(j>1) lowL2 = tabuleiro[i+2][j-2].getTipo();
            if(j<6) lowR2 = tabuleiro[i+2][j+2].getTipo();
        }

        if(c=='o')
        {
            if(upL=='.') return true;
            if(upR=='.') return true;
            if(Character.toLowerCase(upL)=='x' && upL2=='.') return true;
            if(Character.toLowerCase(upR)=='x' && upR2=='.') return true;
        }
        else if(c=='x')
        {
            if(lowL=='.') return true;
            if(lowR=='.') return true;
            if(Character.toLowerCase(lowL)=='o' && lowL2=='.') return true;
            if(Character.toLowerCase(lowR)=='o' && lowR2=='.') return true;
        }
        else if(c=='O')
        {
            if(upL=='.') return true;
            if(upR=='.') return true;
            if(lowL=='.') return true;
            if(lowR=='.') return true;
            if(Character.toLowerCase(upL)=='x' && upL2=='.') return true;
            if(Character.toLowerCase(upR)=='x' && upR2=='.') return true;
            if(Character.toLowerCase(lowL)=='x' && lowL2=='.') return true;
            if(Character.toLowerCase(lowR)=='x' && lowR2=='.') return true;
        }
        else if(c=='X')
        {
            if(upL=='.') return true;
            if(upR=='.') return true;
            if(lowL=='.') return true;
            if(lowR=='.') return true;
            if(Character.toLowerCase(upL)=='o' && upL2=='.') return true;
            if(Character.toLowerCase(upR)=='o' && upR2=='.') return true;
            if(Character.toLowerCase(lowL)=='o' && lowL2=='.') return true;
            if(Character.toLowerCase(lowR)=='o' && lowR2=='.') return true;
        }
        
        return false;
    }
    
    public boolean jogadaValida(int i, int j, int i2, int j2)
    {
        if(i2<0 || i2>7 || j2<0 || j2>7) return false;
        
        char casa = tabuleiro[i2][j2].getTipo();
        if(casa!='.') return false;
        
        String posicao = null;
        if(i!=0)
        {
            if(j!=0 && i2==i-1 && j2==j-1) posicao = "upL";
            else if(j!=7 && i2==i-1 && j2==j+1) posicao = "upR";
        }
        if(posicao==null && i!=7)
        {
            if(j!=0 && i2==i+1 && j2==j-1) posicao = "lowL";
            if(j!=7 && i2==i+1 && j2==j+1) posicao = "lowR";
        }
        if(posicao==null && i>1)
        {
            if(j>1 && i2==i-2 && j2==j-2) posicao = "upL2";
            if(j<6 && i2==i-2 && j2==j+2) posicao = "upR2";
        }
        if(posicao==null && i<6)
        {
            if(j>1 && i2==i+2 && j2==j-2) posicao = "lowL2";
            if(j<6 && i2==i+2 && j2==j+2) posicao = "lowR2";
        }
        
        if(posicao==null) return false;
        
        char peca = tabuleiro[i][j].getTipo();
        
        if(peca=='o')
        {
            if(posicao.equals("upL") || posicao.equals("upR"))
            {
                tabuleiro[i][j].setTipo('.');
                tabuleiro[i2][j2].setTipo('o');
                if(i2==0) tabuleiro[i2][j2].promocao();
                passaVez();
                return true;
            }
            if(posicao.equals("upL2"))
            {
                if(Character.toLowerCase(tabuleiro[i-1][j-1].getTipo())=='x')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i-1][j-1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('o');
                    if(i2==0)
                    {
                        tabuleiro[i2][j2].promocao();
                        passaVez();
                    }
                    else if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            if(posicao.equals("upR2"))
            {
                if(Character.toLowerCase(tabuleiro[i-1][j+1].getTipo())=='x')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i-1][j+1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('o');
                    if(i2==0)
                    {
                        tabuleiro[i2][j2].promocao();
                        passaVez();
                    }
                    else if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            return false;
        }
        
        if(peca=='x')
        {
            if(posicao.equals("lowL") || posicao.equals("lowR"))
            {
                tabuleiro[i][j].setTipo('.');
                tabuleiro[i2][j2].setTipo('x');
                if(i2==7) tabuleiro[i2][j2].promocao();
                passaVez();
                return true;
            }
            if(posicao.equals("lowL2"))
            {
                if(Character.toLowerCase(tabuleiro[i+1][j-1].getTipo())=='o')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i+1][j-1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('x');
                    if(i2==7)
                    {
                        tabuleiro[i2][j2].promocao();
                        passaVez();
                    }
                    else if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            if(posicao.equals("lowR2"))
            {
                if(Character.toLowerCase(tabuleiro[i+1][j+1].getTipo())=='o')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i+1][j+1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('x');
                    if(i2==7)
                    {
                        tabuleiro[i2][j2].promocao();
                        passaVez();
                    }
                    else if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            return false;
        }
        
        if(peca=='O')
        {
            if(posicao.equals("upL") || posicao.equals("upR")
            || posicao.equals("lowL") || posicao.equals("lowR"))
            {
                tabuleiro[i][j].setTipo('.');
                tabuleiro[i2][j2].setTipo('O');
                passaVez();
                return true;
            }
            if(posicao.equals("upL2"))
            {
                if(Character.toLowerCase(tabuleiro[i-1][j-1].getTipo())=='x')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i-1][j-1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('O');
                    if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            if(posicao.equals("upR2"))
            {
                if(Character.toLowerCase(tabuleiro[i-1][j+1].getTipo())=='x')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i-1][j+1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('O');
                    if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            if(posicao.equals("lowL2"))
            {
                if(Character.toLowerCase(tabuleiro[i+1][j-1].getTipo())=='x')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i+1][j-1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('O');
                    if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            if(posicao.equals("lowR2"))
            {
                if(Character.toLowerCase(tabuleiro[i+1][j+1].getTipo())=='x')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i+1][j+1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('O');
                    if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            return false;
        }
        
        if(peca=='X')
        {
            if(posicao.equals("upL") || posicao.equals("upR")
            || posicao.equals("lowL") || posicao.equals("lowR"))
            {
                tabuleiro[i][j].setTipo('.');
                tabuleiro[i2][j2].setTipo('X');
                passaVez();
                return true;
            }
            if(posicao.equals("upL2"))
            {
                if(Character.toLowerCase(tabuleiro[i-1][j-1].getTipo())=='o')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i-1][j-1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('X');
                    if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            if(posicao.equals("upR2"))
            {
                if(Character.toLowerCase(tabuleiro[i-1][j+1].getTipo())=='o')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i-1][j+1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('X');
                    if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            if(posicao.equals("lowL2"))
            {
                if(Character.toLowerCase(tabuleiro[i+1][j-1].getTipo())=='o')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i+1][j-1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('X');
                    if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
            if(posicao.equals("lowR2"))
            {
                if(Character.toLowerCase(tabuleiro[i+1][j+1].getTipo())=='o')
                {
                    tabuleiro[i][j].setTipo('.');
                    tabuleiro[i+1][j+1].setTipo('.');
                    tabuleiro[i2][j2].setTipo('X');
                    if(!verificaCaptura(i2,j2)) passaVez();
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean verificaCaptura(int i, int j)
    {
        if(i<0 || i>7 || j<0 || j>7) return false;

        char c = tabuleiro[i][j].getTipo();
        if(Character.toLowerCase(c)!=proximo) return false;
        
        char lowL = 'n', lowR = 'n', upL = 'n', upR = 'n';
        char lowL2 = 'n', lowR2 = 'n', upL2 = 'n', upR2 = 'n';
        if(i!=0)
        {
            if(j!=0) upL = tabuleiro[i-1][j-1].getTipo();
            if(j!=7) upR = tabuleiro[i-1][j+1].getTipo();
        }
        if(i!=7)
        {
            if(j!=0) lowL = tabuleiro[i+1][j-1].getTipo();
            if(j!=7) lowR = tabuleiro[i+1][j+1].getTipo();
        }
        if(i>1)
        {
            if(j>1) upL2 = tabuleiro[i-2][j-2].getTipo();
            if(j<6) upR2 = tabuleiro[i-2][j+2].getTipo();
        }
        if(i<6)
        {
            if(j>1) lowL2 = tabuleiro[i+2][j-2].getTipo();
            if(j<6) lowR2 = tabuleiro[i+2][j+2].getTipo();
        }

        if(c=='o')
        {
            if(Character.toLowerCase(upL)=='x' && upL2=='.') return true;
            if(Character.toLowerCase(upR)=='x' && upR2=='.') return true;
        }
        else if(c=='x')
        {
            if(Character.toLowerCase(lowL)=='o' && lowL2=='.') return true;
            if(Character.toLowerCase(lowR)=='o' && lowR2=='.') return true;
        }
        else if(c=='O')
        {
            if(Character.toLowerCase(upL)=='x' && upL2=='.') return true;
            if(Character.toLowerCase(upR)=='x' && upR2=='.') return true;
            if(Character.toLowerCase(lowL)=='x' && lowL2=='.') return true;
            if(Character.toLowerCase(lowR)=='x' && lowR2=='.') return true;
        }
        else if(c=='X')
        {
            if(Character.toLowerCase(upL)=='o' && upL2=='.') return true;
            if(Character.toLowerCase(upR)=='o' && upR2=='.') return true;
            if(Character.toLowerCase(lowL)=='o' && lowL2=='.') return true;
            if(Character.toLowerCase(lowR)=='o' && lowR2=='.') return true;
        }
        
        return false;
    }
    
    public boolean capturaForcada()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                if(Character.toLowerCase(tabuleiro[i][j].getTipo())==proximo)
                {
                    if(verificaCaptura(i,j)) return true;
                }
            }
        }
        return false;
    }
    
    public void passaVez()
    {
        if(proximo=='o') proximo = 'x';
        else proximo = 'o';
    }
    
    public char getProximo()
    {
        return proximo;
    }
    
    public String toString()
    {
        String msg = "  A B C D E F G H\n";
        for(int i=0; i<8; i++)
        {
            msg += (i+1) + " ";
            for(int j=0; j<8; j++)
            {
                msg += tabuleiro[i][j] + " ";
            }
            msg += "\n";
        }
        return msg;
    }
}