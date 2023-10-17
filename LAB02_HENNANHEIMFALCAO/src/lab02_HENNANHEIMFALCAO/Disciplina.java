package lab02_HENNANHEIMFALCAO;

import java.util.Arrays;

/**
 * Essa classe tem como objetivo guardar informações sobre as notas obtidas em determinada disciplina. 
 * Além disso, cadastra o número de horas investido na disciplina, bem como calcula a média obtida e, consequentemente, o status de aprovação do aluno.
 * @author HENNAN HEIM FALCÃO - 122110048
 *
 */

public class Disciplina {
	
	private double[] notas = {0,0,0,0};
	
	private int horas;
	
	private int nota;
		
	private String nomeDisciplina;
	
	private boolean aprovado;
	
	/**
	 * Construtor responsável por construir uma String com o nome da Disciplina
	 * @param nomeDisciplina inicializa uma String com o nome da disciplina.
	 */
	
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Método responsável por acumular a quantidade de horas investidas em uma disciplina
	 * @param horas parâmetro responsável por receber a informação do tempo investido na disciplina, em horas.
	 */
	
	public void cadastraHoras(int horas) {
		this.horas = this.horas + horas;
	}
	
	/**
	 * Método responsável por cadastrar as notas, do tipo inteiro, no array de notas. 
	 * @param nota parâmetro auxilia na construção do array de notas, visto que está atrelado ao índice da nota no referente array.
	 * está no formato nota - 1 para compatibilizar o número da nota com o índice do array: nota 1 = posição 0 do array de notas.
	 * @param valorNota parâmetro responsável por receber o valor da nota, do tipo double
	 */
	
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
		
	private double calcularMedia() {
		double soma = 0;
		for (int index = 0; index < this.notas.length; index++) {
			soma = soma +this.notas[index];
		}
		double media = soma/this.notas.length;	
		return media;
		
	}
	
	/**
	 * Método responsável por retornar se o aluno foi aprovado ou não. Se a média(calculada pelo método privado estruturado anteriormente) for maior que 7, o aluno foi aprovado (retorna true), caso contrário, retorna false.
	 * @return boolean true (caso a média seja maior que 7.0), ou boolean false (caso a média seja menor que 7.0).
	 */
	
	public boolean aprovado() {
		if (this.calcularMedia() >= 7.0) {
			this.aprovado = true;
		}
		else {
			this.aprovado = false;
		}
		return this.aprovado;
	}
	
	/**
	 * Método responsável por montar um pequeno relatório no formato "Nome da disciplina + quantidade de horas estudadas + média + os valores de notas armazenados no array notas"
	 */
	
	public String toString() {
		return this.nomeDisciplina + " " + this.horas + " " + this.calcularMedia() + " " + Arrays.toString(this.notas);
	}
}
