package br.com.santander.zurich.previdencia.service.impl;

import org.springframework.stereotype.Component;

import br.com.santander.zurich.previdencia.processo.ExecucaoProcessoException;
import br.com.santander.zurich.previdencia.processo.Processos;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResponseResource;
import br.com.santander.zurich.previdencia.validacao.ValidacaoBeneficiarios;
import br.com.santander.zurich.previdencia.validacao.ValidacaoDomicilioFiscal;
import br.com.santander.zurich.previdencia.validacao.ValidacaoFundosInvestimento;
import br.com.santander.zurich.previdencia.validacao.ValidacaoTipoPlano;
import br.com.santander.zurich.previdencia.validacao.ValidacaoTributacao;

@Component
public final class GenericServiceFacade {

	
	public PropostaAdesaoResponseResource executeStep(final PropostaAdesaoResource propostaAdesao) {

		PropostaAdesaoResponseResource response = null;
		
		try {
			Processos.<PropostaAdesaoResource> builder()
					.add(ValidacaoTipoPlano.getInstance(), ValidacaoTipoPlano.deveExecutar())
					.add(ValidacaoTributacao.getInstance(), ValidacaoTributacao.deveExecutar())
					.add(ValidacaoBeneficiarios.getInstance(), ValidacaoBeneficiarios.deveExecutar())
					.add(ValidacaoDomicilioFiscal.getInstance(), ValidacaoDomicilioFiscal.deveExecutar())
					.add(ValidacaoFundosInvestimento.getInstance(), ValidacaoFundosInvestimento.deveExecutar())
					.build().executar(propostaAdesao);
		} catch (ExecucaoProcessoException e) {
			e.printStackTrace();
		}
		
		return response;
	}

}
