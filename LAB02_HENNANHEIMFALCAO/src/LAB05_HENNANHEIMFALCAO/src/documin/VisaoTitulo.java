package documin;

import java.util.ArrayList;

/**
 * Classe responsável por gerenciar informações acerca das visões do tipo Título
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class VisaoTitulo extends Visao {
	/**
	 * Construtor responsável por inicializar uma visão do tipo Título.
	 * 
	 * @param documento - Documento que será representado na visão do tipo Título.
	 */
	public VisaoTitulo(Documento documento) {
		super(documento);
	}

	/**
	 * Método responsável por exibir a visão do tipo Título. Só serão representados
	 * nessa visão os elementos que forem do tipo título.
	 * @return retorna um Array de Strings 
	 */
	@Override
	public String[] exibirVisao() {
		ArrayList<String> visaotitulo = new ArrayList<>();
		for (Elemento elemento : documento.getElementos()) {
			if (elemento instanceof Titulo) {
				visaotitulo.add(elemento.repResumida());
			}
		}
		return visaotitulo.toArray(new String[0]);
	}

}
