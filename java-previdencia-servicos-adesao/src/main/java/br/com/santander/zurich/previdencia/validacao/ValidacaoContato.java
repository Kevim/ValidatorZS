package br.com.santander.zurich.previdencia.validacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.enums.StepAdesaoEnum;
import br.com.santander.zurich.previdencia.processo.ExecucaoProcessoException;
import br.com.santander.zurich.previdencia.processo.Processo;
import br.com.santander.zurich.previdencia.resource.ContatoResource;
import br.com.santander.zurich.previdencia.resource.PagamentoResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.validacao.validators.ContatoValidator;
import br.com.santander.zurich.previdencia.validacao.validators.PagamentoValidator;

public class ValidacaoContato implements Processo<PropostaAdesaoResource> {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private static final ValidacaoContato INSTANCE = new ValidacaoContato();

	public static ValidacaoContato getInstance() {
		return INSTANCE;
	}

	private ValidacaoContato() {
	}

	@Override
	public void executar(PropostaAdesaoResource propostaAdesao) throws ExecucaoProcessoException {

		ValidationResult resultadoValidacao = new ContatoValidator().validate(propostaAdesao.getContato());

		if (resultadoValidacao.hasErrors()) {
			LOGGER.debug("Ocorreram erros durante a validação de Contato: " + resultadoValidacao.errorMessages());
			throw new ExecucaoProcessoException(resultadoValidacao.errorMessages());
		}

		LOGGER.debug("Validação da Contato executada sem erros.");
	}

	public static Predicate<PropostaAdesaoResource> deveExecutar() {
		return new Predicate<PropostaAdesaoResource>() {
			@Override
			public boolean apply(PropostaAdesaoResource propostaAdesao) {
				return propostaAdesao.getStep().equals(StepAdesaoEnum.CONTATO);
			}
		};
	}

}
