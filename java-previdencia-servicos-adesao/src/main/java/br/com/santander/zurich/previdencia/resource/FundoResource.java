package br.com.santander.zurich.previdencia.resource;

import java.io.Serializable;

public class FundoResource implements Serializable {
	
	private static final long serialVersionUID = 7366618369993125104L;
	
	private Long codigoFundo;
	private Double valorMinimo;
	private Double percentualContribuicao;

	public FundoResource() {
		super();
	}

	/**
	 * @return the codigoFundo
	 */
	public Long getCodigoFundo() {
		return codigoFundo;
	}

	/**
	 * @param codigoFundo the codigoFundo to set
	 */
	public void setCodigoFundo(Long codigoFundo) {
		this.codigoFundo = codigoFundo;
	}

	/**
	 * @return the valorMinimo
	 */
	public Double getValorMinimo() {
		return valorMinimo;
	}

	/**
	 * @param valorMinimo the valorMinimo to set
	 */
	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	/**
	 * @return the percentualContribuicao
	 */
	public Double getPercentualContribuicao() {
		return percentualContribuicao;
	}

	/**
	 * @param percentualContribuicao the percentualContribuicao to set
	 */
	public void setPercentualContribuicao(Double percentualContribuicao) {
		this.percentualContribuicao = percentualContribuicao;
	}

}
