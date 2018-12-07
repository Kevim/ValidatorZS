package br.com.santander.zurich.previdencia.api.validacao.builder;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import br.com.santander.zurich.previdencia.api.validacao.CompositeValidator;
import br.com.santander.zurich.previdencia.api.validacao.ConditionalNullValidator;
import br.com.santander.zurich.previdencia.api.validacao.CustomMessageValidator;
import br.com.santander.zurich.previdencia.api.validacao.PropertyValidator;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.common.Validators;
import br.com.santander.zurich.previdencia.api.validacao.condition.Condition;
import br.com.santander.zurich.previdencia.api.validacao.condition.ConditionalValidator;
import br.com.santander.zurich.previdencia.api.validacao.condition.Conditions;
import br.com.santander.zurich.previdencia.api.validacao.condition.PropertyCondition;

/**
 * Builder para construaao de um {@link Validator} para uma propriedade de um
 * bean. Deve ser utilizado em conjunto com o {@link ValidatorBuilder}.
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 *            Tipo do bean onde a propriedade esta localizada
 */
public final class PropertyValidatorBuilder<T> {

	private final String 				propertyName;
	private final List<Validator<?>> 	validators = Lists.newArrayList();
	private final List<Condition<?>> 	conditions = Lists.newArrayList();
	private final ValidatorBuilder<T> 	beanValidatorBuilder;
	
	/**
	 * Constrai uma nova instancia referente a propriedade
	 * 
	 * @param propertyName
	 *            Nome da propriedade do bean
	 * @param beanValidatorBuilder
	 *            Builder do validador do bean, necessario para manter a
	 *            interface fluente nos builders
	 */
	private PropertyValidatorBuilder(final String propertyName,
			final ValidatorBuilder<T> beanValidatorBuilder) {
		this.propertyName = propertyName;
		this.beanValidatorBuilder = beanValidatorBuilder;
	}

	/**
	 * Valor da propriedade
	 * @param <T> De acordo com o tipo de beanValidatorBuilder
	 * @param propertyName O nome da propriedade
	 * @param beanValidatorBuilder O Builder do validator
	 * @return Retorna o PropertyValidatorBuilder que esta sendo construido
	 */
	protected static <T> PropertyValidatorBuilder<T> fromProperty(
			final String propertyName,
			final ValidatorBuilder<T> beanValidatorBuilder) {
		return new PropertyValidatorBuilder<T>(propertyName,
				beanValidatorBuilder);
	}

	/**
	 * Valida se o valor nao a null.
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> notNull() {
		validators.add(Validators.notNull());
		return this;
	}

	/**
	 * Valida se o valor a null.
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> isNull() {
		validators.add(Validators.isNull());
		return this;
	}
	
	/**
	 * Valida uma propriedade do tipo String se ela possui um valor Integer valido
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> isInteger() {
		validators.add(Validators.isInteger());
		return this;
	}
	
	/**
	 * Valida uma propriedade do tipo String se ela possui um valor Short valido
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> isShort() {
		validators.add(Validators.isShort());
		return this;
	}
	
	/**
	 * Valida uma propriedade do tipo String se ela possui um valor Byte valido
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> isByte() {
		validators.add(Validators.isByte());
		return this;
	}
	
	/**
	 * Valida uma propriedade do tipo String se ela possui um valor BigDecimal valido
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> isBigDecimal() {
		validators.add(Validators.isBigDecimal());
		return this;
	}
	
	/**
	 * Valida uma propriedade do tipo String se ela possui um valor Long valido
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> isLong() {
		validators.add(Validators.isLong());
		return this;
	}
	
	/**
	 * Valida uma propriedade do tipo String se ela possui uma data no pattern DIA/MES/ANO
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> isDateDMY() {
		validators.add(Validators.isDateDMY());
		return this;
	}
	
	/**
	 * Valida uma propriedade do tipo String se ela possui uma data de acordo com o pattern informado.
	 * @param pattern Formato da data, ex: dd/MM/yyyy
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> isDate(final String pattern) {
		validators.add(Validators.isDate(pattern));
		return this;
	}

	/**
	 * Valida se a propriedade nao possue um valor vazio.
	 *  -Pode ser utilizado com propriedades do tipo {@link String} e {@link Collection}
	 *  -Valida tambam se o valor a null, caso for sera validado tambam
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> notEmpty() {
		validators.add(Validators.notEmpty());
		return this;
	}

	/**
	 * Valida a propriedade com o validador informado
	 * @param validator Validator a ser utilizado na validaaao
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> with(final Validator<?> validator) {
		Preconditions.checkNotNull(validator);
		validators.add(validator);
		return this;
	}

	/**
	 * Apenas valida a propriedade caso seja valida a condiaao informada. 
	 * <br><br>Ex: 
	 * <pre><code>.validateProperty("sexo")
	 *	.with(new SexoValidator())
	 *	.when(new TipoPessoaFisicaCondition())
	 *</code></pre>
	 * @param condition Condiaao a ser verificada
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> when(final Condition<?> condition) {
		Preconditions.checkNotNull(condition);
		return when(propertyName, condition);
	}

	/**
	 * Apenas valida a propriedade caso seja valida a condiaao informada. 
	 * O valor passado a Condition sera o valor da propriedade conditionProperty.
	 * <br><br>Ex: 
	 * <pre><code>.validateProperty("sexo")
	 *	.with(new SexoValidator())
	 *	.when("tipoPessoa", new TipoPessoaFisicaCondition())
	 *</code></pre>
	 * @param conditionProperty Nome da propriedade a ser passada a condiaao
	 * @param condition Condiaao a ser verificada
	 * @return PropertyValidatorBuilder
	 */
	public PropertyValidatorBuilder<T> when(final String conditionProperty,
			final Condition<?> condition) {
		Preconditions.checkNotNull(conditionProperty);
		Preconditions.checkNotNull(condition);
		conditions.add(new PropertyCondition<T>(conditionProperty, condition));
		return this;
	}
	
