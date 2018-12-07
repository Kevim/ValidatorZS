package br.com.santander.zurich.previdencia.api.validacao.condition;


/**
 * Representa uma composiaao de 2 condiaaes utilizando o operador OR.
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 *            Tipo do objeto em que as condiaaes serao aplicadas.
 */
public final class OrCondition<T> implements Condition<T> {

	private final Condition<T> firstCondition;
	private final Condition<T> secondCondition;

	/**
	 * Construtor que recebe as duas condiaaes necessarias na composiaao.
	 * 
	 * @param firstCondition
	 *            Primeira condiaao
	 * @param secondCondition
	 *            Segunda condiaao
	 */
	public OrCondition(final Condition<T> firstCondition, final Condition<T> secondCondition) {
		super();
		this.firstCondition = firstCondition;
		this.secondCondition = secondCondition;
	}

	@Override
	public boolean isApplied(final T value) {
		return firstCondition.isApplied(value)
				|| secondCondition.isApplied(value);
	};

}
