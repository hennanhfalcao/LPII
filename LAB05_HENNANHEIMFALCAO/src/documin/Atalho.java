package documin;

import java.util.ArrayList;

/**
 * Classe responsável por gerenciar as informações acerca do elemento do tipo
 * Atalho
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class Atalho extends Elemento {
	/**
	 * Os atributos a seguir representam respectivamente o documento que receberá o
	 * elemnto do tipo atalho e o documento que será referenciado, ou seja, terá um
	 * atalho em outro documento.
	 */
	private Documento documento;
	private Documento referencia;

	/**
	 * Construtor responsável por inicializar um elemento do tipo Atalho
	 * 
	 * @param documento  - Documento que receberá um atalho
	 * @param referencia - Documento que será referenciado.
	 */
	public Atalho(Documento documento, Documento referencia) {
		super(referencia.calcMediaPrioridade(), referencia.getTitulo());
		this.documento = documento;
		this.referencia = referencia;
	}

	/**
	 * Método responsável por retornar a representação resumida do elemento do tipo
	 * atalho. Apenas os elementos de prioridade 4 ou 5 são concatenados.
	 * 
	 * @return retorna uma String contendo a representação resumida do elemento do
	 *         tipo Atalho.
	 */
	@Override
	public String repResumida() {
		ArrayList<Elemento> elementos = this.referencia.getElementos();
		String strfinal = "";
		for (Elemento elemento : elementos) {
			if (elemento.getPrioridade() == 4 || elemento.getPrioridade() == 5) {
				strfinal += elemento.repResumida() + "\n";
			}
		}
		return strfinal;
	}

	/**
	 * Método responsável por retornar a representação completa de um elemento do
	 * tipo Atalho. Apenas os elementos de prioridade 4 ou 5 são concatenados.
	 * 
	 * @return retorna uma String contendo a representação completa do elemento do
	 *         tipo Atalho.
	 */
	@Override
	public String repCompleta() {
		ArrayList<Elemento> elementos = this.referencia.getElementos();
		String strfinal = "";
		for (Elemento elemento : elementos) {
			if (elemento.getPrioridade() == 4 || elemento.getPrioridade() == 5) {
				strfinal += elemento.repCompleta() + "\n";
			}
		}
		return strfinal;
	}

}
