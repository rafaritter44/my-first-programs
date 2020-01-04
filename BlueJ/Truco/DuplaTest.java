import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe teste DuplaTest.
 *
 * @author Rafael Ritter
 * @version 19/11/2016
 */
public class DuplaTest
{
    public DuplaTest()
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
    public void testeAumentaPontos()
    {
        Dupla d = new Dupla("d");
        assertEquals(0, d.getPontos(), 0);
        
        d.aumentaPontos(1);
        assertEquals(1, d.getPontos(), 0);
        
        d.aumentaPontos(3);
        assertEquals(4, d.getPontos(), 0);
        
        d.aumentaPontos(6);
        assertEquals(10, d.getPontos(), 0);
        
        d.aumentaPontos(9);
        assertEquals(19, d.getPontos(), 0);
    }
}