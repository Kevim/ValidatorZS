package br.com.santander.zurich.previdencia.validacao.validator;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.resource.FundoResource;

public class FundoValidator implements Validator<FundoResource> {

	@Override
	public ValidationResult validate(FundoResource fundoResource) {
		return ValidatorBuilder.validateBean(FundoResource.class).validateProperty("codigoFundo").notNull()
				.validateProperty("valorMinimo").notNull().validateProperty("percentualContribuicao").build()
				.validate(fundoResource);
	}

}
