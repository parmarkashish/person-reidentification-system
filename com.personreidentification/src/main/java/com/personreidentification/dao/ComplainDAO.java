package com.personreidentification.dao;

import java.util.List;

import com.personreidentification.model.ComplainVO;
import com.personreidentification.model.LoginVO;

public interface ComplainDAO {

	void complainInsert(ComplainVO complainVO);
	List<ComplainVO> complainSearchByLoginVO(LoginVO loginVO);
	List<ComplainVO> complainSearch();
	ComplainVO complainSearchById(ComplainVO complainVO);

}
