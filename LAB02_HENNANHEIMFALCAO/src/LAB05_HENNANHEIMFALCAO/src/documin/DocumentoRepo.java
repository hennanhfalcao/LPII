package documin;

/**
 * Classe que representa o repositório dos documentos do sistema DocuMin.
 * 
 * @author HENNAN HEIM FALCÃO - 122110048 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoRepo {

	/**
	 * Os atributos a seguir são, respectivamente: documentos - HashMap de
	 * documentos - elementos - ArrayList de elementos que estão contidos nos
	 * documentos.
	 */
	private HashMap<String, Documento> documentos;

	/**
	 * Construtor responsável por inicializar os atributos expostos anteriormente.
	 */
	public DocumentoRepo() {
		this.documentos = new HashMap<>();
	}

	/**
	 * Método responsável por criar um documento, sem restrição de quantidade de
	 * elementos, caso o título do documento esteja vazio ou apenas com espaços,
	 * lança-se uma exceção "IllegalArgumentException".
	 * 
	 * @param titulo - String contendo o título do documento.
	 * @return Retorna true, caso o documento tenha sido criado com sucesso, ou
	 *         false caso o documento já exista no sistema.
	 */
	public boolean criaDocumento(String titulo) {
		Documento documento = new Documento(titulo);
		if (titulo.isBlank()) {
			throw new IllegalArgumentException("TÍTULO VAZIO!");
		} else if (documentos.containsKey(titulo)) {
			return false;
		} else {
			this.documentos.put(titulo, documento);
			return true;
		}
	}

	/**
	 * Método responsável por criar um documento, com restrição de quantidade de
	 * elementos, caso o título do documento esteja vazio ou apenas com espaços,
	 * lança-se uma exceção "IllegalArgumentException".
	 * 
	 * @param titulo        - String contendo o título do documento
	 * @param tamanhoMaximo - inteiro contendo a quantidade máxima de elementos
	 *                      comportada pelo documento
	 * @return Retorna true, caso o documento tenha sido criado com sucesso, ou
	 *         false caso o documento já exista no sistema.
	 */
	public boolean criaDocumento(String titulo, int tamanhoMaximo) {
		Documento documento = new Documento(titulo, tamanhoMaximo);
		if (titulo.isBlank()) {
			throw new IllegalArgumentException("TÍTULO VAZIO!");
		} else if (documentos.containsKey(titulo)) {
			return false;
		} else {
			this.documentos.put(titulo, documento);
			return true;
		}
	}

	/**
	 * Método responsável por remover um documento do sistema. Caso o documento que
	 * se deseja excluir não esteja no sistema, lança-se uma exceção
	 * "NoSuchElementException"
	 * 
	 * @param titulo - String contendo o título do documento.
	 */
	public void removeDocumento(String titulo) {
		if (titulo.isBlank()) {
			throw new IllegalArgumentException("TÍTULO VAZIO!");
		}
		if (this.documentos.get(titulo) == null) {
			throw new NoSuchElementException("DOCUMENTO NÃO EXISTE!");
		}
		this.documentos.remove(titulo);
	}

	/**
	 * Método responsável por contabilizar a quantidade de elementos que está
	 * contido em um documento, caso o título do documento esteja vazio ou apenas
	 * com espaços, lança-se uma exceção "IllegalArgumentException".
	 * 
	 * @param titulo - String contendo o título do documento que se deseja
	 *               contabilizar os elementos.
	 * @return retorna um inteiro com a quantidade de elementos presente no
	 *         documento.
	 */
	public int contaElementos(String titulo) {
		if (titulo.isBlank()) {
			throw new IllegalArgumentException("DOCUMENTO NÃO EXISTE!");
		}
		if (this.documentos.get(titulo) == null) {
			throw new NoSuchElementException("DOCUMENTO NÃO EXISTE!");
		}
		return this.documentos.get(titulo).getElementos().size();
	}

	/**
	 * Método responsável por exibir os elementos de um documento. Caso o título
	 * esteja vazio ou contenha apenas espaços, ou o documento pesquisado não esteja
	 * cadastrado no sistema, lança-se uma exceção "IllegalArgumentException"
	 * 
	 * @param titulo - String contendo o título do documento.
	 * @return retorna um Array de String com os elementos presentes no documento.
	 */
	public String[] exibeDocumento(String titulo) {
		if (titulo.isBlank()) {
			throw new IllegalArgumentException("DOCUMENTO NÃO EXISTE!");
		}
		if (this.documentos.get(titulo) == null) {
			throw new NoSuchElementException("DOCUMENTO NÃO EXISTE!");
		}
		ArrayList<String> elementos = new ArrayList<>();
		for (Elemento elemento : this.documentos.get(titulo).getElementos()) {
			elementos.add(elemento.repCompleta());
		}
		String[] elementos2 = elementos.toArray(new String[0]);
		return elementos2;
	}

	/**
	 * Método responsável por mover um elemento uma posição acima no ArrayList de
	 * elementos. Só é valido para os elementos que estão abaixo da posição 0. Caso
	 * o índice passado esteja abaixo de 0 ou acima da quantidade de elementos
	 * presente no ArrayList, lança-se a exceção "IndexOutOfBoundsException".
	 * 
	 * @param posicao - inteiro contendo a posição do elemento que se deseja mover
	 *                para cima
	 */
	public void moveParaCima(String tituloDoc, int posicao) {
		this.documentos.get(tituloDoc).moveParaCima(posicao);
	}

	/**
	 * Método responsável por mover um elemento uma posição abaixo no ArrayList de
	 * elementos. Só é valido para os elementos que estão abaixo da última posição.
	 * Caso o índice passado esteja abaixo de 0 ou acima da quantidade de elementos
	 * presente no ArrayList, lança-se a exceção "IndexOutOfBoundsException".
	 * 
	 * @param posicao - inteiro contendo a posição do elemento que se deseja mover
	 *                para baixo
	 */
	public void moveParaBaixo(String tituloDoc, int posicao) {
		this.documentos.get(tituloDoc).moveParaBaixo(posicao);
	}

	/**
	 * Método responsável por criar um elemento do tipo texto. As exceções descritas
	 * anteriormente são válidas para esse método. Caso o tamanho máximo de
	 * elementos do documento já tenha sido atingido, lança-se a exceção contendo a
	 * mensagem "TAMANHO MÁXIMO ATINGIDO".
	 * 
	 * @param tituloDoc  - String contendo o nome do documento que se deseja
	 *                   adicionar um elemento do tipo texto.
	 * @param valor      - String contendo o conteúdo do elemento do tipo texto.
	 * @param prioridade - inteiro contendo a prioridade do elemento do tipo texto.
	 * @return retorna um inteiro contendo a posição do elemento adicionado no
	 *         ArrayList de elementos.
	 * @throws Exception - lançada quando o tamanho máximo do documento foi
	 *                   atingido.
	 */
	public int criaTexto(String tituloDoc, String valor, int prioridade) throws Exception {
		if (!this.documentos.containsKey(tituloDoc)) {
			throw new IllegalArgumentException("DOCUMENTO NÃO EXISTE!");
		}
		if (this.documentos.get(tituloDoc) == null) {
			throw new NoSuchElementException();
		}
		if (contaElementos(tituloDoc) < this.documentos.get(tituloDoc).getTamanho()) {
			this.documentos.get(tituloDoc).getElementos().add(new Texto(prioridade, valor));
			return this.documentos.get(tituloDoc).getElementos().size() - 1;
		} else {
			throw new Exception("TAMANHO MÁXIMO ATINGIDO!");
		}
	}

	/**
	 * Método responsável por criar um elemento do tipo Título. As exceções
	 * descritas anteriormente são válidas para esse método. Caso o tamanho máximo
	 * de elementos do documento já tenha sido atingido, lança-se a exceção contendo
	 * a mensagem "TAMANHO MÁXIMO ATINGIDO".
	 * 
	 * @param tituloDoc  - String contendo o nome do documento que se deseja
	 *                   adicionar um elemento do tipo título.
	 * @param valor      - String contendo o conteúdo do elemento do tipo título.
	 * @param prioridade - inteiro contendo a prioridade do elemento do tipo título.
	 * @param nivel      - inteiro contendo o nível do elemento do tipo Título
	 * @param linkavel   - boolean - se o elemento do tipo título é linkável ou não.
	 * @return retorna um inteiro contendo a posição do elemento do tipo título
	 *         adicionado.
	 * @throws Exception - lançada quando o tamanho máximo do documento foi
	 *                   atingido.
	 */
	public int criaTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel)
			throws Exception {
		int posicao = 0;
		if (!this.documentos.containsKey(tituloDoc)) {
			throw new IllegalArgumentException("DOCUMENTO NÃO EXISTE!");
		}
		if (this.documentos.get(tituloDoc) == null) {
			throw new NoSuchElementException();
		}
		if (contaElementos(tituloDoc) < this.documentos.get(tituloDoc).getTamanho()) {
			Titulo titulo = new Titulo(prioridade, valor, nivel, linkavel);
			this.documentos.get(tituloDoc).getElementos().add(titulo);
			posicao = this.documentos.get(tituloDoc).getElementos().size() - 1;
			return posicao;
		}
		throw new Exception("TAMANHO MÁXIMO ATINGIDO!");
	}

	/**
	 * Método responsável por criar um elemento do tipo Lista. As exceções descritas
	 * anteriormente são válidas para esse método. Caso o tamanho máximo de
	 * elementos do documento já tenha sido atingido, lança-se a exceção contendo a
	 * mensagem "TAMANHO MÁXIMO ATINGIDO".
	 * 
	 * @param tituloDoc  - String contendo o nome do documento que se deseja
	 *                   adicionar um elemento do tipo Lista.
	 * @param valorLista - String contendo o conteúdo do elemento do tipo Lista.
	 * @param prioridade - inteiro contendo a prioridade do elemento tipo Lista.
	 * @param separador  - String contendo o separador dos conteúdos do elemento
	 *                   tipo Lista.
	 * @param charLista  - String contendo o caractere que pontua cada conteúdo do
	 *                   elemento tipo Lista.
	 * @return retorna um inteiro com a posição do elemento do tipo Lista
	 *         adicionado.
	 * @throws Exception - lançada quando o tamanho máximo do documento foi
	 *                   atingido.
	 */
	public int criaLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista)
			throws Exception {
		int posicao = 0;
		if (!this.documentos.containsKey(tituloDoc)) {
			throw new IllegalArgumentException("DOCUMENTO NÃO EXISTE!");
		}
		if (this.documentos.get(tituloDoc) == null) {
			throw new NoSuchElementException();
		}
		if (contaElementos(tituloDoc) < this.documentos.get(tituloDoc).getTamanho()) {
			Lista lista = new Lista(prioridade, valorLista, separador, charLista);
			this.documentos.get(tituloDoc).getElementos().add(lista);
			posicao = this.documentos.get(tituloDoc).getElementos().size() - 1;
			return posicao;
		}
		throw new Exception("TAMANHO MÁXIMO ATINGIDO!");
	}

	/**
	 * Método responsável por criar um elemento do tipo Termos. As exceções
	 * descritas anteriormente são válidas para esse método. Caso o tamanho máximo
	 * de elementos do documento já tenha sido atingido, lança-se a exceção contendo
	 * a mensagem "TAMANHO MÁXIMO ATINGIDO".
	 * 
	 * @param tituloDoc  - String contendo o nome do documento que se deseja
	 *                   adicionar um elemento do tipo Termos.
	 * @param valor      - String contendo o conteúdo do elemento do tipo Termos.
	 * @param prioridade - inteiro contendo a prioridade do elemento tipo Termos.
	 * @param separador  - String contendo o separador do conteúdo do elemento tipo
	 *                   Termos.
	 * @param ordem      - String contedo a ordem em que os termos serão
	 *                   organizados, podendo não ter ordem, serem ordenados em
	 *                   ordem alfabética ou pelo tamannho das palavras em ordem
	 *                   decrescente
	 * @return retorna um inteiro contendo a posição do elemento do tipo Termos
	 *         adicionado.
	 * @throws Exception- lançada quando o tamanho máximo do documento foi atingido.
	 */
	public int criaTermos(String tituloDoc, String valor, int prioridade, String separador, String ordem)
			throws Exception {
		int posicao = 0;
		if (!this.documentos.containsKey(tituloDoc)) {
			throw new IllegalArgumentException("DOCUMENTO NÃO EXISTE!");
		}
		if (this.documentos.get(tituloDoc) == null) {
			throw new NoSuchElementException();
		}
		if (contaElementos(tituloDoc) < this.documentos.get(tituloDoc).getTamanho()) {
			Termos termos = new Termos(prioridade, valor, separador, ordem);
			this.documentos.get(tituloDoc).getElementos().add(termos);
			posicao = this.documentos.get(tituloDoc).getElementos().size() - 1;
			return posicao;
		}
		throw new Exception("TAMANHO MÁXIMO ATINGIDO!");
	}

	/**
	 * Método responsável por pegar a representação completa de um elemento.
	 * 
	 * @param tituloDoc       - String contendo o título do documento.
	 * @param elementoPosicao - inteiro contendo a posição do elemento que se deseja
	 *                        pegar a representação completa.
	 * @return retorna uma String contendo a representação completa do elemento.
	 */
	public String pegarRepCompleta(String tituloDoc, int elementoPosicao) {
		if (!this.documentos.containsKey(tituloDoc)) {
			throw new IllegalArgumentException("DOCUMENTO NÃO EXISTE!");
		}
		if (this.documentos.get(tituloDoc) == null) {
			throw new NoSuchElementException();
		}
		if (elementoPosicao >= this.documentos.get(tituloDoc).getElementos().size() || elementoPosicao < 0) {
			throw new IndexOutOfBoundsException("ELEMENTO INVÁLIDO!");
		}
		return this.documentos.get(tituloDoc).getElementos().get(elementoPosicao).repCompleta();
	}

	/**
	 * Método responsável por pegar a representação resumida de um elemento.
	 * 
	 * @param tituloDoc       - String contendo o título do documento.
	 * @param elementoPosicao - inteiro contendo a posição do elemento que se deseja
	 *                        pegar a representação resumida
	 * @return retorna uma String contendo a representação resumida do elemento.
	 */
	public String pegarRepResumida(String tituloDoc, int elementoPosicao) {
		if (!this.documentos.containsKey(tituloDoc)) {
			throw new IllegalArgumentException("DOCUMENTO NÃO EXISTE!");
		}
		if (this.documentos.get(tituloDoc) == null) {
			throw new NoSuchElementException();
		}
		if (elementoPosicao >= this.documentos.get(tituloDoc).getElementos().size() || elementoPosicao < 0) {
			throw new IndexOutOfBoundsException("ELEMENTO INVÁLIDO!");
		}
		return this.documentos.get(tituloDoc).getElementos().get(elementoPosicao).repResumida();
	}

	/**
	 * Método responsável por apagar um elemento de um documento
	 * 
	 * @param tituloDoc       - String contendo o título do documento
	 * @param elementoPosicao - inteiro contendo a posição do elemento que se deseja
	 *                        apagar.
	 * @return retorna true, caso o elemento tenha sido apagado com sucesso, ou
	 *         false, caso não tenha sido removido com sucesso.
	 */
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		if (!this.documentos.containsKey(tituloDoc)) {
			throw new IllegalArgumentException("DOCUMENTO NÃO EXISTE!");
		}
		if (this.documentos.get(tituloDoc) == null) {
			throw new NoSuchElementException();
		}
		if (elementoPosicao >= this.documentos.get(tituloDoc).getElementos().size() || elementoPosicao < 0) {
			throw new IndexOutOfBoundsException("ELEMENTO INVÁLIDO!");
		}
		int aux = this.documentos.get(tituloDoc).getElementos().size();
		this.documentos.get(tituloDoc).getElementos().remove(elementoPosicao);
		if (this.documentos.get(tituloDoc).getElementos().size() < aux) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método responsável por criar um elemento do tipo Atalho
	 * 
	 * @param tituloDoc             - String contendo o título do documento que
	 *                              receberá o elemento do tipo atalho.
	 * @param tituloDocReferenciado - String contendo o título do documento que será
	 *                              referenciado no atalho.
	 * @return retorna um inteiro contendo a posição do elemento do tipo atalho
	 *         adicionado.
	 * @throws Exception - lançada caso o tamanho máximo de elementos do documento
	 *                   tenha sido atingido.
	 */
	public int criaAtalho(String tituloDoc, String tituloDocReferenciado) throws Exception {
		if (contaElementos(tituloDoc) < this.documentos.get(tituloDoc).getTamanho()) {
			return this.documentos.get(tituloDoc).criaAtalho(this.documentos.get(tituloDocReferenciado));
		}
		throw new Exception("TAMANHO MÁXIMO ATINGIDO!");
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
		if (this.documentos.containsKey(tituloDoc)) {
			return this.documentos.get(tituloDoc);
		}
		throw new Exception("DOCUMENTO NÃO EXISTE!");
	}

	public HashMap<String, Documento> getDocumentos() {
		return documentos;
	}
}
