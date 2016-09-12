package br.com.mercs.projetoweb.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericEntity {

	@Column(length = 80, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Short quantidade;
	
	@Column(nullable = false, precision = 6, scale = 2) //dos 6 dígitos, 2 são depois da vírgula (9999,99)
	private BigDecimal preco;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}
