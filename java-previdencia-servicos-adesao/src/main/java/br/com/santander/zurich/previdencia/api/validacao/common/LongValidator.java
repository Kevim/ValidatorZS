package br.com.santander.zurich.previdencia.api.validacao.common;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;

/**
 * Validador que checa se um valor a um Long valido, gerando erro caso nao seja.
 * 
 * @author Arthur Fernandes
 * @see {@link Validators#isLong()}
 */
public class LongValidator implements Validator<String> {

	@Override
	public ValidationResult validate(final String value) {
		ValidationResult result = ValidationResult.empty();
		try {
			Long.valueOf(value);
		} catch (Exception e) {
			result = ValidationResult.error("LongValidator");
		}
		
		return result;
	}

}