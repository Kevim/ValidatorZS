package br.com.santander.zurich.previdencia.validacao;

import com.google.common.base.Predicate;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.dtos.PropostaAdesaoDTO;
import br.com.santander.zurich.previdencia.enums.TipoValidacaoEnum;
import br.com.santander.zurich.previdencia.processo.ExecucaoProcessoException;
import br.com.santander.zurich.previdencia.processo.Processo;
import br.com.santander.zurich.previdencia.validacao.validator.FundoInvestimentoValidator;

/**
 * responsável por aplicar as validações para garantir a consistência do
 * orçamento enviado antes da chamada do cálculo do orçamento.
 */
public class ValidacaoFundosInvestimento implements Processo<PropostaAdesaoDTO> {

	private static final ValidacaoFundosInvestimento INSTANCE = new ValidacaoFundosInvestimento();

	public static ValidacaoFundosInvestimento getInstance() {
		return INSTANCE;
	}

	private ValidacaoFundosInvestimento() {
		// singleton
	}

	@Override
	public void executar(PropostaAdesaoDTO propostaAdesaoDTO) throws ExecucaoProcessoException {

		// Obtém o validador
		ValidationResult resultadoValidacao = new FundoInvestimentoValidator().validate(propostaAdesaoDTO);

		if (resultadoValidacao.hasErrors()) {
//			LOGGER.debug("Ocorreram erros durante a validação da Solicitação de orçamento: "
//					+ resultadoValidacao.errorMessages());
			throw new ExecucaoProcessoException(resultadoValidacao.errorMessages());
		}

//		LOGGER.debug("validação da Solicitação de orçamento executada sem erros.");
	}

	/**
	 * Regra de execução do Processo. não deve ser executado para endosso de
	 * cancelamento.
	 */
	public static Predicate<PropostaAdesaoDTO> deveExecutar() {
		return new Predicate<PropostaAdesaoDTO>() {
			@Override
			public boolean apply(PropostaAdesaoDTO propostaAdesao) {
				return !propostaAdesao.getTipoValidacao().equals(TipoValidacaoEnum.FUNDO_INVESTIMENTOS);
			}
		};
	}

}
