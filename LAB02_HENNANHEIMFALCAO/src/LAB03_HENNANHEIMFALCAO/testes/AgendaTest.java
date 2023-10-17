import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import agenda.Agenda;

import agenda.Contato;
/**
* Classe de testes referente a classe Agenda
* @author Hennan Heim Falcão - Matrícula 122110048
*
*/
class AgendaTest {
	
	private Agenda agenda;
	private Contato contato;
	
	@BeforeEach
	void preparaAgenda() {
		this.agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "99999-0000");

	}
	 
	/**
	 * Testa se o cadastro será realizado com os dados do contato. Deve ser realizado com sucesso.
	 */
	@Test
	void testCadastraContato() {
		assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(2, "Deus", "Gaudencio", "(83) 99999-0000"));
	}
	@Test
	void testCadastroSobrepoe() {
		this.agenda.cadastraContato(2, "José", "Silva", "232323-0000");
		assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(1, "Pedro", "Silva", "(84) 98888-111"));
	}	
	
	@Test
	void testContatoJaCadastrado() {
		
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "99999-0000");
		String msg = agenda.cadastraContato(3, "Matheus", "Gaudencio", "99999-0000");
		assertEquals("CONTATO JÁ CADASTRADO", msg);
	}
		
	@Test
	void testCadastroLimiteSuperior() {
		assertEquals("CADASTRO REALIZADO", agenda.cadastraContato(100, "Vitor", "Silva", "99999-0000"));
	}
	
	@Test
	void testCadastroAcimadoLimiteDePosicao() {
		assertEquals("POSIÇÃO INVÁLIDA", agenda.cadastraContato(101, "Silva", "Luiz", "99999-0000"));
	}
	
	@Test
	void testCadastroAbaixoDoLimite() {
		assertEquals("POSIÇÃO INVÁLIDA", agenda.cadastraContato(0, "Alane", "Gaudencio", "99999-0000"));
	}	
	
	@Test
	void testCadastroTelefoneVazio() {
		assertEquals("CONTATO INVÁLIDO", agenda.cadastraContato(1, "Jorge", "Gaudencio", ""));
	}	
	
	@Test
	void testCadastroNomeVazio() {
	assertEquals("CONTATO INVÁLIDO", agenda.cadastraContato(1, "", "Gaudencio", "99999-0000"));
	}
	
	@Test
	void testAdicionaFavorito() {
		
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "99999-0000");
		assertEquals("CONTATO FAVORITADO NA POSIÇÃO 1!", agenda.adicionaFavorito(1, 1));
	}
	
	@Test
	void testAdicionaFavoritoUltimaPosicao() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "99999-0000");
		assertEquals("CONTATO FAVORITADO NA POSIÇÃO 10!", agenda.adicionaFavorito(1, 10));
	}	
	@Test
	void testAdicionaFavoritoJaExistente() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "99999-0000");
		agenda.adicionaFavorito(1, 1);
		agenda.adicionaFavorito(1, 2);
	}
	
	@Test 
	void testPosicaoInvalidaInferiorFavoritos() {
		try {
			this.agenda = new Agenda();
			agenda.cadastraContato(1, "Matheus", "Gaudencio", "99999-0000");
			agenda.adicionaFavorito(1, 0);
		}
		catch(Exception e) {
			assertEquals("Index -1 out of bounds for length 10", e.getMessage());
		}
	}	
	@Test 
	void testPosicaoInvalidaSuperiorFavoritos() {
		try {
			this.agenda = new Agenda();
			agenda.cadastraContato(1, "Matheus", "Gaudencio", "99999-0000");
			agenda.adicionaFavorito(1, 11);
		}
		catch(Exception e) {
			assertEquals("Index 10 out of bounds for length 10", e.getMessage());
		}
	}	
	@Test
	void testRemoveFavorito() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "99999-0000");
		agenda.adicionaFavorito(1, 1);
		agenda.removeFavorito(1);
		assertEquals("CONTATO FAVORITADO NA POSIÇÃO 1!", agenda.adicionaFavorito(1, 1));
		}
	@Test
	void testExibeFavorito() {
		this.contato = new Contato(1, "Matheus", "Gaudencio", "99999-0000", true);
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "99999-0000");
		agenda.adicionaFavorito(1, 1);
		assertEquals("❤ Matheus Gaudencio\n99999-0000", contato.toStringExibir());
	}
	@Test
	void testExibeContatoSemTelefone() {
		this.contato = new Contato(1, "Matheus", "Gaudencio", "");
		assertEquals("Matheus Gaudencio\n", contato.toStringExibir());
	}
	@Test
	void testExibeContatoVazio() {
		this.contato = new Contato(1, "", "", "");
		assertEquals(" \n", contato.toStringExibir());
	}
	@Test
	void testExibeContatoSemContato() {
		try {
			this.agenda.getContato(55).toString();
		}catch(NullPointerException e) {
			
		}
	}
	
	@Test
	void testExibeContatoPosicaoInvalida() {
		try {
			this.agenda.getContato(100).toString();
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
	}
	
}

	