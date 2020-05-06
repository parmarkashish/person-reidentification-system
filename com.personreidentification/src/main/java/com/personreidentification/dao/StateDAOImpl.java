package com.personreidentification.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personreidentification.model.CountryVO;
import com.personreidentification.model.StateVO;

@Repository
public class StateDAOImpl implements StateDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void stateInsert(StateVO stateVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(stateVO);
	}

	@Override
	public List<StateVO> stateSearch() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from StateVO where stateStatus=1").list();		
	}

	@Override
	public StateVO stateSearchById(StateVO stateVO) {
		Session session = this.sessionFactory.getCurrentSession();
		List<StateVO> stateList=session.createQuery("from StateVO where state_status=1 and id="+stateVO.getId()).list();		
		return stateList.get(0);
	}

	@Override
	public List<StateVO> stateSearchByCountry(CountryVO countryVO) {
		Session session = this.sessionFactory.getCurrentSession();
		List<StateVO> stateList=session.createQuery("from StateVO where state_status=1 and countryVO.id="+countryVO.getId()).list();		
		return stateList;
	}
}
