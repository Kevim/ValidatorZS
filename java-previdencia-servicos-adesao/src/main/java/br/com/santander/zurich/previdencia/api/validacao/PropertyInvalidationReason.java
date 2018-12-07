package br.com.santander.zurich.previdencia.api.validacao;

/**
 * Representa um motivo de invalidaaao que guarda, alam da severidade da
 * invalidaaao e mensagem gerada pelo validador, a classe do bean e a
 * propriedade que foi validada. Por esse motivo, sa a utilizada quando a
 * validaaao ocorre no contexto de validaaao de propriedades de um bean.
 * 
 * @author Ricardo Okura
 * 
 * @see InvalidationSeverityEnum
 * @see PropertyValidator
 */
public class PropertyInvalidationReason extends SimpleInvalidationReason {

	private final Class<?> beanClass;
	private final String propertyName;

	/**
	 * Constrai um novo motivo de invalidaaao com os dados de classe do bean e
	 * nome da propriedade que esta sendo validada.
	 * 
	 * @param severity
	 *            Severidade da falha na validaaao
	 * @param message
	 *            Mensagem da validaaao
	 * @param beanClass
	 *            Classe do bean que esta sendo validado
	 * @param propertyName
	 *            Nome da propriedade que esta sendo validada
	 */
	protected PropertyInvalidationReason(
			final InvalidationSeverityEnum severity, final String message,
			final Class<?> beanClass, final String propertyName) {
		super(severity, message);
		this.beanClass = beanClass;
		this.propertyName = propertyName;
	}

	/**
	 * @return the beanClass
	 */
	public Class<?> getBeanClass() {
		return beanClass;
	}

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

}
