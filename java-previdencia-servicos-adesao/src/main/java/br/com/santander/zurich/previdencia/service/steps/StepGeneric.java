package br.com.santander.zurich.previdencia.service.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.santander.zurich.previdencia.exception.StepAdesaoException;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResponseResource;

/**
 * Step genérico para os casos que não se deve ter acesso a base de dados, apenas validação.
 * 
 * @author Andre Dornelas
 */
public final class StepGeneric implements StepAdesao {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
	public PropostaAdesaoResponseResource executeStepAdesao(final PropostaAdesaoResource propostaAdesao)
			throws StepAdesaoException {

		LOGGER.debug("Step genérico acionado, pois não há acesso a base de dados.");
		return null;
	}

}
