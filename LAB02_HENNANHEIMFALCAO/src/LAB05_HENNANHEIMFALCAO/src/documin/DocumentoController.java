package documin;

/**
 * Classe que representa o controlador de documentos do sistema DocuMin.
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class DocumentoController {
	/**
	 * O atributo a seguir representa o repositório de documentos.
	 */
	private DocumentoRepo documentos;

	/**
	 * Construtor responsável por inicializar o controlador de documentos.
	 */
	public DocumentoController() {
		this.documentos = new DocumentoRepo();
	}

	/**
	 * Método responsável pela criação de um documento sem restrição de tamanho.
	 * 
	 * @param titulo - String contendo o título do documento.
	 * @return retorna true, caso o documento tenha sido criado com sucesso, ou
	 *         false, caso contrário.
	 */
	public boolean criarDocumento(String titulo) {
		return this.documentos.criaDocumento(titulo);
	}

	/**
	 * Método responsável por criar um documento com restrição de tamanho.
	 * 
	 * @param titulo  - String contendo o título do documento.
	 * @param tamanho - Inteiro contendo a quantidade máxima de elementos que
	 *                poderão ser adicionados ao documento.
	 * @return retorna true, caso o documento tenha sido criado com sucesso, ou
	 *         false, caso contrário.
	 */
	public boolean criarDocumento(String titulo, int tamanho) {
		return this.documentos.criaDocumento(titulo, tamanho);
	}

	/**
	 * Método responsável por remover um documento do sistema.
	 * 
	 * @param titulo - String contendo o título do documento a ser removido.
	 */
	public void removeDocumento(String titulo) {
		this.documentos.removeDocumento(titulo);
	}

	/**
	 * Método responsável por contar elementos em um documento.
	 * 
	 * @param titulo - String contendo o título do documento a se contabilizar os
	 *               elementos.
	 * @return retorna um inteiro contendo a quantidade de elementos do documento.
	 */
	public int contaElementos(String titulo) {
		return this.documentos.contaElementos(titulo);
	}

	/**
	 * Método responsável por exibir um documento.
	 * 
	 * @param titulo - String contendo o título do documento.
	 * @return retorna um Array de Strings contendo os elementos do documento.
	 */
	public String[] exibeDocumento(String titulo) {
		return this.documentos.exibeDocumento(titulo);
	}

	/**
	 * Método responsável por criar e adicionar um elemento do tipo texto a um
	 * documento.
	 * 
	 * @param tituloDoc  - String contendo o título do documento ao qual o elemento
	 *                   será adicionado.
	 * @param valor      - String contendo o conteúdo do elemento do tipo Texto.
	 * @param prioridade - Inteiro contendo a prioridade do elemento do tipo Texto.
	 * @return retorna um inteiro contendo a posição do elemento no ArrayList de
	 *         elementos.
	 * @throws Exception - lançada quando o tamanho máximo do documento foi
	 *                   atingido.
	 */
	public int criaTexto(String tituloDoc, String valor, int prioridade) throws Exception {
		return this.documentos.criaTexto(tituloDoc, valor, prioridade);
	}

	/**
	 * Método responsável por criar e adicionar um elemento do tipo Título a um
	 * documento.
	 * 
	 * @param tituloDoc  - String contendo o título do documento ao qual o elemento
	 *                   será adicionado.
	 * @param valor      - String contendo o conteúdo do elemento do tipo Título.
	 * @param prioridade - Inteiro contendo a prioridade do elemento do tipo Título.
	 * @param nivel      - Inteiro contendo o nível do elemento do tipo Título.
	 * @param linkavel   - boolean que representa se o elemento pode ou não pode ser
	 *                   linkável. True = pode, False = não pode.
	 * @return retorna um inteiro contendo a posição do elemento no ArrayList de
	 *         elementos.
	 * @throws Exception - lançada quando a quantidade de elementos máxima já foi
	 *                   atingida.
	 */
	public int criaTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel)
			throws Exception {
		return this.documentos.criaTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
	}

	/**
	 * Método responsável por criar e adicionar um elemento do tipo Lista a um
	 * documento.
	 * 
	 * @param tituloDoc  - String contendo o título do documento ao qual o elemento
	 *                   será adicionado.
	 * @param valorLista - uma String que armazena o conteúdo do elemento do tipo
	 *                   Lista.
	 * @param prioridade - um inteiro que armazena a prioridade do elemento do tipo
	 *                   Lista
	 * @param separador  - uma String que armazena o caractere responsável por
	 *                   separar os itens na sua representação textual.
	 * @param charLista- uma String que armazena o caractere responsável por pontuar
	 *                   os itens da lista.
	 * @return retorna um inteiro contendo a posição do elemento no ArrayList de
	 *         elementos.
	 * @throws Exception - lançada quando a quantidade de elementos máxima já foi
	 *                   atingida.
	 */
	public int criaLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista)
			throws Exception {
		return this.documentos.criaLista(tituloDoc, valorLista, prioridade, separador, charLista);
	}

	/**
	 * Método responsável por criar e adicionar um elemento do tipo Termos a um
	 * documento.
	 * 
	 * @param tituloDoc  - String contendo o título do documento ao qual o elemento
	 *                   será adicionado.
	 * @param valor      - uma String que armazena o conteúdo do elemento do tipo
	 *                   Termos.
	 * @param prioridade - um inteiro que armazena a prioridade do elemento do tipo
	 *                   Termos
	 * @param separador  - uma String que armazena o caractere responsável por
	 *                   separar os termos na sua representação textual.
	 * @param ordem      - uma String que armazena a ordem a qual os elementos do
	 *                   tipo Termos serão ordenados. Por meio do Switch essa
	 *                   informação é traduzida para o tipo constante enum e a ordem
	 *                   dos termos é estabelecida.
	 * @return retorna um inteiro contendo a posição do elemento no ArrayList de
	 *         elementos.
	 * @throws Exception - lançada quando a quantidade de elementos máxima já foi
	 *                   atingida.
	 */
	public int criaTermos(String tituloDoc, String valor, int prioridade, String separador, String ordem)
			throws Exception {
		return this.documentos.criaTermos(tituloDoc, valor, prioridade, separador, ordem);
	}

	/**
	 * Método responsável por pegar a representação completa de um determinado
	 * elemento.
	 * 
	 * @param tituloDoc       - String contendo o título do documento o qual será
	 *                        buscada a representação completa do elemento.
	 * @param elementoPosicao - Inteiro contendo a posição do elemento de interesse.
	 * @return retorna uma String contendo a representação completa do elemento de
	 *         interesse do usuário.
	 */
	public String pegarRepCompleta(String tituloDoc, int elementoPosicao) {
		return this.documentos.pegarRepCompleta(tituloDoc, elementoPosicao);
	}

	/**
	 * Método responsável por pegar a representação resumida de um determinado
	 * elemento.
	 * 
	 * @param tituloDoc       - String contendo o título do documento o qual será
	 *                        buscada a representação resmuida do elemento de
	 *                        interesse.
	 * @param elementoPosicao - Inteiro contendo a posição do elemento de interesse.
	 * @return retorna uma String contendo a representação resumida do elemento de
	 *         interesse do usuário.
	 */
	public String pegarRepResumida(String tituloDoc, int elementoPosicao) {
		return this.documentos.pegarRepResumida(tituloDoc, elementoPosicao);
	}

	/**
	 * Método responsável por mover um determinado elemento para cima no ArrayList
	 * de elementos.
	 * 
	 * @param posicao - inteiro contendo a posição do elemento a ser movido para
	 *                cima.
	 */
	public void moveParaCima(String tituloDoc, int posicao) {
		this.documentos.moveParaCima(tituloDoc, posicao);
	}

	/**
	 * Método responsável por mover um determinado elemento para baixo no ArrayList
	 * de elementos.
	 * 
	 * @param posicao - inteiro contendo a posição do elemento a ser movido para
	 *                baixo.
	 */
	public void moveParaBaixo(String tituloDoc, int posicao) {
		this.documentos.moveParaBaixo(tituloDoc, posicao);
	}

	/**
	 * Método responsável por criar um atalho e adicionar este elemento ao ArrayList
	 * de elementos.
	 * 
	 * @param tituloDoc    - String contendo o título do documento a receber um
	 *                     atalho.
	 * @param documentoRef - String contendo o título do documento a ser
	 *                     referenciado em um outro documento.
	 * @return retorna a posição do elemento atalho no ArrayList de elementos.
	 * @throws Exception - lançada caso o tamanho máximo de elementos do documento
	 *                   tenha sido atingido.
	 */
	public int criaAtalho(String tituloDoc, String documentoRef) throws Exception {
		return this.documentos.criaAtalho(tituloDoc, documentoRef);
	}

	/**
	 * Método responsável por retornar um documento.
	 * 
	 * @param tituloDoc - String contendo o título do documento que se deseja
	 *                  acessar
	 * @return retorna um documento.
	 * @throws Exception lançada quando o documento não está cadastrado no sistema.
	 */
	public Documento getDocumento(String tituloDoc) throws Exception {
		return this.documentos.getDocumento(tituloDoc);
	}

}
