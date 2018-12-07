package br.com.santander.zurich.previdencia.api.validacao.common;

import br.com.santander.zurich.previdencia.api.validacao.AcceptNullValues;
import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;

/**
 * Validador que checa se um valor a diferente de nulo, gerando erro caso nao
 * seja.
 * 
 * @author Ricardo Okura
 * @see {@link Validators#notNull()}
 */
public class NotNullValidator<T> implements Validator<T>, AcceptNullValues {

	@Override
	public ValidationResult validate(final T value) {
		ValidationResult result = ValidationResult.empty();
		if (value == null) {
			result = ValidationResult.error("NotNullValidator");
		}
		return result;
	}

}
