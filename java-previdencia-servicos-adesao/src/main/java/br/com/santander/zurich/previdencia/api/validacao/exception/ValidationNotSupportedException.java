package br.com.santander.zurich.previdencia.api.validacao.exception;

public class ValidationNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String MSG = "Validacao nao suportada";
	
	/**
	 * Construtor padrao
	 */
	public ValidationNotSupportedException() {
		super(MSG);
	}
	
}
