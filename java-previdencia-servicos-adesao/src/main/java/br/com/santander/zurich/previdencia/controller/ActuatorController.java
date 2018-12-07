package br.com.santander.zurich.previdencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ActuatorController {

	@RequestMapping(method = RequestMethod.GET, path = "/health")
	public String getHealth(){
		return HttpStatus.OK.name();
	}
}
