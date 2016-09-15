package br.com.mercs.projetoweb.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mercs.projetoweb.entity.Produto;

public class ProdutoDAOTest implements DAOTest{
	
	@Test
	@Ignore
	public void salvar(){
		Produto produto = new Produto();
		produto.setDescricao("Samsung Galaxy S6");
		produto.setPreco(new BigDecimal("1899.90"));
		produto.setQuantidade(new Short("50"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
		System.out.println("Produto salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {
		// TODO Auto-generated method stub
		
	}

	@Test
	@Ignore
	public void buscar() {
		// TODO Auto-generated method stub
		
	}

	@Test
	@Ignore
	public void excluir() {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	@Ignore
	public void editar() {
		// TODO Auto-generated method stub
		
	}

}
