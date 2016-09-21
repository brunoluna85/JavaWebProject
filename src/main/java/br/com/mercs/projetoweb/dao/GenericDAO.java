package br.com.mercs.projetoweb.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.mercs.projetoweb.util.HibernateUtil;

public class GenericDAO<Entity> {
	
	private Class<Entity> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO(){
		//armazenar o tipo da classe dos DAOs das entidades filhas
		this.classe = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	
	
	public void salvar(Entity entity){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		//iniciar tentativa de transação
		try{
			transacao = sessao.beginTransaction();
			sessao.save(entity);
			transacao.commit();
		}catch(RuntimeException erro){
			if (transacao != null){
				transacao.rollback();
			}
			//TODO colocar uma excecao específica para erro ao salvar
			throw erro;
		}finally{
			sessao.close();
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Entity> listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try{
			Criteria consulta = sessao.createCriteria(classe);
			List<Entity> resultado = consulta.list();
			return resultado;
		}catch(RuntimeException erro){
			throw erro;
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entity buscar(Long id){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try{
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(id));
			Entity resultado = (Entity) consulta.uniqueResult();
			return resultado;
		}catch(RuntimeException erro){
			throw erro;
		}finally{
			sessao.close();
		}
	}
	
	
	public void excluir(Entity entity){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		//iniciar tentativa de transação
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(entity);
			transacao.commit();
		}catch(RuntimeException erro){
			if (transacao != null){
				transacao.rollback();
			}
			//TODO colocar uma excecao específica para erro ao salvar
			throw erro;
		}finally{
			sessao.close();
		}
	}
	
	
	public void editar(Entity entity){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		//iniciar tentativa de transação
		try{
			transacao = sessao.beginTransaction();
			sessao.update(entity);
			transacao.commit();
		}catch(RuntimeException erro){
			if (transacao != null){
				transacao.rollback();
			}
			//TODO colocar uma excecao específica para erro ao salvar
			throw erro;
		}finally{
			sessao.close();
		}
	}
	
	public void merge(Entity entity){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		
		//iniciar tentativa de transação
		try{
			transacao = sessao.beginTransaction();
			sessao.merge(entity);
			transacao.commit();
		}catch(RuntimeException erro){
			if (transacao != null){
				transacao.rollback();
			}
			//TODO colocar uma excecao específica para erro ao salvar
			throw erro;
		}finally{
			sessao.close();
		}
	}
}
