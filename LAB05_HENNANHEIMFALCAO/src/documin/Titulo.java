package documin;

/**
 * Classe responsável por gerenciar as informações acerca do elemento do tipo
 * Título.
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class Titulo extends Elemento {
	/**
	 * Os atributos a seguir representam, respectivamente, um inteiro contendo o
	 * nível do elemento e um boolean que representa se o elemento pode ou não pode
	 * ser linkável.
	 */
	private int nivel;
	private boolean linkavel;

	/**
	 * Construtor responsável por inicializar um elemento do tipo Título
	 * 
	 * @param prioridade - inteiro contendo a prioridade do elemento do tipo Título
	 * @param valor      - uma String contendo o conteúdo do elemento do tipo Título
	 * @param nivel      - um inteiro contendo o nível do elemento do tipo Título.
	 * @param linkavel   - boolean que representa se o elemento pode ou não pode ser
	 *                   linkável. True = pode, False = não pode.
	 */
	public Titulo(int prioridade, String valor, int nivel, boolean linkavel) {
		super(prioridade, valor);
		this.nivel = nivel;
		this.linkavel = linkavel;
	}

	/**
	 * Método responsável por gerar a representação resumida dos elementos do tipo
	 * Título
	 * 
	 * @return retorna uma String contendo a representação resumida do elemento do
	 *         tipo Título.
	 */
	@Override
	public String repResumida() {
		return this.nivel + ". " + this.valor;
	}

	/**
	 * Método responsável por gerar a representação completa dos elementos do tipo
	 * Título.
	 * 
	 * @return retorna uma String contendo a representação completa do elemento do
	 *         tipo Título.
	 */
	@Override
	public String repCompleta() {
		if (this.linkavel) {
			String link = " " + this.nivel + "-" + this.valor.toUpperCase().replaceAll("\\s", "");
			return this.nivel + ". " + this.valor + " --" + link;
		} else {
			return repResumida();
		}
	}
}
