package br.uel.portal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class ContaInvestimento implements ContaBancaria, Tributavel{

	private String cliente,
				   numeroConta;
	
	private BigDecimal saldo;
	
	public ContaInvestimento(String cliente, String numeroConta, BigDecimal saldo){
		
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		
		this.saldo = saldo.setScale(4, RoundingMode.HALF_EVEN);
	}
	
	public void sacar(BigDecimal valor){
		
		BigDecimal buffer = this.saldo.subtract(valor);
		
		if(buffer.compareTo(BigDecimal.ZERO) < 0)
			this.saldo = buffer;
		else
			System.out.println("ERRO: Saldo insuficiente.\nSaque cancelado.");
	}
	
	public void depositar(BigDecimal valor){
		
		this.saldo = this.saldo.add(valor);
	}
	
	public BigDecimal calcularTributo(BigDecimal taxaRendimento){
		
		return this.saldo.multiply(taxaRendimento).multiply(BigDecimal
				.valueOf(0.005));
	}
	
	public BigDecimal calcularTaxaAdministracao(BigDecimal taxaRendimento){
		
		return this.saldo.multiply(taxaRendimento).multiply(BigDecimal
				.valueOf(0.01));
	}

	public void calcularNovoSaldo(BigDecimal taxaRendimento){
		
		this.saldo = this.saldo.multiply(taxaRendimento);
	}

	public void mostrarExtrato(){
		
		System.out.printf("Nome do cliente: %s\nNúmero da conta: %s\nSaldo: %s\n",
						  this.cliente, this.numeroConta, 
						  NumberFormat.getCurrencyInstance().format(this.saldo));
	}
	
	@Override
	public boolean equals(Object o){
		
		if (o == this)
	        return true;
	    
	    if (o == null || !(o instanceof ContaBancaria))
	        return false;
	     
    	ContaInvestimento p = (ContaInvestimento) o;
    	
    	return this.numeroConta.compareTo(p.numeroConta) == 0;
	}
	
	@Override
	public int hashCode(){
		
		return Integer.parseInt(this.numeroConta);
	}

	public String getCliente() {
		
		return cliente;
	}

	public void setCliente(String cliente) {
		
		this.cliente = cliente;
	}

	public String getNumeroConta() {
		
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		
		this.numeroConta = numeroConta;
	}

	public BigDecimal getSaldo() {
		
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		
		this.saldo = saldo;
	}
}
