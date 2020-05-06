package com.personreidentification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personreidentification.dao.CountryDAO;
import com.personreidentification.model.CountryVO;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired 
	CountryDAO countryDAO;
	
	@Override
	@Transactional
	public void countryInsert(CountryVO countryVO) {		
		countryDAO.countryInsert(countryVO);
	}

	@Override
	@Transactional
	public List<CountryVO> countrySearch() {		
		return countryDAO.countrySearch();
	}

	@Override
	@Transactional
	public CountryVO countrySearchById(CountryVO countryVO) {
		return countryDAO.countrySearchById(countryVO);
	}
}
