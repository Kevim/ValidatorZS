package br.com.santander.zurich.previdencia.api.validacao.condition;


/**
 * Condiaao aplicada quando o valor a diferente de nulo.
 * 
 * @author Ricardo Okura
 *
 * @param <T> Tipo do valor em que a condiaao sera aplicada
 */
public class NullCondition<T> implements Condition<T> {

	/**
	 * Restringindo o acesso ao construtor 
	 */
	NullCondition() {
		super();
	}
	
	@Override
	public boolean isApplied(final T value) {
		return value != null;
	}
	
}
