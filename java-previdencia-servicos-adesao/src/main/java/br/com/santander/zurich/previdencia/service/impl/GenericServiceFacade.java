package br.com.santander.zurich.previdencia.service.impl;

import org.springframework.stereotype.Component;

import br.com.santander.zurich.previdencia.processo.ExecucaoProcessoException;
import br.com.santander.zurich.previdencia.processo.Processos;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResponseResource;
import br.com.santander.zurich.previdencia.validacao.ValidacaoBeneficiarios;
import br.com.santander.zurich.previdencia.validacao.ValidacaoDomicilioFiscal;
import br.com.santander.zurich.previdencia.validacao.ValidacaoFundosInvestimento;
import br.com.santander.zurich.previdencia.validacao.ValidacaoPropostaAdesao;
import br.com.santander.zurich.previdencia.validacao.ValidacaoTipoPlano;
import br.com.santander.zurich.previdencia.validacao.ValidacaoTributacao;

@Component
public final class GenericServiceFacade {

	
	public PropostaAdesaoResponseResource executeStep(final PropostaAdesaoResource propostaAdesao) {

		PropostaAdesaoResponseResource response = null;
		
<<<<<<< HEAD
		try {
			Processos.<PropostaAdesaoResource> builder()
					//.add(ValidacaoPropostaAdesao.getInstance())
					.add(ValidacaoTipoPlano.getInstance(), ValidacaoTipoPlano.deveExecutar())
					.add(ValidacaoTributacao.getInstance(), ValidacaoTributacao.deveExecutar())
					.add(ValidacaoBeneficiarios.getInstance(), ValidacaoBeneficiarios.deveExecutar())
					.add(ValidacaoDomicilioFiscal.getInstance(), ValidacaoDomicilioFiscal.deveExecutar())
					.add(ValidacaoFundosInvestimento.getInstance(), ValidacaoFundosInvestimento.deveExecutar())
					.build().executar(propostaAdesao);
		} catch (ExecucaoProcessoException e) {
			e.printStackTrace();
		}
=======
		//TODO MOCK
		if(StepAdesaoEnum.TIPO_PLANO.equals(propostaAdesao.getStep())) {

			response = new PropostaAdesaoResponseResource();
			response.getErrors().add("Velho, preenhce o campo tipo do plano...");
			response.getErrors().add("Aproveita e preenche o resto dos campos certo carai");
		} 
>>>>>>> branch 'master' of https://github.com/Kevim/ValidatorZS.git
		
		return response;
	}

}
