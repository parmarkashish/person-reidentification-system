package com.personreidentification.dao;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.personreidentification.model.LoginVO;

public interface LoginDAO {

	void loginInsert(LoginVO loginVO);
	LoginVO getLoginVOByUser();
	List<LoginVO> getLoginVO();
}
