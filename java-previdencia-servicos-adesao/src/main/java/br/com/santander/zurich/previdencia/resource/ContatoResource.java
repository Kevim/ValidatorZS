package br.com.santander.zurich.previdencia.resource;

import java.io.Serializable;

public class ContatoResource implements Serializable {

	private static final long serialVersionUID = 8466805842758880636L;

	private String email;
	private Integer dddTelefone;
	private Integer numeroTelefone;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dddTelefone
	 */
	public Integer getDddTelefone() {
		return dddTelefone;
	}

	/**
	 * @param dddTelefone the dddTelefone to set
	 */
	public void setDddTelefone(Integer dddTelefone) {
		this.dddTelefone = dddTelefone;
	}

	/**
	 * @return the numeroTelefone
	 */
	public Integer getNumeroTelefone() {
		return numeroTelefone;
	}

	/**
	 * @param numeroTelefone the numeroTelefone to set
	 */
	public void setNumeroTelefone(Integer numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	/**
	 * 
	 */
	public ContatoResource() {
	}

}
