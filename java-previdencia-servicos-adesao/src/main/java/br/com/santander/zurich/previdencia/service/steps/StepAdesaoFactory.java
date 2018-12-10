package br.com.santander.zurich.previdencia.service.steps;

import br.com.santander.zurich.previdencia.enums.StepAdesaoEnum;

/**
 * Factory dos steps da adesão.
 * 
 * @author Andre Dornelas
 */
public final class StepAdesaoFactory {

	/**
	 * Factory do step com as regras de adesão a ser executada.
	 * 
	 * @param stepAdesao - {@link StepAdesaoEnum}
	 * @return Implementação do Step com suas devidas regras
	 */
	public static StepAdesao criarStep(final StepAdesaoEnum stepAdesao) {
		
		final StepAdesao stepExecucao;
		
		/* Regra:
		 * ------
		 *   Todos os Steps que devem ter acesso a dados, devem ser a interface instanciada 
		 *   pela classe que implementará a regra.
		 *   
		 *   Caso o Step não precise de acesso a base, então deve ser instanciado o 
		 *   Step Genérico.
		 */
		switch (stepAdesao) {
			
			case BENEFICIARIOS:
				stepExecucao = new StepBeneficiarios();
				break;
	
			default:
				stepExecucao = new StepGeneric();
				break;
		}
		return stepExecucao;
	}
}
