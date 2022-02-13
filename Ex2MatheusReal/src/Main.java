import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Character;

public class Main {
	public static void main(String[] args){
	
		Scanner terminal = new Scanner(System.in);
		
		ArrayList <Costumer> regularQueue = new ArrayList <Costumer>();
		ArrayList <Costumer> seniorQueue = new ArrayList <Costumer>();
		
		Costumer toInsert = null;
		String name = null, task = null, toSearch = null;
		int input = 0, age = 0;
		char ch = 0;
		boolean attendSenior = true;
		
		printMenu();
		input = terminal.nextInt();
		
		while(input > 0){
			switch(input){
			
				case 1:			// Adicionar cliente
					
					terminal.nextLine();
					
					System.out.print("\nInsira o nome do cliente: ");
					name = terminal.nextLine();
					
					System.out.print("Insira a idade do cliente: ");
					age = terminal.nextInt();
					terminal.nextLine();
					
					System.out.print("Insira o serviço a ser realizado: ");
					task = terminal.nextLine();
					
					toInsert = new Costumer(name, age, task);
					
					if(age < 65)
						regularQueue.add(toInsert);
							
					else
						seniorQueue.add(toInsert);
						
					break;
				
				case 2:			// Atender cliente		
					
					if((attendSenior || regularQueue.size() == 0) && seniorQueue.size() > 0){
						
						seniorQueue.remove(0);	
						attendSenior = false;
						
					} else if(regularQueue.size() > 0){
						
						regularQueue.remove(0);
						attendSenior = true;
						
					} else System.out.println("\nNão há clientes para atender");
					
					break;
					
				case 3:			// Remover cliente
			
					System.out.print("\nIndique a fila para buscar (C - comum/P - preferencial): ");
					
					ch = terminal.next().charAt(0);
					ch = Character.toUpperCase(ch);
					
					System.out.print("Insira a posição do cliente na fila para remover (0 - primeiro): ");
					
					switch(ch){
					
						case 'C':
							
							regularQueue.remove(terminal.nextInt());
							
							break;
							
						case 'P':
							
							seniorQueue.remove(terminal.nextInt());
							
							break;
							
						default:
							break;
					}
					
					break;
					
				case 4:				// Pesquisar na fila
					
					System.out.print("\nIndique a fila para buscar (C - comum/P - preferencial): ");
					
					ch = terminal.next().charAt(0);
					ch = Character.toUpperCase(ch);
					
					terminal.nextLine();
					
					System.out.print("\nIndique o nome do cliente: ");
					toSearch = new String(terminal.nextLine());
					
					switch(ch){
					
						case 'C':
							
							System.out.println("Correspondências encontradas:");
							
							for(int i = 0; i < regularQueue.size(); i++){
								
								if(regularQueue.get(i).compareCostumerName(toSearch)){
									
									System.out.printf("[%d] ", i);
									regularQueue.get(i).displayCostumer("");
								}
							}
							
							break;
							
						case 'P':
							
							System.out.println("Correspondências encontradas:");
							
							for(int i = 0; i < regularQueue.size(); i++){
								
								if(regularQueue.get(i).compareCostumerName(toSearch)){
									
									System.out.printf("[%d] ", i);
									regularQueue.get(i).displayCostumer("");
								}
							}
							
							break;
							
						default:
							break;
					}
					
					break;
					
				case 5:
					
					System.out.print("\nIndique a fila para imprimir (C - comum/P - preferencial/A - ambas): ");
					
					ch = terminal.next().charAt(0);
					ch = Character.toUpperCase(ch);
					
					terminal.nextLine();
					
					switch(ch){
					
						case 'C':
							
							printQueue(regularQueue);
							
							break;
							
						case 'P':
							
							printQueue(seniorQueue);
							
							break;
							
						case 'A':
							
							System.out.println("\nFila comum: ");
							
							printQueue(regularQueue);
							
							System.out.println("\nFila preferencial: ");
							
							printQueue(seniorQueue);
							
							break;
							
						default:
							break;
					}
					
					break;
					
				default:
					break;
			}
			
			printMenu();
			input = terminal.nextInt();
		}
		
		terminal.close();
	}
	
	public static void printMenu(){
		
		System.out.print("\n$================$================$================$\n");
		System.out.println("Digite um dos comandos no menu abaixo para efetuar\numa ação");
		System.out.println("1 - Inserir novo cliente na fila");
		System.out.println("2 - Atender um cliente");
		System.out.println("3 - Remover cliente da fila");
		System.out.println("4 - Pesquisar um cliente");
		System.out.println("5 - Imprimir fila");
		System.out.println("\n0 - Encerrar");
		System.out.print("\n>> ");
	}
	
	public static void printQueue(ArrayList <Costumer> queue){
		
		if(queue.size() == 0)
			System.out.println("(vazia)");
		
		for(int i = 0; i < queue.size(); i++){
			
			System.out.printf("[%d] ", i);
			queue.get(i).displayCostumer("");
		}
	}
}