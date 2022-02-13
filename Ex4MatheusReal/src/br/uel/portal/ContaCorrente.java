package br.uel.portal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class ContaCorrente implements ContaBancaria{

	private BigDecimal saldo,
					   limite;
	
	private String cliente,
		   		   numeroConta;
	
	public ContaCorrente(String cliente, String numeroConta, BigDecimal saldo,
			BigDecimal limite){
		
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		
		this.saldo = saldo.setScale(4, RoundingMode.HALF_EVEN);

		if(limite.compareTo(BigDecimal.valueOf(-1)) > 0)
			limite = limite.multiply(BigDecimal.valueOf(-1));
		
		this.limite = limite.setScale(4, RoundingMode.HALF_EVEN);
	}
	
	public void sacar(BigDecimal valor){

		BigDecimal buffer = this.saldo.subtract(valor);
		
		if(buffer.compareTo(this.limite) <= 0)
			this.saldo = buffer;
		else
			System.out.println("ERRO: Saldo insuficiente.\nSaque cancelado.");
	}

	public void depositar(BigDecimal valor){
		
		this.saldo = this.saldo.add(valor);
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
	     
    	ContaCorrente p = (ContaCorrente) o;
    	
    	return this.numeroConta.compareTo(p.numeroConta) == 0;
	}
	
	@Override
	public int hashCode(){
		
		return Integer.parseInt(this.numeroConta);
	}
	
	public BigDecimal getSaldo() {
		
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		
		this.saldo = saldo;
	}

	public BigDecimal getLimite() {
		
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		
		this.limite = limite;
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
}
