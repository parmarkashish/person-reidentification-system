package com.personreidentification.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personreidentification.model.ComplainVO;
import com.personreidentification.model.CountryVO;
import com.personreidentification.model.LoginVO;
@Repository
public class ComplainDAOImpl implements ComplainDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void complainInsert(ComplainVO complainVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(complainVO);
	}

	@Override
	public List<ComplainVO> complainSearchByLoginVO(LoginVO loginVO) {
		Session session = this.sessionFactory.getCurrentSession();
		List<ComplainVO> complainList=session.createQuery("from ComplainVO where status=1 and loginVO.id="+loginVO.getLoginId()).list();
		return complainList;
		
	}

	@Override
	public List<ComplainVO> complainSearch() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ComplainVO> complainList=session.createQuery("from ComplainVO where status=1").list();
		return complainList;
	}
	
	@Override
	public ComplainVO complainSearchById(ComplainVO complainVO) {
		Session session = this.sessionFactory.getCurrentSession();
		List<ComplainVO> complainList=session.createQuery("from ComplainVO where status=1 and id="+complainVO.getId()).list();
		return complainList.get(0);
		
	}

}
