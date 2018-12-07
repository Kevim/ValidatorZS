package br.com.santander.zurich.previdencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.zurich.previdencia.processo.ExecucaoProcessoException;
import br.com.santander.zurich.previdencia.processo.Processos;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.validacao.ValidacaoBeneficiarios;
import br.com.santander.zurich.previdencia.validacao.ValidacaoDomicilioFiscal;
import br.com.santander.zurich.previdencia.validacao.ValidacaoFundosInvestimento;
import br.com.santander.zurich.previdencia.validacao.ValidacaoTipoPlano;
import br.com.santander.zurich.previdencia.validacao.ValidacaoTributacao;

@RestController
public class ActuatorController {

	@RequestMapping(method = RequestMethod.GET, path = "/health")
	public String getHealth(@RequestBody PropostaAdesaoResource propostaAdesaoResource) {
		try {
			Processos.<PropostaAdesaoResource> builder()
					.add(ValidacaoTipoPlano.getInstance(), ValidacaoTipoPlano.deveExecutar())
					.add(ValidacaoTributacao.getInstance(), ValidacaoTributacao.deveExecutar())
					.add(ValidacaoBeneficiarios.getInstance(), ValidacaoBeneficiarios.deveExecutar())
					.add(ValidacaoDomicilioFiscal.getInstance(), ValidacaoDomicilioFiscal.deveExecutar())
					.add(ValidacaoFundosInvestimento.getInstance(), ValidacaoFundosInvestimento.deveExecutar())
					.build().executar(propostaAdesaoResource);
		} catch (ExecucaoProcessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return HttpStatus.OK.name();
	}
}