	/**
	 * Customiza a mensagem padrao gerada pelo validador pela mensagem informada.
	 * Deve ser chamado apas a chamada de um validador. 
	 * <br><br>Por exemplo: 
	 * 
	 * <pre><code>.validateProperty("nome")
	 *  .notEmpty()
	 *  .withCustomMessage("Nome deve ser informado")
	 * </code></pre>
	 * 
	 * @param message Mensagem a ser customizada.
	 * @return PropertyValidatorBuilder 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PropertyValidatorBuilder<T> withCustomMessage(final String message) {
		Validator<?> currentValidator = currentValidator();
		overrideCurrentValidator(new CustomMessageValidator(currentValidator, message));
		return this;
	}
	
	/**
	 * Retorna o validador corrente no builder
	 * @return Validator corrente
	 */
	private Validator<?> currentValidator(){
		Preconditions.checkPositionIndex(0, validators.size());
		int lastIndex = validators.size() - 1;
		return validators.get(lastIndex);
	}
	
	/**
	 * Sobreescreve o validador corrente na lista de validaaao pelo validador informado
	 * @param validator Validador a ser sobreescrito
	 */
	private void overrideCurrentValidator(final Validator<?> validator){
		Preconditions.checkPositionIndex(0, validators.size());
		int lastIndex = validators.size() - 1;
		validators.remove(lastIndex);
		validators.add(validator);
	}
	
	/**
	 * Constrai uma nova instancia de {@link Validator} referente ao bean T.
	 * 
	 * @return Nova instancia de {@link Validator} referente ao bean T.
	 */
	public Validator<T> build() {
		return beanValidatorBuilder.build();
	}

	/**
	 * Devolve um novo builder para criaaao dos validadores da propriedade
	 * passada como parametro.
	 * 
	 * @param propertyName
	 *            Nome da propriedade que sera validada
	 * @return {@link PropertyValidatorBuilder} para criaaao dos validadores da
	 *         propriedade
	 */
	public PropertyValidatorBuilder<T> validateProperty(
			final String propertyName) {
		return beanValidatorBuilder.validateProperty(propertyName);
	}

	/**
	 * Constrai uma nova instancia de {@link Validator} para validaaao da
	 * propriedade.
	 * 
	 * @return Nova instancia de {@link Validator} para validaaao da
	 *         propriedade.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Validator<T> buildPropertyValidator() {
		CompositeValidator compositeValidator = new CompositeValidator();
		for (Validator validator : validators) {
			compositeValidator.add(new ConditionalNullValidator(validator));
		}
		
		Validator<T> propertyValidator = new ConditionalNullValidator<T>(
				new PropertyValidator<T>(propertyName, compositeValidator));
		if (!conditions.isEmpty()) {
			propertyValidator = new ConditionalValidator<T>(propertyValidator,
					Conditions.and((List) conditions));
		}
		return propertyValidator;
	}
	
}
