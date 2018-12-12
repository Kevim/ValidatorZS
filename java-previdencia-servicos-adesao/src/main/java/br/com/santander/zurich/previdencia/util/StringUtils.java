package br.com.santander.zurich.previdencia.util;

public class StringUtils {

   public static boolean isBlank(String s) {
      return s == null || s.trim().length() < 1;
   }

   public static boolean isNotBlank(String s) {
      return !isBlank(s);
   }

   public static boolean isNumericInteger(String s) {
      if(isNotBlank(s)){
	 return s.matches("[0-9]+");
      }
      return false;
   }
}
