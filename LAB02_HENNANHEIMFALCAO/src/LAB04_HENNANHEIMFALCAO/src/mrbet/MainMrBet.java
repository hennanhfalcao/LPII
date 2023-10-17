package mrbet;

import java.util.Scanner;

public class MainMrBet {	
	
	SistemaMrBet sistema = new SistemaMrBet();
	
	
	public static void main(String[] args) {
		
		System.out.println("Carregando Menu");
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			try {
				comando(escolha, sistema, scanner);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private static String menu(Scanner scanner) {
			System.out.println(
					"\n---\nMENU\n" + 
							"(M)Minha inclusão de times\n" + 
							"(R)Recuperar Times\n" + 
							"(.)Adicionar Campeonato\n" + 
							"(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
							"(E)Exibir campeonatos que o time participa\n" +
							"(T)Tentar a sorte e status\n" +
							"(!)Já pode fechar o programa\n" + 
							"\n" + 
							"Opção> ");
			return scanner.next().toUpperCase();
		}

		private static void comando(String opcao, SistemaMrBet sistema, Scanner scanner) {
			switch(opcao) {
			case "M":
				incluiTimes(sistema, scanner);
				break;
		case "R":
				recuperaTimes(sistema, scanner);
				break;
			}
	}
		
		private static void incluiTimes(SistemaMrBet sistema, Scanner scanner) {
			System.out.println("Código: ");
			String codigo = scanner.nextLine();
			System.out.println("Nome: ");
			String nome = scanner.nextLine();
			System.out.println("Mascote: ");
			String mascote = scanner.nextLine();
			System.out.println(sistema.incluiTimes(codigo, nome, mascote));
		}
		
		private static void recuperaTimes(SistemaMrBet sistema, Scanner scanner) {
			System.out.println("Código: ");
			String codigo = scanner.nextLine();
			System.out.println(sistema.recuperaTimes(codigo));
		}
	}
}
