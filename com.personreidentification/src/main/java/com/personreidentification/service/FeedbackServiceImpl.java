package com.personreidentification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personreidentification.dao.FeedbackDAO;
import com.personreidentification.dao.LoginDAO;
import com.personreidentification.model.FeedbackVO;
import com.personreidentification.model.LoginVO;
@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	FeedbackDAO feedbackDAO;

	@Override
	@Transactional
	public void feedbackInsert(FeedbackVO feedbackVO) {
		feedbackDAO.feedbackInsert(feedbackVO);		
	}

	@Override
	@Transactional
	public List<FeedbackVO> feedbackSearchByLoginVO(LoginVO loginVO) {
		return feedbackDAO.feedbackSearchByLoginVO(loginVO);
	}

	@Override
	@Transactional
	public List<FeedbackVO> feedbackSearch() {
		return feedbackDAO.feedbackSearch();
	}

}
