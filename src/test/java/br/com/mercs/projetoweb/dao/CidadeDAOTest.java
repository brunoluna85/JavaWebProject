package br.com.mercs.projetoweb.dao;

import org.junit.Test;

import br.com.mercs.projetoweb.entity.Cidade;
import br.com.mercs.projetoweb.entity.Estado;

public class CidadeDAOTest {
	
	@Test
	public void salvar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(2L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("João Pessoa");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
}
