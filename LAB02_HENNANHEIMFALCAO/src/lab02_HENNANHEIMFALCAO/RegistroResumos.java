package lab02_HENNANHEIMFALCAO;

/**
 * Esta classe tem como objetivo armazenar informações acerca de um relatório de resumos, cada resumo está relacionado a um tema específico.
 * Tem como função, também, contabilizar a quantidade de resumos salvos. 
 * Além disso, busca no array de resumos estruturado pela classe "Resumo" algum tema específico e retorna false ou true, caso o tema pesquisado pela classe Coisa esteja armazenado nesse array.
 * @author HENNAN HEIM FALCÃO - MATRÍCULA - 122110048
 */

public class RegistroResumos {

	private int numeroDeResumos;
	
	private Resumo[] resumos;
		
	private int count = 0;
/**
 * Construtor responsável por inicializar a quantidade de resumos máxima permitida no array de Resumo.	
 * @param numeroDeResumos é o número máximo de informação armazenada no array de Resumo.
 */
	
	public RegistroResumos(int numeroDeResumos) {
		
		this.numeroDeResumos = numeroDeResumos;
		this.resumos = new Resumo[numeroDeResumos];
		
}

/**
 * Método responsável por adicionar o tema e o resumo no array de resumo. O tema e o resumo são adicionados na primeira posição do array e os seguintes nas posições subsequentes.
 * Se a quantidade de resumos ultrapassar a máxima permitida (estabelecida pela variável "numeroDeResumos", o contador "cont" é reinicializado, com a função de recomeçar o armazenamento de informação a partir da primeira posição do array. 	
 * @param tema parâmetro contendo informação do tipo String referente ao tema do resumo a ser adicionado.
 * @param resumo parâmetro contendo informação d otipo String referente ao escopo do resumo a ser adiconado
 */
	
	public void adiciona(String tema, String resumo) {
		this.resumos[this.count] = new Resumo(tema,resumo);
		this.count++;
		if(this.count>=numeroDeResumos) {
			this.count=0;
		}
	}

/**
 * Método responsável por adicionar as informações contidas no array de resumos e estruturar o array de Strings com tais informações.	
 * @return Retorna uma String no formato "Tema: resumo"
 */
	
	
	public String[] pegaResumos() {
		String[] resumosString = new String[count];
		for(int i=0;i<this.count;i++) {
			resumosString[i] = resumos[i].toString();
		}
		return resumosString;
	}

/**
 * Método responsável por imprimir o relatório de resumos.
 * @return uma String contendo o relatório de resumos no formato:
 * "Resumos:
 * Quantidade (representada pela variável count, controlada pelo método adiciona) de resumos cadastrados.
 * Tema 1 | Tema 2... | Tema count.
 */
	
	public String imprimeResumos() {
		String resumoString = "- "+this.count+" resumo(s) cadastrado(s)";
		if(this.count>0) {
			resumoString =resumoString + "\n- ";
			for(int i=0;i<this.count;i++) {
				if(i+1==this.count) {
					resumoString = resumoString +this.resumos[i].getTema();

				}else {
					resumoString = resumoString +this.resumos[i].getTema()+" | ";

				}
			}
		}
		return resumoString;
	}
	
/**
 * Método responsável por armazenar a variável count
 * @return retorna a quantidade de resumos que estão adicionados ao array de resumo, do tipo int.
 */
	
	public int conta() {
		return this.count;
	}	

/**
 * Método responsável por pesquisa se determinado tema está armazenado ou não no array de resumo.	
 * @param tema parâmetro com o tema a ser pesquisado.
 * @return Retorna true, caso o tema pesquisado esteja contido no array de resumo, caso contrário, retorna false.
 */
	
	public boolean temResumo(String tema) {
		Boolean temResumo = false;
		for(int i=0;i<this.count;i++) {
			if( this.resumos[i].getTema().equals(tema)) {
				temResumo = true;
            	break;
			}
			
			else {
            	temResumo = false;
			}
		}
		return temResumo;
	}
}
