package br.uel.portal;

import java.math.BigDecimal;

public interface Tributavel{

	BigDecimal calcularTributo(BigDecimal taxaRendimento);
}