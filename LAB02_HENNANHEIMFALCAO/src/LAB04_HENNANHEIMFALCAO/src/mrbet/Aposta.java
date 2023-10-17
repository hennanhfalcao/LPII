package mrbet;

public class Aposta {

	private String codigo;
	private String nome;
	private int colocacao;
	private double valor;
	
	public Aposta(String codigo, String nome, int colocacao, double valor) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.colocacao = colocacao;
		this.valor = valor;
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getColocacao() {
		return colocacao;
	}

	public void setColocacao(int colocacao) {
		this.colocacao = colocacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
