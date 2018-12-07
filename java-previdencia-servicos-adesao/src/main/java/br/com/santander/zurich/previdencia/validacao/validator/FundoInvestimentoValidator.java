package br.com.santander.zurich.previdencia.validacao.validator;

import br.com.santander.zurich.previdencia.api.validacao.ArrayElementValidator;
import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.dtos.FundoDTO;
import br.com.santander.zurich.previdencia.dtos.PropostaAdesaoDTO;

public class FundoInvestimentoValidator implements Validator<PropostaAdesaoDTO> {

	@Override
	public ValidationResult validate(PropostaAdesaoDTO propostaAdesaoDTO) {
		return ValidatorBuilder.validateBean(PropostaAdesaoDTO.class).validateProperty("fundosInvestimento").notNull()
				.notEmpty().with(new ArrayElementValidator<FundoDTO>(new FundoValidator()))
				.build()
				.validate(propostaAdesaoDTO);
	}

}
