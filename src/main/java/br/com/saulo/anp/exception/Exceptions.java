
package br.com.saulo.anp.exception;

import lombok.Getter;

public class Exceptions extends RuntimeException {

     private static final long serialVersionUID = -601362897548358062L;

     @Getter
     private ExceptionsMessagesEnum msgEnum;

     private String key;

     public Exceptions(String key, String msg) {

          super(msg);
          this.key = key;
          this.msgEnum = ExceptionsMessagesEnum.getEnum(key);
     }
     
     public Exceptions(ExceptionsMessagesEnum globalRegistroNaoEncontrado) {
          
          super(globalRegistroNaoEncontrado.getMessage());
          this.msgEnum = globalRegistroNaoEncontrado;
          
     }
     
     public static void checkThrow(boolean expression, ExceptionsMessagesEnum exceptionsMessagesEnum) throws Exceptions {

          if (expression) {
        	  exceptionsMessagesEnum.raise();
          }
          
     }

     public static void checkThrow(boolean expression, ExceptionsMessagesEnum exceptionsMessagesEnum, String... textoDinamico) throws Exceptions {

          if (expression) {
        	  exceptionsMessagesEnum.raise(textoDinamico);
          }
          
     }

}
