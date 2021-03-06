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

	// @NotNull(message = "Código da Proposta é obrigatório")
	private Long codigoProposta;
	private Long cpf;
	@NotNull(message = "Step é obrigatório")
	private StepAdesaoEnum step;
	private TipoImpostoRendaEnum formaDeclaracaoIR;
	private TipoModalidadeEnum modalidade;
	private ConfirmarEnum prazoInferiorQuatroAnos;
	private TipoTributacaoEnum tipoTributacao;
	private Boolean residenteFiscalExterior;
	private List<FundoResource> fundosInvestimento;
	private List<BeneficiarioResource> beneficiarios;
	private PagamentoResource pagamento;
	private ContatoResource contato;
	private Integer idade;
	private Double valorLucro;
	private Double valorInvestimentoInicial;

	/**
	 * 
	 */
	public PropostaAdesaoResource() {
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

	/**
	 * @return the pagamento
	 */
	public PagamentoResource getPagamento() {
		return pagamento;
	}

	/**
	 * @param pagamento the pagamento to set
	 */
	public void setPagamento(PagamentoResource pagamento) {
		this.pagamento = pagamento;
	}

	/**
	 * @return the contato
	 */
	public ContatoResource getContato() {
		return contato;
	}

	/**
	 * @param contato the contato to set
	 */
	public void setContato(ContatoResource contato) {
		this.contato = contato;
	}

	/**
	 * @return the idade
	 */
	public Integer getIdade() {
		return idade;
	}

	/**
	 * @param idade the idade to set
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	/**
	 * @return the valorInvestimentoInicial
	 */
	public Double getValorInvestimentoInicial() {
		return valorInvestimentoInicial;
	}

	/**
	 * @param valorInvestimentoInicial the valorInvestimentoInicial to set
	 */
	public void setValorInvestimentoInicial(Double valorInvestimentoInicial) {
		this.valorInvestimentoInicial = valorInvestimentoInicial;
	}

	/**
	 * @return the valorLucro
	 */
	public Double getValorLucro() {
		return valorLucro;
	}

	/**
	 * @param valorLucro the valorLucro to set
	 */
	public void setValorLucro(Double valorLucro) {
		this.valorLucro = valorLucro;
	}

}
