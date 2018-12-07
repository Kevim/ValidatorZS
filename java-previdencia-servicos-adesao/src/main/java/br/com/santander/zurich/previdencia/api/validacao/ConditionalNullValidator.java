package br.com.santander.zurich.previdencia.api.validacao;

/**
 * Validador responsavel por Nao permitir que os validadores sejam executados
 * com valores nulos. A unica excecao para este caso eh quando o validador
 * implementar a interface {@link AcceptNullValues}, que neste caso sera
 * executado mesmo quando o valor validado seja nulo.
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 *            Tipo do objeto que sera validado
 * 
 * @see AcceptNullValues
 */
public class ConditionalNullValidator<T> implements Validator<T> {
	
	private final Validator<T> validator;
	
	/**
	 * Validador a ser chamado caso o valor nao seja nulo
	 * @param validator O validador
	 */
	public ConditionalNullValidator(final Validator<T> validator) {
		this.validator = validator;
	}
	
	@Override
	public ValidationResult validate(final T value) {
		ValidationResult result = ValidationResult.empty();
		if(value != null || validator instanceof AcceptNullValues) {
			result = validator.validate(value);
		} 
		return result;
	}

}
