package documin;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DocumentoControllerTest {

	private DocumentoController documentocontroller = new DocumentoController();

	@Test
	void criaDocumentoSemRestriçãoDeTamanho() {
		assertEquals(true, this.documentocontroller.criarDocumento("Teste"));
	}

	@Test
	void criaDocumentoComRestriçãoDeTamanho() {
		assertEquals(true, this.documentocontroller.criarDocumento("Teste", 1));
	}

	@Test
	void removeDocumento() throws Exception {
		assertEquals(true, this.documentocontroller.criarDocumento("Teste", 1));
		this.documentocontroller.removeDocumento("Teste");
		Exception e = assertThrows(Exception.class, () -> this.documentocontroller.getDocumento("Teste"));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void contaElementos() throws Exception {
		assertEquals(true, this.documentocontroller.criarDocumento("Teste", 1));
		this.documentocontroller.criaTexto("Teste", "Testando", 5);
		assertEquals(1, this.documentocontroller.contaElementos("Teste"));
	}

	@Test
	void exibeDocumento() throws Exception {
		assertEquals(true, this.documentocontroller.criarDocumento("Programação Orientada a Objetos"));
		assertEquals(0, this.documentocontroller.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 5));
		assertEquals(1, this.documentocontroller.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		String[] mostraDoc = this.documentocontroller.exibeDocumento("Programação Orientada a Objetos");
		assertEquals("Testando a representação completa do elemento tipo texto", mostraDoc[0]);
		assertEquals("Testando a representação completa do elemento tipo texto mais uma vez", mostraDoc[1]);
	}

	@Test
	void criaTexto() throws Exception {
		assertEquals(true, this.documentocontroller.criarDocumento("Programação Orientada a Objetos"));
		assertEquals(0, this.documentocontroller.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 5));
	}

	@Test
	void criaLista() throws Exception {
		assertEquals(true, this.documentocontroller.criarDocumento("Programação Orientada a Objetos"));
		assertEquals(0,
				this.documentocontroller.criaLista("Programação Orientada a Objetos", "Testando / Lista", 4, "/", "."));
	}

	@Test
	void criaTítulo() throws Exception {
		assertEquals(true, this.documentocontroller.criarDocumento("Programação Orientada a Objetos"));
		assertEquals(0,
				this.documentocontroller.criaTitulo("Programação Orientada a Objetos", "Testando", 4, 3, false));
	}

	@Test
	void criaTermos() throws Exception {
		assertEquals(true, this.documentocontroller.criarDocumento("Programação Orientada a Objetos"));
		assertEquals(0, this.documentocontroller.criaTermos("Programação Orientada a Objetos", "Termos / Aleatórios", 4,
				"/", "NENHUM"));
	}

	@Test
	void criaAtalho() throws Exception {
		assertEquals(true, this.documentocontroller.criarDocumento("Programação Orientada a Objetos"));
		assertEquals(true, this.documentocontroller.criarDocumento("Testando"));
		this.documentocontroller.criaTexto("Programação Orientada a Objetos", "Teste", 5);
		this.documentocontroller.criaTexto("Testando", "Mais um teste", 5);
		assertEquals(1, this.documentocontroller.criaAtalho("Programação Orientada a Objetos", "Testando"));
	}

	@Test
	void moveParaCimaVálido() throws Exception {
		assertEquals(true, this.documentocontroller.criarDocumento("Programação Orientada a Objetos"));
		assertEquals(0, this.documentocontroller.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentocontroller.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		this.documentocontroller.moveParaCima("Programação Orientada a Objetos", 1);
		assertEquals("Testando a representação completa do elemento tipo texto mais uma vez",
				this.documentocontroller.pegarRepCompleta("Programação Orientada a Objetos", 0));
	}
	@Test
	void moveParaBaixoVálido() throws Exception {
		assertEquals(true, this.documentocontroller.criarDocumento("Programação Orientada a Objetos"));
		assertEquals(0, this.documentocontroller.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentocontroller.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		this.documentocontroller.moveParaBaixo("Programação Orientada a Objetos", 0);
		assertEquals("Testando a representação completa do elemento tipo texto",
				this.documentocontroller.pegarRepCompleta("Programação Orientada a Objetos", 1));
	}
}