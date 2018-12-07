package br.com.santander.zurich.previdencia.api.validacao;

/**
 * Por padrao os validadores nao aceitam valores nulos, ou seja, a infra de
 * validacaoo nao executa o validador caso o valor seja nulo. Essa eh uma
 * interface de marcacao para os validadores que necessitem validar o valor,
 * mesmo quando esse valor seja nulo.
 * 
 * @author Ricardo Okura
 */
public interface AcceptNullValues {

}
