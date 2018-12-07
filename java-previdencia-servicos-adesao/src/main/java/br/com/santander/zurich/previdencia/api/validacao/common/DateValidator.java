package br.com.santander.zurich.previdencia.api.validacao.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;

/**
 * Validador que checa se um valor a um Date valido de acordo com o pattern informado, gerando erro caso nao seja.
 * 
 * @author Arthur Fernandes
 * @see {@link Validators#isDateDMY()}
 * @see {@link Validators#isDate(String)}
 */
public class DateValidator implements Validator<String> {

	private final static String PATTERN_DEFAULT = "dd/MM/yyyy";
	
	private final String currentPattern;
	
	/**
	 * Contrutor padrao. 
	 * -Carrega o currentPattern o PATTERN_DEFAULT
	 */
	public DateValidator() {
		this(PATTERN_DEFAULT);
	}
	
	/**
	 * Carrega o currentPattern com o valor informado
	 * @param pattern Carrega o currentPattern com o valor
	 */
	public DateValidator(final String pattern) {
		this.currentPattern = pattern;
	}
	
	@Override
	public ValidationResult validate(final String value) {
		ValidationResult result = ValidationResult.empty();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(currentPattern, Locale.getDefault());
			sdf.setLenient(false);
			sdf.parse(value);
		} catch (ParseException e) {
			result = ValidationResult.error("DateValidator");
		}
		
		return result;
	}

}