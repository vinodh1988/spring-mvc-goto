package com.model;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonDAO {
@Autowired
SessionFactory sessionFactory;
	public List<Person> getPeople(){
		return sessionFactory.getCurrentSession().createQuery("from Person").list();
	}
	
	public boolean addPerson(Person person){
		try{
			sessionFactory.getCurrentSession().save(person);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
