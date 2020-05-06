package com.personreidentification.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personreidentification.dao.RegisterDAO;
import com.personreidentification.model.RegisterVO;
@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	RegisterDAO registerDAO;

	@Override
	@Transactional
	public void registerInsert(RegisterVO registerVO) {
		registerDAO.registerInsert(registerVO);

	}
	

}
