package documin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisaoControllerTest {
	private VisaoController visaocontroller = new VisaoController();
	private DocumentoRepo documentorepo = new DocumentoRepo();

	@Test
	void criaVisaoCompleta() throws Exception {
		this.documentorepo.criaDocumento("Teste");
		this.documentorepo.criaTexto("Teste", "Testando", 4);
		assertEquals(0, this.visaocontroller.criarVisaoCompleta(this.documentorepo.getDocumento("Teste")));
	}

	@Test
	void exibeVisaoCompleta() throws Exception {
		this.documentorepo.criaDocumento("Teste");
		this.documentorepo.criaTexto("Teste", "Testando", 4);
		assertEquals(0, this.visaocontroller.criarVisaoCompleta(this.documentorepo.getDocumento("Teste")));
		String[] exibeVisao = this.visaocontroller.exibirVisao(0);
		assertEquals("Testando", exibeVisao[0]);
	}

	@Test
	void criaVisaoResumida() throws Exception {
		this.documentorepo.criaDocumento("Teste");
		this.documentorepo.criaTexto("Teste", "Testando", 4);
		assertEquals(0, this.visaocontroller.criarVisaoResumida(this.documentorepo.getDocumento("Teste")));
	}

	@Test
	void exibeVisaoResumida() throws Exception {
		this.documentorepo.criaDocumento("Teste");
		this.documentorepo.criaTexto("Teste", "Testando", 4);
		assertEquals(0, this.visaocontroller.criarVisaoResumida(this.documentorepo.getDocumento("Teste")));
		String[] exibeVisao = this.visaocontroller.exibirVisao(0);
		assertEquals("Testando", exibeVisao[0]);
	}

	@Test
	void criaVisaoPrioritária() throws Exception {
		this.documentorepo.criaDocumento("Teste");
		this.documentorepo.criaTexto("Teste", "Testando", 4);
		this.documentorepo.criaTexto("Teste", "Testando mais uma vez", 5);
		this.documentorepo.criaTexto("Teste", "Testando uma outra vez", 3);
		assertEquals(0, this.visaocontroller.criarVisaoPrioritaria(this.documentorepo.getDocumento("Teste"), 4));
	}

	@Test
	void exibeVisaoPrioritária() throws Exception {
		this.documentorepo.criaDocumento("Teste");
		this.documentorepo.criaTexto("Teste", "Testando", 4);
		this.documentorepo.criaTexto("Teste", "Testando mais uma vez", 5);
		this.documentorepo.criaTexto("Teste", "Testando uma outra vez", 3);
		assertEquals(0, this.visaocontroller.criarVisaoPrioritaria(this.documentorepo.getDocumento("Teste"), 4));
		String[] exibeVisao = this.visaocontroller.exibirVisao(0);
		assertEquals("Testando", exibeVisao[0]);
		assertEquals("Testando mais uma vez", exibeVisao[1]);
		assertEquals(2, exibeVisao.length);
	}

	@Test
	void criaVisaoTitulo() throws Exception {
		this.documentorepo.criaDocumento("Teste");
		this.documentorepo.criaTitulo("Teste", "Testando", 4, 3, false);
		this.documentorepo.criaTitulo("Teste", "Testando mais uma vez", 4, 3, true);
		assertEquals(0, this.visaocontroller.criarVisaoTitulo(this.documentorepo.getDocumento("Teste")));
	}

	@Test
	void exibeVisaoTitulo() throws Exception {
		this.documentorepo.criaDocumento("Teste");
		this.documentorepo.criaTitulo("Teste", "Testando", 4, 3, false);
		this.documentorepo.criaTitulo("Teste", "Testando mais uma vez", 4, 3, true);
		assertEquals(0, this.visaocontroller.criarVisaoTitulo(this.documentorepo.getDocumento("Teste")));
		String[] exibeVisao = this.visaocontroller.exibirVisao(0);
		assertEquals("3. Testando", exibeVisao[0]);
		assertEquals("3. Testando mais uma vez", exibeVisao[1]);
		assertEquals(2, exibeVisao.length);
	}
}