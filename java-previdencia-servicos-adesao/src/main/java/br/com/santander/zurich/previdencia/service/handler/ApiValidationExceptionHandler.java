package br.com.santander.zurich.previdencia.service.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		final BindingResult bindingResult = ex.getBindingResult();

		final List<String> errors = Lists.newArrayList();
		errors.addAll(bindingResult.getFieldErrors().stream()
				.map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList()));
		errors.addAll(bindingResult.getGlobalErrors().stream()
				.map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList()));

		return new ResponseEntity<>(new PropostaAdesaoResponseResource(errors), HttpStatus.BAD_REQUEST);
	}
}
