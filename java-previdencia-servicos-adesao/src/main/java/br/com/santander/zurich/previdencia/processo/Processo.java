package br.com.santander.zurich.previdencia.processo;


/**
 * Representa um processo que eh executado durante o cálculo de orçamento
 * 
 * @param <T>
 *            Tipo de entrada do Processo
 */
public interface Processo<T> {

	/**
	 * execução do processo
	 * 
	 * @param entrada
	 *            Entrada do Processo
	 * @throws ExecucaoProcessoException
	 */
	void executar(T entrada) throws ExecucaoProcessoException;
	
}
