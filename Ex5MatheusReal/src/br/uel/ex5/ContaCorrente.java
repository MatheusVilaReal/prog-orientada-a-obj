package br.uel.ex5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class ContaCorrente extends ContaBancaria{
	
	private BigDecimal limite;

	public ContaCorrente(String cliente, String numero, BigDecimal saldo,
			BigDecimal limite){
		super(cliente, numero, saldo);
		
		if(limite.compareTo(BigDecimal.valueOf(-1f)) < 0)
			limite = limite.multiply(BigDecimal.valueOf(-1f));
		
		this.limite = limite.setScale(4, RoundingMode.HALF_EVEN);
	}
	
	public void sacar(BigDecimal valor){
		
		BigDecimal buffer = this.saldo.subtract(valor);
		
		if(buffer.compareTo(this.limite) >= 0)
			this.saldo = buffer;
		else
			System.out.println("ERRO\nSaldo insuficiente para efetuar saque.");
	}
	
	public String getLimiteFormatado(){
		
		return NumberFormat.getCurrencyInstance().format(this.limite);
	}

	public BigDecimal getLimite(){
		
		return limite;
	}

	public void setLimite(BigDecimal limite){
		
		this.limite = limite;
	}
	
//	public void calcularNovoSaldo(BigDecimal taxaRendimento){
//		
//		
//	}
}
