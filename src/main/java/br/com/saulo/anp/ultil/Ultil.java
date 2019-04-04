package br.com.saulo.anp.ultil;

public class Ultil {
	
	   public static String primeiraLetraMaiuscula(String palavra) {
		   
		   String palavraMaiuscula;
		   palavraMaiuscula = palavra.toUpperCase();
		   
		   return palavraMaiuscula.substring(0,1) + palavra.substring (1);
		   
	   }
	   
	   public static Boolean dataValida(String dataAnalisada) {
		   
		   String DatePattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}$";
			if ( dataAnalisada.matches(DatePattern) ) {
				return true;
			}
			
			return false;
	   }

}
