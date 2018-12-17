package br.com.santander.zurich.previdencia.validacao.validators.spring;

import br.com.santander.zurich.previdencia.api.validacao.AcceptNullValues;
import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;

public class LucroMinimoValidator implements Validator<Double>, AcceptNullValues {

	// TODO: injetar serviço

	@Override
	public ValidationResult validate(Double value) {
		ValidationResult result = ValidationResult.empty();
		// TODO: chamar serviço que retorne valor minimo de lucro
		Double valorMinLucro = 30D;
		if (value == null || value < valorMinLucro) {
			result = ValidationResult.error("erro.lucro.minimo");
		}
		return null;
	}
}
