package br.com.santander.zurich.previdencia.validacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.enums.StepAdesaoEnum;
import br.com.santander.zurich.previdencia.processo.ExecucaoProcessoException;
import br.com.santander.zurich.previdencia.processo.Processo;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.validacao.validators.PagamentoValidator;

public class ValidacaoPagamento implements Processo<PropostaAdesaoResource> {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private static final ValidacaoPagamento INSTANCE = new ValidacaoPagamento();

	public static ValidacaoPagamento getInstance() {
		return INSTANCE;
	}

	private ValidacaoPagamento() {
	}

	@Override
	public void executar(PropostaAdesaoResource propostaAdesao) throws ExecucaoProcessoException {

		ValidationResult resultadoValidacao = new PagamentoValidator().validate(propostaAdesao.getPagamento());

		if (resultadoValidacao.hasErrors()) {
			LOGGER.debug("Ocorreram erros durante a validação de Pagamento: "
					+ resultadoValidacao.errorMessages());
			throw new ExecucaoProcessoException(resultadoValidacao.errorMessages());
		}

		LOGGER.debug("Validação da Pagamento executada sem erros.");
	}

	public static Predicate<PropostaAdesaoResource> deveExecutar() {
		return new Predicate<PropostaAdesaoResource>() {
			@Override
			public boolean apply(PropostaAdesaoResource propostaAdesao) {
				return propostaAdesao.getStep().equals(StepAdesaoEnum.PAGAMENTO);
			}
		};
	}

}
