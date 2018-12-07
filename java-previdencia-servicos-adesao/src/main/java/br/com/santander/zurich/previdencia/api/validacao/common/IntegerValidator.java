package br.com.santander.zurich.previdencia.api.validacao.common;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;

/**
 * Validador que checa se um valor a um Integer valido, gerando erro caso nao seja.
 * 
 * @author Arthur Fernandes
 * @see {@link Validators#isInteger()}
 */
public class IntegerValidator implements Validator<String> {

	@Override
	public ValidationResult validate(final String value) {
		ValidationResult result = ValidationResult.empty();
		try {
			Integer.valueOf(value);
		} catch (Exception e) {
			result = ValidationResult.error("IntegerValidator");
		}
		
		return result;
	}

}