package br.uel.ex5;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){

		LinkedList <ContaBancaria> agencia = new LinkedList <ContaBancaria>();
		
		Scanner terminal = new Scanner(System.in);
		
		BigDecimal saldo = BigDecimal.ZERO,
				   limite = BigDecimal.ZERO,
				   buffer = BigDecimal.ZERO;
		
		String cliente = null,
			   numeroConta = null;
				
		int diaRendimento = 0;
		
		int input = 0,
			input_2 = 0,
			index = -1;
		
		do{
			
			menu();
			input = terminal.nextInt();
			
			switch(input){
			
				case 1:			// Cadastrar nova conta
					
					System.out.println("Deseja cadastrar uma conta corrente, "
							+ " investimento ou poupança?");
					System.out.print("1 - Corrente\n2 - Poupança\n"
							+ "3 - Investimento \n0 - cancelar\n>> ");
					
					input_2 = terminal.nextInt();
					
					terminal.nextLine();
					
					if(input_2 == 1){
						
						System.out.print("Digite o nome do cliente: ");
						cliente = terminal.nextLine();
						
						System.out.print("Digite o número da conta: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite o saldo inicial: ");
						saldo = terminal.nextBigDecimal();
						
						System.out.print("Digite o limite da conta: ");
						limite = terminal.nextBigDecimal();
						
						agencia.add(new ContaCorrente(cliente, 
								numeroConta, saldo, limite));
						
					} else if(input_2 == 2){
						
						System.out.print("Digite o nome do cliente: ");
						cliente = terminal.nextLine();
						
						System.out.print("Digite o número da conta: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite o saldo inicial: ");
						saldo = terminal.nextBigDecimal();
						
						System.out.print("Digite o rendimento da conta: ");
						diaRendimento = terminal.nextInt();
						
						agencia.add(new ContaPoupanca(cliente, 
								numeroConta, saldo, diaRendimento));
					
					} else if(input_2 == 3){
						
						System.out.print("Digite o nome do cliente: ");
						cliente = terminal.nextLine();
						
						System.out.print("Digite o número da conta: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite o saldo inicial: ");
						saldo = terminal.nextBigDecimal();
						
						agencia.add(new ContaInvestimento(cliente, 
								numeroConta, saldo));
					}
					
					break;
					
				case 2:			// Sacar
					
					System.out.println("Deseja sacar de uma conta corrente, "
							+ " investimento ou poupança?");
					System.out.print("1 - Corrente\n2 - Poupança\n"
							+ "3 - Investimento \n0 - cancelar\n>> ");
					
					input_2 = terminal.nextInt();
					
					terminal.nextLine();
					
					if(input_2 == 1){
						
						System.out.print("Digite o número da conta que deseja"
								+ " sacar: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite a quantia: ");
						buffer = terminal.nextBigDecimal();
						
						index = agencia.indexOf(new ContaCorrente("", 
								numeroConta, BigDecimal.ZERO, BigDecimal.ZERO));
						
						if(index >= 0)
							agencia.get(index).sacar(buffer);
						else
							System.out.println("Número de conta não encontrado."
									+ " Tente novamente.");
						
					} else if(input_2 == 2){
						
						System.out.print("Digite o número da conta que deseja"
								+ " sacar: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite a quantia: ");
						buffer = terminal.nextBigDecimal();
						
						index = agencia.indexOf(new ContaPoupanca("", 
								numeroConta, BigDecimal.ZERO, 0));
						
						if(index >= 0)
							agencia.get(index).sacar(buffer);
						else
							System.out.println("Número de conta não encontrado."
									+ " Tente novamente.");
					
					} else if(input_2 == 3){
						
						System.out.print("Digite o número da conta que deseja"
								+ " sacar: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite a quantia: ");
						buffer = terminal.nextBigDecimal();
						
						index = agencia.indexOf(new ContaInvestimento
								("", numeroConta, BigDecimal.ZERO));
						
						if(index >= 0)
							agencia.get(index).sacar(buffer);
						else
							System.out.println("Número de conta não encontrado."
									+ " Tente novamente.");
					}
					break;
					
				case 3:			// Atualizar saldo
					
					terminal.nextLine();
					
					System.out.print("Digite o número da conta poupança que"
							+ " deseja atualizar: ");
					numeroConta = terminal.nextLine();
					
					System.out.print("Digite o rendimento (em %): ");
					buffer = terminal.nextBigDecimal();
					
					index = agencia.indexOf(new ContaPoupanca("", 
							numeroConta, BigDecimal.ZERO, 0));
					
					if(index >= 0)
						((ContaPoupanca) agencia.get(index))
							.calcularNovoSaldo(buffer);
					else
						System.out.println("Número de conta não encontrado."
								+ " Tente novamente.");
					
					break;
					
				case 4:			// Depositar
					
					System.out.println("Deseja depositar em uma conta corrente, "
							+ " investimento ou poupança?");
					System.out.print("1 - Corrente\n2 - Poupança\n"
							+ "3 - Investimento \n0 - cancelar\n>> ");
					
					input_2 = terminal.nextInt();
					
					terminal.nextLine();
					
					if(input_2 == 1){
						
						System.out.print("Digite o número da conta que deseja"
								+ " depositar: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite a quantia: ");
						buffer = terminal.nextBigDecimal();
						
						index = agencia.indexOf(new ContaCorrente("", 
								numeroConta, BigDecimal.ZERO, BigDecimal.ZERO));
						
						if(index >= 0)
							agencia.get(index).depositar(buffer);
						else
							System.out.println("Número de conta não encontrado."
									+ " Tente novamente.");
						
					} else if(input_2 == 2){
						
						System.out.print("Digite o número da conta que deseja"
								+ " depositar: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite a quantia: ");
						buffer = terminal.nextBigDecimal();
						
						index = agencia.indexOf(new ContaPoupanca("",
								numeroConta, BigDecimal.ZERO, 0));
						
						if(index >= 0)
							agencia.get(index).depositar(buffer);
						else
							System.out.println("Número de conta não encontrado."
									+ " Tente novamente.");
					
					} else if(input_2 == 3){
						
						System.out.print("Digite o número da conta que deseja"
								+ " depositar: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite a quantia: ");
						buffer = terminal.nextBigDecimal();
						
						index = agencia.indexOf(new ContaInvestimento
								("", numeroConta, BigDecimal.ZERO));
						
						if(index >= 0)
							agencia.get(index).depositar(buffer);
						else
							System.out.println("Número de conta não encontrado."
									+ " Tente novamente.");
					}
					
					break;
					
				case 5:			// Mostrar o saldo
					
					System.out.println("Deseja consultar o saldo de uma conta"
							+ " corrente, poupança ou investimento?");
					System.out.print("1 - Corrente\n2 - Poupança\n"
							+ "3 - Investimento \n0 - cancelar\n>> ");
					
					input_2 = terminal.nextInt();
					
					terminal.nextLine();

					if(input_2 == 1){
						
						System.out.print("Digite o número da conta que deseja"
								+ " consultar: ");
						numeroConta = terminal.nextLine();
						
						index = agencia.indexOf(new ContaCorrente("", 
								numeroConta, BigDecimal.ZERO, BigDecimal.ZERO));
						
						if(index >= 0)
							agencia.get(index).mostrarExtrato();
						else
							System.out.println("Número de conta não encontrado."
									+ " Tente novamente.");
						
					} else if(input_2 == 2){
						
						System.out.print("Digite o número da conta que deseja"
								+ " consultar: ");
						numeroConta = terminal.nextLine();
						
						index = agencia.indexOf(new ContaPoupanca("", 
								numeroConta, BigDecimal.ZERO, 0));
						
						if(index >= 0)
							agencia.get(index).mostrarExtrato();
						else
							System.out.println("Número de conta não encontrado."
									+ " Tente novamente.");
					
					} else if(input_2 == 3){
						
						System.out.print("Digite o número da conta que deseja"
								+ " consultar: ");
						numeroConta = terminal.nextLine();
						
						index = agencia.indexOf(new ContaInvestimento
								("", numeroConta, BigDecimal.ZERO));
						
						if(index >= 0)
							agencia.get(index).mostrarExtrato();
						else
							System.out.println("Número de conta não encontrado."
									+ " Tente novamente.");
					}
					
					break;
					
				case 6:
					
					terminal.nextLine();
					
					System.out.print("Digite o número da conta investimento que"
							+ " deseja calcular os tributos: ");
					numeroConta = terminal.nextLine();
					
					System.out.print("Digite a taxa de rendimento (em %): ");
					buffer = terminal.nextBigDecimal();
					
					index = agencia.indexOf(new ContaInvestimento("", 
							numeroConta, BigDecimal.ZERO));
					
					if(index >= 0)
						System.out.println("Tributos a serem cobrados: " +
								ContaBancaria.formataValor(
										((ContaInvestimento) agencia.get(index))
											.calcularTributo(buffer)));
					else
						System.out.println("Número de conta não encontrado."
								+ " Tente novamente.");
					
					break;
					
				case 7:
					
					terminal.nextLine();
					
					System.out.print("Digite o número da conta investimento que"
							+ " deseja calcular a taxa de administração: ");
					numeroConta = terminal.nextLine();
					
					System.out.print("Digite a taxa de rendimento (em %): ");
					buffer = terminal.nextBigDecimal();
					
					index = agencia.indexOf(new ContaInvestimento("", 
							numeroConta, BigDecimal.ZERO));
					
					if(index >= 0)
						System.out.println("Taxa de administração da conta: " +
								ContaBancaria.formataValor(
										((ContaInvestimento) agencia.get(index))
											.calcularTaxaAdministracao(buffer)));
					else
						System.out.println("Número de conta não encontrado."
								+ " Tente novamente.");
					
					break;
					
				default:
					break;
			}
		} while(input > 0);
		
		terminal.close();
	}
	
	public static void menu(){
		
		System.out.print("\n$================$================$================$\n");
		System.out.println("Digite um dos comandos no menu abaixo para efetuar\n"
				+ " uma ação");
		System.out.println("1 - Cadastrar a conta (corrente, poupança ou"
				+ " investimento) de um cliente");
		System.out.println("2 - Sacar um valor de uma conta "
				+ "(corrente, poupança ou investimento)");
		System.out.println("3 - Atualizar o rendimento de conta poupança");
		System.out.println("4 - Efetuar um depósito");
		System.out.println("5 - Mostrar saldo");
		System.out.println("6 - Calcular os tributos de uma conta investimento");
		System.out.println("7 - Calcula a taxa de administração de uma conta"
				+ " investimento");
		System.out.println("\n0 - Encerrar");
		System.out.print("\n>> ");
	}	
}