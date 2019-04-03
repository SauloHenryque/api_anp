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
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import br.com.saulo.anp.entidades.HistoricoCombustivelEntidade;
import br.com.saulo.anp.entidades.UserEntidade;
import br.com.saulo.anp.exception.BadRequestException;
import br.com.saulo.anp.exception.NotFoundException;
import br.com.saulo.anp.repositorios.HistoricoCombustivelRepositorio;
import br.com.saulo.anp.servicos.HistoricoCombustivelServico;
import junit.framework.TestCase;

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
    	 
    	 historicoCombustivelEntidadeNovo.setNome("Nome Teste");
    	 historicoCombustivelEntidadeNovo.setEmail("email@teste.com");
    	 historicoCombustivelEntidadeNovo.setPassword("13321344654");
    	 
         Mockito.when(historicoCombustivelRepositorio.existsByEmail("Teste")).thenReturn(false);
         Mockito.when(historicoCombustivelRepositorio.save(Mockito.any(UserEntidade.class))).thenReturn(historicoCombustivelEntidadeNovo);

         HistoricoCombustivelEntidade historicoCombustivelEntidadeCadastrado = historicoCombustivelServicoMock.salvarHistoricoCombustivel(historicoCombustivelEntidadeNovo);

         testCase(historicoCombustivelEntidadeNovo, historicoCombustivelEntidadeCadastrado);
     }
     
     @Test(expected = BadRequestException.class)
     public void salvarUserEmailRepetido(){
    	 
    	 UserEntidade	userEntidadeNovo		 = new UserEntidade();
    	 
    	 userEntidadeNovo.setNome("Nome Teste");
    	 userEntidadeNovo.setEmail("email@teste.com");
    	 userEntidadeNovo.setPassword("13321344654");
    	 
         Mockito.when(userRepositorio.existsByEmail("email@teste.com")).thenReturn(true);
         Mockito.when(userRepositorio.save(Mockito.any(UserEntidade.class))).thenReturn(userEntidadeNovo);

         userServicoMock.salvarUser(userEntidadeNovo);
     }
     
     
    @Test
    public void atualizarUser(){
    	 
    	 UserEntidade	userEntidadeNovo		 = new UserEntidade();
    	 
    	 userEntidadeNovo.setId(1L);
    	 userEntidadeNovo.setNome("Nome Teste");
    	 userEntidadeNovo.setEmail("email@teste.com");
    	 userEntidadeNovo.setPassword("13321344654");
    	 
    	 Mockito.when(userRepositorio.existsById(1L)).thenReturn(true);
         Mockito.when(userRepositorio.existsByEmailAndIdNotIn("email@teste.com", 1L)).thenReturn(false);
         Mockito.when(userRepositorio.save(Mockito.any(UserEntidade.class))).thenReturn(userEntidadeNovo);

         UserEntidade userEntidadeAtualizado = userServicoMock.atualizarUser(userEntidadeNovo);

         testCase(userEntidadeNovo, userEntidadeAtualizado);
         TestCase.assertEquals(userEntidadeNovo.getId(), userEntidadeAtualizado.getId());
    }
    
    @Test(expected = NotFoundException.class)
    public void atualizarUserNaoEncontrado(){
   	 
   	 	UserEntidade	userEntidadeNovo		 = new UserEntidade();
   	 
   	 	userEntidadeNovo.setId(1L);
   	 	userEntidadeNovo.setNome("Nome Teste");
   	 	userEntidadeNovo.setEmail("email@teste.com");
   	 	userEntidadeNovo.setPassword("13321344654");
   	 
   	 	Mockito.when(userRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(userRepositorio.existsByEmailAndIdNotIn("email@teste.com", 1L)).thenReturn(false);
   	 	Mockito.when(userRepositorio.save(Mockito.any(UserEntidade.class))).thenReturn(userEntidadeNovo);

   	 	userServicoMock.atualizarUser(userEntidadeNovo);
    }
    
    @Test(expected = BadRequestException.class)
    public void atualizarUserNomeRepetido(){
   	 
   	 	UserEntidade	userEntidadeNovo		 = new UserEntidade();
   	 
   	 	userEntidadeNovo.setId(1L);
   	 	userEntidadeNovo.setNome("Nome Teste");
   	 	userEntidadeNovo.setEmail("email@teste.com");
   	 	userEntidadeNovo.setPassword("13321344654");
   	 
   	 	Mockito.when(userRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(userRepositorio.existsByEmailAndIdNotIn("email@teste.com", 1L)).thenReturn(true);
   	 	Mockito.when(userRepositorio.save(Mockito.any(UserEntidade.class))).thenReturn(userEntidadeNovo);

   	 	userServicoMock.atualizarUser(userEntidadeNovo);
    }
    
    @Test()
    public void deletarUser(){
   	 
   	 	Mockito.when(userRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(userRepositorio.findById(1L)).thenReturn(userEntidade);

   	 	userServicoMock.deletarUser(1L);
    }
    
    @Test(expected = NotFoundException.class)
    public void deletarUserInexistente(){
   	 
   	 	Mockito.when(userRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(userRepositorio.findById(1L)).thenReturn(userEntidade);

   	 	userServicoMock.deletarUser(1L);
    }

    @Test
    public void testListar() {

    	UserEntidade	userEntidadeList		 = new UserEntidade();
	 
    	userEntidadeList.setNome("Nome Teste");
    	
        List<UserEntidade> listaUserEntidade  = Lists.newArrayList(userEntidade);
    	 	
        Mockito.when(userRepositorio.findAll(Example.of(userEntidadeList))).thenReturn(listaUserEntidade);
    	 
        List<UserEntidade> listStoreEntidade = userServicoMock.listarUser(userEntidade);
       
    	assertNotNull(listStoreEntidade);
        

    }
    
	private static void testCase(UserEntidade userEntidade, UserEntidade userEntidadeCadastrado) {
         
         TestCase.assertNotNull(userEntidadeCadastrado);
         TestCase.assertEquals(userEntidade.getNome(), userEntidadeCadastrado.getNome());
         TestCase.assertEquals(userEntidade.getEmail(), userEntidadeCadastrado.getEmail());
         TestCase.assertEquals(userEntidade.getPassword(), userEntidadeCadastrado.getPassword());
         
    }
}
