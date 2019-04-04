package br.com.saulo.user.unitario;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;
import br.com.saulo.anp.exception.NotFoundException;
import br.com.saulo.anp.repositorios.HistoricoCombustivelRepositorio;
import br.com.saulo.anp.servicos.HistoricoCombustivelServico;
import junit.framework.TestCase;
import org.springframework.data.domain.Example;


@RunWith(SpringRunner.class)
public class HistoricoCombustivelServicoTest {
 
	 @InjectMocks
     private HistoricoCombustivelServico historicoCombustivelServicoMock;
	
     @Mock
     private HistoricoCombustivelRepositorio historicoCombustivelRepositorio;
     
     @Mock
     private HistoricoCombustivelEntidade historicoCombustivelEntidade;
     

     @Before
     public void setup() {

          MockitoAnnotations.initMocks(this);
     }
     
     @Test
     public void salvar(){
    	 
    	 HistoricoCombustivelEntidade	historicoCombustivelEntidadeNovo		 = new HistoricoCombustivelEntidade();
    	 
    	 historicoCombustivelEntidadeNovo.setRegiao("CO");
    	 historicoCombustivelEntidadeNovo.setEstado("DF");
    	 historicoCombustivelEntidadeNovo.setMunicipio("BRASILIA");
    	 historicoCombustivelEntidadeNovo.setRevenda("AUTO POSTO BRAGA LTDA");
    	 historicoCombustivelEntidadeNovo.setInstalacao("7890");
    	 historicoCombustivelEntidadeNovo.setProduto("DIESEL");
    	 historicoCombustivelEntidadeNovo.setData_coleta("03/01/2018");
    	 historicoCombustivelEntidadeNovo.setValor_compra("3,218");
    	 historicoCombustivelEntidadeNovo.setValor_venda("3,559");
    	 historicoCombustivelEntidadeNovo.setUnidade("R$ / litro");
    	 historicoCombustivelEntidadeNovo.setBandeira("PETROBRAS DISTRIBUIDORA S.A.");
    	  
         Mockito.when(historicoCombustivelRepositorio.save(Mockito.any(HistoricoCombustivelEntidade.class))).thenReturn(historicoCombustivelEntidadeNovo);
         HistoricoCombustivelEntidade historicoCombustivelEntidadeCadastrado = historicoCombustivelServicoMock.salvarHistoricoCombustivel(historicoCombustivelEntidadeNovo);

         testCase(historicoCombustivelEntidadeNovo, historicoCombustivelEntidadeCadastrado);
     }
     
    @Test
    public void atualizar(){
    	 
    	HistoricoCombustivelEntidade	historicoCombustivelEntidadeNovo		 = new HistoricoCombustivelEntidade();
    	 
    	 historicoCombustivelEntidadeNovo.setId(1L);
    	 historicoCombustivelEntidadeNovo.setRegiao("CO");
    	 historicoCombustivelEntidadeNovo.setEstado("DF");
    	 historicoCombustivelEntidadeNovo.setMunicipio("BRASILIA");
    	 historicoCombustivelEntidadeNovo.setRevenda("AUTO POSTO BRAGA LTDA");
    	 historicoCombustivelEntidadeNovo.setInstalacao("7890");
    	 historicoCombustivelEntidadeNovo.setProduto("DIESEL");
    	 historicoCombustivelEntidadeNovo.setData_coleta("03/01/2018");
    	 historicoCombustivelEntidadeNovo.setValor_compra("3,218");
    	 historicoCombustivelEntidadeNovo.setValor_venda("3,559");
    	 historicoCombustivelEntidadeNovo.setUnidade("R$ / litro");
    	 historicoCombustivelEntidadeNovo.setBandeira("PETROBRAS DISTRIBUIDORA S.A.");
    	 
    	 Mockito.when(historicoCombustivelRepositorio.existsById(1L)).thenReturn(true);
         Mockito.when(historicoCombustivelRepositorio.save(Mockito.any(HistoricoCombustivelEntidade.class))).thenReturn(historicoCombustivelEntidadeNovo);

         HistoricoCombustivelEntidade historicoCombustivelEntidadeAtualizado = historicoCombustivelServicoMock.atualizarHistoricoCombustivel(historicoCombustivelEntidadeNovo);

         testCase(historicoCombustivelEntidadeNovo, historicoCombustivelEntidadeAtualizado);
         TestCase.assertEquals(historicoCombustivelEntidadeNovo.getId(), historicoCombustivelEntidadeAtualizado.getId());
    }
    
