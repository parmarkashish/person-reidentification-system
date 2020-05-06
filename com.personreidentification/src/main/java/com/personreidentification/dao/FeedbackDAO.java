package com.personreidentification.dao;

import java.util.List;

import com.personreidentification.model.FeedbackVO;
import com.personreidentification.model.LoginVO;

public interface FeedbackDAO {
	
	void feedbackInsert(FeedbackVO feedbackVO);

	List<FeedbackVO> feedbackSearchByLoginVO(LoginVO loginVO);

	List<FeedbackVO> feedbackSearch();

}
