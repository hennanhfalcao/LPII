package documin;

import java.util.ArrayList;

/**
 * Classe responsável por gerenciar informações acerca das visões do tipo
 * Resumida
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class Resumida extends Visao {
	/**
	 * Construtor responsável por inicializar uma Visão Resumida
	 * 
	 * @param documento - Documento que será representado na Visão Resumida
	 */
	public Resumida(Documento documento) {
		super(documento);
	}

	/**
	 * Método responsável por exibir a visão do tipo resumida.
	 * 
	 * @return retorna um array de Strings contendo os elementos do documento a ser
	 *         representado e suas respectivas representações resumidas.
	 */
	@Override
	public String[] exibirVisao() {
		ArrayList<String> visaoresumida = new ArrayList<>();

		for (Elemento elemento : documento.getElementos()) {
			visaoresumida.add(elemento.repResumida());
		}

		return visaoresumida.toArray(new String[0]);
	}

}
