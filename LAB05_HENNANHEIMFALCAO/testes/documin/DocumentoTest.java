package documin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DocumentoTest {

	private Documento documento;

	@Test
	void criaDocumentoSemLimiteTamanhoTituloVazio() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> this.documento = new Documento(""));

		assertEquals("TÍTULO VAZIO!", e.getMessage());
	}

	@Test
	void criaDocumentoSemLimiteDeTamanho() throws Exception {
		this.documento = new Documento("Título");
		assertEquals("Título", this.documento.getTitulo());
	}

	@Test
	void criaDocumentoSemLimiteDeTamanhoTítuloComEspaços() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> this.documento = new Documento("     "));

		assertEquals("TÍTULO VAZIO!", e.getMessage());
	}

	@Test
	void criaDocumentoComLimiteDeTamanhoTítuloComEspaços() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> this.documento = new Documento("     ", 100));

		assertEquals("TÍTULO VAZIO!", e.getMessage());
	}

	@Test
	void criaDocumentoComLimiteDeTamanhoTítuloVazio() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> this.documento = new Documento("", 100));

		assertEquals("TÍTULO VAZIO!", e.getMessage());
	}

	@Test
	void criaDocumentoComLimiteDeTamanhoTamanhoInválido() {
		Exception e = assertThrows(IllegalArgumentException.class,
				() -> this.documento = new Documento("Testando o construtor", -2));

		assertEquals("TAMANHO INVÁLIDO", e.getMessage());
	}

	@Test
	void criaDocumentoComLimiteDeTamanho() throws Exception {
		this.documento = new Documento("Título", 100);
		assertEquals(100, this.documento.getTamanho());
	}
	
}
