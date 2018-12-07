package br.com.santander.zurich.previdencia.validacao.validator;

import br.com.santander.zurich.previdencia.api.validacao.ArrayElementValidator;
import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.resource.FundoResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;

public class FundoInvestimentoValidator implements Validator<PropostaAdesaoResource> {

	@Override
	public ValidationResult validate(PropostaAdesaoResource PropostaAdesaoResource) {
		return ValidatorBuilder.validateBean(PropostaAdesaoResource.class).validateProperty("fundosInvestimento").notNull()
				.notEmpty().with(new ArrayElementValidator<FundoResource>(new FundoValidator()))
				.build()
				.validate(PropostaAdesaoResource);
	}

}
