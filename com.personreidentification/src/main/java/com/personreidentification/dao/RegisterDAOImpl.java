package com.personreidentification.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.personreidentification.model.LoginVO;
import com.personreidentification.model.RegisterVO;
@Repository
public class RegisterDAOImpl implements RegisterDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	@Autowired
	private LoginDAO loginDAO;


	@Override
	public void registerInsert(RegisterVO registerVO) {

		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(registerVO);

	}


	

}
