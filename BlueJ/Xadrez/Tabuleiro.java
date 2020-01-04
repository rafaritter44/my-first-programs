public class Tabuleiro
{
    private Peca[][] tabuleiro;
    private String vez;
    public Tabuleiro()
    {
        vez = "branca";
        tabuleiro = new Peca[8][8];
        for(int i=0; i<8; i++)
        {
            tabuleiro[1][i] = new Peao("preta", '♟', 1, i);
            tabuleiro[6][i] = new Peao("branca", '♙', 1, i);
        }
        tabuleiro[0][0] = new Torre("preta", '♜', 0, 0);
        tabuleiro[0][7] = new Torre("preta", '♜', 0, 7);
        tabuleiro[0][1] = new Cavalo("preta", '♞', 0, 1);
        tabuleiro[0][6] = new Cavalo("preta", '♞', 0, 6);
        tabuleiro[0][2] = new Bispo("preta", '♝', 0, 2);
        tabuleiro[0][5] = new Bispo("preta", '♝', 0, 5);
        tabuleiro[0][3] = new Rainha("preta", '♛', 0, 3);
        tabuleiro[0][4] = new Rei("preta", '♚', 0, 4);
        tabuleiro[7][0] = new Torre("branca", '♖', 7, 0);
        tabuleiro[7][7] = new Torre("branca", '♖', 7, 7);
        tabuleiro[7][1] = new Cavalo("branca", '♘', 7, 1);
        tabuleiro[7][6] = new Cavalo("branca", '♘', 7, 6);
        tabuleiro[7][2] = new Bispo("branca", '♗', 7, 2);
        tabuleiro[7][5] = new Bispo("branca", '♗', 7, 5);
        tabuleiro[7][3] = new Rainha("branca", '♕', 7, 3);
        tabuleiro[7][4] = new Rei("branca", '♔', 7, 4);
    }
    public boolean xequeMate()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                for(int i2=0; i2<8; i2++)
                {
                    for(int j2=0; j2<8; j2++)
                    {
                        if(jogadaValida(i,j,i2,j2)) return false;
                    }
                }
            }
        }
        if(reiAtacado()) return true;
        return false;
    }
    public boolean empate()
    {
        int cont = 0;
        boolean pecaMenor = false;
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                if(tabuleiro[i][j]!=null)
                {
                    cont++;
                    if(tabuleiro[i][j].getFigura()=='♗' || tabuleiro[i][j].getFigura()=='♘'
                    || tabuleiro[i][j].getFigura()=='♝' || tabuleiro[i][j].getFigura()=='♞')
                    {
                        pecaMenor = true;
                    }
                }
            }
        }
        if(cont==2) return true;
        if(cont==3 && pecaMenor) return true;
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                for(int i2=0; i2<8; i2++)
                {
                    for(int j2=0; j2<8; j2++)
                    {
                        if(jogadaValida(i,j,i2,j2)) return false;
                    }
                }
            }
        }
        return true;
    }
    public int roques()
    {
        if(reiAtacado()) return 0;
        int ret = 3;
        if(vez.equals("branca"))
        {
            if(tabuleiro[7][4]==null) return 0;
            if(tabuleiro[7][4].getFigura()!='♔') return 0;
            if(tabuleiro[7][4].getJaMoveu()) return 0;
            if(tabuleiro[7][7]==null) ret--;
            else if(tabuleiro[7][7].getFigura()!='♖') ret--;
            else if(tabuleiro[7][7].getJaMoveu()) ret--;
            else if(tabuleiro[7][6]!=null) ret--;
            else if(colocaReiEmXeque(7,4,7,6)) ret--;
            else if(tabuleiro[7][5]!=null) ret--;
            else if(colocaReiEmXeque(7,4,7,5)) ret--;
            if(tabuleiro[7][0]==null) ret-=2;
            else if(tabuleiro[7][0].getFigura()!='♖') ret-=2;
            else if(tabuleiro[7][0].getJaMoveu()) ret-=2;
            else if(tabuleiro[7][1]!=null) ret-=2;
            else if(tabuleiro[7][2]!=null) ret-=2;
            else if(colocaReiEmXeque(7,4,7,2)) ret-=2;
            else if(tabuleiro[7][3]!=null) ret-=2;
            else if(colocaReiEmXeque(7,4,7,3)) ret-=2;
            return ret;
        }
        else
        {
            if(tabuleiro[0][4]==null) return 0;
            if(tabuleiro[0][4].getFigura()!='♚') return 0;
            if(tabuleiro[0][4].getJaMoveu()) return 0;
            if(tabuleiro[0][7]==null) ret--;
            else if(tabuleiro[0][7].getFigura()!='♜') ret--;
            else if(tabuleiro[0][7].getJaMoveu()) ret--;
            else if(tabuleiro[0][6]!=null) ret--;
            else if(colocaReiEmXeque(0,4,0,6)) ret--;
            else if(tabuleiro[0][5]!=null) ret--;
            else if(colocaReiEmXeque(0,4,0,5)) ret--;
            if(tabuleiro[0][0]==null) ret-=2;
            else if(tabuleiro[0][0].getFigura()!='♜') ret-=2;
            else if(tabuleiro[0][0].getJaMoveu()) ret-=2;
            else if(tabuleiro[0][1]!=null) ret-=2;
            else if(tabuleiro[0][2]!=null) ret-=2;
            else if(colocaReiEmXeque(0,4,0,2)) ret-=2;
            else if(tabuleiro[0][3]!=null) ret-=2;
            else if(colocaReiEmXeque(0,4,0,3)) ret-=2;
        }
        return ret;
    }
    public void roqueMenor()
    {
        if(vez.equals("branca"))
        {
            tabuleiro[7][6] = tabuleiro[7][4];
            tabuleiro[7][5] = tabuleiro[7][7];
            tabuleiro[7][4] = null;
            tabuleiro[7][7] = null;
            tabuleiro[7][6].setJ(6);
            tabuleiro[7][6].jaMoveu();
            tabuleiro[7][5].setJ(5);
            tabuleiro[7][5].jaMoveu();
        }
        else
        {
            tabuleiro[0][6] = tabuleiro[0][4];
            tabuleiro[0][5] = tabuleiro[0][7];
            tabuleiro[0][4] = null;
            tabuleiro[0][7] = null;
            tabuleiro[0][6].setJ(6);
            tabuleiro[0][6].jaMoveu();
            tabuleiro[0][5].setJ(5);
            tabuleiro[0][5].jaMoveu();
        }
        passaVez();
        naoEnPassant();
    }
    public void roqueMaior()
    {
        if(vez.equals("branca"))
        {
            tabuleiro[7][2] = tabuleiro[7][4];
            tabuleiro[7][3] = tabuleiro[7][0];
            tabuleiro[7][4] = null;
            tabuleiro[7][0] = null;
            tabuleiro[7][2].setJ(2);
            tabuleiro[7][2].jaMoveu();
            tabuleiro[7][3].setJ(3);
            tabuleiro[7][3].jaMoveu();
        }
        else
        {
            tabuleiro[0][2] = tabuleiro[0][4];
            tabuleiro[0][3] = tabuleiro[0][0];
            tabuleiro[0][4] = null;
            tabuleiro[0][0] = null;
            tabuleiro[0][2].setJ(2);
            tabuleiro[0][2].jaMoveu();
            tabuleiro[0][3].setJ(3);
            tabuleiro[0][3].jaMoveu();
        }
        passaVez();
        naoEnPassant();
    }
    public boolean pecaValida(int i, int j)
    {
        for(int i2=0; i2<8; i2++)
        {
            for(int j2=0; j2<8; j2++)
            {
                if(jogadaValida(i,j,i2,j2)) return true;
            }
        }
        return false;
    }
    public boolean reiAtacado()
    {
        char rei;
        if(vez.equals("branca")) rei = '♔';
        else rei = '♚';
        
        int i, j=0;
        loop:for(i=0; i<8; i++)
        {
            for(j=0; j<8; j++)
            {
                if(tabuleiro[i][j]!=null && tabuleiro[i][j].getFigura()==rei) break loop;
            }
        }
        
        passaVez();
        
        for(int i2=0; i2<8; i2++)
        {
            for(int j2=0; j2<8; j2++)
            {
                if(capturaValida(i2,j2,i,j))
                {
                    passaVez();
                    return true;
                }
            }
        }
        
        passaVez();
        return false;
    }
    public Peca promocao()
    {
        for(int i=0; i<8; i++)
        {
            if(tabuleiro[0][i]!=null && tabuleiro[0][i].getFigura()=='♙')
            {
                return tabuleiro[0][i];
            }
            if(tabuleiro[7][i]!=null && tabuleiro[7][i].getFigura()=='♟')
            {
                return tabuleiro[7][i];
            }
        }
        return null;
    }
    public void naoEnPassant()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                if(tabuleiro[i][j]!=null)
                {
                    if(tabuleiro[i][j].getFigura()=='♙' || tabuleiro[i][j].getFigura()=='♟')
                    {
                        ((Peao)tabuleiro[i][j]).setEnPassant(false);
                    }
                }
            }
        }
    }
    public void jogada(int i, int j, int i2, int j2)
    {
        char figura = tabuleiro[i][j].getFigura();
        if(figura=='♙' || figura=='♟')
        {
            if(tabuleiro[i2][j2]==null && j!=j2) tabuleiro[i][j2] = null;
        }
        tabuleiro[i2][j2] = tabuleiro[i][j];
        tabuleiro[i][j] = null;
        tabuleiro[i2][j2].setI(i2);
        tabuleiro[i2][j2].setJ(j2);
        tabuleiro[i2][j2].jaMoveu();
        passaVez();
        if(Math.abs(i2-i)==2 && (figura=='♙' || figura=='♟'))
        {
            ((Peao)tabuleiro[i2][j2]).setEnPassant(true);
        }
        else naoEnPassant();
    }
    public boolean jogadaValida(int i, int j, int i2, int j2)
    {
        if(movimentoValido(i,j,i2,j2) || capturaValida(i,j,i2,j2)) return true;
        if(i<0 || i>7 || j<0 || j>7 || i2<0 || i2>7 || j2<0 || j2>7) return false;
        if(tabuleiro[i][j]==null) return false;
        if(tabuleiro[i2][j2]!=null) return false;
        if(tabuleiro[i][j].getFigura()=='♙')
        {
            if(i-i2!=1) return false;
            if(Math.abs(j-j2)!=1) return false;
            if(tabuleiro[i][j2]==null) return false;
            if(tabuleiro[i][j2].getFigura()!='♟') return false;
            if(!((Peao)tabuleiro[i][j2]).getEnPassant()) return false;
            return true;
        }
        if(tabuleiro[i][j].getFigura()=='♟')
        {
            if(i2-i!=1) return false;
            if(Math.abs(j-j2)!=1) return false;
            if(tabuleiro[i][j2]==null) return false;
            if(tabuleiro[i][j2].getFigura()!='♙') return false;
            if(!((Peao)tabuleiro[i][j2]).getEnPassant()) return false;
            return true;
        }
        return false;
    }
    public boolean colocaReiEmXeque(int i, int j, int i2, int j2)
    {
        Peca aux = tabuleiro[i2][j2];
        tabuleiro[i2][j2] = tabuleiro[i][j];
        tabuleiro[i][j] = null;
        
        boolean reiEmXeque = false;
        if(reiAtacado()) reiEmXeque = true;

        tabuleiro[i][j] = tabuleiro[i2][j2];
        tabuleiro[i2][j2] = aux;
        
        return reiEmXeque;
    }
    public boolean movimentoValido(int i, int j, int i2, int j2)
    {
        if(i<0 || i>7 || j<0 || j>7 || i2<0 || i2>7 || j2<0 || j2>7) return false;
        if(tabuleiro[i][j]==null) return false;
        if(!tabuleiro[i][j].getCor().equals(vez)) return false;
        if(tabuleiro[i2][j2]!=null) return false;
        
        char figura = tabuleiro[i][j].getFigura();
        
        if(figura=='♙')
        {
            if(j!=j2) return false;
            if(tabuleiro[i][j].getJaMoveu() && i-i2==2) return false;
            if(i-i2==1) return !colocaReiEmXeque(i,j,i2,j2);
            if(i-i2==2 && tabuleiro[i2+1][j2]==null) return !colocaReiEmXeque(i,j,i2,j2);
            return false;
        }
        
        if(figura=='♟')
        {
            if(j!=j2) return false;
            if(tabuleiro[i][j].getJaMoveu() && i2-i==2) return false;
            if(i2-i==1) return !colocaReiEmXeque(i,j,i2,j2);
            if(i2-i==2 && tabuleiro[i2-1][j2]==null) return !colocaReiEmXeque(i,j,i2,j2);
            return false;
        }
        
        if(figura=='♖' || figura=='♜')
        {
            if(i!=i2 && j!=j2) return false;
            if(i==i2)
            {
                int menor = j;
                if(j2<j) menor = j2;
                int maior = j+j2-menor;
                for(int cont=menor+1; cont<maior; cont++)
                {
                    if(tabuleiro[i][cont]!=null) return false;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            int menor = i;
            if(i2<i) menor = i2;
            int maior = i+i2-menor;
            for(int cont=menor+1; cont<maior; cont++)
            {
                if(tabuleiro[cont][j]!=null) return false;
            }
            return !colocaReiEmXeque(i,j,i2,j2);
        }
        
        if(figura=='♗' || figura=='♝')
        {
            if(i-i2==j-j2)
            {
                if(i<i2)
                {
                    for(int contI = i+1, contJ = j+1; contI<i2; contI++, contJ++)
                    {
                        if(tabuleiro[contI][contJ]!=null) return false;
                    }
                    return !colocaReiEmXeque(i,j,i2,j2);
                }
                for(int contI = i2+1, contJ = j2+1; contI<i; contI++, contJ++)
                {
                    if(tabuleiro[contI][contJ]!=null) return false;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(i+j==i2+j2)
            {
                if(i<i2)
                {
                    for(int contI = i+1, contJ = j-1; contI<i2; contI++, contJ--)
                    {
                        if(tabuleiro[contI][contJ]!=null) return false;
                    }
                    return !colocaReiEmXeque(i,j,i2,j2);
                }
                for(int contI = i2+1, contJ = j2-1; contI<i; contI++, contJ--)
                {
                    if(tabuleiro[contI][contJ]!=null) return false;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            return false;
        }
        
        if(figura=='♘' || figura=='♞')
        {
            if(Math.abs(i2-i)==2 && Math.abs(j2-j)==1) return !colocaReiEmXeque(i,j,i2,j2);
            if(Math.abs(i2-i)==1 && Math.abs(j2-j)==2) return !colocaReiEmXeque(i,j,i2,j2);
            return false;
        }
        
        if(figura=='♕' || figura =='♛')
        {
            if(i==i2)
            {
                int menor = j;
                if(j2<j) menor = j2;
                int maior = j+j2-menor;
                for(int cont=menor+1; cont<maior; cont++)
                {
                    if(tabuleiro[i][cont]!=null) return false;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(j==j2)
            {
                int menor = i;
                if(i2<i) menor = i2;
                int maior = i+i2-menor;
                for(int cont=menor+1; cont<maior; cont++)
                {
                    if(tabuleiro[cont][j]!=null) return false;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(i-i2==j-j2)
            {
                if(i<i2)
                {
                    for(int contI = i+1, contJ = j+1; contI<i2; contI++, contJ++)
                    {
                        if(tabuleiro[contI][contJ]!=null) return false;
                    }
                    return !colocaReiEmXeque(i,j,i2,j2);
                }
                for(int contI = i2+1, contJ = j2+1; contI<i; contI++, contJ++)
                {
                    if(tabuleiro[contI][contJ]!=null) return false;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(i+j==i2+j2)
            {
                if(i<i2)
                {
                    for(int contI = i+1, contJ = j-1; contI<i2; contI++, contJ--)
                    {
                        if(tabuleiro[contI][contJ]!=null) return false;
                    }
                    return !colocaReiEmXeque(i,j,i2,j2);
                }
                for(int contI = i2+1, contJ = j2-1; contI<i; contI++, contJ--)
                {
                    if(tabuleiro[contI][contJ]!=null) return false;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            return false;
        }
        
        if(figura=='♔' || figura=='♚')
        {
            if(Math.abs(i-i2)==1 && j==j2) return !colocaReiEmXeque(i,j,i2,j2);
            if(Math.abs(i-i2)==1 && Math.abs(j-j2)==1) return !colocaReiEmXeque(i,j,i2,j2);
            if(i==i2 && Math.abs(j-j2)==1) return !colocaReiEmXeque(i,j,i2,j2);
        }
        
        return false;
    }
    public boolean capturaValida(int i, int j, int i2, int j2)
    {
        if(i<0 || i>7 || j<0 || j>7 || i2<0 || i2>7 || j2<0 || j2>7) return false;
        if(tabuleiro[i][j]==null) return false;
        if(!tabuleiro[i][j].getCor().equals(vez)) return false;
        if(tabuleiro[i2][j2]==null) return false;
        if(tabuleiro[i2][j2].getCor().equals(vez)) return false;
        
        char figura = tabuleiro[i][j].getFigura();
        
        if(figura=='♙')
        {
            if(i2==i-1 && Math.abs(j-j2)==1)
            {
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            return false;
        }
        
        if(figura=='♟')
        {
            if(i2==i+1 && Math.abs(j-j2)==1)
            {
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            return false;
        }
        
        if(figura=='♖' || figura=='♜')
        {
            if(i!=i2 && j!=j2) return false;
            if(i==i2)
            {
                int menor = j;
                if(j2<j) menor = j2;
                int maior = j+j2-menor;
                for(int cont=menor+1; cont<maior; cont++)
                {
                    if(tabuleiro[i][cont]!=null) return false;
                }
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            int menor = i;
            if(i2<i) menor = i2;
            int maior = i+i2-menor;
            for(int cont=menor+1; cont<maior; cont++)
            {
                if(tabuleiro[cont][j]!=null) return false;
            }
            if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
            {
                return true;
            }
            return !colocaReiEmXeque(i,j,i2,j2);
        }
        
        if(figura=='♗' || figura=='♝')
        {
            if(i-i2==j-j2)
            {
                if(i<i2)
                {
                    for(int contI = i+1, contJ = j+1; contI<i2; contI++, contJ++)
                    {
                        if(tabuleiro[contI][contJ]!=null) return false;
                    }
                    if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                    {
                        return true;
                    }
                    return !colocaReiEmXeque(i,j,i2,j2);
                }
                for(int contI = i2+1, contJ = j2+1; contI<i; contI++, contJ++)
                {
                    if(tabuleiro[contI][contJ]!=null) return false;
                }
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(i+j==i2+j2)
            {
                if(i<i2)
                {
                    for(int contI = i+1, contJ = j-1; contI<i2; contI++, contJ--)
                    {
                        if(tabuleiro[contI][contJ]!=null) return false;
                    }
                    if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                    {
                        return true;
                    }
                    return !colocaReiEmXeque(i,j,i2,j2);
                }
                for(int contI = i2+1, contJ = j2-1; contI<i; contI++, contJ--)
                {
                    if(tabuleiro[contI][contJ]!=null) return false;
                }
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            return false;
        }
        
        if(figura=='♘' || figura=='♞')
        {
            if(Math.abs(i2-i)==2 && Math.abs(j2-j)==1)
            {
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(Math.abs(i2-i)==1 && Math.abs(j2-j)==2)
            {
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            return false;
        }
        
        if(figura=='♕' || figura =='♛')
        {
            if(i==i2)
            {
                int menor = j;
                if(j2<j) menor = j2;
                int maior = j+j2-menor;
                for(int cont=menor+1; cont<maior; cont++)
                {
                    if(tabuleiro[i][cont]!=null) return false;
                }
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(j==j2)
            {
                int menor = i;
                if(i2<i) menor = i2;
                int maior = i+i2-menor;
                for(int cont=menor+1; cont<maior; cont++)
                {
                    if(tabuleiro[cont][j]!=null) return false;
                }
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(i-i2==j-j2)
            {
                if(i<i2)
                {
                    for(int contI = i+1, contJ = j+1; contI<i2; contI++, contJ++)
                    {
                        if(tabuleiro[contI][contJ]!=null) return false;
                    }
                    if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                    {
                        return true;
                    }
                    return !colocaReiEmXeque(i,j,i2,j2);
                }
                for(int contI = i2+1, contJ = j2+1; contI<i; contI++, contJ++)
                {
                    if(tabuleiro[contI][contJ]!=null) return false;
                }
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(i+j==i2+j2)
            {
                if(i<i2)
                {
                    for(int contI = i+1, contJ = j-1; contI<i2; contI++, contJ--)
                    {
                        if(tabuleiro[contI][contJ]!=null) return false;
                    }
                    if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                    {
                        return true;
                    }
                    return !colocaReiEmXeque(i,j,i2,j2);
                }
                for(int contI = i2+1, contJ = j2-1; contI<i; contI++, contJ--)
                {
                    if(tabuleiro[contI][contJ]!=null) return false;
                }
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            return false;
        }
        
        if(figura=='♔' || figura=='♚')
        {
            if(Math.abs(i-i2)==1 && j==j2) 
            {
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(Math.abs(i-i2)==1 && Math.abs(j-j2)==1)
            {
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
            if(i==i2 && Math.abs(j-j2)==1)
            {
                if(tabuleiro[i2][j2].getFigura()=='♔' || tabuleiro[i2][j2].getFigura()=='♚')
                {
                    return true;
                }
                return !colocaReiEmXeque(i,j,i2,j2);
            }
        }
        
        return false;
    }
    public void passaVez()
    {
        if(vez.equals("branca")) vez = "preta";
        else vez = "branca";
    }
    public String getVez()
    {
        return vez;
    }
    public String toString()
    {
        String msg = "  A B C D E F G H\n";
        for(int i=0; i<8; i++)
        {
            msg += i+1 + " ";
            for(int j=0; j<8; j++)
            {
                if(tabuleiro[i][j]==null) msg += ". ";
                else msg += tabuleiro[i][j] + " ";
            }
            msg += i+1 + "\n";
        }
        msg += "  A B C D E F G H";
        return msg;
    }
}