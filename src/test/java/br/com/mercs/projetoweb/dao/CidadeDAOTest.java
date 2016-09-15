package br.com.mercs.projetoweb.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mercs.projetoweb.entity.Cidade;
import br.com.mercs.projetoweb.entity.Estado;

public class CidadeDAOTest implements DAOTest{
	
	@Test
	@Ignore
	public void salvar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(2L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Rio de Janeiro");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
	
	@Test
	@Ignore
	public void buscar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(2L);
		
		System.out.println("ID: "+cidade.getId());
		System.out.println("Nome: "+cidade.getNome());
		System.out.println("Estado: "+cidade.getEstado().getNome() + "-" +cidade.getEstado().getSigla());
	}
	
	@Test
	@Ignore
	public void excluir(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(2L);
		
		cidadeDAO.excluir(cidade);
		System.out.println("Cidade removida com sucesso!");
	}
	
	@Test
	@Ignore
	public void editar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(2L);
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado novoEstado = estadoDAO.buscar(3L);
		
		cidade.setNome("Rio de Janeiro");
		cidade.setEstado(novoEstado);
		
		cidadeDAO.editar(cidade);
		
		System.out.println("ID: "+cidade.getId());
		System.out.println("Nome: "+cidade.getNome());
		System.out.println("Estado: "+cidade.getEstado().getNome() + "-" +cidade.getEstado().getSigla());
	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> cidades = cidadeDAO.listar();
		
		for (Cidade cidade: cidades){
			System.out.println(cidade.getNome() + " " + cidade.getEstado().getSigla());
		}
	}
}
