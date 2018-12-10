package br.com.santander.zurich.previdencia.resource;

import java.io.Serializable;
import java.sql.Date;

import br.com.santander.zurich.previdencia.enums.FormaPagamentoEnum;

public class PagamentoResource implements Serializable {

	private static final long serialVersionUID = -3162139812441909930L;

	private FormaPagamentoEnum formaPagamento;
	private Date dataPagamentoInicial;
	private Integer diaPagamentoMensalidades;
	private String endereco;

	/**
	 * 
	 */
	public PagamentoResource() {
	}

	/**
	 * @return the formaPagamento
	 */
	public FormaPagamentoEnum getFormaPagamento() {
		return formaPagamento;
	}

	/**
	 * @param formaPagamento the formaPagamento to set
	 */
	public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	/**
	 * @return the dataPagamentoInicial
	 */
	public Date getDataPagamentoInicial() {
		return dataPagamentoInicial;
	}

	/**
	 * @param dataPagamentoInicial the dataPagamentoInicial to set
	 */
	public void setDataPagamentoInicial(Date dataPagamentoInicial) {
		this.dataPagamentoInicial = dataPagamentoInicial;
	}

	/**
	 * @return the diaPagamentoMensalidades
	 */
	public Integer getDiaPagamentoMensalidades() {
		return diaPagamentoMensalidades;
	}

	/**
	 * @param diaPagamentoMensalidades the diaPagamentoMensalidades to set
	 */
	public void setDiaPagamentoMensalidades(Integer diaPagamentoMensalidades) {
		this.diaPagamentoMensalidades = diaPagamentoMensalidades;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
