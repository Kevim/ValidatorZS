package br.com.santander.zurich.previdencia.api.validacao;

import java.util.Collection;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

import br.com.santander.zurich.previdencia.api.validacao.bundle.ValidationBundle;

/**
 * Representa o resultado da execuaao de uma validaaao, armazendo informaaaes
 * sobre as falhas na validaaao. Permite agregar o resultado de diversos
 * validadores.
 * 
 * @author Ricardo Okura
 * 
 * @see InvalidationReason
 * @see InvalidationSeverityEnum
 */
public final class ValidationResult {
	
	private static final ValidationResult EMPTY_RESULT = new ValidationResult();
	
	private final Collection<InvalidationReason> reasonList;

	/**
	 * Construtor padrao
	 */
	private ValidationResult() {
		this(ImmutableList.<InvalidationReason> of());
	}
	
	/**
	 * Constrai um novo resultado de validaaao com apenas 1 motivo de
	 * invalidaaao.
	 * 
	 * @param reason Motivo da invalidaaao
	 */
	private ValidationResult(final InvalidationReason reason) {
		this(ImmutableList.of(reason));
	}

	/**
	 * Constrai um novo resultado de validaaao com apenas uma coleaao de motivos
	 * de invalidaaao.
	 * 
	 * @param reasons
	 *            Motivos de invalidaaao
	 */
	private ValidationResult(final Collection<InvalidationReason> reasons) {
		super();
		this.reasonList = reasons;
	}
	
	/**
	 * @return {@link ValidationResult} sem motivo de invalidaaao.
	 */
	public static ValidationResult empty() {
		return EMPTY_RESULT;
	}
	
	/**
	 * Cria uma nova instancia do resultado com severidade ERROR.
	 * 
	 * @param message
	 *            Mensagem do validador
	 * @return Nova instancia do resultado com severidade ERROR
	 */
	public static ValidationResult error(final String message) {
		return new ValidationResult(new SimpleInvalidationReason(
				InvalidationSeverityEnum.ERROR,
				ValidationBundle.getMessage(message)));
	}

	/**
	 * Cria uma nova instancia do resultado com severidade WARNING.
	 * 
	 * @param message
	 *            Mensagem do validador
	 * @return Nova instancia do resultado com severidade WARNING
	 */
	public static ValidationResult warning(final String message) {
		return new ValidationResult(new SimpleInvalidationReason(
				InvalidationSeverityEnum.WARNING,
				ValidationBundle.getMessage(message)));
	}
	
	/**
	 * Retorna uma nova instancia de {@link ValidationResult} com os motivos
	 * desta instancia agregados aos motivos da instancia passada como
	 * parametro. O objetivo a compor o resultado de diversas validaaaes. A
	 * utilizaaao deste matodo NaO deve ser feita fora da infra de validaaao.
	 * 
	 * @param result
	 *            Resultado da validaaao
	 * @return Nova instancia de {@link ValidationResult} com todos os motivos
	 */
	protected ValidationResult add(final ValidationResult result) {
		ImmutableList<InvalidationReason> newReasons = ImmutableList
				.<InvalidationReason> builder()
				.addAll(this.reasonList)
				.addAll(result.reasons()).build();
		return new ValidationResult(newReasons);
	}
	
	/**
	 * Gera um novo ValidationResult aplicando a regra do converter informado
	 * 
	 * @param converter
	 *            Converter que possui a regra de conversao
	 * @return O ValidationResult com as mudanaas aplicadas no converter
	 *         informado
	 */
	protected ValidationResult copyConvertingReasons(
			final Function<InvalidationReason, InvalidationReason> converter) {
		Collection<InvalidationReason> convertedReasons = Collections2
				.transform(reasonList, converter);
		return new ValidationResult(convertedReasons);
	}

	/**
	 * @return Devolve true se a validaaao gerou erros.  
	 */
	public boolean hasErrors() {
		return !errors().isEmpty();
	}

	/**
	 * @return Devolve uma lista contendo apenas os motivos com severidade ERROR.
	 */
	public Collection<InvalidationReason> errors() {
		return Collections2.filter(reasonList, new Predicate<InvalidationReason>() {
			@Override
			public boolean apply(final InvalidationReason reason) {
				return reason.getSeverity().equals(InvalidationSeverityEnum.ERROR);
			}
		});
	}
	
	/**
	 * @return Devolve uma lista contendo as mensagem dos erros de validaaao.
	 */
	public Collection<String> errorMessages() {
		return Collections2.transform(errors(), new Function<InvalidationReason, String>() {
			@Override
			public String apply(InvalidationReason reason) {
				return reason.getMessage();
			}
		});
	}
	
	/**
	 * @return Devolve todos os motivos registrados nesta validaaao,
	 *         independente da severidade.
	 */
	public Collection<InvalidationReason> reasons() {
		return reasonList; // assumindo que a coleaao a imutavel
	}
	
}
