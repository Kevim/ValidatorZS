package br.com.santander.zurich.previdencia.service.impl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.santander.zurich.previdencia.processo.ExecucaoProcessoException;
import br.com.santander.zurich.previdencia.processo.Processos;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResponseResource;
import br.com.santander.zurich.previdencia.validacao.ValidacaoBeneficiarios;
import br.com.santander.zurich.previdencia.validacao.ValidacaoContato;
import br.com.santander.zurich.previdencia.validacao.ValidacaoDomicilioFiscal;
import br.com.santander.zurich.previdencia.validacao.ValidacaoFundosInvestimento;
import br.com.santander.zurich.previdencia.validacao.ValidacaoPagamento;
import br.com.santander.zurich.previdencia.validacao.ValidacaoTipoPlano;
import br.com.santander.zurich.previdencia.validacao.ValidacaoTributacao;

/**
 * Facade responsável por executar o step requisitado.
 * 
 * @author Andre Dornelas
 */
@Component
public final class GenericServiceFacade {


	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public PropostaAdesaoResponseResource executeStep(final PropostaAdesaoResource propostaAdesao) {

		PropostaAdesaoResponseResource response = null;

		try {
			
			LOGGER.debug("Processando o Step : " + propostaAdesao.getStep());
			
			//-- Executa os processos de validação do Step
			Processos.<PropostaAdesaoResource> builder()
					.add(ValidacaoTipoPlano.getInstance(), ValidacaoTipoPlano.deveExecutar())
					.add(ValidacaoTributacao.getInstance(), ValidacaoTributacao.deveExecutar())
					.add(ValidacaoBeneficiarios.getInstance(), ValidacaoBeneficiarios.deveExecutar())
					.add(ValidacaoDomicilioFiscal.getInstance(), ValidacaoDomicilioFiscal.deveExecutar())
					.add(ValidacaoFundosInvestimento.getInstance(), ValidacaoFundosInvestimento.deveExecutar())
					.add(ValidacaoPagamento.getInstance(), ValidacaoPagamento.deveExecutar())
					.add(ValidacaoContato.getInstance(), ValidacaoContato.deveExecutar())
					.build().executar(propostaAdesao);
			
		} catch (ExecucaoProcessoException e) {
			response = new PropostaAdesaoResponseResource(new ArrayList<String>(e.getMensagens()));
		}

		return response;
	}

}
