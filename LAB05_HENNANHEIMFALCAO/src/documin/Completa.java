package documin;

import java.util.ArrayList;

/**
 * Classe responsável por gerenciar as informações acerca das visões do tipo
 * Completa
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class Completa extends Visao {
	/**
	 * Construtor resposável por inicializar uma Visão do tipo Completa
	 * 
	 * @param documento - Documento que será representado na Visão Completa.
	 */
	public Completa(Documento documento) {
		super(documento);
	}

	/**
	 * Método responsável por exibir a visão do tipo completa
	 * 
	 * @return retorna um array de Strings contendo os elementos do documento a ser
	 *         representado e suas respectivas representações completas
	 */
	@Override
	public String[] exibirVisao() {

		ArrayList<String> visaocompleta = new ArrayList<>();

		for (Elemento elemento : documento.getElementos()) {
			visaocompleta.add(elemento.repCompleta());
		}
		return visaocompleta.toArray(new String[0]);
	}

}
