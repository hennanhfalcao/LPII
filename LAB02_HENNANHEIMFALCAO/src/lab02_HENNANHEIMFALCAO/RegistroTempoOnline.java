package lab02_HENNANHEIMFALCAO;
/**
 * Esta classe tem como objetivo guardar a informação acerca da quantidade de horas de internet que o aluno tem dedicado a uma determinada disciplina remota.
 * Neste caso, para cada disciplina seria criado um objeto (tempo online usado) para controlar esse estado.
 * @author HENNAN HEIM FALCÃO - MATRÍCULA - 122110048
 */
public class RegistroTempoOnline {

	private String nomeDisciplina;
	
	private int tempoOnlineEsperado;
	
	private boolean atingiuMetaTempoOnline;
	
	private int tempoOnline;
	
/**
 * Contrutor responsável por inicializar o atributo nomeDsciplina. Nesse caso específico, esse construtor se diferencia do seguinte por ter parâmetros diferentes.
 * Padroniza-se o Tempo Online Esperado em 120h nos casos em que esse valor não é recebido.	
 * @param nomeDisciplina inicializa o nome da disciplina em questão.
 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
	}
/**
 * Construtor responsável por inicializar os atributos nomeDisciplina e tempoOnlineEsperado, respectivamente.	
 * @param nomeDisciplina inicializa o nome da disciplina em questão
 * @param tempoOnlineEsperado determina a quantiadde de tempo esperado para atingir a meta, em horas.
 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
/**
 * Este método armazena o tempo online de determinada disciplina.	
 * @param tempo recebe a quantidade de tempo em horas e acumula conforme o método é chamado.
 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnline =  this.tempoOnline + tempo;
	}
/**
 * Método responsável por retornar o status de Tempo Online, caso o aluno tenha atingido a meta, retorna true, caso contrário, retorna false.
 * @return atingiuMetaTempoOnline: true ou false a depender de ter atingido a média ou não, respectivamente. 
 */
	public boolean atingiuMetaTempoOnline() {
		if (this.tempoOnline >= this.tempoOnlineEsperado) {
			this.atingiuMetaTempoOnline = true;
		}
		else {
			this.atingiuMetaTempoOnline = false;
		}
		return this.atingiuMetaTempoOnline;
		
	}
/**
 * Método que retorna a String contendo o relatório no formato Tempo Online/Tempo Online Esperado	
 */
	public String toString() {
		String relatorio = this.nomeDisciplina + " " + this.tempoOnline + "/" + this.tempoOnlineEsperado;
		return relatorio;
	}
}
