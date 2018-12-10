package br.com.santander.zurich.previdencia.validacao.validators;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.resource.ContatoResource;

public class ContatoValidator implements Validator<ContatoResource> {

	@Override
	public ValidationResult validate(ContatoResource contatoResource) {
		return ValidatorBuilder.validateBean(ContatoResource.class)
				.validateProperty("email").notNull().notEmpty()
				.validateProperty("dddTelefone").notNull()
				.validateProperty("numeroTelefone").notNull()
				.build().validate(contatoResource);
	}

}
