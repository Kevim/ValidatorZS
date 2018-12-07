package br.com.santander.zurich.previdencia.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResponseResource;
import br.com.santander.zurich.previdencia.service.impl.GenericServiceFacade;

/**
 * Servico generico e unico de adesao de proposta de previdencia
 * para as novas plataformas.
 * 
 * @author Andre Dornelas
 */
@RestController
@RequestMapping("/api")
public final class GenericAdesaoService implements RestService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GenericServiceFacade genericServiceFacade;
	
	/**
	 * Método principal onde deve processar todas as requisições de adesao.
	 * 
	 * @param propostaAdesao - Proposta de adesao {@link PropostaAdesaoResource}
	 * @return {@link PropostaAdesaoResponseResource}
	 */
	@RequestMapping(method=RequestMethod.POST, 
					path="/generic-adesao-service")
	public ResponseEntity<PropostaAdesaoResponseResource> execute(
									@Valid @RequestBody final PropostaAdesaoResource propostaAdesao){
		
		ResponseEntity<PropostaAdesaoResponseResource> response = null;
		
		LOGGER.debug("Inicio da execucao do servico...");
		
		response = this.montarResponse(this.genericServiceFacade.executeStep(propostaAdesao));
		
		LOGGER.debug("Fim da execucao do servico...");
		
		return response;
	}

	/*
	 * Monta o response de acordo com o retorno do facade
	 */
	private ResponseEntity<PropostaAdesaoResponseResource> montarResponse(final PropostaAdesaoResponseResource propostaResponse) {
		
		if(propostaResponse == null) {
			//-- Se estiver null significa que não houve nenhum problema e monta o response vazio e com status OK
			return new ResponseEntity<PropostaAdesaoResponseResource>(propostaResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<PropostaAdesaoResponseResource>(propostaResponse, HttpStatus.BAD_REQUEST);
		}
	}

}
