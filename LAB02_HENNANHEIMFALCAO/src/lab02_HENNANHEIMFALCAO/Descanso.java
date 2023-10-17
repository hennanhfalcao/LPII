package lab02_HENNANHEIMFALCAO;
/** 
 * Define o status de descanso do aluno, tal status é definido pela quantidade de horas descansadas por semana.
 * Se esse valor for maior ou igual a 26, o status será descansado, caso contrário, cansado.
 * @author HENNAN HEIM FALCÃO - MATRÍCULA - 122110048
 *
 */
public class Descanso {

	private int horasDescanso;

	private int numeroSemanas;
	
	private String statusGeral;

/**
 * Método que recebe o valor de horas de descanso.	
 * @param valor armazena o número de horas de descanso.
 */

	public void defineHorasDescanso(int valor) {
		this.horasDescanso = valor;
	}
/**
 * Método que recebe o número de semanas
 * @param valor armazena o número de semanas.
 */
	public void defineNumeroSemanas(int valor) {
		this.numeroSemanas = valor;
	}
/**
 * Método responsável por retornar uma String com o Status de descanso do aluno: cansado ou descansado.
 * @return StatusGeral com o status do aluno, descansado, caso o número de horas de descanso/semana seja maior ou igual a 26.
 * Caso contrário, retorna cansado.
 */
	public String getStatusGeral() {
		if (this.horasDescanso == 0 || this.numeroSemanas == 0) {
			this.statusGeral = "cansado";
		}
		else {
			if ((this.horasDescanso/this.numeroSemanas) >= 26) {
				this.statusGeral = "descansado";
			}
			else {
				this.statusGeral = "cansado";
			}
		}
		return this.statusGeral;
	}
}
