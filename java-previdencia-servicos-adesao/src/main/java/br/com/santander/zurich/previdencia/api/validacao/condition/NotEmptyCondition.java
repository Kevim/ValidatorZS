package br.com.santander.zurich.previdencia.api.validacao.condition;


/**
 * Condiaao aplicada quando um valor nao a vazio, gerando erro caso esteja.
 * Suporta os tipos String e Collection.
 * 
 * @author Ricardo Okura
 * 
 * @see EmptyCondition
 */
public final class NotEmptyCondition<T> implements Condition<T> {

	/**
	 * Restringindo o acesso ao construtor 
	 */
	NotEmptyCondition() {
		super();
	}
	
	@Override
	public boolean isApplied(final T value) {
		return !new EmptyCondition<T>().isApplied(value);
	}
	
}
