
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestaCalculadiora.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestaOperacoes
{
    /**
     * Default constructor for test class TestaCalculadiora
     */
    public TestaOperacoes()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void TesteFatorial()
    {
        assertEquals(1, Operacoes.fatorial(1), 0);
        assertEquals(1, Operacoes.fatorial(0), 0);
        assertEquals(-1, Operacoes.fatorial(-1), 0);
        assertEquals(6, Operacoes.fatorial(3), 0);
        assertEquals(120, Operacoes.fatorial(5), 0);
        assertEquals(720, Operacoes.fatorial(6), 0);
        assertEquals(-1, Operacoes.fatorial(171), 0);
    }

}
