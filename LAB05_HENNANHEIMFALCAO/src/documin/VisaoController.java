package documin;

import java.util.ArrayList;

/**
 * Classe referente ao controlador de Visões do sistema DocuMin.
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class VisaoController {
	/**
	 * O seguinte atributo representa um ArrayList do tipo Visão.
	 */
	private ArrayList<Visao> visao = new ArrayList<>();

	/**
	 * Construtor responsável por inicializar o controlador de visões.
	 */
	public VisaoController() {

	}

	/**
	 * Método responsável por criar uma visão do tipo Completa
	 * 
	 * @param documento - Documento que será representado na visão completa
	 * @return retorna um inteiro representando a posição da visão no ArrayList.
	 */
	public int criarVisaoCompleta(Documento documento) {
		visao.add(new Completa(documento));
		return visao.size() - 1;
	}

	/**
	 * Método responsável por criar uma visão do tipo Resumida.
	 * 
	 * @param documento - Documento que será representado na visão resumida.
	 * @return retorna um inteiro representando a posição da visão no ArrayList.
	 */
	public int criarVisaoResumida(Documento documento) {
		visao.add(new Resumida(documento));
		return visao.size() - 1;
	}

	/**
	 * Método responsável por criar uma visão do tipo Prioritária.
	 * 
	 * @param documento  - Documento que será representado na visão prioritária.
	 * @param prioridade - inteiro que armazena a prioridade que será usada como
	 *                   parametro para gerar a visão do elementos que tiverem
	 *                   prioridade igual ou maior que esta.
	 * @return retorna um inteiro representando a posição da visão no ArrayList.
	 */
	public int criarVisaoPrioritaria(Documento documento, int prioridade) {
		visao.add(new Prioritaria(documento, prioridade));
		return visao.size() - 1;
	}

	/**
	 * * Método responsável por criar uma visão do tipo Título.
	 * 
	 * @param documento - Documento que será representado na visão título.
	 * @return retorna um inteiro representando a posição da visão no ArrayList.
	 */
	public int criarVisaoTitulo(Documento documento) {
		visao.add(new VisaoTitulo(documento));
		return visao.size() - 1;
	}

	/**
	 * Método responsável por exibir uma visão.
	 * 
	 * @param id - inteiro que armazena o indentificador da visão que consiste no
	 *           índice dela no ArrayList.
	 * @return retorna um Array de Strings contendo a visão.
	 */
	public String[] exibirVisao(int id) {
		return visao.get(id).exibirVisao();
	}
	public ArrayList<Visao> getVisao() {
		return visao;
	}
}
