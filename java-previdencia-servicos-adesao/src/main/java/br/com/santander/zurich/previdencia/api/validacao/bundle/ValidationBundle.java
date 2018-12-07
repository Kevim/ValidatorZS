package br.com.santander.zurich.previdencia.api.validacao.bundle;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Utilitario para message bundle
 * @author Arthur Fernandes
 */
public final class ValidationBundle {

	private static final ResourceBundle BUNDLE = PropertyResourceBundle.getBundle("properties.ValidationResources");
	
	/**
	 * Contrutor default
	 */
	private ValidationBundle(){
		// Empty
	}
	
	/**
	 * Retorna a mensagem cadastrada correspondente a chave informada no bundle.
	 * Caso nao exista retorna a prapria chave
	 * @param key A chave da mensagem
	 * @return A mensagem relacionada a chave
	 */
	public static String getMessage(final String key) {
		
		String message = key;
		
		if (BUNDLE.containsKey(key)){
			message = (String) BUNDLE.getString(key);
		}
		
		return message;
	}
	
}
