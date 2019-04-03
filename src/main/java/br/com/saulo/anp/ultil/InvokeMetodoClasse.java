package br.com.saulo.anp.ultil;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;
import br.com.saulo.anp.importacao.ArquivoCSV;

public class InvokeMetodoClasse {
	
	public static <T> String retornarValorMetodo(String metodo) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String valorRetornar = null;
		String nomeMetodo = "get" + Ultil.primeiraLetraMaiuscula(metodo);
		ArquivoCSV objetoClasse = new ArquivoCSV();
		
		try {
			Method metodoDoSeuObjeto = objetoClasse.getClass().getMethod(nomeMetodo, null );
			valorRetornar = (String) metodoDoSeuObjeto.invoke(objetoClasse);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		return valorRetornar;
	}
	
	public static HistoricoCombustivelEntidade retornarHistoricoCombustivel(HistoricoCombustivelEntidade historicoCombustivelEntidade, String metodo, String valor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String nomeMetodo = "set" + Ultil.primeiraLetraMaiuscula(metodo);
		
		try {
			Method metodoDoSeuObjeto = historicoCombustivelEntidade.getClass().getMethod(nomeMetodo, null );
			metodoDoSeuObjeto.invoke(historicoCombustivelEntidade, valor);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		return historicoCombustivelEntidade;
	}


}
