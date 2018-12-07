package br.com.santander.zurich.previdencia.validacao.validator;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;

public class PropostaAdesaoValidator implements Validator<PropostaAdesaoResource> {

	@Override
	public ValidationResult validate(PropostaAdesaoResource propostaAdesaoResource) {
		return ValidatorBuilder.validateBean(PropostaAdesaoResource.class)
				.validateProperty("codigoProposta").notNull()
				.validateProperty("tipoValidacao").notNull()
				.build()
				.validate(propostaAdesaoResource);
	}

}
