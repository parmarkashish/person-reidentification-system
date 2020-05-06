package com.personreidentification.service;

import java.util.List;

import com.personreidentification.model.ComplainVO;
import com.personreidentification.model.LoginVO;


public interface ComplainService {
	void complainInsert(ComplainVO complainVO);
	List<ComplainVO> complainSearchByLoginVO(LoginVO loginVO);
	List<ComplainVO> complainSearch();
	ComplainVO complainSearchById(ComplainVO complainVO);
}
