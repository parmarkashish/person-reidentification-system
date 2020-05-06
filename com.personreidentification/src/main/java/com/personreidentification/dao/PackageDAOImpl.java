package com.personreidentification.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personreidentification.model.PackageVO;
@Repository
public class PackageDAOImpl implements PackageDAO {
	@Autowired
	private SessionFactory sessionFactory;	

	@Override
	public void packageInsert(PackageVO packageVO) {
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(packageVO);
	}

	@Override
	public List<PackageVO> packageSearch() {
		Session session=this.sessionFactory.getCurrentSession();
		return session.createQuery("from PackageVO where package_status=1").list();
	}

	@Override
	public PackageVO packageSearchById(PackageVO packageVO) {
		Session session=this.sessionFactory.getCurrentSession();
		List<PackageVO> packageList=session.createQuery("from PackageVO where package_status=1 and id="+packageVO.getId()).list();
		return packageList.get(0);
	}

}
