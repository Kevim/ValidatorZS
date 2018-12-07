package br.com.santander.zurich.previdencia.validacao.validator;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.dtos.PropostaAdesaoDTO;

public class TributacaoValidator implements Validator<PropostaAdesaoDTO> {

	@Override
	public ValidationResult validate(PropostaAdesaoDTO propostaAdesaoDTO) {
		return ValidatorBuilder.validateBean(PropostaAdesaoDTO.class).validateProperty("prazoInferiorQuatroAnos")
				.notNull().validateProperty("tipoTributacao").notNull().build().validate(propostaAdesaoDTO);
	}

}
