package mrbet;

import java.util.*;

public class SistemaMrBet {

	private HashMap<String, Time> time = new HashMap<>();
	private HashMap<String, Campeonato> campeonato = new HashMap<String, Campeonato>();
	private ArrayList<Aposta> aposta = new ArrayList<Aposta>();

	/* implementar um método toUpperCase para chave e para nome */

	public String incluiTimes(String codigo, String nome, String mascote) {
		String mensagem = "";
		if (!this.time.containsKey(codigo)) {
			this.time.put(codigo, new Time(codigo, nome, mascote));
			mensagem = "INCLUSÃO REALIZADA!\n";
		} else {
			mensagem = "TIME JÁ EXISTE!\n";
		}
		return mensagem;
	}

	public String recuperaTimes(String codigo) {
		String mensagem = "";
		if (!this.time.containsKey(codigo)) {
			mensagem = "TIME NÃO EXISTE!\n";
		} else {
			mensagem = this.time.get(codigo).toStringRecupera();
		}

		return mensagem;
	}

	public String adicionaCampeonato(String nome, int numeroDeParticipantes) {
		String mensagem = "";
		if (!this.campeonato.containsKey(nome.toUpperCase())) {
			this.campeonato.put(nome.toUpperCase(), new Campeonato(nome, numeroDeParticipantes));
			mensagem = "CAMPEONATO ADICIONADO!\n";
		} else {
			mensagem = "CAMPEONATO JÁ EXISTE!\n";
		}
		return mensagem;
	}

	public String incluiTime(String nome, String codigo) {
		String mensagem = "";
		int numerodeparticipantes = campeonato.get(nome.toUpperCase()).getNumeroDeParticipantes();

		if (!this.campeonato.containsKey(nome.toUpperCase())) {
			mensagem = "CAMPEONATO NÃO EXISTE!";
		} else {
			if (!this.time.containsKey(codigo)) {
				mensagem = "TIME NÃO EXISTE!";
			} else if (this.campeonato.get(nome.toUpperCase()).timesSize() < numerodeparticipantes) {
				mensagem = "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM CADASTRADOS!";
			} else {
				this.campeonato.get(nome.toUpperCase()).addTimeCampeonato(codigo, this.time.get(codigo));
				mensagem = "TIME INCLUÍDO NO CAMPEONATO!";
			}
		}
		return mensagem;
	}

	public String verificaTime(String codigo, String nome) {
		String mensagem = "";
		if (!this.campeonato.containsKey(nome.toUpperCase())) {
			mensagem = "O CAMPEONATO NÃO EXISTE!\n";
		} else {
			if (!this.time.containsKey(codigo)) {
				mensagem = "O TIME NÃO EXISTE!\n";
			} else if (this.campeonato.get(nome.toUpperCase()).containsTime(codigo)) {
				mensagem = "O TIME ESTÁ NO CAMPEONATO!\n";
			} else {
				mensagem = "O TIME NÃO ESTÁ NO CAMPEONATO!\n";
			}
		}
		return mensagem;
	}

	public String exibeCampeonatos(String codigo) {
		String mensagem = "";
		if (this.time.containsKey(codigo)) {
			mensagem = "Campeonatos do " + this.time.get(codigo) + ":\n";
			for (String key : campeonato.keySet()) {
				Campeonato campeonato = this.campeonato.get(key);
				if (campeonato.containsTime(codigo)) {
					mensagem += campeonato.exibeCampeonatosString() + "\n";
				}
			}
		} else {
			mensagem = "O TIME NÃO EXISTE!\n";
		}
		return mensagem;
	}

	public String registraAposta(String codigo, String nome, int colocacao, double valor) {
		String mensagem = "";
		if (this.time.containsKey(codigo)) {
			if (this.campeonato.containsKey(nome.toUpperCase())) {
				if (colocacao <= this.campeonato.get(nome.toUpperCase()).getNumeroDeParticipantes()) {
					this.aposta.add(new Aposta(codigo, nome, colocacao, valor));
					mensagem = "APOSTA REGISTRADA!\n";
				} else {
					mensagem = "APOSTA NÃO REGISTRADA!\n";
				}
			} else {
				mensagem = "O CAMPEONATO NÃO EXISTE!\n";
			}
		} else {
			mensagem = "O TIME NÃO EXISTE!\n";
		}
		return mensagem;
	}

	/* lembrar de colocar em todos os campos que utilizam chave o toUpperCase */
	public String statusApostas() {
		String mensagem = "Apostas:\n";
		for (int i = 0; i < this.aposta.size(); i++) {
			mensagem += i + 1 + ". " + "[" + this.aposta.get(i).getCodigo() + "]" + " "
					+ this.time.get(this.aposta.get(i).getCodigo()).getNome() + "/ "
					+ this.time.get(this.aposta.get(i).getCodigo()).getMascote() + "\n"
					+ this.campeonato.get(this.aposta.get(i).getNome().toUpperCase()).getNome() + "\n"
					+ this.aposta.get(i).getColocacao() + "/"
					+ this.campeonato.get(this.aposta.get(i).getNome().toUpperCase()).getNumeroDeParticipantes() + "\n" + "R$ "
					+ this.aposta.get(i).getValor();
		}
		return mensagem;
	}
}
