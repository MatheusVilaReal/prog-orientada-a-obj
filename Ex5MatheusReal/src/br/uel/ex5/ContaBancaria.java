package br.uel.ex5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public abstract class ContaBancaria{

	private String numero,
				   cliente;
	
	protected BigDecimal saldo;
	
	public static String formataValor(BigDecimal valor){
		
		return NumberFormat.getCurrencyInstance().format(valor);
	}
	
	public ContaBancaria(String cliente, String numero, BigDecimal saldo){
		
		this.cliente = cliente;
		this.numero = numero;
		
		this.saldo = saldo.setScale(4, RoundingMode.HALF_EVEN);
									/* Padrão adotado pelo ****
									 * Banco Central do Brasil*/
	}
	
	public abstract void sacar(BigDecimal valor);
	
	public void depositar(BigDecimal valor){
		
		this.saldo = this.saldo.add(valor);
	}
	
	public void mostrarExtrato(){
		
		System.out.printf("Nome do cliente: %s\nNúmero da conta: %s\nSaldo: %s\n",
						  this.cliente, this.numero, formataValor(this.saldo));
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o == this)
			return true;
		
		if(o == null || !(o instanceof ContaBancaria))
			return false;
		
		ContaBancaria p = (ContaBancaria) o;
		
		return this.numero.compareTo(p.numero) == 0;
	}
	
	@Override
	public int hashCode(){
		
		return Integer.parseInt(this.numero);
	}
	
	/**************************************************************************/

	public BigDecimal getSaldo() {
	
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		
		this.saldo = saldo;
	}

	public String getNumero() {
		
		return numero;
	}

	public void setNumero(String numero) {
		
		this.numero = numero;
	}

	public String getCliente() {
		
		return cliente;
	}

	public void setCliente(String cliente) {
		
		this.cliente = cliente;
	}
}