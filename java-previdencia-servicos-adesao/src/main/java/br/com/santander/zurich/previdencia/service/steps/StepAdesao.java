package br.com.santander.zurich.previdencia.service.steps;

import br.com.santander.zurich.previdencia.exception.StepAdesaoException;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResponseResource;

/**
 * Interface que representa um step de uma adesão.
 * 
 * @author Andre Dornelas
 */
public interface StepAdesao {

	/**
	 * Executa o step da adesão com suas respectivas regras específicas.
	 * 
	 * @param propostaAdesao - Proposta de adesão
	 * @return {@link PropostaAdesaoResponseResource}
	 * @throws StepAdesaoException Erro ao executar o step
	 */
	PropostaAdesaoResponseResource executeStepAdesao(final PropostaAdesaoResource propostaAdesao)
	throws StepAdesaoException;
	
}
