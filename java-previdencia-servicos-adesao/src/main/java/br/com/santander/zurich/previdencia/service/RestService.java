package br.com.santander.zurich.previdencia.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface que todos os servicos REST devem implementar,
 * pois define para todos os servicos que o request e o response 
 * será um JSON.
 * 
 * @author Andre Dornelas
 */
@RequestMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, 
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface RestService {
	
}
