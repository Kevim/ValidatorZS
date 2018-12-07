package br.com.santander.zurich.previdencia.api.validacao.builder;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import br.com.santander.zurich.previdencia.api.validacao.CompositeValidator;
import br.com.santander.zurich.previdencia.api.validacao.ConditionalNullValidator;
import br.com.santander.zurich.previdencia.api.validacao.CustomMessageValidator;
import br.com.santander.zurich.previdencia.api.validacao.Validator;

/**
 * Builder para construaao de um {@link Validator} para um determinado bean. A
 * validaaao do bean pode ser composta por validaaaes de 2 tipos: <br>
 * 
 * 1) Validador de propriedade/atributo do bean. a responsavel pela validaaao do
 * valor de uma propriedade do bean, que a extraada por reflexao e passada para
 * os validadores. <br>
 * 
 * 2) Validador do bean, que a um validador que recebe a instancia do bean como
 * parametro e a mais flexavel para realizar validaaaes que necessitem de
 * diversas informaaaes do bean.<br>
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 *            Tipo do bean que sera validado
 */
public final class ValidatorBuilder<T> {
	
	private final List<PropertyValidatorBuilder<T>> propertyBuilders = Lists.newArrayList();
	private final List<Validator<T>> validators = Lists.newArrayList();
	
	/**
	 * Construtor para evitar instancias fora dessa classe
	 */
	private ValidatorBuilder() {
		super();
	}
	
	/**
	 * Cria um novo builder responsavel pela construaao do validador de um bean.
	 * 
	 * @param beanClass Classe do bean que sera validado
	 * @param <T> Tipo do Class<T> informado
	 * @return {@link ValidatorBuilder} referente ao bean
	 */
	public static <T> ValidatorBuilder<T> validateBean(final Class<T> beanClass) {
		return new ValidatorBuilder<T>();
	}
	
	/**
	 * Cria um validador para uma determinada propriedade do bean.
	 * 
	 * @param propertyName
	 *            Nome da propriedade do bean
	 * @return Novo builder responsavel pela construaao do validador da
	 *         propriedade
	 */
	public PropertyValidatorBuilder<T> validateProperty(final String propertyName) {
		PropertyValidatorBuilder<T> builder = PropertyValidatorBuilder
				.fromProperty(propertyName, this);
		propertyBuilders.add(builder);
		return builder;
	}
	
	/**
	 * Adiciona um {@link Validator} para o objeto T.
	 * 
	 * @param validator
	 *            Validador do objeto T
	 * @return this
	 */
	public ValidatorBuilder<T> with(final Validator<T> validator) {
		Preconditions.checkNotNull(validator);
		validators.add(validator);
		return this;
	}
	
	/**
	 * Este matodo habilita a funcionalidade de aplicar trim em todos os valores
	 * do tipo String antes de chamar os validadores.
	 * 
	 * @return this
	 */
	public ValidatorBuilder<T> withTrimEnabled() {
		return this; // TODO Implementar
	}
	
	/**
	 * Customiza a mensagem padrao gerada pelo validador pela mensagem informada.
	 * Deve ser chamado apas a chamada de um validador. 
	 * <br><br>Por exemplo: 
	 * 
	 * <pre><code>.with(new ClienteVO())
	 *  .withCustomMessage("Cliente a invalido")
	 * </code></pre>
	 * 
	 * @param message Mensagem a ser customizada.
	 * @return PropertyValidatorBuilder 
	 */
	public ValidatorBuilder<T> withCustomMessage(final String message) {
		Validator<T> currentValidator = currentValidator();
		overrideCurrentValidator(new CustomMessageValidator<T>(currentValidator, message));
		return this;
	}
	
	/**
	 * Retorna o validador corrente no builder
	 * @return Validator corrente
	 */
	private Validator<T> currentValidator(){
		Preconditions.checkPositionIndex(0, validators.size());
		int lastIndex = validators.size() - 1;
		return validators.get(lastIndex);
	}
	
	/**
	 * Sobreescreve o validador corrente na lista de validaaao pelo validador informado
	 * @param validator Validador a ser sobreescrito
	 */
	private void overrideCurrentValidator(final Validator<T> validator){
		Preconditions.checkPositionIndex(0, validators.size());
		int lastIndex = validators.size() - 1;
		validators.remove(lastIndex);
		validators.add(validator);
	}
	
	/**
	 * Constrai a instancia do validador do bean.
	 * 
	 * @return Instancia do validador do bean
	 */
	public Validator<T> build() {
		CompositeValidator<T> beanValidator = new CompositeValidator<T>();
		
		// Validadores do praprio bean 
		for (Validator<T> validator : validators) {
			beanValidator.add(new ConditionalNullValidator<T>(validator));
		}
		
		// Validadores de propriedades do bean
		for (PropertyValidatorBuilder<T> propBuilder : propertyBuilders) {
			beanValidator.add(propBuilder.buildPropertyValidator());
		}
		return beanValidator;
	}
	
}
