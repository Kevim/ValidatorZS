package br.com.santander.zurich.previdencia.validacao.validators;

import br.com.santander.zurich.previdencia.api.validacao.CollectionElementValidator;
import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.resource.BeneficiarioResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;

public class BeneficiariosValidator implements Validator<PropostaAdesaoResource> {

	@Override
	public ValidationResult validate(PropostaAdesaoResource propostaAdesaoResource) {
		return ValidatorBuilder.validateBean(PropostaAdesaoResource.class)
				.validateProperty("beneficiarios").notNull().notEmpty()
				.with(new CollectionElementValidator<BeneficiarioResource>(new BeneficiarioValidator()))
				.build()
				.validate(propostaAdesaoResource);
	}

}
