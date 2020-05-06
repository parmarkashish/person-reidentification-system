package com.personreidentification.service;


import java.util.List;

import com.personreidentification.model.FeedbackVO;
import com.personreidentification.model.LoginVO;

public interface FeedbackService {
	
	void feedbackInsert(FeedbackVO feedbackVO);

	List<FeedbackVO> feedbackSearchByLoginVO(LoginVO loginVOByUser);
	
	List<FeedbackVO> feedbackSearch();

}
