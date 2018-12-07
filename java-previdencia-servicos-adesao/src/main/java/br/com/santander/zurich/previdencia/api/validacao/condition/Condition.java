package br.com.santander.zurich.previdencia.api.validacao.condition;

/**
 * Interface para implementaaao de validaaao condicional
 * A validaaao condicional diz se uma validaaao deve ou 
 * nao ser executada de acordo com a condiaao implementada 
 * em  {@link Condition#isApplied(T)}
 * 
 * @author Ricardo Okura
 *
 * @param <T> Tipo de onde a condicional sera aplicada
 * @see {@link com.porto.cds.validation.builder.PropertyValidatorBuilder#when(Condition) 
 * PropertyValidatorBuilder.when(Condition)}
 * @see {@link com.porto.cds.validation.builder.PropertyValidatorBuilder#when(String, Condition) 
 * PropertyValidatorBuilder.when(String, Condition)}
 */
public interface Condition<T> {
	
	/**
	 * Verifica se a condiaao se aplica ao valor informado
	 * @param value Valor de onde esta sendo aplicado a condicional.
	 * @return Se deve ou nao ser aplicada
	 */
	boolean isApplied(T value);
	
}
