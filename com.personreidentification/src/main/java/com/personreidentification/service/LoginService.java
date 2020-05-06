package com.personreidentification.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.personreidentification.model.LoginVO;

public interface LoginService {
	
	void loginInsert(LoginVO loginVO);
	LoginVO getLoginVOByUser();
	List<LoginVO> getLoginVO();
}
