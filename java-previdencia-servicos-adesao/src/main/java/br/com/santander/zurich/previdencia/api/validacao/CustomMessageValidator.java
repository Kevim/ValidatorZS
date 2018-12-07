package br.com.santander.zurich.previdencia.api.validacao;


/**
 * Validador utilizado para sobreescrever a mensagem retornada por outro validador.
 * 
 * @see {@link com.porto.cds.validation.builder.PropertyValidatorBuilder#withCustomMessage(String) 
 * 		PropertyValidatorBuilder.withCustomMessage(String)}
 * @see {@link com.porto.cds.validation.builder.ValidatorBuilder#withCustomMessage(String) 
 * 		ValidatorBuilder.withCustomMessage(String)}
 * @author Arthur Fernandes
 *
 * @param <T>
 *            Tipo do objeto que sera validado
 */
public class CustomMessageValidator<T> implements Validator<T>, AcceptNullValues {

	private final String customMessage;
	private final Validator<T> validator;
	
	/**
	 * Validador que sera reescrito a mensagem
	 * @param validator O validado a ser reescrito
	 * @param customMessage Mensagem a ser substituida
	 */
	public CustomMessageValidator(final Validator<T> validator, final String customMessage) {
		this.customMessage = customMessage;
		this.validator = validator;
	}
	
	@Override
	public ValidationResult validate(final T value) {
		ValidationResult result = validator.validate(value);
		if (result.hasErrors()){
			result = ValidationResult.error(customMessage);
		}
		return result;
	}

}
