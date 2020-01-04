import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe teste JogoTest.
 *
 * @author Rafael Ritter
 * @version 19/11/2016
 */
public class JogoTest
{
    public JogoTest()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testeProximoDaRodada()
    {
        Jogo j = new Jogo();
        assertEquals(j.getJogador1(), j.getProximoJogador());
        
        j.proximoDaRodada();
        assertEquals(j.getJogador2(), j.getProximoJogador());
        
        j.proximoDaRodada();
        assertEquals(j.getJogador3(), j.getProximoJogador());
        
        j.proximoDaRodada();
        assertEquals(j.getJogador4(), j.getProximoJogador());
        
        j.proximoDaRodada();
        assertEquals(j.getJogador1(), j.getProximoJogador());
    }
    
    @Test
    public void testeAumentaValorDaRodada()
    {
        Jogo j = new Jogo();
        assertEquals(1, j.getValorDaRodada(), 0);
        
        j.aumentaValorDaRodada();
        assertEquals(3, j.getValorDaRodada(), 0);
        
        j.aumentaValorDaRodada();
        assertEquals(6, j.getValorDaRodada(), 0);
        
        j.aumentaValorDaRodada();
        assertEquals(9, j.getValorDaRodada(), 0);
        
        j.aumentaValorDaRodada();
        assertEquals(12, j.getValorDaRodada(), 0);
    }
    
    @Test
    public void testeProximaRodada()
    {
        Jogo j = new Jogo();
        assertEquals(j.getJogador1(), j.getIniciadorDaRodada());
        
        j.proximaRodada();
        assertEquals(j.getJogador2(), j.getIniciadorDaRodada());
        
        j.proximaRodada();
        assertEquals(j.getJogador3(), j.getIniciadorDaRodada());
        
        j.proximaRodada();
        assertEquals(j.getJogador4(), j.getIniciadorDaRodada());
        
        j.proximaRodada();
        assertEquals(j.getJogador1(), j.getIniciadorDaRodada());
    }
}