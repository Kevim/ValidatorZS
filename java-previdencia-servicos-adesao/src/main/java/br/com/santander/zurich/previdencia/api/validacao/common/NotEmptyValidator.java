package br.com.santander.zurich.previdencia.api.validacao.common;

import java.util.Collection;

import br.com.santander.zurich.previdencia.api.validacao.AcceptNullValues;
import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.exception.ValidationNotSupportedException;

/**
 * Validador que checa se um valor nao esta vazio, gerando erro caso nao seja.
 * Caso o valor seja nulo, a validaaao tambam gera erro. Suporta os tipos String
 * e Collection.
 * 
 * @author Ricardo Okura
 * @see {@link Validators#notEmpty()}
 * @see {@link NotNullValidator}
 */
public class NotEmptyValidator<T> implements Validator<T>, AcceptNullValues {

	@Override
	public ValidationResult validate(final T value) {
		ValidationResult result = Validators.notNull().validate(value);
		if (!result.hasErrors()) {
			if (value instanceof String){
				String strValue = (String) value;
				if (strValue.isEmpty()){
					result = ValidationResult.error("NotEmptyValidator");
				}
			} else if (value instanceof Collection<?>){
				Collection<?> collection = (Collection<?>) value;
				if (collection.isEmpty()){
					result = ValidationResult.error("NotEmptyValidator");
				}
			}else{
				throw new ValidationNotSupportedException();
			}
		}
		return result;
	}

}
