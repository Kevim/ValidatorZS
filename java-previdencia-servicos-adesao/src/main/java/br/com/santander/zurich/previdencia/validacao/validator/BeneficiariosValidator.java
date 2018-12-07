package br.com.santander.zurich.previdencia.validacao.validator;

import br.com.santander.zurich.previdencia.api.validacao.ArrayElementValidator;
import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.resource.BeneficiarioResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;

public class BeneficiariosValidator implements Validator<PropostaAdesaoResource> {

	@Override
	public ValidationResult validate(PropostaAdesaoResource PropostaAdesaoResource) {
		return ValidatorBuilder.validateBean(PropostaAdesaoResource.class)
				.validateProperty("beneficiarios").notNull().notEmpty()
				.with(new ArrayElementValidator<BeneficiarioResource>(new BeneficiarioValidator()))
				.build()
				.validate(PropostaAdesaoResource);
	}

}
