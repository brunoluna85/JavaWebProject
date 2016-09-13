package br.com.mercs.projetoweb.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mercs.projetoweb.entity.Estado;

public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("Paraíba");
		estado.setSigla("PB");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		System.out.println("Total de registros encontrados: "+resultado.size());
		
		for(Estado estado : resultado){
			System.out.println(estado.getNome() +" - "+estado.getSigla());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(1L);
		
		if (estado != null)
			System.out.println("Estado encontrado: "+estado.getNome() + " - " + estado.getSigla());
		else
			System.out.println("Registro não encontrado");
	}
	
	
	@Test
	@Ignore
	public void excluir(){
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(1L);
		
		estadoDAO.excluir(estado);
		
		estado = estadoDAO.buscar(1L);
		if (estado == null)
			System.out.println("Estado removido com sucesso!");
	}
	
	
	@Test
	public void editar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(2L);
		
		String novoNome = "Paraíba";
		String novaSigla = "PB";
		
		estado.setNome(novoNome);
		estado.setSigla(novaSigla);
		estadoDAO.editar(estado);
		
		estado = estadoDAO.buscar(2L);
		if (estado.getNome().equals(novoNome) && estado.getSigla().equals(novaSigla)){
			System.out.println("Modificação realiada com sucesso!");
		}
	}
}
