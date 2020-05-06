package com.personreidentification.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.personreidentification.model.CountryVO;
import com.personreidentification.model.LoginVO;
@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public void loginInsert(LoginVO loginVO) {
		Session session = this.sessionFactory.getCurrentSession();	
		session.saveOrUpdate(loginVO);

	}

	@Override
	public LoginVO getLoginVOByUser() {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<LoginVO> loginList=session.createQuery("from LoginVO where status=1 and username='"+user.getUsername()+"'").list();
		return loginList.get(0);
	}
	
	@Override
	public List<LoginVO> getLoginVO() {
		Session session = this.sessionFactory.getCurrentSession();
		List<LoginVO> loginList=session.createQuery("from LoginVO where status=1").list();
		return loginList;
	}

}
