package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		while (true) {

			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					+ "**********************************************************");
			System.out.println("                                                          ");
			System.out.println("                     BANCO                                ");
			System.out.println("                                                          ");
			System.out.println("**********************************************************" + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "                                                          ");
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

			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				scanner.nextLine();
				opcao = 0;
			}

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

					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = scanner.nextInt();

					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
			}
			case 2 -> {
				System.out.println("\nListar todas as Contas\n\n");
				contas.listarContas();
				keyPress();
			}
			case 3 -> {
				System.out.println("\nConsultar dados da Conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				keyPress();
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
				keyPress();
			}
			case 5 -> {
				System.out.println("\nApagar a Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				keyPress();
			}
			case 6 -> {
				System.out.println("\nSaque\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();

				System.out.println("Digite o valor do Saque: ");
				valor = scanner.nextFloat();
				keyPress();
			}
			case 7 -> {
				System.out.println("\nDepósito\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();

				System.out.println("Digite o valor do Depósito:  ");
				valor = scanner.nextFloat();
				keyPress();
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

				keyPress();
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

	public static void keyPress() {

		try {
			System.out.println(Cores.TEXT_RESET + "Pressione a tecla enter  para continuar");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Erro de digitação");
		}

	}

}
