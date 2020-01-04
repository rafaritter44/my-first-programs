

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste TesteOperacoes.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class TesteOperacoes
{
    /**
     * Construtor default para a classe de teste TesteOperacoes
     */
    public TesteOperacoes()
    {
    }

    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void TesteFatorial()
    {
        assertEquals(6, Operacoes.fatorial(3), 0);
        assertEquals(120, Operacoes.fatorial(5), 0);
    }
}

