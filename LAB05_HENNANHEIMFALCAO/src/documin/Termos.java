package documin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Classe responsável por gerenciar as informações acerca do elemento do tipo
 * Termos
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class Termos extends Elemento {
	/**
	 * Os atributos a seguir representam, respectivamente, uma String contendo o
	 * separador utilizado na representação textual dos elementos do tipo Termos e a
	 * ordem que estes termos podem ser representados.
	 */
	private String separador;
	private Ordem ordem;

	/**
	 * Construtor responsável por inicializar um elemento do tipo Termos.
	 * 
	 * @param prioridade - um inteiro que armazena a prioridade do elemento do tipo
	 *                   Termos
	 * @param valor      - uma String que armazena o conteúdo do elemento do tipo
	 *                   Termos.
	 * @param separador  - uma String que armazena o caractere responsável por
	 *                   separar os termos na sua representação textual.
	 * @param ordem      - uma String que armazena a ordem a qual os elementos do
	 *                   tipo Termos serão ordenados. Por meio do Switch essa
	 *                   informação é traduzida para o tipo constante enum e a ordem
	 *                   dos termos é estabelecida. Caso o usuário digite uma ordem
	 *                   inválida, lança-se uma exceção "IllegalArgumentException".
	 */
	public Termos(int prioridade, String valor, String separador, String ordem) {
		super(prioridade, valor);
		this.separador = separador;

		switch (ordem) {

		case "ALFABETICA" -> {
			this.ordem = Ordem.ALFABETICA;
		}
		case "TAMANHO" -> {
			this.ordem = Ordem.TAMANHO;
		}
		case "NENHUM" -> {
			this.ordem = Ordem.NENHUM;
		}
		default -> {
			throw new IllegalArgumentException("ORDEM INVÁLIDA!");
		}
		}
	}

	/**
	 * Método responsável por ordenar os termos.
	 * 
	 * @param termos - Um array de strings contendo os termos a serem ordenados.
	 * @param ordem  - tipo constante Ordem que será utilizado para ordenar os
	 *               termos.
	 */
	private void ordenar(String[] termos, Ordem ordem) {
		switch (ordem) {
		case ALFABETICA: {
			Arrays.sort(termos);
		}
		case TAMANHO: {
			Arrays.sort(termos, Comparator.comparingInt(String::length).reversed());
		}
		default: {
		}
		}
	}

	/**
	 * Método responsável por gerar a representação resumida dos elementos do tipo
	 * Termos.
	 * 
	 * @return retorna uma String com a representação resumida do elemento do tipo
	 *         Termos.
	 */
	@Override
	public String repResumida() {
		ArrayList<String> termos2 = new ArrayList<>();

		String[] termos = this.valor.split(this.separador);

		for (int i = 0; i < termos.length; i++) {
			termos2.add(termos[i].trim());
		}

		String[] termosarray = termos2.toArray(new String[0]);

		String strfinal = "";
		ordenar(termosarray, this.ordem);
		for (int i = 0; i < termosarray.length; i++) {
			if (i == termosarray.length - 1) {
				strfinal += termosarray[i];
			} else {
				strfinal += termosarray[i] + " " + this.separador + " ";
			}
		}
		return strfinal;
	}

	/**
	 * Método responsável por gerar a representação completa dos elementos do tipo
	 * Termos.
	 * 
	 * @return retorna uma String contendo a quantidade de termos representados e
	 *         suas rescpectivas representações completas.
	 */
	@Override
	public String repCompleta() {
		ArrayList<String> termos2 = new ArrayList<>();

		String[] termos = this.valor.split(this.separador);

		for (int i = 0; i < termos.length; i++) {
			termos2.add(termos[i].trim());
		}

		String[] termosarray = termos2.toArray(new String[0]);

		String strfinal = "";
		ordenar(termosarray, this.ordem);
		strfinal = "Total de termos: " + termosarray.length + "\n" + "- ";
		for (int i = 0; i < termosarray.length; i++) {
			if (i == termosarray.length - 1) {
				strfinal += termosarray[i];
			} else if (i == 0) {
				strfinal += termosarray[i] + ",";
			} else {
				strfinal += " " +termosarray[i] + ", ";
			}
		}
		return strfinal;
	}

}
