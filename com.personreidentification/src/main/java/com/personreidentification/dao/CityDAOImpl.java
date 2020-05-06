package com.personreidentification.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personreidentification.model.CityVO;
import com.personreidentification.model.StateVO;

@Repository
public class CityDAOImpl implements CityDAO {

	@Autowired
	private SessionFactory sessionFactory;	

	@Override
	public void cityInsert(CityVO cityVO) {
		Session session = this.sessionFactory.getCurrentSession();	
		session.saveOrUpdate(cityVO);
	}

	@Override
	public List<CityVO> citySearch() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from CityVO where city_status=1").list();		
	}

	@Override
	public CityVO citySearchById(CityVO cityVO) {
		Session session = this.sessionFactory.getCurrentSession();
		List<CityVO> cityList=session.createQuery("from CityVO where city_status=1 and id="+cityVO.getId()).list();
		return cityList.get(0);
	}

	@Override
	public List<CityVO> citySearchByState(StateVO stateVO) {
		Session session = this.sessionFactory.getCurrentSession();
		List<CityVO> cityList=session.createQuery("from CityVO where city_status=1 and stateVO.id="+stateVO.getId()).list();
		return cityList;
	}
}
