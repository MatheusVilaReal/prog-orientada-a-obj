package br.uel.ex5;

import java.math.BigDecimal;
//import java.math.RoundingMode;

public class ContaPoupanca extends ContaBancaria{
	
	private int diaRendimento;
	
	public ContaPoupanca(String cliente, String numero, BigDecimal saldo,
			int diaRendimento){
		super(cliente, numero, saldo);
		
		this.diaRendimento = diaRendimento;
	}
	
	public void sacar(BigDecimal valor){
		
		BigDecimal buffer = this.saldo.subtract(valor);
		
		if(buffer.compareTo(this.saldo) <= 0)
			this.saldo = buffer;
		else
			System.out.println("ERRO\nSaldo insuficiente para efetuar saque.");
	}
	
	public void calcularNovoSaldo(BigDecimal taxaRendimento){
		
		taxaRendimento = taxaRendimento.divide(BigDecimal.valueOf(100f));
		
		this.saldo = this.saldo.add(this.saldo.multiply(taxaRendimento));
	}

	public int getDiaRendimento(){
		
		return diaRendimento;
	}

	public void setDiaRendimento(int diaRendimento){
		
		this.diaRendimento = diaRendimento;
	}
}
