package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */
public class Agenda {
	
	private static final int TAMANHO = 100;
	
	private static final int TAMANHO_FAVORITOS = 10;
	
	private Contato[] contatos; 
	
	private Contato[] favoritos;
	
	/**
	 * Cria uma agenda que contém uma lista de contatos e uma lista de favoritos.
	 */
	
	public Agenda() {
		this.contatos = new Contato[TAMANHO];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	
	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}
	
	public Contato getFavorito(int posicao) {
		return favoritos[posicao];
	}
	
	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @return retorna quatro tipos de mensagem, caso o contato seja cadastrado com sucesso "CADASTRO REALIZADO", caso o telefone ou o nome sejam vazios "CONTATO INVÁLIDO", caso a posição esteja abaixo de 1 ou acima de 100, "POSIÇÃO INVÁLIDA", e caso o contato ja esteja cadastrado (tenha um contato de mesmo nome na agenda), "CONTATO JÁ CADASTRADO".
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		boolean verificador = false;
		String mensagem = "";
		Contato contato = new Contato(posicao, nome, sobrenome, telefone);
		for (int i = 0; i < getCount(); i++) {
			if (contato.equals(contatos[i])) {
				verificador = true;
				break;
			}
		}
		if (verificador) {
			mensagem = "CONTATO JÁ CADASTRADO";
		}
		else if (posicao > 100 || posicao < 1) {
			mensagem = "POSIÇÃO INVÁLIDA";
		}
		else if (nome == "" || telefone == "") {
			mensagem = "CONTATO INVÁLIDO";
		}
		else {
			this.contatos[posicao-1] = new Contato(posicao, nome, sobrenome, telefone);
			mensagem = "CADASTRO REALIZADO";	
		}
		return mensagem;
	}
	
	
	/**
	 * Este método adiciona um contato a um array de contatos favoritos.
	 * @param posicao posição do contato na agenda.
	 * @param posicaofavorito posição do contato na lista de favoritos.
	 * @return retorna uma string com uma mensagem, sendo ela "CONTATO JÁ CADASTRADO" caso o contato já esteja na lista de favoritos, ou "CONTATO FAVORITADO NA POSIÇÃO X!" caso o contato tenha sido adicionado.
	 */
	public String adicionaFavorito(int posicao, int posicaofavorito) {
		String mensagem = "";
		Contato contato = this.contatos[posicao-1];
		for (int i = 0; i < getCountFavoritos(); i++) {
			if (contato.equals(favoritos[i])) {
				mensagem = "CONTATO JÁ CADASTRADO";
				break;
			}
		}
		if (mensagem.length() == 0) {
			this.contatos[posicao-1].setFavorito(true);
			this.favoritos[posicaofavorito-1] = new Contato(posicao, this.contatos[posicao-1].getNome(), this.contatos[posicao-1].getSobrenome(), this.contatos[posicao-1].getTelefone(), this.contatos[posicao-1].getFavorito());
			mensagem = "CONTATO FAVORITADO NA POSIÇÃO " + (posicaofavorito) + "!";
		}
		return mensagem;
	}
	/**
	 * Esse método remove um favorito da lista de favoritos.
	 * @param posicaofavorito posição do contato na lista de favoritos.
	 */
	public void removeFavorito(int posicaofavorito) {
		for (int i = 0; i < getCount(); i++) {
			if (this.favoritos[posicaofavorito-1].equals(this.contatos[i])) {
				this.contatos[i].setFavorito(false);
			}
		}
		Contato[] favoritos = new Contato[TAMANHO_FAVORITOS];
		for (int j = 0; j < getCountFavoritos(); j++) {
			if (this.favoritos[posicaofavorito-1].equals(this.favoritos[j]) == false) {
				favoritos[j] = this.favoritos[j];
			}
		}
		this.favoritos = favoritos;
	}

	public int getCount() {
		return this.contatos.length;
	}
	
	public int getCountFavoritos() {
		return this.favoritos.length;
	}
}
