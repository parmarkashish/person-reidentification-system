package com.personreidentification.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personreidentification.model.CountryVO;

@Repository
public class CountryDAOImpl implements CountryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void countryInsert(CountryVO countryVO) {		
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(countryVO);
	}

	@Override
	public List<CountryVO> countrySearch() {		
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from CountryVO where country_status=1").list();		
	}

	@Override
	public CountryVO countrySearchById(CountryVO countryVo) {		
		Session session = this.sessionFactory.getCurrentSession();
		List<CountryVO> countryList=session.createQuery("from CountryVO where country_status=1 and id="+countryVo.getId()).list();
		return countryList.get(0);
	}
}
