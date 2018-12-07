package br.com.santander.zurich.previdencia.api.validacao.common;

import java.math.BigDecimal;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;

/**
 * Validador que checa se um valor a um BigDecimal valido, gerando erro caso nao seja.
 * 
 * @author Arthur Fernandes
 * @see {@link Validators#isBigDecimal()}
 */
public class BigDecimalValidator implements Validator<String> {

	@Override
	public ValidationResult validate(final String value) {
		ValidationResult result = ValidationResult.empty();
		try {
			new BigDecimal(value);
		} catch (Exception e) {
			result = ValidationResult.error("BigDecimalValidator");
		}
		
		return result;
	}

}
