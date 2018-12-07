package br.com.santander.zurich.previdencia.api.validacao;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Validador composto por outros validadores, responsavel por gerenciar a
 * execucao desses validadores agregando seus resultados em um unico
 * {@link ValidationResult}.
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 *            Tipo do objeto que sera validado
 */
public class CompositeValidator<T> implements Validator<T> {

	private final List<Validator<T>> validators = Lists.newArrayList();

	/**
	 * Construtor padrao
	 */
	public CompositeValidator() {
		super();
	}

	/**
	 * Construtor que recebe a lista de validadores
	 * 
	 * @param validators
	 *            Lista de validadores
	 */
	public CompositeValidator(final List<Validator<T>> validators) {
		super();
		this.validators.addAll(validators);
	}

	/**
	 * Adiciona um novo validador a este validador composto.
	 * 
	 * @param validator
	 *            Validador a ser adicionado
	 * @return this
	 */
	public CompositeValidator<T> add(final Validator<T> validator) {
		this.validators.add(validator);
		return this;
	}

	/**
	 * Adiciona uma colecao de validadores a este validador composto.
	 * 
	 * @param validators
	 *            Colecao de validadores que serao adicionados
	 * @return this
	 */
	public CompositeValidator<T> addAll(
			final Collection<Validator<T>> validators) {
		this.validators.addAll(validators);
		return this;
	}

	@Override
	public ValidationResult validate(final T value) {
		ValidationResult finalResult = ValidationResult.empty();
		for (Validator<T> validator : validators) {
			ValidationResult result = validator.validate(value);
			finalResult = finalResult.add(result);
		}
		return finalResult;
	}

}
