import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class ContaBancaria{

	public String cliente;
	public String numeroConta;
	
	protected BigDecimal saldo;
	
	public ContaBancaria(String cliente, String numeroConta, double saldo){
		
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.saldo = new BigDecimal(String.valueOf(saldo)).setScale(4, RoundingMode.HALF_EVEN);
																	/* Padrão adotado pelo
																	 * Banco Central do Brasil*/
	}

	public void sacar(double valor){
		
		BigDecimal buffer = this.saldo.subtract(BigDecimal.valueOf(valor));
		
		if(buffer.compareTo(BigDecimal.ZERO) > 0)
			this.saldo = buffer;
		else
			System.out.println("Não foi possível realizar saque, saldo insuficiente.");
	}

	public void depositar(double valor){
		
		this.saldo = this.saldo.add(BigDecimal.valueOf(valor));
	}

	public void mostrarExtrato(){
		
		System.out.printf("Nome do cliente: %s\nNúmero da conta: %s\nSaldo: %s\n",
						  this.cliente, this.numeroConta, 
						  NumberFormat.getCurrencyInstance().format(this.saldo));
	}

	@Override
	public boolean equals(Object o) {
		
	    if (o == this)
	        return true;
	    
	    if (o == null || !(o instanceof ContaBancaria))
	        return false;
	     
    	ContaBancaria p = (ContaBancaria) o;
    	
    	return this.numeroConta.compareTo(p.numeroConta) == 0;
	}

	@Override
	public int hashCode(){
		
		return Integer.parseInt(this.cliente);
	}
}