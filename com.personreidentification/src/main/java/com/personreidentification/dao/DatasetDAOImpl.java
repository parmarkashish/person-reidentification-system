package com.personreidentification.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personreidentification.model.CountryVO;
import com.personreidentification.model.DatasetVO;

@Repository
public class DatasetDAOImpl implements DatasetDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void datasetInsert(DatasetVO datasetVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(datasetVO);		
	}

	@Override
	public List<DatasetVO> datasetSearch() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from DatasetVO where dataset_status=1").list();
	}

	@Override
	public DatasetVO datasetSearchById(DatasetVO datasetVO) {
		Session session = this.sessionFactory.getCurrentSession();
		List<DatasetVO> datasetList=session.createQuery("from DatasetVO where dataset_status=1 and id="+datasetVO.getId()).list();
		return datasetList.get(0);
	}

}
