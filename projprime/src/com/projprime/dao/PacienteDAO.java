package com.projprime.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.projprime.modelo.Paciente;

@Stateless
public class PacienteDAO {	
	
	
	@PersistenceContext
	EntityManager entity;

	
	@PostConstruct
	void contruindo(){
		System.out.println("Construiu Dao");
	}

	public Paciente getId(Integer id){
		/*TypedQuery<Paciente> paciente = entity.createQuery("Select p from Paciente p where p.id = ?", Paciente.class);
		paciente.setParameter("id", id);
		return paciente.getSingleResult();*/
		return entity.find(Paciente.class, id);
	}
	
	public void salvar(Paciente paciente){
		entity.persist(paciente);
	}
	@Produces
	public List<Paciente> getLista() {	
		List<Paciente> lista = entity.createQuery("select p from Paciente p",Paciente.class ).getResultList() ;
		return lista;
	}

	
	
	

}
