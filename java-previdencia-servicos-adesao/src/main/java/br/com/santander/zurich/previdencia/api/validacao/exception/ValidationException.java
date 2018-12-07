package br.com.santander.zurich.previdencia.api.validacao.exception;

/**
 * Exceaao que encapsula problemas ocorridos na infra de validacao.
 * 
 * @author Ricardo Okura
 */
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Define o Throwable a classe
	 * @param throwable Throwable causador da exception
	 */
	public ValidationException(final Throwable throwable) {
		super(throwable);
	}

	/**
	 * Define uma mensagem a classe
	 * @param message Mensagem para a exception
	 */
	public ValidationException(final String message) {
		super(message);
	}
}
