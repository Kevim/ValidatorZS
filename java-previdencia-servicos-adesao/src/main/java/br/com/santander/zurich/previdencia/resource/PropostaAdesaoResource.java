package br.com.santander.zurich.previdencia.resource;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.santander.zurich.previdencia.enums.ConfirmarEnum;
import br.com.santander.zurich.previdencia.enums.StepAdesaoEnum;
import br.com.santander.zurich.previdencia.enums.TipoImpostoRendaEnum;
import br.com.santander.zurich.previdencia.enums.TipoModalidadeEnum;
import br.com.santander.zurich.previdencia.enums.TipoTributacaoEnum;

public class PropostaAdesaoResource implements Serializable {

	private static final long serialVersionUID = -999032162535418569L;

	@NotNull(message="Código da Proposta é obrigatório")
	private Long codigoProposta;
	private Long cpf;
	@NotNull(message="Tipo da validação é obrigatório")
	private StepAdesaoEnum step;
	private TipoImpostoRendaEnum formaDeclaracaoIR;
	private TipoModalidadeEnum modalidade;
	private ConfirmarEnum prazoInferiorQuatroAnos;
	private TipoTributacaoEnum tipoTributacao;
	private Boolean residenteFiscalExterior;
	private List<FundoResource> fundosInvestimento;
	private List<BeneficiarioResource> beneficiarios;

	/**
	 * 
	 */
	public PropostaAdesaoResource() {
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
	 * @return the step
	 */
	public StepAdesaoEnum getStep() {
		return step;
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(StepAdesaoEnum step) {
		this.step = step;
	}

	/**
	 * @return the formaDeclaracaoIR
	 */
	public TipoImpostoRendaEnum getFormaDeclaracaoIR() {
		return formaDeclaracaoIR;
	}

	/**
	 * @param formaDeclaracaoIR the formaDeclaracaoIR to set
	 */
	public void setFormaDeclaracaoIR(TipoImpostoRendaEnum formaDeclaracaoIR) {
		this.formaDeclaracaoIR = formaDeclaracaoIR;
	}

	/**
	 * @return the modalidade
	 */
	public TipoModalidadeEnum getModalidade() {
		return modalidade;
	}

	/**
	 * @param modalidade the modalidade to set
	 */
	public void setModalidade(TipoModalidadeEnum modalidade) {
		this.modalidade = modalidade;
	}

	/**
	 * @return the prazoInferiorQuatroAnos
	 */
	public ConfirmarEnum getPrazoInferiorQuatroAnos() {
		return prazoInferiorQuatroAnos;
	}

	/**
	 * @param prazoInferiorQuatroAnos the prazoInferiorQuatroAnos to set
	 */
	public void setPrazoInferiorQuatroAnos(ConfirmarEnum prazoInferiorQuatroAnos) {
		this.prazoInferiorQuatroAnos = prazoInferiorQuatroAnos;
	}

	/**
	 * @return the tipoTributacao
	 */
	public TipoTributacaoEnum getTipoTributacao() {
		return tipoTributacao;
	}

	/**
	 * @param tipoTributacao the tipoTributacao to set
	 */
	public void setTipoTributacao(TipoTributacaoEnum tipoTributacao) {
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
	public List<FundoResource> getFundosInvestimento() {
		return fundosInvestimento;
	}

	/**
	 * @param fundosInvestimento the fundosInvestimento to set
	 */
	public void setFundosInvestimento(List<FundoResource> fundosInvestimento) {
		this.fundosInvestimento = fundosInvestimento;
	}

	/**
	 * @return the beneficiarios
	 */
	public List<BeneficiarioResource> getBeneficiarios() {
		return beneficiarios;
	}

	/**
	 * @param beneficiarios the beneficiarios to set
	 */
	public void setBeneficiarios(List<BeneficiarioResource> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

}
