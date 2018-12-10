package br.com.santander.zurich.previdencia.resource;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

/**
 * Objeto que representa o response que toda requisição do servico generico 
 * da Adesao da Previdencia.
 * 
 * @author Andre Dornelas
 */
public class PropostaAdesaoResponseResource implements Serializable {

	private static final long serialVersionUID = 6670252827950513293L;
	
	@JsonIgnore
	private Integer httpStatus;
	
	private List<String> errors;
	
	public PropostaAdesaoResponseResource(final String mensagem, final Integer httpStatus) {
		super();
		this.getErrors().add(mensagem);
		this.httpStatus = httpStatus;
	}

	public PropostaAdesaoResponseResource(final List<String> errors, final Integer httpStatus) {
		super();
		this.errors = errors;
		this.httpStatus = httpStatus;
	}

	public List<String> getErrors() {
		if(this.errors == null) {
			this.errors = Lists.newArrayList();
		}
		return errors;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}
	
}
