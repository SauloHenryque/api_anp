package br.com.saulo.anp.ultil;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.saulo.anp.importacao.ArquivoCSV;

public class InvokeMetodoClasse {
	
	public static <T> String retornarValorMetodo(String metodo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String valorRetornar = null;
		String nomeMetodo = "get" + GenericConvert.primeiraLetraMaiuscula(metodo);
		ArquivoCSV objetoClasse = new ArquivoCSV();
		
		try {
			Method metodoDoSeuObjeto = objetoClasse.getClass().getMethod(nomeMetodo, null );
			valorRetornar = (String) metodoDoSeuObjeto.invoke(objetoClasse);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		return valorRetornar;
	}


}
