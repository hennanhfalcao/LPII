package documin;
import java.util.ArrayList;
/**
 * Classe responsável por gerenciar as informações acerca do elemento do tipo
 * Lista
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class Lista extends Elemento {
	/**
	 * Os atributos a seguir representam, respectivamente, uma String contendo o
	 * separador utilizado na representação textual das Listas e uma String contendo
	 * um caractere utilizado na pontuação dos itens da lista.
	 */
	String separador;
	String caractere;

	/**
	 * Construtor responsável por inicializar um elemento do tipo Lista.
	 * 
	 * @param prioridade - um inteiro que armazena a prioridade do elemento do tipo
	 *                   Lista
	 * @param valor      - uma String que armazena o conteúdo do elemento do tipo
	 *                   Lista.
	 * @param separador  - uma String que armazena o caractere responsável por
	 *                   separar os itens na sua representação textual.
	 * @param caractere  - uma String que armazena o caractere responsável por
	 *                   pontuar os itens da lista.
	 */
	public Lista(int prioridade, String valor, String separador, String caractere) {
		super(prioridade, valor);
		this.separador = separador;
		this.caractere = caractere;
	}

	/**
	 * Método responsável por gerar a representação resumida dos elementos do tipo
	 * Lista.
	 * 
	 * @return retorna uma String com a representação resumida de cada elemento do
	 *         tipo Lista.
	 */
	@Override
	public String repResumida() {

ArrayList<String> trechos2 = new ArrayList<>();
		
		String[] trechos = this.valor.split(this.separador);
		
		for(int i = 0; i < trechos.length; i++) {
			trechos2.add(trechos[i].trim());
		}
		
		String[] trechosarray = trechos2.toArray(new String[0]);
		
		String strfinal = "";

		for (int i = 0; i < trechosarray.length; i++) {
			if (i == trechosarray.length - 1) {
				strfinal += trechosarray[i];
			} else {
				strfinal += trechosarray[i] + this.separador + " ";
			}
		}
		return strfinal;
	}

	/**
	 * Método responsável por gerar a representação completa dos elementos do tipo
	 * Lista.
	 * 
	 * @return retorna uma String contendo a representação completa do elemento do
	 *         tipo Lista.
	 */
	@Override
	public String repCompleta() {
		ArrayList<String> trechos2 = new ArrayList<>();
		
		String[] trechos = this.valor.split(this.separador);
		
		for(int i = 0; i < trechos.length; i++) {
			trechos2.add(trechos[i].trim());
		}
		
		String[] trechosarray = trechos2.toArray(new String[0]);
		
		String strfinal = "";

		for (int i = 0; i < trechosarray.length; i++) {
			if (i == trechosarray.length - 1) {
				strfinal += this.caractere + " " + trechosarray[i];
			} else {
				strfinal += this.caractere + " " + trechosarray[i] + "\n";
			}
		}
		return strfinal;
	}

}
