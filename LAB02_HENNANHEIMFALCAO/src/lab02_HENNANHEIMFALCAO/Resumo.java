package lab02_HENNANHEIMFALCAO;

/** 
 * Essa classe tem como responsabilidade atuar no encapsulamento da informação, armazenando as informações referentes ao array de resumos (tema e resumo me si)
 * @author HENNAN HEIM FALCÃO - MATRÍCULA - 122110048
 *
 */

public class Resumo {
	private String tema;
	private String resumo;
	
	/**
	 * Construor responsável por construir um array de resumos contendo o tema, e o resumo, efetivamente.
	 * @param constrói o tema do resumo (String)
	 * @param constrói o resumo (String)
	 */
	
	public Resumo(String tema, String resumo) {
		this.tema = tema;
		this.resumo = resumo;
	}
	
	/**
	 * método responsável por retornar uma string no formato "Tema: Resumo";
	 */
	
	public String toString() {
		return this.tema+": "+this.resumo;
	}
	
	public String getTema() {
		return this.tema;
	}
	
	public String getResumo() {
		return this.resumo;
	}
}
