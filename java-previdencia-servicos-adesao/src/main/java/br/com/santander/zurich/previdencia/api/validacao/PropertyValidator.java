package br.com.santander.zurich.previdencia.api.validacao;

import java.text.MessageFormat;

import org.apache.commons.beanutils.PropertyUtils;

import com.google.common.base.Function;

import br.com.santander.zurich.previdencia.api.validacao.exception.ValidationException;

/**
 * Validador de propriedade de um bean, responsavel por extrair o valor da
 * propriedade e invocar um validador passando o valor da propriedade.
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 *            Tipo do bean onde a propriedade esta localizada
 */
@SuppressWarnings(value = { "unchecked", "rawtypes" })
public final class PropertyValidator<T> implements Validator<T> {

	private final String propertyName;
	private final Validator validator;

	/**
	 * Constrai uma nova instancia referente a propriedade passada como
	 * parametro.
	 * 
	 * @param property
	 *            Nome da propriedade do bean
	 * @param validator
	 *            Validador que sera aplicado ao valor da propriedade
	 */
	public PropertyValidator(final String property, final Validator<?> validator) {
		super();
		this.propertyName = property;
		this.validator = validator;
	}

	@Override
	public ValidationResult validate(final T bean) {
		final Object propertyValue;
		try {
			propertyValue = PropertyUtils.getProperty(bean, propertyName);

		} catch (Exception e) {
			throw new ValidationException(e);
		}

		ValidationResult result = validator.validate(propertyValue);
		
		/*
		 * Neste ponto ocorre uma conversao dos motivos de invalidaaao para um
		 * tipo mais especafico (PropertyInvalidationReason), que possui as
		 * seguintes diferenaas: 1) Acrescenta as informaaaes da classe do bean
		 * e o nome da propriedade que esta sendo validada; 2) Aplica os
		 * replaces dos parametros suportados pelo ValidationResources.
		 */
		ValidationResult newResult = result.copyConvertingReasons(new Function<InvalidationReason, InvalidationReason>() {
			@Override
			public InvalidationReason apply(final InvalidationReason reason) {
				
				/*
				 * Formata a mensagem aplicando os replaces dos parametros 
				 * suportados pelo ValidationResources
				 */
				String formattedMessage = MessageFormat.format(reason.getMessage(), new Object[]{
						propertyValue, 
						bean.getClass().getSimpleName(), 
						propertyName});
				
				/*
				 * Acrescenta as informaaaes da classe do bean e o nome da 
				 * propriedade que esta sendo validada ao InvalidationReason
				 */
				return new PropertyInvalidationReason(reason
						.getSeverity(), formattedMessage, bean
						.getClass(), propertyName);
				
			}
		});
		
		return newResult;
	}

}
