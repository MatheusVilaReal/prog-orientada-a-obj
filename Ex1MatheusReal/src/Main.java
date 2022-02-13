import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		Scanner terminal = new Scanner(System.in);
		
		System.out.println("Insira o nome: ");
		String nome = terminal.nextLine();
		
		System.out.println("Insira o sobrenome: ");
		String sobrenome = terminal.nextLine();
		
		System.out.println("Insira o dia de nascimento (1 a 31): ");
		int dia = terminal.nextInt();
		
		System.out.println("Insira o mês de nascimento (janeiro - 1, dezembro - 12): ");
		int mes = terminal.nextInt();
		
		System.out.println("Insira o ano de nascimento: ");
		int ano = terminal.nextInt();
		
		HeartRates heartRates = new HeartRates(nome, sobrenome, dia, mes, ano);
		
		System.out.printf("Nome: %s\n", heartRates.getNome());
		System.out.printf("Sobrenome: %s\n", heartRates.getSobrenome());
		System.out.printf("Data de Nascimento: %d/%d/%d\n", heartRates.getDia(), heartRates.getMes(), heartRates.getAno());
		System.out.printf("Idade: %d anos\n", heartRates.getAge());
		System.out.printf("Freq max: %s bpm\n", heartRates.getHeartRateMax());
		System.out.printf("Freq alvo: %s bpm\n", heartRates.getHeartRateAlvo());
		
		terminal.close();
	}
}
