package br.com.santander.zurich.previdencia.api.validacao;

import java.util.Map;

import com.google.common.collect.Maps;

import br.com.santander.zurich.previdencia.api.validacao.exception.ContextNotAvailableException;
import br.com.santander.zurich.previdencia.api.validacao.exception.DuplicateContextException;

/**
 * Contexto de Validacao responsavel por disponibilizar parametros durante a
 * execucao da validacao.
 * 
 * @author Ricardo Okura
 * 
 * @see ParameterizedValidator
 * @see ContextNotAvailableException
 * @see DuplicateContextException
 */
public final class ValidationContext {

	private static final ThreadLocal<ValidationContext> CONTEXT_INSTANCE = new ThreadLocal<ValidationContext>();
	
	private final Map<String, Object> parameters = Maps.newHashMap();

	/**
	 * A criacao das instancias e feita pelo proprio contexto
	 */
	private ValidationContext() {
		super();
	}

	/**
	 * @return Instancia corrente do {@link ValidationContext}
	 */
	public static ValidationContext currentInstance() {
		ValidationContext currentInstance = CONTEXT_INSTANCE.get();
		if (currentInstance == null) {
			throw new ContextNotAvailableException();
		}
		return currentInstance;
	}

	/**
	 * @return [true] quando existir uma instancia do {@link ValidationContext}
	 *         criada na thread corrente.
	 */
	public static boolean hasCurrentInstance() {
		return CONTEXT_INSTANCE.get() != null;
	}

	/**
	 * Obtam o valor de um parametro deste contexto atravas da chave.
	 * 
	 * @param key
	 *            Chave do parametro
	 * @param <T> Tipo de acordo com o esperado
	 * @return Valor do parametro
	 */
	@SuppressWarnings("unchecked")
	public <T> T getParameter(final String key) {
		return (T) parameters.get(key);
	}

	/**
	 * Cria uma nova instancia do {@link ValidationContext} associada a thread
	 * corrente.
	 * 
	 * @return Nova instancia do contexto associada a thread corrente
	 */
	protected static ValidationContext createContext() {
		ValidationContext instance = new ValidationContext();
		if (CONTEXT_INSTANCE.get() != null) {
			throw new DuplicateContextException();
		}
		CONTEXT_INSTANCE.set(instance);
		return instance;
	}

	/**
	 * Remove o contexto da thread corrente. Deve ser chamado apas a execuaao da
	 * validaaao, quando o contexto nao for mais utilizado. Caso este matodo nao
	 * seja chamado, o contexto ficara associado na thread corrente e podera
	 * causar uma {@link DuplicateContextException} caso a mesma thread seja
	 * utilizada para executar outra validaaao.
	 */
	protected static void removeContext() {
		CONTEXT_INSTANCE.remove();
	}

	/**
	 * Adiciona um mapa de parametros neste contexto para disponibiliza-los para
	 * os validadores.
	 * 
	 * @param parameters
	 *            Mapa de parametros
	 */
	protected void addParameters(final Map<String, Object> parameters) {
		this.parameters.putAll(parameters);
	}

}
