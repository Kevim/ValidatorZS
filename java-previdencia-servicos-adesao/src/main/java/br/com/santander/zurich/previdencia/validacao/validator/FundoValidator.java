package br.com.santander.zurich.previdencia.validacao.validator;

import br.com.santander.zurich.previdencia.api.validacao.ValidationResult;
import br.com.santander.zurich.previdencia.api.validacao.Validator;
import br.com.santander.zurich.previdencia.api.validacao.builder.ValidatorBuilder;
import br.com.santander.zurich.previdencia.dtos.FundoDTO;

public class FundoValidator implements Validator<FundoDTO> {

	@Override
	public ValidationResult validate(FundoDTO fundoDTO) {
		return ValidatorBuilder.validateBean(FundoDTO.class).validateProperty("codigoFundo").notNull()
				.validateProperty("valorMinimo").notNull().validateProperty("percentualContribuicao").build()
				.validate(fundoDTO);
	}

}
