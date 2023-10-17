package documin;

/**
 * Classe abstrata responsável por gerenciar as informações acerca das visões de
 * um documento. Esta classe representa o supertipo Visão, que são subdivididos
 * em Visão Completa, Visão Resumida, Visão Prioritária e Visão Título.
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public abstract class Visao {
	/**
	 * O atributo a seguir representa o documento que será representado na visão.
	 */
	protected Documento documento;

	/**
	 * Construtor responsável por inicializar uma Visão.
	 * 
	 * @param documento - Documento que será representado na visão.
	 */
	public Visao(Documento documento) {
		this.documento = documento;
	}

	/**
	 * Método responsável por exibir uma visão de um documento
	 * 
	 * @return retorna um array de Strings contendo a visão de um documento.
	 */
	public abstract String[] exibirVisao();

}
