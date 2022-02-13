package br.uel.portal;

import java.math.BigDecimal;

public interface ContaBancaria{

	void sacar(BigDecimal valor);
	
	void depositar(BigDecimal valor);
}