package br.com.santander.zurich.previdencia.api.validacao;

import java.util.HashMap;
import java.util.Map;

/**
 * Responsavel por encapsular um Validador e permitir a passagem de parametros
 * para este validador, disponibilizando um {@link ValidationContext} com os
 * parametros.
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 *            Tipo do objeto que sera validado
 * 
 * @see ValidationContext
 */
public final class ParameterizedValidator<T> implements Validator<T> {

	private final Validator<T> validator;
	private final Map<String, Object> parameters;

	/**
	 * Construtor sem os parametros de validacao
	 * 
	 * @param validator
	 *            Instancia do Validador
	 */
	public ParameterizedValidator(final Validator<T> validator) {
		this(validator, new HashMap<String, Object>());
	}

	/**
	 * Construtor que recebe um mapa de parametros para disponibiliza-los no
	 * {@link ValidationContext}
	 * 
	 * @param validator
	 *            Instancia do Validador
	 * @param parameters
	 *            Parametros que serao disponibilizados atraves do
	 *            {@link ValidationContext}
	 */
	public ParameterizedValidator(final Validator<T> validator,
			final Map<String, Object> parameters) {
		super();
		this.validator = validator;
		this.parameters = parameters;
	}

	/**
	 * Adiciona um novo parametro ao contexto de validacao.
	 * 
	 * @param key
	 *            Chave do parametro
	 * @param value
	 *            Valor do parametro
	 */
	public void addParameter(final String key, final Object value) {
		this.parameters.put(key, value);
	}

	@Override
	public ValidationResult validate(final T value) {

		ValidationContext createdContext = null;
		try {

			/*
			 * Centraliza a criacao e finalizacao do contexto de validacao.
			 * Durante a validacao podem existir diversas instancias desta
			 * classe, mas deve existir apenas 1 contexto de validacao por
			 * thread, portanto este metodo cuida de criar o contexto apenas 1
			 * vez.
			 */
			if (!ValidationContext.hasCurrentInstance()) {
				createdContext = ValidationContext.createContext();
			}
			ValidationContext.currentInstance().addParameters(parameters);

			return this.validator.validate(value);

		} finally {
			if (createdContext != null) {
				ValidationContext.removeContext();
			}
		}
	};
}
