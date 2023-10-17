package documin;

public class Facade {

	private DocumentoController documentoController;
	private VisaoController visaoController;

	public Facade() {
		this.documentoController = new DocumentoController();
	}

	public boolean criarDocumento(String titulo) {

		return this.documentoController.criarDocumento(titulo);
	}

	public void removeDocumento(String titulo) {
		this.documentoController.removeDocumento(titulo);
	}

	public int contaElementos(String titulo) {
		return this.documentoController.contaElementos(titulo);
	}

	public String[] exibeDocumento(String titulo) {
		return this.documentoController.exibeDocumento(titulo);
	}

	public int criaTexto(String tituloDoc, String valor, int prioridade) throws Exception {
		return this.documentoController.criaTexto(tituloDoc, valor, prioridade);
	}

	public int criaTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel)
			throws Exception {
		return this.documentoController.criaTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
	}

	public int criaLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista)
			throws Exception {
		return this.documentoController.criaLista(tituloDoc, valorLista, prioridade, separador, charLista);
	}

	public int criaTermos(String tituloDoc, String valor, int prioridade, String separador, String ordem)
			throws Exception {
		return this.documentoController.criaTermos(tituloDoc, valor, prioridade, separador, ordem);
	}

	public String pegarRepCompleta(String tituloDoc, int elementoPosicao) {
		return this.documentoController.pegarRepCompleta(tituloDoc, elementoPosicao);
	}

	public String pegarRepResumida(String tituloDoc, int elementoPosicao) {
		return this.documentoController.pegarRepResumida(tituloDoc, elementoPosicao);
	}

	public void moveParaCima(String tituloDoc, int posicao) {
		this.documentoController.moveParaCima(tituloDoc, posicao);
	}

	public void moveParaBaixo(String tituloDoc, int posicao) {
		this.documentoController.moveParaBaixo(tituloDoc, posicao);
	}

	public int criaAtalho(String tituloDoc, String documentoRef) throws Exception {
		return this.documentoController.criaAtalho(tituloDoc, documentoRef);
	}

	public int criaVisaoResumida(String tituloDoc) throws Exception {
		return this.visaoController.criarVisaoResumida(this.documentoController.getDocumento(tituloDoc));
	}

	public int criaVisaoPrioritaria(String tituloDoc, int prioridade) throws Exception {
		return this.visaoController.criarVisaoPrioritaria(this.documentoController.getDocumento(tituloDoc), prioridade);
	}

	public int criaVisaoTitulo(String tituloDoc) throws Exception {
		return this.visaoController.criarVisaoTitulo(this.documentoController.getDocumento(tituloDoc));
	}

	public int criaVisaoCompleta(String tituloDoc) throws Exception {
		return this.visaoController.criarVisaoCompleta(this.documentoController.getDocumento(tituloDoc));
	}
	public String[] exibirVisao(int id) {
		return this.visaoController.exibirVisao(id);
	}
}
