package br.uel.ex5;

import java.math.BigDecimal;

public class ContaInvestimento extends ContaBancaria{

	public ContaInvestimento(String cliente, String numero, BigDecimal saldo){
		super(cliente, numero, saldo);
	}
	
	public BigDecimal calcularTributo(BigDecimal taxaRendimento){

		taxaRendimento = taxaRendimento.divide(BigDecimal.valueOf(100f));
		
		return this.saldo.multiply(taxaRendimento).multiply(BigDecimal
				.valueOf(0.005));
	}

	public BigDecimal calcularTaxaAdministracao(BigDecimal taxaRendimento){
		
		taxaRendimento = taxaRendimento.divide(BigDecimal.valueOf(100f));
		
		return this.saldo.multiply(taxaRendimento).multiply(BigDecimal
				.valueOf(0.01));
	}
	
	public void calcularNovoSaldo(BigDecimal taxaRendimento){
		
		this.saldo = this.saldo.add(this.saldo.multiply(taxaRendimento));
	}

	public void sacar(BigDecimal valor){
		
		BigDecimal buffer = this.saldo.subtract(valor);
		
		if(buffer.compareTo(this.saldo) <= 0)
			this.saldo = buffer;
		else
			System.out.println("ERRO\nSaldo insuficiente para efetuar saque.");
	}
}
