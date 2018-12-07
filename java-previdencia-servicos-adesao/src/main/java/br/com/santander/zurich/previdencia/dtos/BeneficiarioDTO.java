package br.com.santander.zurich.previdencia.dtos;

import java.sql.Date;

public class BeneficiarioDTO {

	private Long cpf;
	private String nomeCompleto;
	private Date dataNascimento;
	private Integer grauParentesco;
	private Integer genero;
	private Double percentualAcumulacao;

	/**
	 * 
	 */
	public BeneficiarioDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the cpf
	 */
	public Long getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the nomeCompleto
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	 * @param nomeCompleto the nomeCompleto to set
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the grauParentesco
	 */
	public Integer getGrauParentesco() {
		return grauParentesco;
	}

	/**
	 * @param grauParentesco the grauParentesco to set
	 */
	public void setGrauParentesco(Integer grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	/**
	 * @return the genero
	 */
	public Integer getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	/**
	 * @return the percentualAcumulacao
	 */
	public Double getPercentualAcumulacao() {
		return percentualAcumulacao;
	}

	/**
	 * @param percentualAcumulacao the percentualAcumulacao to set
	 */
	public void setPercentualAcumulacao(Double percentualAcumulacao) {
		this.percentualAcumulacao = percentualAcumulacao;
	}

}
