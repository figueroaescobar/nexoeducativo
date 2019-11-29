package com.nigmacode.apiREST.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.nigmacode.apiREST.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<User> findAll(){
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		List<User> users = theQuery.getResultList();
		
		return users;
	}
	
	@Override
	public User findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		User user = currentSession.get(User.class, id);
		
		return user;
	}
	
	@Modifying
	@Transactional
	@Override
	public void save(User user) {
		Session curretSession = entityManager.unwrap(Session.class);
		curretSession.saveOrUpdate(user);
	}
	
	@SuppressWarnings("unchecked")
	@Modifying
	@Transactional
	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> theQuery = currentSession.createQuery("delete from User where id=:idUser");
		
		theQuery.setParameter("idUser", id);
		theQuery.executeUpdate();
	}
}
