package br.com.santander.zurich.previdencia.service.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import br.com.santander.zurich.previdencia.exception.StepAdesaoException;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResponseResource;

/**
 * Step de regras para adesão de beneficiários.
 * 
 * @author Andre Dornelas
 */
public final class StepBeneficiarios implements StepAdesao {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
	public PropostaAdesaoResponseResource executeStepAdesao(final PropostaAdesaoResource propostaAdesao)
			throws StepAdesaoException {
		
		PropostaAdesaoResponseResource response = null;
		
		LOGGER.debug("Inicio do Step de Beneficiarios...");
		try {
			
			//TODO implementar a logica aqui
			
//			
//			//MOCK - TESTE DE ERROS
//			if(Boolean.TRUE.equals(propostaAdesao.getResidenteFiscalExterior())) {
//				throw new NumberFormatException("Erro forçado para testes...");
//			} 
			
		} catch (Exception e) {
			LOGGER.error("Erro ao executar Step de adesão de Beneficiarios: ", e);
			response = new PropostaAdesaoResponseResource(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		
		LOGGER.debug("Fim do Step de Beneficiarios");
		
		return response;
	}

}
