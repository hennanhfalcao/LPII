package documin;

/**
 * Classe abstrata responsável por armazenar as informações acerca dos Elementos
 * do sistema. Esta classe representa o supertipo Elemento, que são subdivididos
 * em Texto, Título, Lista, Termos e Atalho.
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public abstract class Elemento {
	/**
	 * Os atributos a seguir representam respectivamente: um inteiro contendo a
	 * prioridade do elemento - uma String contendo o conteúdo do elemento.
	 */
	protected int prioridade;
	protected String valor;

	/**
	 * Construtor responsável por inicializar um elemento
	 * 
	 * @param prioridade - inteiro contendo a prioridade do elemento
	 * @param valor      - String contendo o conteúdo do elemento
	 */
	public Elemento(int prioridade, String valor) {
		this.prioridade = prioridade;
		this.valor = valor;
	}

	/**
	 * Método responsável por retornar um inteiro contendo a prioridade de um
	 * elemento.
	 * 
	 * @return retorna um inteiro contendo a prioridade do elemento.
	 */
	public int getPrioridade() {
		return this.prioridade;
	}

	/**
	 * Método responsável por retornar o conteúdo de um elemento
	 * 
	 * @return retorna uma String contendo o conteúdo de um elemento
	 */
	public String getValor() {
		return this.valor;
	}

	/**
	 * Método responsável por retornar a representação completa de um elemento.
	 * 
	 * @return retorna uma String contendo a representação completa de um elemento.
	 */
	public String repCompleta() {
		return this.valor;
	}

	/**
	 * Método responsáevl por retornar a representação resumida de um elemento.
	 * 
	 * @return retorna uma String com a representação resumida de um elemento
	 */
	public String repResumida() {
		return this.valor;
	}
}