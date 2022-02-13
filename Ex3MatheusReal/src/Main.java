import java.util.Scanner;
import java.util.LinkedList;

public class Main{
	public static void main(String[] args){
		
		LinkedList <ContaCorrente> contasCorrente = new LinkedList <ContaCorrente>();
		LinkedList <ContaPoupanca> contasPoupanca= new LinkedList <ContaPoupanca>();
		
		Scanner terminal = new Scanner(System.in);
		
		String cliente = null,
			   numeroConta = null;
		
		double saldo = 0,
			   limite = 0,
			   buffer = 0;
		
		int diaRendimento = 0;
		
		int input = 0,
			input_2 = 0,
			index = -1;
		
		do{
			
			menu();
			input = terminal.nextInt();
			
			switch(input){
			
				case 1:			// Cadastrar nova conta
					
					System.out.println("Deseja cadastrar uma conta corrente ou poupança?");
					System.out.print("1 - Corrente\n2 - Poupança\n0 - cancelar\n>> ");
					
					input_2 = terminal.nextInt();
					
					terminal.nextLine();
					
					if(input_2 == 1){
						
						System.out.print("Digite o nome do cliente: ");
						cliente = terminal.nextLine();
						
						System.out.print("Digite o número da conta: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite o saldo inicial: ");
						saldo = terminal.nextDouble();
						
						System.out.print("Digite o limite da conta: ");
						limite = terminal.nextDouble();
						
						contasCorrente.add(new ContaCorrente(cliente, numeroConta, saldo, limite));
						
					} else if(input_2 == 2){
						
						System.out.print("Digite o nome do cliente: ");
						cliente = terminal.nextLine();
						
						System.out.print("Digite o número da conta: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite o saldo inicial: ");
						saldo = terminal.nextDouble();
						
						System.out.print("Digite o rendimento da conta: ");
						diaRendimento = terminal.nextInt();
						
						contasPoupanca.add(new ContaPoupanca(cliente, numeroConta, saldo, diaRendimento));
					}
					
					break;
					
				case 2:			// Sacar
					
					System.out.println("Deseja sacar uma conta corrente ou poupança?");
					System.out.print("1 - Corrente\n2 - Poupança\n0 - cancelar\n>> ");
					
					input_2 = terminal.nextInt();
					
					terminal.nextLine();
					
					if(input_2 == 1){
						
						System.out.print("Digite o número da conta que deseja sacar: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite a quantia: ");
						buffer = terminal.nextDouble();
						
						index = contasCorrente.indexOf(new ContaCorrente("", numeroConta, 0, 0));
						
						if(index >= 0)
							contasCorrente.get(index).sacar(buffer);
						else
							System.out.println("Número de conta não encontrado. Tente novamente.");
						
					} else if(input_2 == 2){
						
						System.out.print("Digite o número da conta que deseja sacar: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite a quantia: ");
						buffer = terminal.nextDouble();
						
						index = contasPoupanca.indexOf(new ContaPoupanca("", numeroConta, 0, 0));
						
						if(index >= 0)
							contasPoupanca.get(index).sacar(buffer);
						else
							System.out.println("Número de conta não encontrado. Tente novamente.");
					}
					
					break;
					
				case 3:			// Atualizar saldo
					
					terminal.nextLine();
					
					System.out.print("Digite o número da conta poupança que deseja atualizar: ");
					numeroConta = terminal.nextLine();
					
					System.out.print("Digite o rendimento (em %): ");
					buffer = terminal.nextDouble();
					
					index = contasPoupanca.indexOf(new ContaPoupanca("", numeroConta, 0, 0));
					
					if(index >= 0)
						contasPoupanca.get(index).calcularNovoSaldo(buffer);
					else
						System.out.println("Número de conta não encontrado. Tente novamente.");
					
					break;
					
				case 4:			// Depositar
					
					System.out.println("Deseja depositar em uma conta corrente ou poupança?");
					System.out.print("1 - Corrente\n2 - Poupança\n0 - cancelar\n>> ");
					
					input_2 = terminal.nextInt();
					
					terminal.nextLine();
					
					if(input_2 == 1){
						
						System.out.print("Digite o número da conta que deseja depositar: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite a quantia: ");
						buffer = terminal.nextDouble();
						
						index = contasCorrente.indexOf(new ContaCorrente("", numeroConta, 0, 0));
						
						if(index >= 0)
							contasCorrente.get(index).depositar(buffer);
						else
							System.out.println("Número de conta não encontrado. Tente novamente.");
						
					} else if(input_2 == 2){
						
						System.out.print("Digite o número da conta que deseja depositar: ");
						numeroConta = terminal.nextLine();
						
						System.out.print("Digite a quantia: ");
						buffer = terminal.nextDouble();
						
						index = contasPoupanca.indexOf(new ContaPoupanca("", numeroConta, 0, 0));
						
						if(index >= 0)
							contasPoupanca.get(index).depositar(buffer);
						else
							System.out.println("Número de conta não encontrado. Tente novamente.");
					}
					
					break;
					
				case 5:			// Mostrar o saldo
					
					System.out.println("Deseja consultar o saldo de uma conta corrente ou poupança?");
					System.out.print("1 - Corrente\n2 - Poupança\n0 - cancelar\n>> ");
					
					input_2 = terminal.nextInt();
					
					terminal.nextLine();

					if(input_2 == 1){
						
						System.out.print("Digite o número da conta que deseja consultar: ");
						numeroConta = terminal.nextLine();
						
						index = contasCorrente.indexOf(new ContaCorrente("", numeroConta, 0, 0));
						
						if(index >= 0)
							contasCorrente.get(index).mostrarExtrato();
						else
							System.out.println("Número de conta não encontrado. Tente novamente.");
						
					} else if(input_2 == 2){
						
						System.out.print("Digite o número da conta que deseja consultar: ");
						numeroConta = terminal.nextLine();
						
						index = contasPoupanca.indexOf(new ContaPoupanca("", numeroConta, 0, 0));
						
						if(index >= 0)
							contasPoupanca.get(index).mostrarExtrato();
						else
							System.out.println("Número de conta não encontrado. Tente novamente.");
					}
					
					break;
					
				default:
					break;
			}
		} while(input > 0);
		
		terminal.close();
	}
	
	public static void menu(){
		
		System.out.print("\n$================$================$================$\n");
		System.out.println("Digite um dos comandos no menu abaixo para efetuar\numa ação");
		System.out.println("1 - Cadastrar a conta (poupança ou corrente) de um cliente");
		System.out.println("2 - Sacar um valor de uma conta (poupança ou corrente)");
		System.out.println("3 - Atualizar o rendimento de conta poupança");
		System.out.println("4 - Efetuar um depósito");
		System.out.println("5 - Mostrar saldo");
		System.out.println("\n0 - Encerrar");
		System.out.print("\n>> ");
	}
}
