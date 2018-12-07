package br.com.santander.zurich.previdencia.validacao.validator;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;

public class DomicilioFiscalValidator implements Validator<PropostaAdesaoResource> {

	@Override
	public ValidationResult validate(PropostaAdesaoResource PropostaAdesaoResource) {
		return ValidatorBuilder.validateBean(PropostaAdesaoResource.class).validateProperty("residenteFiscalExterior")
				.notNull().build().validate(PropostaAdesaoResource);
	}

}
