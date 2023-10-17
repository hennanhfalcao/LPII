package documin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Classe responsável por gerenciar informações acerca dos documentos do
 * DocuMin.
 * 
 * @author HENNAN HEIM FALCÃO - 122110048 *
 */
public class Documento {
	/**
	 * Os atributos a seguir são, respecitvamente: título - String com o título do
	 * documento elementos - ArrayList de elementos que compõem o documento. tamanho
	 * - um inteiro que representa a quantidade de elementos máxima que o documento
	 * comporta. ehAtallho - um boolean que controla se o documento é atalho para
	 * algum outro documento. temAtalho - um boolean que controla se o documento tem
	 * atalho para um outro documento.
	 */
	private String titulo;
	private ArrayList<Elemento> elementos;
	private int tamanho;
	private boolean ehAtalho = false;
	private boolean temAtalho = false;

	/**
	 * Construtor responsável por inicializar um documento. Caso o documento tenha
	 * título vazio ou contendo apenas espaços ou o tamanho passado seja inválido, o
	 * sistema lança a excessão "IllegalArgumentException"
	 * 
	 * @param titulo  - String contendo o título do documento
	 * @param tamanho inteiro contendo a quantidade máxima de elementos do documento
	 */
	public Documento(String titulo, int tamanho) {
		if (tamanho <= 0) {
			throw new IllegalArgumentException("TAMANHO INVÁLIDO");
		}
		if (titulo.isBlank()) {
			throw new IllegalArgumentException("TÍTULO VAZIO!");
		}
		this.titulo = titulo;
		this.tamanho = tamanho;
		this.elementos = new ArrayList<>();
	}

	/**
	 * Construtor responsável por inicializar um documento sem restrição de tamanho.
	 * 
	 * @param titulo - título do documento
	 */
	public Documento(String titulo) {
		this(titulo, Integer.MAX_VALUE);

		if (titulo.isBlank()) {
			throw new IllegalArgumentException("TÍTULO VAZIO!");
		}
		this.elementos = new ArrayList<>();
	}

	/**
	 * Método responsável por retornar o estado do documento com relação a ser
	 * atalho ou não.
	 * 
	 * @return boolean contendo o estado do atual documento com relação a ser atalho
	 *         ou não.
	 */
	public boolean isEhAtalho() {
		return ehAtalho;
	}

	/**
	 * Método responsável por tornar o documento um atalho para outro documento
	 * 
	 * @param ehAtalho boolean contendo o novo estado do documento com relação a ser
	 *                 ou não atalho.
	 */
	public void setEhAtalho(boolean ehAtalho) {
		this.ehAtalho = ehAtalho;
	}

	/**
	 * Método responsável por retornar o estado do documento com relação a ter um
	 * atalho para outro documento ou não.
	 * 
	 * @return retorna um boolean com o atual estado do documento quanto a ter ou
	 *         não atalho
	 */
	public boolean isTemAtalho() {
		return temAtalho;
	}

	/**
	 * Método responsável por retornar a informação de que o documento tem ou não
	 * tem atalho para outro documento.
	 * 
	 * @param boolean contendo o novo estado do documento com relação a ter ou não
	 *                atalho.
	 */
	public void setTemAtalho(boolean temAtalho) {
		this.temAtalho = temAtalho;
	}

	/**
	 * Método responsável por retornar os elementos do documento
	 * 
	 * @return retorna um ArrayList do tipo Elemento
	 */
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	/**
	 * Método responsável por retornar o título do documento.
	 * 
	 * @return String com o título do documento
	 */
	public String getTitulo() {
		return this.titulo;
	}

	/**
	 * Método responsável por retornar a quantidade máxima de elementos que o
	 * documento comporta
	 * 
	 * @return inteiro com a quantidade máxima de elementos
	 */
	public int getTamanho() {
		return this.tamanho;
	}

	/**
	 * Método responsável por calcular a média das prioridades dos elementos de um
	 * documento
	 * 
	 * @return retorna um inteiro com a média das prioridades.
	 */
	public int calcMediaPrioridade() {
		double soma = 0.0;
		for (Elemento elemento : this.elementos) {
			if (elemento != null) {
				soma += elemento.getPrioridade();
			}
		}
		return (int) soma / this.elementos.size();
	}

	/**
	 * Método responsável por criar um elemento do tipo atalho. Caso o documento já
	 * seja atalho ou tenha algum atalho, o método lança a exceção
	 * "IllegalStateException"
	 * 
	 * @param documentoRef documento que será referenciado
	 * @return um inteiro contendo a posição do elemento atalho.
	 */
	public int criaAtalho(Documento documentoRef) {
		if (!this.temAtalho && !documentoRef.isEhAtalho()) {
			this.setTemAtalho(true);
			documentoRef.setEhAtalho(true);
			this.elementos.add(new Atalho(this, documentoRef));
			return this.elementos.size() - 1;
		}
		throw new IllegalStateException("Documento referenciado já tem atalho ou o documento a receber a referência já é um atalho!");
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(titulo, other.titulo);
	}
	/**
	 * Método responsável por mover um elemento uma posição acima no ArrayList de
	 * elementos. Só é valido para os elementos que estão abaixo da posição 0. Caso
	 * o índice passado esteja abaixo de 0 ou acima da quantidade de elementos
	 * presente no ArrayList, lança-se a exceção "IndexOutOfBoundsException".
	 * 
	 * @param posicao - inteiro contendo a posição do elemento que se deseja mover
	 *                para cima
	 */
	public void moveParaCima(int posicao) {
		if (posicao >= this.elementos.size() || posicao < 0) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		}
		if (posicao != 0) {
			Collections.swap(elementos, posicao, posicao - 1);
		}
	}

	/**
	 * Método responsável por mover um elemento uma posição abaixo no ArrayList de
	 * elementos. Só é valido para os elementos que estão abaixo da última posição.
	 * Caso o índice passado esteja abaixo de 0 ou acima da quantidade de elementos
	 * presente no ArrayList, lança-se a exceção "IndexOutOfBoundsException".
	 * 
	 * @param posicao - inteiro contendo a posição do elemento que se deseja mover
	 *                para baixo
	 */
	public void moveParaBaixo(int posicao) {
		if (posicao >= elementos.size() || posicao < 0) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		}
		if (posicao != elementos.size() - 1) {
			Collections.swap(elementos, posicao, posicao + 1);
		}
	}

}