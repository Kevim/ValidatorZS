package br.com.santander.zurich.previdencia.validacao.validators;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.resource.PagamentoResource;
import br.com.santander.zurich.previdencia.validacao.validator.conditions.BoletoBancarioCondition;

public class PagamentoValidator implements Validator<PagamentoResource> {

	@Override
	public ValidationResult validate(PagamentoResource pagamentoResource) {
		return ValidatorBuilder.validateBean(PagamentoResource.class)
				.validateProperty("formaPagamento").notNull()
				.validateProperty("dataPagamentoInicial").notNull()
				.validateProperty("diaPagamentoMensalidades").notNull()
				.validateProperty("endereco").notNull().when("formaPagamento", new BoletoBancarioCondition())
				.build().validate(pagamentoResource);
	}

}
