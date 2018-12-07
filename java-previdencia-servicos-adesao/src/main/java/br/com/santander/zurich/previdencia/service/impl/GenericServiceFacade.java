package br.com.santander.zurich.previdencia.service.impl;

import org.springframework.stereotype.Component;

import br.com.santander.zurich.previdencia.enums.StepAdesaoEnum;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResponseResource;

@Component
public final class GenericServiceFacade {

	
	public PropostaAdesaoResponseResource executeStep(final PropostaAdesaoResource propostaAdesao) {

		PropostaAdesaoResponseResource response = null;
		
		//TODO MOCK
		if(StepAdesaoEnum.TIPO_PLANO.equals(propostaAdesao.getTipoValidacao())) {

			response = new PropostaAdesaoResponseResource();
			response.getErrors().add("Velho, preenhce o campo tipo do plano...");
			response.getErrors().add("Aproveita e preenche o resto dos campos certo carai");
		} 
		
		return response;
	}

}
