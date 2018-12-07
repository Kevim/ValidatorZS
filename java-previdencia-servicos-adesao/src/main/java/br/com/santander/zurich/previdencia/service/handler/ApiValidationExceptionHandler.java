package br.com.santander.zurich.previdencia.service.handler;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.collect.Lists;

@RestControllerAdvice
public class ApiValidationExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
    		final MethodArgumentNotValidException exception, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        
		final List<String> errors = Lists.newArrayList();
		
		final BindingResult bindingResult = exception.getBindingResult();
		
		errors.add(exception.getBindingResult().getFieldErrors().stream().findFirst().get().getDefaultMessage());
		
          
          return new ResponseEntity<>(errors, status);
//          
//          final List<ErrorDTO> apiFieldErrors = bindingResult.getFieldErrors().stream()
//                       .map(fieldError -> conversionService.convert(fieldError, ErrorDTO.class)).collect(Collectors.toList());
//
//          final List<ErrorDTO> apiGlobalErrors = bindingResult.getGlobalErrors().stream()
//                       .map(globalError -> new ErrorDTO(globalError.getCode())).collect(Collectors.toList());
//
//          return new ResponseEntity<PropostaAdesaoResponseResource>(new ApiErrorDTO(apiFieldErrors, apiGlobalErrors, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

	
}
