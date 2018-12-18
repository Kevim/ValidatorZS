package br.com.santander.zurich.previdencia.exception;

public class ApplicationException extends RuntimeException{

   private static final long serialVersionUID = 1L;
   
   public ApplicationException(String msg, Exception e) {
      super(msg,e);
   }
   
   public ApplicationException(Exception e) {
      super(e);
   }
   
   public ApplicationException(String msg) {
      super(msg);
   }
   

}
