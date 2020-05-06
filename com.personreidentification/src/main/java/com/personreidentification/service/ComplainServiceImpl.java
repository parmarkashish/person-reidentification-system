package com.personreidentification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personreidentification.dao.ComplainDAO;
import com.personreidentification.model.ComplainVO;
import com.personreidentification.model.LoginVO;
@Service
public class ComplainServiceImpl implements ComplainService {
	
	@Autowired
	ComplainDAO complainDAO;

	@Override
	@Transactional
	public void complainInsert(ComplainVO complainVO) {
		complainDAO.complainInsert(complainVO);
	}

	@Override
	@Transactional
	public List<ComplainVO> complainSearchByLoginVO(LoginVO loginVO) {
		return complainDAO.complainSearchByLoginVO(loginVO);
	}

	@Override
	@Transactional
	public List<ComplainVO> complainSearch() {
		
		return complainDAO.complainSearch();
	}

	@Override
	@Transactional
	public ComplainVO complainSearchById(ComplainVO complainVO) {
		
		return complainDAO.complainSearchById(complainVO);
	}

}
