package br.com.santander.zurich.previdencia.resource;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Objeto que representa o response que toda requisição do servico generico 
 * da Adesao da Previdencia.
 * 
 * @author Andre Dornelas
 */
public class PropostaAdesaoResponseResource implements Serializable {

	private static final long serialVersionUID = 6670252827950513293L;
	
	private List<String> errors;
	
	public PropostaAdesaoResponseResource(final String mensagem) {
		super();
		this.getErrors().add(mensagem);
	}

	public PropostaAdesaoResponseResource(final List<String> errors) {
		super();
		this.errors = errors;
	}

	public List<String> getErrors() {
		if(this.errors == null) {
			this.errors = Lists.newArrayList();
		}
		return errors;
	}
}
