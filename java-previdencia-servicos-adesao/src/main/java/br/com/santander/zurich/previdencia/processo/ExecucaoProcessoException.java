package br.com.santander.zurich.previdencia.processo;

import java.util.Collection;


/**
 * Excecao gerada para indicar falhas na execução de um {@link Processo} durante
 * o cálculo de orçamento. Suporta o armazenamento de uma lista de mensagens.
 */
public class ExecucaoProcessoException extends Exception {

	private static final long serialVersionUID = 1L;

	private final Collection<String> mensagens;
	
	public ExecucaoProcessoException(final Collection<String> mensagens) {
		super(mensagens.toString());
		this.mensagens = mensagens;
	}
	
	public Collection<String> getMensagens() {
		return mensagens;
	}
	
}
