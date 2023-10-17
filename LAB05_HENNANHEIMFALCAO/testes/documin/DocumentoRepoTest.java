package documin;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentoRepoTest {

	private DocumentoRepo documentorepo = new DocumentoRepo();

	@Test
	void criaDocumentoSemRestricaoDeTamanho() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
	}

	@Test
	void criaDocumentoSemLimiteTamanhoTituloVazio() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> new Documento(""));

		assertEquals("TÍTULO VAZIO!", e.getMessage());
	}

	@Test
	void criaDocumentoSemLimiteDeTamanho() throws Exception {
		Documento documento = new Documento("Título");
		assertEquals("Título", documento.getTitulo());
	}

	@Test
	void criaDocumentoSemLimiteDeTamanhoTítuloComEspaços() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> new Documento("     "));

		assertEquals("TÍTULO VAZIO!", e.getMessage());
	}

	@Test
	void criaDocumentoComLimiteDeTamanhoTítuloComEspaços() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> new Documento("     ", 100));

		assertEquals("TÍTULO VAZIO!", e.getMessage());
	}

	@Test
	void criaDocumentoComLimiteDeTamanhoTítuloVazio() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> new Documento("", 100));

		assertEquals("TÍTULO VAZIO!", e.getMessage());
	}

	@Test
	void criaDocumentoComLimiteDeTamanhoTamanhoInválido() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> new Documento("Testando o construtor", -2));

		assertEquals("TAMANHO INVÁLIDO", e.getMessage());
	}

	@Test
	void criaDocumentoComLimiteDeTamanho() throws Exception {
		Documento documento = new Documento("Título", 100);
		assertEquals(100, documento.getTamanho());
	}

	@Test
	void criaDocumentoComLimiteDeTamanhoNoRepositórioTítuloVazio() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.criaDocumento("", 1));

		assertEquals("TÍTULO VAZIO!", e.getMessage());
	}

	@Test
	void criaDocumentoSemLimiteDeTamanhoNoRepositórioTítuloVazio() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.criaDocumento(""));

		assertEquals("TÍTULO VAZIO!", e.getMessage());
	}

	@Test
	void criaDocumentoSemLimiteDeTamanhoNoRepositório() {
		assertEquals(true, this.documentorepo.criaDocumento("Título"));
	}

	@Test
	void criaDocumentoSemLimiteDeTamanhoNoRepositórioDocumentoJáExiste() {
		this.documentorepo.criaDocumento("Título");
		assertEquals(false, this.documentorepo.criaDocumento("Título"));
	}

	@Test
	void criaDocumentoComLimiteDeTamanhoNoRepositórioDocumentoJáExiste() {
		this.documentorepo.criaDocumento("Título", 1);
		assertEquals(false, this.documentorepo.criaDocumento("Título", 1));
	}

	@Test
	void criaDocumentoComLimiteDeTamanhoNoRepositório() {
		assertEquals(true, this.documentorepo.criaDocumento("Título", 1));
	}

	@Test
	void removeDocumentoVálido() {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		this.documentorepo.removeDocumento("Programação Orientada a Objetos");
		assertEquals(0, this.documentorepo.getDocumentos().size());
	}

	@Test
	void removeDocumentoInválido() {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		NoSuchElementException e = assertThrows(NoSuchElementException.class,
				() -> this.documentorepo.removeDocumento("Título"));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());

	}

	@Test
	void removeDocumentoTítuloVazio() {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.removeDocumento(""));

		assertEquals("TÍTULO VAZIO!", e.getMessage());

	}

	@Test
	void removeDocumentoTítuloComEspaços() {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.removeDocumento("     "));

		assertEquals("TÍTULO VAZIO!", e.getMessage());

	}

	@Test
	void criaTextoVálido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos", "Testando", 4));
	}

	@Test
	void criaTextoVálido2() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos", "Testando", 4));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos", "Testando mais uma vez", 5));
	}

	@Test
	void criaTextoDocumentoInválido() {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos", 1));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.criaTexto("Título", "Testando", 4));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void criaTextoTamanhoMáximoAtingido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos", 1));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos", "Testando2", 5));
		Exception e = assertThrows(Exception.class,
				() -> this.documentorepo.criaTexto("Programação Orientada a Objetos", "Testando", 4));

		assertEquals("TAMANHO MÁXIMO ATINGIDO!", e.getMessage());
	}

	@Test
	void criaTítuloVálido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTitulo("Programação Orientada a Objetos", "Testando", 4, 3, true));
	}

	@Test
	void criaTítuloVálido2() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTitulo("Programação Orientada a Objetos", "Testando", 4, 3, true));
		assertEquals(1,
				this.documentorepo.criaTitulo("Programação Orientada a Objetos", "Testando mais uma vez", 3, 3, false));
	}

	@Test
	void criaTítuloDocumentoInválido() {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos", 1));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.criaTitulo("", "Testando", 4, 3, true));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void criaTítuloTamanhoMáximoAtingido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos", 1));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTitulo("Programação Orientada a Objetos", "Testando2", 5, 2, false));
		Exception e = assertThrows(Exception.class,
				() -> this.documentorepo.criaTitulo("Programação Orientada a Objetos", "Testando", 4, 3, true));

		assertEquals("TAMANHO MÁXIMO ATINGIDO!", e.getMessage());
	}

	@Test
	void criaListaVálida() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaLista("Programação Orientada a Objetos",
				"Testando a criação de uma lista", 4, " ", "-"));
	}

	@Test
	void criaListaVálida2() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaLista("Programação Orientada a Objetos",
				"Testando a criação de uma lista", 4, "|", "-"));
		assertEquals(1, this.documentorepo.criaLista("Programação Orientada a Objetos",
				"Testando mais uma vez a criação de uma lista", 5, " ", "."));
	}

	@Test
	void criaListaDocumentoInválido() {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos", 1));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.criaLista("", "Testando a criação de uma lista", 4, " ", "-"));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void criaListaTamanhoMáximoAtingido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos", 1));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaLista("Programação Orientada a Objetos",
				"Testando a criação de uma lista", 4, " ", "-"));
		;
		Exception e = assertThrows(Exception.class,
				() -> this.documentorepo.criaLista("Programação Orientada a Objetos",
						"Testando mais uma vez a criação de uma lista", 5, " ", "."));

		assertEquals("TAMANHO MÁXIMO ATINGIDO!", e.getMessage());
	}

	@Test
	void criaTermosVálidoSemOrdem() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTermos("Programação Orientada a Objetos",
				"Testando / a / criação / de / um / elemento / tipo / termos", 4, "/", "NENHUM"));
	}

	@Test
	void criaTermosVálido2() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTermos("Programação Orientada a Objetos",
				"Testando / a / criação / de / um / elemento / tipo / termos", 4, "/", "NENHUM"));
		assertEquals(1, this.documentorepo.criaTermos("Programação Orientada a Objetos",
				"Testando / a / criação / de / um / elemento / tipo / termos", 4, "/", "ALFABETICA"));
	}

	@Test
	void criaTermosVálido3() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTermos("Programação Orientada a Objetos",
				"Testando / a / criação / de / um / elemento / tipo / termos", 4, "/", "NENHUM"));
		assertEquals(1, this.documentorepo.criaTermos("Programação Orientada a Objetos",
				"Testando / a / criação / de / um / elemento / tipo / termos", 4, "/", "TAMANHO"));
	}

	@Test
	void criaTermosOrdemInválida() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.criaTermos("Programação Orientada a Objetos",
						"Testando / a / criação / de / um / elemento / tipo / termos", 4, "/", "DEFAULT"));

		assertEquals("ORDEM INVÁLIDA!", e.getMessage());
	}

	@Test
	void criaTermosDocumentoInválido() {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos", 1));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> this.documentorepo
				.criaTermos("", "Testando / a / criação / de / um / elemento / tipo / termos", 4, "/", "ALFABETICA"));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void criaTermosTamanhoMáximoAtingido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos", 1));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTermos("Programação Orientada a Objetos",
				"Testando / a / criação / de / um / elemento / tipo / termos", 4, "/", "NENHUM"));
		Exception e = assertThrows(Exception.class,
				() -> this.documentorepo.criaTermos("Programação Orientada a Objetos",
						"Testando / a / criação / de / um / elemento / tipo / termos", 4, "/", "ALFABETICA"));
		assertEquals("TAMANHO MÁXIMO ATINGIDO!", e.getMessage());
	}

	@Test
	void pegaRepresentacaoCompletaTexto() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals("Testando a representação completa do elemento tipo texto",
				this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoCompletaTítuloLinkavel() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTitulo("Programação Orientada a Objetos", "Testando", 4, 3, true));
		assertEquals("3. Testando -- 3-TESTANDO",
				this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoCompletaTítuloNãoLinkavel() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTitulo("Programação Orientada a Objetos", "Testando", 4, 3, false));
		assertEquals("3. Testando", this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoCompletaLista() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaLista("Programação Orientada a Objetos",
				"Testando / a / criação / de / uma / lista", 4, "/", "-"));
		assertEquals("- Testando\n- a\n- criação\n- de\n- uma\n- lista",
				this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoCompletaTermosOrdemAlfabética() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTermos("Programação Orientada a Objetos", "Teste / Termos / Aleatórios",
				4, "/", "ALFABETICA"));
		assertEquals("Total de termos: 3\n- Aleatórios, Termos, Teste",
				this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoCompletaTermosOrdemTamanho() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTermos("Programação Orientada a Objetos", "Teste / Termos / Aleatórios",
				4, "/", "TAMANHO"));
		assertEquals("Total de termos: 3\n- Aleatórios, Termos, Teste",
				this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoCompletaTermosSemOrdem() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTermos("Programação Orientada a Objetos", "Teste / Termos / Aleatórios",
				4, "/", "NENHUM"));
		assertEquals("Total de termos: 3\n- Teste, Termos, Aleatórios",
				this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoCompletaElementoInválido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class,
				() -> this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 1));

		assertEquals("ELEMENTO INVÁLIDO!", e.getMessage());
	}

	@Test
	void pegaRepresentacaoCompletaDocumentoInválido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.pegarRepCompleta("", 0));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void pegaRepresentacaorResumidaTexto() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals("Testando a representação completa do elemento tipo texto",
				this.documentorepo.pegarRepResumida("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoResumidaTítuloLinkavel() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTitulo("Programação Orientada a Objetos", "Testando", 4, 3, true));
		assertEquals("3. Testando", this.documentorepo.pegarRepResumida("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoResumidaTítuloNãoLinkavel() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTitulo("Programação Orientada a Objetos", "Testando", 4, 3, false));
		assertEquals("3. Testando", this.documentorepo.pegarRepResumida("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoResumidaLista() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaLista("Programação Orientada a Objetos",
				"Testando / a / criação / de / uma / lista", 4, "/", "-"));
		assertEquals("Testando/ a/ criação/ de/ uma/ lista",
				this.documentorepo.pegarRepResumida("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoResumidaTermosOrdemAlfabética() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTermos("Programação Orientada a Objetos", "Teste / Termos / Aleatórios",
				4, "/", "ALFABETICA"));
		assertEquals("Aleatórios / Termos / Teste",
				this.documentorepo.pegarRepResumida("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoResumidaTermosOrdemTamanho() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTermos("Programação Orientada a Objetos", "Teste / Termos / Aleatórios",
				4, "/", "TAMANHO"));
		assertEquals("Aleatórios / Termos / Teste",
				this.documentorepo.pegarRepResumida("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoResumidaTermosSemOrdem() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTermos("Programação Orientada a Objetos", "Teste / Termos / Aleatórios",
				4, "/", "NENHUM"));
		assertEquals("Teste / Termos / Aleatórios",
				this.documentorepo.pegarRepResumida("Programação Orientada a Objetos", 0));
	}

	@Test
	void pegaRepresentacaoResumidaElementoInválido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class,
				() -> this.documentorepo.pegarRepResumida("Programação Orientada a Objetos", 1));

		assertEquals("ELEMENTO INVÁLIDO!", e.getMessage());
	}

	@Test
	void pegaRepresentacaoResumidaDocumentoInválido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.pegarRepResumida("", 0));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void apagarElementoVálido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(true, this.documentorepo.apagarElemento("Programação Orientada a Objetos", 0));

	}

	@Test
	void apagarElementoInválido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class,
				() -> this.documentorepo.apagarElemento("Programação Orientada a Objetos", 1));

		assertEquals("ELEMENTO INVÁLIDO!", e.getMessage());

	}

	@Test
	void apagarElementoDocumentoInválido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.apagarElemento("", 0));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());

	}

	@Test
	void contaElementosVálido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentorepo.contaElementos("Programação Orientada a Objetos"));
	}

	@Test
	void contaElementosDocumentoInválido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.contaElementos(""));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void contaElementosDocumentoInválido2() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		NoSuchElementException e = assertThrows(NoSuchElementException.class,
				() -> this.documentorepo.contaElementos("tÍTULO"));

		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void moveParaCimaVálido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		this.documentorepo.moveParaCima("Programação Orientada a Objetos", 1);
		assertEquals("Testando a representação completa do elemento tipo texto mais uma vez",
				this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 0));
	}

	@Test
	void moveParaCimaPosiçãoInválida() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		this.documentorepo.moveParaCima("Programação Orientada a Objetos", 1);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class,
				() -> this.documentorepo.moveParaCima("Programação Orientada a Objetos", 2));

		assertEquals("POSIÇÃO INVÁLIDA!", e.getMessage());
	}

	@Test
	void moveParaCimaPosiçãoInválida2() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		this.documentorepo.moveParaCima("Programação Orientada a Objetos", 1);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class,
				() -> this.documentorepo.moveParaCima("Programação Orientada a Objetos", -1));

		assertEquals("POSIÇÃO INVÁLIDA!", e.getMessage());
	}

	@Test
	void moveParaBaixoVálido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		this.documentorepo.moveParaBaixo("Programação Orientada a Objetos", 0);
		assertEquals("Testando a representação completa do elemento tipo texto",
				this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 1));
	}

	@Test
	void moveParaBaixoPosiçãoInválida() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		this.documentorepo.moveParaBaixo("Programação Orientada a Objetos", 1);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class,
				() -> this.documentorepo.moveParaBaixo("Programação Orientada a Objetos", 2));

		assertEquals("POSIÇÃO INVÁLIDA!", e.getMessage());
	}

	@Test
	void moveParaBaixoPosiçãoInválida2() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 4));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		this.documentorepo.moveParaBaixo("Programação Orientada a Objetos", 1);
		IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class,
				() -> this.documentorepo.moveParaCima("Programação Orientada a Objetos", -1));

		assertEquals("POSIÇÃO INVÁLIDA!", e.getMessage());
	}

	@Test
	void calculoMédiaPrioridade() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 5));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		assertEquals(4, this.documentorepo.getDocumento("Programação Orientada a Objetos").calcMediaPrioridade());

	}

	@Test
	void exibeDocumento() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 5));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		String[] mostraDoc = this.documentorepo.exibeDocumento("Programação Orientada a Objetos");
		assertEquals("Testando a representação completa do elemento tipo texto", mostraDoc[0]);
		assertEquals("Testando a representação completa do elemento tipo texto mais uma vez", mostraDoc[1]);
	}

	@Test
	void exibeDocumentoDocumentoInválido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 5));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> this.documentorepo.exibeDocumento(""));
		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void exibeDocumentoDocumentoInválido2() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 5));
		assertEquals(1, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto mais uma vez", 3));
		NoSuchElementException e = assertThrows(NoSuchElementException.class,
				() -> this.documentorepo.exibeDocumento("Título"));
		assertEquals("DOCUMENTO NÃO EXISTE!", e.getMessage());
	}

	@Test
	void criaAtalho() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 5));
		assertEquals(true, this.documentorepo.criaDocumento("Java"));
		assertEquals(0, this.documentorepo.criaTexto("Java", "Mais um teste", 5));
		assertEquals(1, this.documentorepo.criaAtalho("Programação Orientada a Objetos", "Java"));
	}

	@Test
	void criaAtalhoTamanhoMáximoAtingido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos", 1));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo texto", 5));
		assertEquals(true, this.documentorepo.criaDocumento("Java"));
		assertEquals(0, this.documentorepo.criaTexto("Java", "Mais um teste", 5));
		Exception e = assertThrows(Exception.class,
				() -> this.documentorepo.criaAtalho("Programação Orientada a Objetos", "Java"));
		assertEquals("TAMANHO MÁXIMO ATINGIDO!", e.getMessage());
	}

	@Test
	void repResumidaAtalho1() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo atalho", 5));
		assertEquals(true, this.documentorepo.criaDocumento("Java"));
		assertEquals(0, this.documentorepo.criaTexto("Java", "Mais um teste", 5));
		assertEquals(1, this.documentorepo.criaAtalho("Programação Orientada a Objetos", "Java"));
		assertEquals("Mais um teste\n", this.documentorepo.pegarRepResumida("Programação Orientada a Objetos", 1));

	}

	@Test
	void repResumidaAtalho2() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo atalho", 5));
		assertEquals(true, this.documentorepo.criaDocumento("Java"));
		assertEquals(0, this.documentorepo.criaTexto("Java", "Mais um teste", 5));
		assertEquals(1, this.documentorepo.criaTexto("Java", "Outro Teste", 4));
		assertEquals(2, this.documentorepo.criaTexto("Java", "e outro teste!", 3));
		assertEquals(1, this.documentorepo.criaAtalho("Programação Orientada a Objetos", "Java"));
		assertEquals("Mais um teste\nOutro Teste\n",
				this.documentorepo.pegarRepResumida("Programação Orientada a Objetos", 1));

	}

	@Test
	void repCompletaAtalho1() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo atalho", 5));
		assertEquals(true, this.documentorepo.criaDocumento("Java"));
		assertEquals(0, this.documentorepo.criaTexto("Java", "Mais um teste", 5));
		assertEquals(1, this.documentorepo.criaAtalho("Programação Orientada a Objetos", "Java"));
		assertEquals("Mais um teste\n", this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 1));

	}

	@Test
	void repCompletaAtalho2() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo atalho", 5));
		assertEquals(true, this.documentorepo.criaDocumento("Java"));
		assertEquals(0, this.documentorepo.criaTexto("Java", "Mais um teste", 5));
		assertEquals(1, this.documentorepo.criaTexto("Java", "Outro Teste", 4));
		assertEquals(2, this.documentorepo.criaTexto("Java", "e outro teste!", 3));
		assertEquals(1, this.documentorepo.criaAtalho("Programação Orientada a Objetos", "Java"));
		assertEquals("Mais um teste\nOutro Teste\n",
				this.documentorepo.pegarRepCompleta("Programação Orientada a Objetos", 1));

	}

	@Test
	void criaAtalhoInválido() throws Exception {
		assertEquals(true, this.documentorepo.criaDocumento("Programação Orientada a Objetos"));
		assertEquals(1, this.documentorepo.getDocumentos().size());
		assertEquals(0, this.documentorepo.criaTexto("Programação Orientada a Objetos",
				"Testando a representação completa do elemento tipo atalho", 5));
		assertEquals(true, this.documentorepo.criaDocumento("Java"));
		assertEquals(0, this.documentorepo.criaTexto("Java", "Mais um teste", 5));
		assertEquals(1, this.documentorepo.criaAtalho("Programação Orientada a Objetos", "Java"));
		System.out.println();
		IllegalStateException e = assertThrows(IllegalStateException.class,
				() -> this.documentorepo.criaAtalho("Programação Orientada a Objetos", "Java"));
		assertEquals("Documento referenciado já tem atalho ou o documento a receber a referência já é um atalho!", e.getMessage());
	}
}
