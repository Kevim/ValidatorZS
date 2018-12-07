package br.com.santander.zurich.previdencia.api.validacao.condition;


import org.apache.commons.beanutils.PropertyUtils;

import br.com.santander.zurich.previdencia.api.validacao.exception.ValidationException;

/**
 * Condiaao baseada no valor da propriedade de um bean, responsavel por extrair
 * o valor da propriedade e invocar a condiaao original passando o valor da
 * propriedade.
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class PropertyCondition<T> implements Condition<T> {

	private final String 		propertyName;
	private final Condition 	condition;
	
	/**
	 * Constrai uma nova condiaao baseado na propriedade informada
	 * 
	 * @param propertyName
	 *            Nome da propriedade do bean
	 * @param condition
	 *            Condiaao que sera aplicada ao valor da propriedade do bean
	 */
	public PropertyCondition(final String propertyName, final Condition<?> condition) {
		super();
		this.propertyName = propertyName;
		this.condition = condition;
	}

	@Override
	public boolean isApplied(final T bean) {
		Object value = null;
		try {
			if(bean != null) {
				value = PropertyUtils.getProperty(bean, propertyName);
			}
		} catch (Exception e) {
			throw new ValidationException(e);
		}
		
		return condition.isApplied(value);
	}
	
}
