package br.com.santander.zurich.previdencia.util;

public class VariaveisAmbienteUtil {

   public static String getValor(String chave) {
      if(StringUtils.isNotBlank(chave)){
    	  return System.getenv(chave);
      }
      return null;
   }
}
