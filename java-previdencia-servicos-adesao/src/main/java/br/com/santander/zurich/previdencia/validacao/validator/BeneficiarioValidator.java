package br.com.santander.zurich.previdencia.validacao.validator;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.resource.BeneficiarioResource;

public class BeneficiarioValidator implements Validator<BeneficiarioResource> {

	@Override
	public ValidationResult validate(BeneficiarioResource beneficiarioResource) {
		return ValidatorBuilder.validateBean(BeneficiarioResource.class)
				.validateProperty("cpf").notNull()
				.validateProperty("nomeCompleto").notNull()
				.validateProperty("dataNascimento").notNull()
				.validateProperty("grauParentesco").notNull()
				.validateProperty("genero").notNull()
				.validateProperty("percentualAcumulacao").notNull()
				.build()
				.validate(beneficiarioResource);
	}

}
