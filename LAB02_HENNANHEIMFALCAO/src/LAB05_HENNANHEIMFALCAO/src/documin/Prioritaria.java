package documin;

import java.util.ArrayList;

/**
 * Classe responsável por gerenciar informações acerca das visões do tipo
 * Prioritária
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class Prioritaria extends Visao {
	/**
	 * O atributo a seguir armazena um inteiro contendo um valor de prioridade que
	 * será usado como referência para exibir os elementos que possuam prioridade
	 * maior que a armazenada neste atributo.
	 */
	private int prioridade;

	/**
	 * Construtor responsável por inicializar uma Visão Prioritária
	 * 
	 * @param documento  - Documento que será representado na Visão Prioritária
	 * @param prioridade - Inteiro contendo a prioridade que será usada como
	 *                   parametro para exibição dos elementos.
	 */
	public Prioritaria(Documento documento, int prioridade) {
		super(documento);
		this.prioridade = prioridade;
	}

	/**
	 * Método responsável por exibir a visão do tipo prioritária. Só serão
	 * representados nessa visão os elementos que possuírem prioridade igual ou
	 * maior àquela passada como parametro pelo usuário.
	 * @return um Array de Strings contendo as representações completas dos elementos que atenderem ao 
	 */
	@Override
	public String[] exibirVisao() {
		ArrayList<String> visaoprioritaria = new ArrayList<>();
		for (Elemento elemento : documento.getElementos()) {
			if (elemento.getPrioridade() >= this.prioridade) {
				visaoprioritaria.add(elemento.repCompleta());
			}
		}
		return visaoprioritaria.toArray(new String[0]);
	}

}
