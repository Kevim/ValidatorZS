package br.com.santander.zurich.previdencia.api.validacao.condition;

import java.util.Collection;

import br.com.santander.zurich.previdencia.api.validacao.exception.ValidationNotSupportedException;

/**
 * Condiaao aplicada quando um valor esta vazio, gerando erro caso nao esteja.
 * Suporta os tipos String e Collection.
 * 
 * @author Ricardo Okura
 */
public class EmptyCondition<T> implements Condition<T> {
	
	@Override
	public boolean isApplied(final T value) {
		boolean isApplied;
		if(value == null) {
			isApplied = true;
			
		} else if (value instanceof String) {
			isApplied = ((String) value).trim().isEmpty();

		} else if (value instanceof Collection<?>) {
			isApplied = ((Collection<?>) value).isEmpty();

		} else {
			throw new ValidationNotSupportedException();
		}
		return isApplied;
	}
	
}
