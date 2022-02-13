import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrente extends ContaBancaria{
	
	private BigDecimal limite;
	
	public ContaCorrente(String cliente, String numeroConta, double saldo, double limite){
		super(cliente, numeroConta, saldo);
		
		if(limite > 0)
			limite *= -1;
		
		this.limite = new BigDecimal(String.valueOf(limite)).setScale(4, RoundingMode.HALF_EVEN);
																		/* Padrão adotado pelo
																		 * Banco Central do Brasil*/
	}
	
	@Override
	public void sacar(double valor){
		
		BigDecimal buffer = this.saldo.subtract(BigDecimal.valueOf(valor));
			
		if(buffer.compareTo(this.limite) >= 0)
			this.saldo = buffer;
		else
			System.out.println("Não foi possível realizar saque, saldo insuficiente.");
	}
	
	public BigDecimal getLimite(){
		
		return this.limite;
	}
	
	public void setLimite(double valor){
		
		this.limite = BigDecimal.valueOf(valor);
	}
}
