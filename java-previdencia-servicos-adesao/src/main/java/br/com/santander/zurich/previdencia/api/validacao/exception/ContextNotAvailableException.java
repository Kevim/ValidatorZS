package br.com.santander.zurich.previdencia.api.validacao.exception;

/**
 * Exceaao que indica que o {@link com.porto.cds.validation.api.ValidationContext ValidationContext} 
 * nao esta disponavel. A possavel causa a o contexto de validaaao nao ter sido 
 * criado antes da execuaao da validaaao.
 * 
 * @author Ricardo Okura
 */
public class ContextNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String MSG = "Contexto de validaaao nao esta disponavel na thread corrente."; 
	
	/**
	 * Construtor padrao
	 */
	public ContextNotAvailableException() {
		super(MSG);
	}
	
}
