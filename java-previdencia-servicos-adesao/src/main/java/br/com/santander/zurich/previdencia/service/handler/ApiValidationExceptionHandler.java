package br.com.santander.zurich.previdencia.service.handler;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.collect.Lists;

import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResponseResource;

/**
 * Classe interceptadora de erros na requisição REST.
 * 
 * @author Andre Dornelas
 */
@RestControllerAdvice
public class ApiValidationExceptionHandler extends ResponseEntityExceptionHandler {

	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
    		final HttpMessageNotReadableException exception, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		
		final List<String> errors = Lists.newArrayList();
		errors.add(exception.getMessage());

		return new ResponseEntity<>(new PropostaAdesaoResponseResource(errors),HttpStatus.BAD_REQUEST);
	}
	
}
