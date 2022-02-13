import java.util.Calendar;

public class HeartRates{

	private String nome, sobrenome;
	private int dia, mes, ano;
	
	public HeartRates(String nome, String sobrenome, int dia, int mes, int ano){
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int getAge(){
		
		Calendar dataHoje = Calendar.getInstance();
		
		int anoAtual = dataHoje.get(Calendar.YEAR);
		int mesAtual = dataHoje.get(Calendar.MONTH) + 1;
		int diaAtual = dataHoje.get(Calendar.DAY_OF_MONTH);
		
		int jaFezAniversario = 0;
		
		if(mesAtual > this.mes)
			jaFezAniversario = 1;
		else if(mesAtual == this.mes && diaAtual >= this.dia)
				jaFezAniversario = 1;
		
		return (anoAtual - this.ano - 1) + jaFezAniversario;
	}
	
	public int getHeartRateMax() {
		
		return 220 - this.getAge();
	}
	
	public String getHeartRateAlvo() {
		
		int heartRateMax = this.getHeartRateMax();
		
		String intervalo = new String();
		
		intervalo = String.format("%.0f-%.0f", 0.5 * heartRateMax, 0.85 * heartRateMax);
		
		return intervalo;
	}
	
/*******************************************************************/
	
	public String getNome(){
		
		return this.nome;
	}
	
	public String getSobrenome(){
		
		return this.sobrenome;
	}
	
	public int getDia(){
		
		return this.dia;
	}
	
	public int getMes(){
		
		return this.mes;
	}
	
	public int getAno(){
		
		return this.ano;
	}
	
	public void setNome(String nome){
		
		this.nome = nome;
	}
	
	public void setSobrenome(String sobrenome){
		
		this.sobrenome = sobrenome;
	}
	
	public void setDia(int dia){
		
		this.dia = dia;
	}
	
	public void setMes(int mes){
		
		this.mes = mes;
	}
	
	public void setAno(int ano){
		
		this.ano = ano;
	}
}
