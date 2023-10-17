import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import agenda.Contato;

/**
 * Classe de testes referente a classe Contato
 * @author Hennan Heim Falcão - Matrícula 122110048
 *
 */
public class ContatoTest {


    private Contato contato;
    
    @BeforeEach
    void preparaContatos() {
        this.contato = new Contato(1, "Matheus", "Gaudencio", "555-5551");
    }
/**
 * Teste referente ao ToStringExibir
 */
    @Test
    void testToStringExibir() {
       assertEquals("Matheus Gaudencio\n555-5551", this.contato.toStringExibir());
    }
/**
 * Teste referente ao ToStringListar    
 */
    @Test
    void testToStringListar() {
    	assertEquals("1 - Matheus Gaudencio", this.contato.toStringListar());
    }
}



