package agenda;

/**
 * Classe responsável por construir um array de contato
 * 
 * @author HENNAN HEIM FALCÃO - 122110048 *
 */
public class Contato {

	private boolean favorito = false;
	
	private int posicao;

	private String nome;

	private String sobrenome;

	private String telefone;
/**
 * Construtor responsável por inicializar um array de Contatos
 * @param posicao posição do contato da agenda do tipo inteiro
 * @param nome nome do contato na agenda do tipo String
 * @param sobrenome sobrenome do contato na agenda do tipo String
 * @param telefone telefone do contato na agenda do tipo String
 */

	public Contato(int posicao, String nome, String sobrenome, String telefone) {

		this.posicao = posicao;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;

	}
/**
 * Construtor responsável por construir  um array de Contatos, incluindo o parametro "favoritos"
 * @param posicao posição do contato na agenda do tipo inteiro
 * @param nome nome do contato na agenda do tipo String
 * @param sobrenome sobrenome do contato na agenda do tipo String
 * @param telefone telefone do contato na agenda do tipo String
 * @param favorito do tipo boolean
 */
	public Contato(int posicao, String nome, String sobrenome, String telefone, boolean favorito) {

		this.posicao = posicao;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.favorito = favorito;
		
	}
	
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public boolean getFavorito() {
		return this.favorito;
	}

	public int getPosicao() {
		return this.posicao;
	}

	public String getNome() {
		return this.nome;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	@Override
	/**
	 * Sobrescrição do método equals para a classe Contato. Os contatos são considerados iguais caso tenham o mesmo NOME e SOBRENOME.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Contato)) {
			return false;
		}
		Contato o2 = (Contato) o;
		return this.nome.equals(o2.getNome()) && this.sobrenome.equals(o2.getSobrenome());
	}

	/**
	 * Método responsável por construir uma representação textual para a funcionalidade exibir contato.
	 * @return uma String no formato:
	 * (flag de favorito, caso seja favorito) nome + sobrenome
	 * telefone
	 */
	public String toStringExibir() {
		String exibircontato = "";
		
		if (this.favorito == true) {
			exibircontato += "❤" + " ";
		}
		
		exibircontato += this.nome + " " + this.sobrenome + "\n" + this.telefone;
		
		return exibircontato;
	}
	/**
	 * Método responsável por criar uma representação textual para a listagem de contatos a agenda.
	 * @return uma String no formato: posicao + - + nome + sonbrenome
	 */
	public String toStringListar() {

		String listarcontato = this.posicao + " - " + this.nome + " " + this.sobrenome;
		return listarcontato;
	}
	/**
	 * Método responsável por criar uma representação textual para a listagem de contatos favoritos da agenda.
	 * @return uma String no formato: posicao + - + nome + sonbrenome
	 */
	public String toStringListarFavorito() {

			String listarcontato = this.posicao+1 + " - " + this.nome + " " + this.sobrenome;
			return listarcontato;	
	}
	
}
