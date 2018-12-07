package br.com.santander.zurich.previdencia.processo;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

/**
 * Processo composto por uma lista de processos que serão executados em
 * sequencia.
 * 
 * @param <T>
 *            Tipo de entrada dos processos
 */
public final class Processos<T> implements Processo<T> {

	private final List<ExecucaoProcesso<T>> execucoesProcessos;

	private Processos(final List<ExecucaoProcesso<T>> execucoesProcessos) {
		this.execucoesProcessos = execucoesProcessos;
	}

	@Override
	public void executar(final T entrada) throws ExecucaoProcessoException {
		for (ExecucaoProcesso<T> execucaoProcesso : execucoesProcessos) {
			if (execucaoProcesso.getCondicao().apply(entrada)) {
				execucaoProcesso.getProcesso().executar(entrada);
			}
		}
	}

	/**
	 * @return {@link Builder} para contrução dos processos
	 */
	public static <T> Builder<T> builder() {
		return new Builder<T>();
	}

	/**
	 * Builder para contrução dos processos
	 * 
	 * @param <T>
	 *            Tipo de entrada dos processos
	 */
	public static class Builder<T> {

		private final List<ExecucaoProcesso<T>> execucoesProcessos = Lists.newArrayList();

		/**
		 * Cria um processo composto que delega sua execução para os processos
		 * adicionados.
		 * 
		 * @return Instância de {@link Processos}
		 */
		public Processo<T> build() {
			return new Processos<T>(this.execucoesProcessos);
		}

		/**
		 * Adiciona um novo processo para ser executado. Os processos serão
		 * executados na sequência em que foram adicionados.
		 * 
		 * @param processo
		 *            Processo a ser executado
		 * @return Devolve este builder para manter a interface fluente
		 */
		public Builder<T> add(final Processo<T> processo) {
			this.execucoesProcessos.add(new ExecucaoProcesso<T>(processo, Predicates.<T>alwaysTrue()));
			return this;
		}
		
		/**
		 * Adiciona um novo processo para ser executado apenas quando a condição for verdadeira. Os processos serão
		 * executados na sequência em que foram adicionados.
		 * 
		 * @param processo
		 *            Processo a ser executado
		 * @param condicao
		 *            Condição para a execução do processo
		 * @return Devolve este builder para manter a interface fluente
		 */
		public Builder<T> add(final Processo<T> processo, Predicate<T> condicao) {
			this.execucoesProcessos.add(new ExecucaoProcesso<T>(processo, condicao));
			return this;
		}
	}
	
	/**
	 * Representa o necessário para a execução do processo
	 * @param <T>  Tipo de entrada dos processos
	 */
	private static class ExecucaoProcesso<T> {
		private final Processo<T> processo; 
		private final Predicate<T> condicao;
		
		/**
		 * Contrutor Padrão
		 * @param processo O Processo
		 * @param condicao A condicao
		 */
		public ExecucaoProcesso(Processo<T> processo, Predicate<T> condicao) {
			super();
			this.processo = processo;
			this.condicao = condicao;
		}

		/**
		 * @return the processo
		 */
		public Processo<T> getProcesso() {
			return processo;
		}

		/**
		 * @return the condicao
		 */
		public Predicate<T> getCondicao() {
			return condicao;
		}
		
	}
	

}
