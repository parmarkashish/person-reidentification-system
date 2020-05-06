package com.personreidentification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.personreidentification.dao.LoginDAO;
import com.personreidentification.model.LoginVO;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDAO loginDAO;

	@Override
	@Transactional
	public void loginInsert(LoginVO loginVO) {
		loginDAO.loginInsert(loginVO);		
	}

	@Override
	@Transactional
	public LoginVO getLoginVOByUser() {
		return loginDAO.getLoginVOByUser();
	}

	@Override
	@Transactional
	public List<LoginVO> getLoginVO() {
		return loginDAO.getLoginVO();
		
	}

}
