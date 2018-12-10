package br.com.santander.zurich.previdencia.exception;

/**
 * Exception para os Steps da adesão.
 * 
 * @author Andre Dornelas
 */
public class StepAdesaoException extends Exception {

	private static final long serialVersionUID = 2610252260879898051L;

	/**
	 * Construtor.
	 * 
	 * @param mensagem - Mensagem do erro
	 * @param erro - Objeto do erro
	 */
	public StepAdesaoException(final String mensagem, final Throwable erro) {
		super(mensagem, erro);
	}
	
}
