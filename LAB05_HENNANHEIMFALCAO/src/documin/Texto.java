package documin;

/**
 * Classe responsável por gerenciar as informações acerca do elemento do tipo
 * Texto.
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class Texto extends Elemento {
	/**
	 * Construtor responsável por inicializar um elemento do tipo Texto.
	 * 
	 * @param prioridade - inteiro que armazena a prioridade do elemento do tipo
	 *                   Texto.
	 * @param valor      - String que armazena o conteúdo do elemento do tipo Texto.
	 */
	public Texto(int prioridade, String valor) {
		super(prioridade, valor);
	}
}
