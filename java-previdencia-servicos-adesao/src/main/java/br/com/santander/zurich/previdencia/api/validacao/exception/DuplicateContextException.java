package br.com.santander.zurich.previdencia.api.validacao.exception;

/**
 * Indica a existancia de mais de um {@link com.porto.cds.validation.api.ValidationContext ValidationContext} 
 *  na mesma thread. 
 * 
 * @author Ricardo Okura
 */
public class DuplicateContextException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String MSG = "Ja existe um contexto de validacao na thread corrente."; 
	
	/**
	 * Construtor padrao
	 */
	public DuplicateContextException() {
		super(MSG);
	}
	
}
