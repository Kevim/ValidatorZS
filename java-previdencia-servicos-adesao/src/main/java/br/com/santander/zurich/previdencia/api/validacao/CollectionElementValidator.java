package br.com.santander.zurich.previdencia.api.validacao;

import java.util.Collection;

/**
 * Validador responsavel por iterar uma colecao e aplicar um validador nos
 * elementos dessa colecao. Eh importante ressaltar que o validador dos elementos
 * nao sera chamado caso a colecao seja nula ou esteja vazia.
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 *            Tipo do elemento da colecao
 */
public class CollectionElementValidator<T> implements Validator<Collection<T>> {

	private final Validator<T> itemValidator;
	
	/**
	 * Construtor do validador de colecao que recebe o validador de elementos da colecao.
	 * 
	 * @param itemValidator Validador para realizar a validacao dos itens
	 */
	public CollectionElementValidator(final Validator<T> itemValidator) {
		this.itemValidator = itemValidator;
	}
	
	@Override
	public ValidationResult validate(final Collection<T> collection) {
		ValidationResult collectionResult = ValidationResult.empty();
		if(collection != null) {
			for (T value : collection) {
				ValidationResult result = itemValidator.validate(value);
				collectionResult = collectionResult.add(result);
			}	
		}
		return collectionResult;
	}
	
}
