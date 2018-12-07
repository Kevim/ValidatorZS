package br.com.santander.zurich.previdencia.api.validacao.common;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;

/**
 * Validador que checa se um valor a um Byte valido, gerando erro caso nao seja.
 * 
 * @author Arthur Fernandes
 * @see {@link Validators#isByte()}
 */
public class ByteValidator implements Validator<String> {

	@Override
	public ValidationResult validate(final String value) {
		ValidationResult result = ValidationResult.empty();
		try {
			Byte.valueOf(value);
		} catch (Exception e) {
			result = ValidationResult.error("ByteValidator");
		}
		
		return result;
	}

}