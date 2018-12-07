package br.com.santander.zurich.previdencia.api.validacao.common;

import br.com.santander.zurich.previdencia.api.validacao.Validator;

/**
 * Validadores padraes da Infra
 * - Contam a referancia para os validadores padraes implementados pela infra.
 * @author Ricardo Okura
 */
public final class Validators {

	/**
	 * Construtor privado
	 */
	private Validators() {
		// Empty
	}
	/**
	 * Retorna uma instancia do validador NotNullValidator
	 * - O validador verifica se o valor nao a null
	 * @see {@link NotNullValidator} 
	 * @param <T>  Tipo de onde o validador estara localizado
	 * @return NotNullValidator<T> Instancia do validador 
	 */
	public static <T> NotNullValidator<T> notNull() {
		return new NotNullValidator<T>();
	}
	
	/**
	 * Retorna uma instancia do validador NullValidator
	 * - O validador verifica se o valor a null
	 * @see {@link NullValidator} 
	 * @param <T>  Tipo de onde o validador estara localizado
	 * @return NullValidator<T> Instancia do validador 
	 */
	public static <T> NullValidator<T> isNull() {
		return new NullValidator<T>();
	}
	
	/**
	 * Retorna uma instancia do validador NotEmptyValidator
	 * - O validador verifica se o valor nao a vazio.
	 * @see {@link NotEmptyValidator} 
	 * @param <T>  Tipo de onde o validador estara localizado
	 * @return NotEmptyValidator<T> Instancia do validador 
	 */
	public static <T> Validator<T> notEmpty() {
		return new NotEmptyValidator<T>();
	}
	
	/**
	 * Retorna uma instancia do validador IntegerValidator
	 * - O validador verifica se o valor a um namero no formato Integer valido.
	 * @see {@link IntegerValidator} 
	 * @return IntegerValidator<T> Instancia do validador 
	 */
	public static IntegerValidator isInteger() {
		return new IntegerValidator();
	}
	
	/**
	 * Retorna uma instancia do validador ShortValidator
	 * - O validador verifica se o valor a um namero no formato Short valido.
	 * @see {@link ShortValidator} 
	 * @return ShortValidator<T> Instancia do validador 
	 */
	public static ShortValidator isShort() {
		return new ShortValidator();
	}
	
	/**
	 * Retorna uma instancia do validador ByteValidator
	 * - O validador verifica se o valor a um namero no formato Byte valido.
	 * @see {@link ByteValidator} 
	 * @return ByteValidator<T> Instancia do validador 
	 */
	public static ByteValidator isByte() {
		return new ByteValidator();
	}
	
	/**
	 * Retorna uma instancia do validador BigDecimalValidator
	 * - O validador verifica se o valor a um namero no formato BigDecimal valido.
	 * @see {@link BigDecimalValidator} 
	 * @return BigDecimalValidator<T> Instancia do validador 
	 */
	public static BigDecimalValidator isBigDecimal() {
		return new BigDecimalValidator();
	}
	
	/**
	 * Retorna uma instancia do validador LongValidator
	 * - O validador verifica se o valor a um namero no formato Long valido.
	 * @see {@link LongValidator} 
	 * @return LongValidator<T> Instancia do validador 
	 */
	public static LongValidator isLong() {
		return new LongValidator();
	}
	
	/**
	 * Retorna uma instancia do validador DateValidator
	 * - O validador verifica se o valor a uma data valida no formato DD/MM/YYYY.
	 * @see {@link DateValidator} 
	 * @return DateValidator<T> Instancia do validador 
	 */
	public static DateValidator isDateDMY() {
		return new DateValidator();
	}
	
	/**
	 * Retorna uma instancia do validador DateValidator
	 * - O validador verifica se o valor a uma data valida no formato informado.
	 * @see {@link DateValidator} 
	 * @param pattern Formato da data para ser validado.
	 * @return DateValidator<T> Instancia do validador 
	 */
	public static DateValidator isDate(final String pattern) {
		return new DateValidator(pattern);
	}
	
}
