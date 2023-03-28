package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ContaCorrente p1 = new ContaCorrente(567,0163,1,"Yago Neves",6580,4350);
		
		p1.visualizar();
		
		ContaPoupanca p2 = new ContaPoupanca(36,0716,2,"Fernanda Dias",3800,12,900);
		
		p2.visualizar();
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		while (true) {

			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "**********************************************************");
			System.out.println("                                                          ");
			System.out.println("                     BANCO                                ");
			System.out.println("                                                          ");
			System.out.println("**********************************************************" + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND + "                                                          ");
			System.out.println("             1 - Criar Conta                              ");
			System.out.println("             2 - Listar todas as Contas                   ");
			System.out.println("             3 - Buscar Conta por numero                  ");
			System.out.println("             4 - Atualizar Dados da Conta                 ");
			System.out.println("             5 - Apagar Conta                             ");
			System.out.println("             6 - Sacar                                    ");
			System.out.println("             7 - Depositar                                ");
			System.out.println("             8 - Transferir valores entre Contas          ");
			System.out.println("             9 - Sair                                     ");
			System.out.println("                                                          ");
			System.out.println("**********************************************************" + Cores.TEXT_RESET);
			System.out.println("Entre com a opção desejada: \n");

			opcao = scanner.nextInt();

			if (opcao == 9) {
				System.out.println("\nAgredecemos a preferência!");
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("\nCriar Conta\n\n");

				System.out.println("Digite o Numero da Agência: ");
				agencia = scanner.nextInt();

				System.out.println("Digite o Nome do Titular: ");
				scanner.skip("\\R?");
				titular = scanner.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = scanner.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = scanner.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = scanner.nextFloat();

					// criar o objeto conta corrente
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = scanner.nextInt();

					// criar o objeto conta poupanca
				}
				}
			}
			case 2 -> System.out.println("\nListar todas as Contas\n\n");
			case 3 -> {
				System.out.println("\nConsultar dados da Conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
			}
			case 4 -> {
				System.out.println("\nAtualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();

				tipo = 1;
				// condicional buscar na collection

				System.out.println("Digite o Numero da Agência: ");
				agencia = scanner.nextInt();

				System.out.println("Digite o Nome do Titular: ");
				scanner.skip("\\R?");
				titular = scanner.nextLine();

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = scanner.nextFloat();

				// retornar tipo

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = scanner.nextFloat();

					// criar o objeto conta corrente
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = scanner.nextInt();

					// criar o objeto conta poupanca

				}
				default -> {
					System.out.println("Tipo de conta inválido!");
				}
				}

				// fim do condicional buscar na collection
			}
			case 5 -> {
				System.out.println("\nApagar a Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
			}
			case 6 -> {
				System.out.println("\nSaque\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				
				System.out.println("Digite o valor do Saque: ");
				valor = scanner.nextFloat();
			}
			case 7 -> {
				System.out.println("\nDepósito\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				
				System.out.println("Digite o valor do Depósito:  ");
				valor = scanner.nextFloat();
			}
			case 8 -> {
				System.out.println("\nTransferência entre Contas\n\n");

				// fim do condicional buscar na collection
				System.out.println("Digite o Numero da Conta de Origem: ");
				numero = scanner.nextInt();
				
				System.out.println("Digite o Numero da Conta de Destino: ");
				numeroDestino = scanner.nextInt();

				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = scanner.nextFloat();
				} while (valor <= 0);

			}
			default -> System.out.println("\nOpção Inválida!\n");
			}

		}

	}
	
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Letícia Queiroga - letqueirogaa@outlook.com");
		System.out.println("github.com/Letixs");
		System.out.println("*********************************************************");
	}
}
