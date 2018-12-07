package br.com.santander.zurich.previdencia.validacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.enums.StepAdesaoEnum;
import br.com.santander.zurich.previdencia.processo.ExecucaoProcessoException;
import br.com.santander.zurich.previdencia.processo.Processo;
import br.com.santander.zurich.previdencia.validacao.validator.TipoPlanoValidator;

public class ValidacaoTipoPlano implements Processo<PropostaAdesaoResource> {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private static final ValidacaoTipoPlano INSTANCE = new ValidacaoTipoPlano();

	public static ValidacaoTipoPlano getInstance() {
		return INSTANCE;
	}

	private ValidacaoTipoPlano() {
	}

	@Override
	public void executar(PropostaAdesaoResource propostaAdesaoResource) throws ExecucaoProcessoException {

		// Obtém o validador
		ValidationResult resultadoValidacao = new TipoPlanoValidator().validate(propostaAdesaoResource);

		if (resultadoValidacao.hasErrors()) {
			LOGGER.debug("Ocorreram erros durante a validação do Tipo Plano: "
					+ resultadoValidacao.errorMessages());
			throw new ExecucaoProcessoException(resultadoValidacao.errorMessages());
		}

		LOGGER.debug("validação do Tipo Plano executada sem erros.");
	}

	public static Predicate<PropostaAdesaoResource> deveExecutar() {
		return new Predicate<PropostaAdesaoResource>() {
			@Override
			public boolean apply(PropostaAdesaoResource propostaAdesao) {
				return propostaAdesao.getStep().equals(StepAdesaoEnum.TIPO_PLANO);
			}
		};
	}

}
