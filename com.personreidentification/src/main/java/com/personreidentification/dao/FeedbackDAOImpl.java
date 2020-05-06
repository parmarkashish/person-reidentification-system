package com.personreidentification.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personreidentification.model.ComplainVO;
import com.personreidentification.model.FeedbackVO;
import com.personreidentification.model.LoginVO;
@Repository
public class FeedbackDAOImpl implements FeedbackDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void feedbackInsert(FeedbackVO feedbackVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(feedbackVO);	

	}

	@Override
	public List<FeedbackVO> feedbackSearchByLoginVO(LoginVO loginVO) {
		Session session = this.sessionFactory.getCurrentSession();
		List<FeedbackVO> feedbackList=session.createQuery("from FeedbackVO where status=1 and loginVO.id="+loginVO.getLoginId()).list();
		return feedbackList;
	}
	
	@Override
	public List<FeedbackVO> feedbackSearch() {
		Session session = this.sessionFactory.getCurrentSession();
		List<FeedbackVO> feedbackList=session.createQuery("from FeedbackVO where status=1").list();
		return feedbackList;
	}
	

}
