package br.com.santander.zurich.previdencia.validacao.validators.spring;

import br.com.santander.zurich.previdencia.api.validacao.AcceptNullValues;
import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;

public class IdadeMaximaValidator implements Validator<Integer>, AcceptNullValues {

	// TODO: injetar serviço

	@Override
	public ValidationResult validate(Integer value) {
		ValidationResult result = ValidationResult.empty();
		// TODO: chamar serviço que retorne idade maxima permitida
		Integer idadeMax = 115;
		if (value == null || value > idadeMax) {
			result = ValidationResult.error("erro.idade.maxima");
		}
		return null;
	}
}
