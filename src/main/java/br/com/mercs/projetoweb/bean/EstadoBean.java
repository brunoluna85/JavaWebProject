package br.com.mercs.projetoweb.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
//import javax.faces.context.FacesContext;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.mercs.projetoweb.dao.EstadoDAO;
import br.com.mercs.projetoweb.entity.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped //escopo de existencia das variáveis é da visão da tela
public class EstadoBean implements Serializable{
	
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void initEstado(){
		estado = new Estado();
	}
	
	public void salvar(){
		/* Fazendo mensagem na mão
		
		String texto = "Programação Web com Java";
		System.out.println(texto);
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,texto,texto);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, mensagem);
	*/
		
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.salvar(estado);
			
			Messages.addGlobalInfo("Estado salvo com sucesso: "+estado.getNome() + "-" + estado.getSigla());
			initEstado();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar o estado.");
			erro.printStackTrace();
		}
	}

}
