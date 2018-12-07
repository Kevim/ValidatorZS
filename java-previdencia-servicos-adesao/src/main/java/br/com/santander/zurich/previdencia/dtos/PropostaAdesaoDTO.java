package br.com.santander.zurich.previdencia.dtos;

import java.util.List;

import br.com.santander.zurich.previdencia.enums.TipoValidacaoEnum;

public class PropostaAdesaoDTO {
	private Long codigoProposta;
	private Long cpf;
	private TipoValidacaoEnum tipoValidacao;
	private Integer formaDeclaracaoIR;
	private Integer modalidade;
	private Integer prazoInferiorQuatroAnos;
	private Integer tipoTributacao;
	private Boolean residenteFiscalExterior;
	private List<FundoDTO> fundosInvestimento;
	private List<BeneficiarioDTO> beneficiarios;

	/**
	 * 
	 */
	public PropostaAdesaoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the codigoProposta
	 */
	public Long getCodigoProposta() {
		return codigoProposta;
	}

	/**
	 * @param codigoProposta the codigoProposta to set
	 */
	public void setCodigoProposta(Long codigoProposta) {
		this.codigoProposta = codigoProposta;
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
	 * @return the tipoValidacao
	 */
	public TipoValidacaoEnum getTipoValidacao() {
		return tipoValidacao;
	}

	/**
	 * @param tipoValidacao the tipoValidacao to set
	 */
	public void setTipoValidacao(TipoValidacaoEnum tipoValidacao) {
		this.tipoValidacao = tipoValidacao;
	}

	/**
	 * @return the formaDeclaracaoIR
	 */
	public Integer getFormaDeclaracaoIR() {
		return formaDeclaracaoIR;
	}

	/**
	 * @param formaDeclaracaoIR the formaDeclaracaoIR to set
	 */
	public void setFormaDeclaracaoIR(Integer formaDeclaracaoIR) {
		this.formaDeclaracaoIR = formaDeclaracaoIR;
	}

	/**
	 * @return the modalidade
	 */
	public Integer getModalidade() {
		return modalidade;
	}

	/**
	 * @param modalidade the modalidade to set
	 */
	public void setModalidade(Integer modalidade) {
		this.modalidade = modalidade;
	}

	/**
	 * @return the prazoInferiorQuatroAnos
	 */
	public Integer getPrazoInferiorQuatroAnos() {
		return prazoInferiorQuatroAnos;
	}

	/**
	 * @param prazoInferiorQuatroAnos the prazoInferiorQuatroAnos to set
	 */
	public void setPrazoInferiorQuatroAnos(Integer prazoInferiorQuatroAnos) {
		this.prazoInferiorQuatroAnos = prazoInferiorQuatroAnos;
	}

	/**
	 * @return the tipoTributacao
	 */
	public Integer getTipoTributacao() {
		return tipoTributacao;
	}

	/**
	 * @param tipoTributacao the tipoTributacao to set
	 */
	public void setTipoTributacao(Integer tipoTributacao) {
		this.tipoTributacao = tipoTributacao;
	}

	/**
	 * @return the residenteFiscalExterior
	 */
	public Boolean getResidenteFiscalExterior() {
		return residenteFiscalExterior;
	}

	/**
	 * @param residenteFiscalExterior the residenteFiscalExterior to set
	 */
	public void setResidenteFiscalExterior(Boolean residenteFiscalExterior) {
		this.residenteFiscalExterior = residenteFiscalExterior;
	}

	/**
	 * @return the fundosInvestimento
	 */
	public List<FundoDTO> getFundosInvestimento() {
		return fundosInvestimento;
	}

	/**
	 * @param fundosInvestimento the fundosInvestimento to set
	 */
	public void setFundosInvestimento(List<FundoDTO> fundosInvestimento) {
		this.fundosInvestimento = fundosInvestimento;
	}

	/**
	 * @return the beneficiarios
	 */
	public List<BeneficiarioDTO> getBeneficiarios() {
		return beneficiarios;
	}

	/**
	 * @param beneficiarios the beneficiarios to set
	 */
	public void setBeneficiarios(List<BeneficiarioDTO> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

}
