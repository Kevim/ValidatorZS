package br.com.santander.zurich.previdencia.enums;

public enum TipoValidacaoEnum {
	TIPO_PLANO(1), TRIBUTACAO(2), FUNDO_INVESTIMENTOS(3), BENEFICIARIOS(4), DOMICILIO_FISCAL(5);

	private final Integer codigo;

	private TipoValidacaoEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}
}
