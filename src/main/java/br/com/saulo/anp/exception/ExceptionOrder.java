
package br.com.saulo.anp.exception;

import lombok.Getter;

public class ExceptionOrder extends RuntimeException {

     private static final long serialVersionUID = -601362897548358062L;

     @Getter
     private ExceptionsMessagesEnum msgEnum;

     private String key;

     public ExceptionOrder(String key, String msg) {

          super(msg);
          this.key = key;
          this.msgEnum = ExceptionsMessagesEnum.getEnum(key);
     }
     
     public ExceptionOrder(ExceptionsMessagesEnum globalRegistroNaoEncontrado) {
          
          super(globalRegistroNaoEncontrado.getMessage());
          this.msgEnum = globalRegistroNaoEncontrado;
          
     }
     
     public static void checkThrow(boolean expression, ExceptionsMessagesEnum exceptionsMessagesPIEREnum) throws ExceptionOrder {

          if (expression) {
               exceptionsMessagesPIEREnum.raise();
          }
          
     }

     public static void checkThrow(boolean expression, ExceptionsMessagesEnum exceptionsMessagesPIEREnum, String... textoDinamico) throws ExceptionOrder {

          if (expression) {
               exceptionsMessagesPIEREnum.raise(textoDinamico);
          }
          
     }

}
