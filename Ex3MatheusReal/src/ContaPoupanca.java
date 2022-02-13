import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaPoupanca extends ContaBancaria{
	
	private int diaRendimento;

	public ContaPoupanca(String cliente, String numeroConta, double saldo, int diaRendimento){
		super(cliente, numeroConta, saldo);
		
		this.diaRendimento = diaRendimento;
	}
	
	public void calcularNovoSaldo(double rendimento){
		
		BigDecimal multiplicand = BigDecimal.valueOf(rendimento + 100).setScale(4, RoundingMode.HALF_EVEN);
		multiplicand = multiplicand.divide(BigDecimal.valueOf(100));
		
		this.saldo = this.saldo.multiply(multiplicand);
	}
	
	public int getDiaRendimento(){
		
		return this.diaRendimento; 
	}
	
	public void setDiaRendimento(int diaRendimento){
		
		this.diaRendimento = diaRendimento;
	}
}
