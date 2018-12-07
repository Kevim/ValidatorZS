package br.com.santander.zurich.previdencia.api.validacao;

/**
 * Representa um motivo de invalidacao, fornecendo detalhes como a severidade
 * da invalidacao e a mensagem gerada pelo validador.
 * 
 * @author Ricardo Okura
 * 
 * @see InvalidationSeverityEnum
 */
public interface InvalidationReason {

	/**
	 * @return Severidade da falha na validacao
	 */
	InvalidationSeverityEnum getSeverity();

	/**
	 * @return Mensagem da validacao
	 */
	String getMessage();

}
