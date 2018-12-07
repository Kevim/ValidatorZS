package br.com.santander.zurich.previdencia.api.validacao.condition;

import java.util.List;


/**
 * Classe utilitaria para obter as implementaaaes mais comuns de
 * {@link Condition}.
 * 
 * @author Ricardo Okura
 */
public final class Conditions {

	/**
	 * Construtor privado
	 */
	private Conditions() {
		// Empty
	}
	
	/**
	 * Uma Condition notNull
	 * @see {@link NotNullCondition}
	 * @param <T> Tipo referente a onde esta sendo aplicada a condition
	 * @return {@link NotNullCondition}
	 */
	public static <T> Condition<T> notNull() {
		return new NotNullCondition<T>();
	}
	
	/**
	 * Uma Condition NullCondition
	 * @see {@link NullCondition}
	 * @param <T> Tipo referente a onde esta sendo aplicada a condition
	 * @return {@link NullCondition}
	 */
	public static <T> Condition<T> isNull() {
		return new NullCondition<T>();
	}
	
	/**
	 * Uma Condition EmptyCondition
	 * @see {@link EmptyCondition}
	 * @param <T> Tipo referente a onde esta sendo aplicada a condition
	 * @return {@link EmptyCondition}
	 */
	public static <T> Condition<T> isEmpty() {
		return new EmptyCondition<T>();
	}
	
	/**
	 * Uma Condition NotEmptyCondition
	 * @see {@link NotEmptyCondition}
	 * @param <T> Tipo referente a onde esta sendo aplicada a condition
	 * @return {@link NotEmptyCondition}
	 */
	public static <T> Condition<T> notEmpty() {
		return new NotEmptyCondition<T>(); 
	}
	
	/**
	 * A condiaao a verdadeira apenas se as duas condiaaes forem verdadeira
	 * @see {@link AndCondition}
	 * @param <T> Tipo referente a onde esta sendo aplicada a condition
	 * @param firstCondition Primeira condiaao
	 * @param secondCondition Segunda condiaao
	 * @return {@link AndCondition}
	 */
	public static <T> Condition<T> and(final Condition<T> firstCondition,
			final Condition<T> secondCondition) {
		return new AndCondition<T>(firstCondition, secondCondition);
	}
	
	/**
	 * A condiaao a verdadeira apenas se todas as condiaaes forem verdadeira
	 * @see {@link AndCondition}
	 * @param <T> Tipo referente a onde esta sendo aplicada a condition
	 * @param conditions Lista de condiaaes
	 * @return {@link AndCondition}
	 */
	public static <T> Condition<T> and(final List<Condition<T>> conditions) {
		Condition<T> andCondition = null;
		for (Condition<T> condition : conditions) {
			if(andCondition == null) {
				andCondition = condition;
			} else {
				andCondition = new AndCondition<T>(andCondition, condition);
			}
		}
		return andCondition;
	}
	
	/**
	 * A condiaao a verdadeira apenas se uma ou outra condiaao for verdadeira
	 * @see {@link OrCondition}
	 * @param <T> Tipo referente a onde esta sendo aplicada a condition
	 * @param firstCondition Primeira condiaao
	 * @param secondCondition Segunda Condiaao
	 * @return {@link OrCondition}
	 */
	public static <T> Condition<T> or(final Condition<T> firstCondition,
			final Condition<T> secondCondition) {
		return new OrCondition<T>(firstCondition, secondCondition);
	}
}
