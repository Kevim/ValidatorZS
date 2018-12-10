package br.com.santander.zurich.previdencia.validacao.validator.conditions;

import br.com.santander.zurich.previdencia.api.validacao.condition.Condition;
import br.com.santander.zurich.previdencia.enums.FormaPagamentoEnum;

public class BoletoBancarioCondition implements Condition<FormaPagamentoEnum> {

	@Override
	public boolean isApplied(FormaPagamentoEnum value) {
		return FormaPagamentoEnum.BOLETO.equals(value);
	}

}
