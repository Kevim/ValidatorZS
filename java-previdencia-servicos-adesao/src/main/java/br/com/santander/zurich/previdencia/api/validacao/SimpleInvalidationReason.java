package br.com.santander.zurich.previdencia.api.validacao;

/**
 * Representa um motivo de invalidacao que guarda a severidade da invalidacao e
 * a mensagem gerada pelo validador.
 * 
 * @author Ricardo Okura
 * 
 * @see InvalidationSeverityEnum
 */
public class SimpleInvalidationReason implements InvalidationReason {

	private final InvalidationSeverityEnum severity;
	private final String message;

	/**
	 * Constroi um novo motivo de invalidacao com a mensagem e a severidade.
	 * 
	 * @param severity
	 *            Severidade da falha na validacao
	 * @param message
	 *            Mensagem da validacao
	 */
	protected SimpleInvalidationReason(final InvalidationSeverityEnum severity,
			final String message) {
		super();
		this.severity = severity;
		this.message = message;
	}

	@Override
	public InvalidationSeverityEnum getSeverity() {
		return severity;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
