package mrbet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Campeonato {

	private String nome;
	private int numeroDeParticipantes;
	private HashMap<String, Time> time = new HashMap <String, Time>();
	
	public Campeonato(String nome, int numeroDeParticipantes) {
		this.nome = nome;
		this.numeroDeParticipantes = numeroDeParticipantes;
	}

	public void addTimeCampeonato(String codigo, Time time) {
		this.time.put(codigo, time);
	}
	public String getNome() {
		return nome;
	}
	
	public int timesSize() {
		return this.time.size();
	}
	
	public boolean containsTime(String codigo) {
		boolean verificador = false;
		if (this.time.containsKey(codigo)) {
			verificador = true;
		}
		return verificador;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroDeParticipantes() {
		return numeroDeParticipantes;
	}

	public void setNumeroDeParticipantes(int numeroDeParticipantes) {
		this.numeroDeParticipantes = numeroDeParticipantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome, other.nome);
	}
	
	public String exibeCampeonatosString() {
		String mensagem = "";
		mensagem = "* " + this.nome + " - " + this.time.size() + "/" + this.numeroDeParticipantes;
		return mensagem;
	}
	
	
}
