package br.com.santander.zurich.previdencia.validacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.enums.StepAdesaoEnum;
import br.com.santander.zurich.previdencia.processo.ExecucaoProcessoException;
import br.com.santander.zurich.previdencia.processo.Processo;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;
import br.com.santander.zurich.previdencia.validacao.validator.BeneficiariosValidator;

public class ValidacaoBeneficiarios implements Processo<PropostaAdesaoResource> {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private static final ValidacaoBeneficiarios INSTANCE = new ValidacaoBeneficiarios();

	public static ValidacaoBeneficiarios getInstance() {
		return INSTANCE;
	}

	private ValidacaoBeneficiarios() {
	}

	@Override
	public void executar(PropostaAdesaoResource propostaAdesaoResource) throws ExecucaoProcessoException {

		ValidationResult resultadoValidacao = new BeneficiariosValidator().validate(propostaAdesaoResource);

		if (resultadoValidacao.hasErrors()) {
			LOGGER.debug("Ocorreram erros durante a validação de Beneficiarios: "
					+ resultadoValidacao.errorMessages());
			throw new ExecucaoProcessoException(resultadoValidacao.errorMessages());
		}

		LOGGER.debug("Validação da Beneficiarios executada sem erros.");
	}

	public static Predicate<PropostaAdesaoResource> deveExecutar() {
		return new Predicate<PropostaAdesaoResource>() {
			@Override
			public boolean apply(PropostaAdesaoResource propostaAdesao) {
				return propostaAdesao.getStep().equals(StepAdesaoEnum.BENEFICIARIOS);
			}
		};
	}

}
