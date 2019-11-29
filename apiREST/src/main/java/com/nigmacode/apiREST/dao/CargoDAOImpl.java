package com.nigmacode.apiREST.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.nigmacode.apiREST.entity.cargo;;

@Repository
public class CargoDAOImpl implements CargoDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<cargo> findAll(){
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<cargo> theQuery = currentSession.createQuery("from User", cargo.class);
		List<cargo> users = theQuery.getResultList();
		
		return users;
	}
	
	@Override
	public cargo findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		cargo Cargo = currentSession.get(cargo.class, id);
		
		return Cargo;
	}
	
	@Modifying
	@Transactional
	@Override
	public void save(cargo Cargo) {
		try {
			Session curretSession = entityManager.unwrap(Session.class);
			curretSession.saveOrUpdate(Cargo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Modifying
	@Transactional
	@Override
	public void deleteById(int idCargo) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<cargo> theQuery = currentSession.createQuery("delete from cargo where ID_CARGO=:idCargo");
		
		theQuery.setParameter("idCargo", idCargo);
		theQuery.executeUpdate();
	}
}
