package br.com.santander.zurich.previdencia.api.validacao.condition;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;

/**
 * Validador condicional responsavel por executar um {@link Validator}
 * dependendo do retorno de um {@link Condition}.
 * 
 * @author Ricardo okura
 * 
 * @param <T>
 *            Tipo do objeto que sera validado
 */
public final class ConditionalValidator<T> implements Validator<T> {

	private final Validator<T> 	validator;
	private final Condition<T> 	condition;
	
	/**
	 * Construtor padrao
	 * @param validator Validador a ser usado na condition
	 * @param condition Condition a ser aplicada
	 */
	public ConditionalValidator(final Validator<T> validator, final Condition<T> condition) {
		super();
		this.validator = validator;
		this.condition = condition;
	}
	
	@Override
	public ValidationResult validate(final T value) {
		ValidationResult result = ValidationResult.empty();
		if (condition.isApplied(value)) {
			result = validator.validate(value);
		}
		return result;
	}
	
}
