package br.com.santander.zurich.previdencia.api.validacao;

/**
 * Validador responsavel por iterar um array e aplicar um validador nos
 * elementos desse array. Eh importante ressaltar que o validador dos elementos
 * nao sera chamado caso o array for nulo ou esteja vazio.
 * 
 * @author Ricardo Okura
 * 
 * @param <T>
 *            Tipo do elemento da colecao
 */
public class ArrayElementValidator<T> implements Validator<T[]> {

	private final Validator<T> itemValidator;
	
	/**
	 * Construtor do validador de colecao que recebe o validador de elementos da colecao.
	 * 
	 * @param itemValidator Validador para realizar a validacao dos itens
	 */
	public ArrayElementValidator(final Validator<T> itemValidator) {
		this.itemValidator = itemValidator;
	}
	
	@Override
	public ValidationResult validate(final T[] array) {
		ValidationResult arrayResult = ValidationResult.empty();
		if(array != null) {
			for (T value : array) {
				ValidationResult result = itemValidator.validate(value);
				arrayResult = arrayResult.add(result);
			}	
		}
		return arrayResult;
	}
	
}