    @Test(expected = NotFoundException.class)
    public void atualizarNaoEncontrado(){
   	 
    	HistoricoCombustivelEntidade	historicoCombustivelEntidadeNovo		 = new HistoricoCombustivelEntidade();
   	 
   	 	historicoCombustivelEntidadeNovo.setId(1L);
   	 	historicoCombustivelEntidadeNovo.setRegiao("CO");
   	 	historicoCombustivelEntidadeNovo.setEstado("DF");
   	 	historicoCombustivelEntidadeNovo.setMunicipio("BRASILIA");
   	 	historicoCombustivelEntidadeNovo.setRevenda("AUTO POSTO BRAGA LTDA");
   	 	historicoCombustivelEntidadeNovo.setInstalacao("7890");
   	 	historicoCombustivelEntidadeNovo.setProduto("DIESEL");
   	 	historicoCombustivelEntidadeNovo.setData_coleta("03/01/2018");
   	 	historicoCombustivelEntidadeNovo.setValor_compra("3,218");
   	 	historicoCombustivelEntidadeNovo.setValor_venda("3,559");
   	 	historicoCombustivelEntidadeNovo.setUnidade("R$ / litro");
   	 	historicoCombustivelEntidadeNovo.setBandeira("PETROBRAS DISTRIBUIDORA S.A.");
   	 
   	 	Mockito.when(historicoCombustivelRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(historicoCombustivelRepositorio.save(Mockito.any(HistoricoCombustivelEntidade.class))).thenReturn(historicoCombustivelEntidadeNovo);

   	 	historicoCombustivelServicoMock.atualizarHistoricoCombustivel(historicoCombustivelEntidadeNovo);
    }

    @Test()
    public void deletar(){
   	 
   	 	Mockito.when(historicoCombustivelRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(historicoCombustivelRepositorio.findById(1L)).thenReturn(historicoCombustivelEntidade);

   	 	historicoCombustivelServicoMock.deletarHistoricoCombustivel(1L);
    }
    
    @Test(expected = NotFoundException.class)
    public void deletarUserInexistente(){
   	 
   	 	Mockito.when(historicoCombustivelRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(historicoCombustivelRepositorio.findById(1L)).thenReturn(historicoCombustivelEntidade);

   	 	historicoCombustivelServicoMock.deletarHistoricoCombustivel(1L);
    }

    @Test
    public void testListar() {

    	HistoricoCombustivelEntidade	historicoCombustivelEntidadeList		 = new HistoricoCombustivelEntidade();
	 
    	historicoCombustivelEntidadeList.setRegiao("CO");
    	
        List<HistoricoCombustivelEntidade> listaHistoricoCombustivelEntidade  = Lists.newArrayList(historicoCombustivelEntidade);
    	 	
        Mockito.when(historicoCombustivelRepositorio.findAll(Example.of(historicoCombustivelEntidadeList))).thenReturn(listaHistoricoCombustivelEntidade);
    	 
        List<HistoricoCombustivelEntidade> listHistoricoCombustivelEntidade = historicoCombustivelServicoMock.listarHistoricoCombustivel(historicoCombustivelEntidade);
       
    	assertNotNull(listHistoricoCombustivelEntidade);
        

    }
    
	private static void testCase(HistoricoCombustivelEntidade historicoCombustivelEntidade, HistoricoCombustivelEntidade historicoCombustivelEntidadeCadastrado) {
         
         TestCase.assertNotNull(historicoCombustivelEntidadeCadastrado);
         TestCase.assertEquals(historicoCombustivelEntidade.getRegiao(), historicoCombustivelEntidadeCadastrado.getRegiao());
         TestCase.assertEquals(historicoCombustivelEntidade.getEstado(), historicoCombustivelEntidadeCadastrado.getEstado());
         TestCase.assertEquals(historicoCombustivelEntidade.getMunicipio(), historicoCombustivelEntidadeCadastrado.getMunicipio());
         TestCase.assertEquals(historicoCombustivelEntidade.getRevenda(), historicoCombustivelEntidadeCadastrado.getRevenda());
         TestCase.assertEquals(historicoCombustivelEntidade.getInstalacao(), historicoCombustivelEntidadeCadastrado.getInstalacao());
         TestCase.assertEquals(historicoCombustivelEntidade.getProduto(), historicoCombustivelEntidadeCadastrado.getProduto());
         TestCase.assertEquals(historicoCombustivelEntidade.getData_coleta(), historicoCombustivelEntidadeCadastrado.getData_coleta());
         TestCase.assertEquals(historicoCombustivelEntidade.getValor_compra(), historicoCombustivelEntidadeCadastrado.getValor_compra());
         TestCase.assertEquals(historicoCombustivelEntidade.getValor_venda(), historicoCombustivelEntidadeCadastrado.getValor_venda());
         TestCase.assertEquals(historicoCombustivelEntidade.getUnidade(), historicoCombustivelEntidadeCadastrado.getUnidade());
         TestCase.assertEquals(historicoCombustivelEntidade.getBandeira(), historicoCombustivelEntidadeCadastrado.getBandeira());
         
    }
}
