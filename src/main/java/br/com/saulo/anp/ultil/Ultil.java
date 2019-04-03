package br.com.saulo.anp.ultil;

public class Ultil {
	
	   public static String primeiraLetraMaiuscula(String palavra) {
		   
		   String palavraMaiuscula;
		   palavraMaiuscula = palavra.toUpperCase();
		   
		   return palavraMaiuscula.substring(0,1) + palavra.substring (1);
		   
	   }

}
