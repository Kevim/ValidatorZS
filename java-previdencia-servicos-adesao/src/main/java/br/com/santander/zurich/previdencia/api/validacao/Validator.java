package br.com.santander.zurich.previdencia.api.validacao;

/**
 * Representa um validador de um objeto do tipo <T>.
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 *            Tipo do objeto que sera validado
 * 
 * @see ValidationResult
 */
public interface Validator<T> {

	/**
	 * Valida um objeto do tipo T, retornando um {@link ValidationResult} com
	 * erros caso a validaaao falhe, ou um {@link ValidationResult} vazio quando
	 * a validaaao passar. a importante ressaltar que este matodo nao devera
	 * retornar null em nenhum momento.
	 * 
	 * @param value
	 *            Valor que sera validado
	 * @return {@link ValidationResult} com erros caso a validaaao falhe, ou um
	 *         {@link ValidationResult} vazio quando a validaaao passar.
	 */
	ValidationResult validate(T value);
	
}
