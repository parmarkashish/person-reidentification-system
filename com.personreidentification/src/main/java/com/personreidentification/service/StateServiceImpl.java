package com.personreidentification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personreidentification.dao.StateDAO;
import com.personreidentification.model.CountryVO;
import com.personreidentification.model.StateVO;

@Service
public class StateServiceImpl implements StateService {
	
	@Autowired 
	StateDAO stateDAO;	

	@Override
	@Transactional
	public void stateInsert(StateVO stateVO) {
		stateDAO.stateInsert(stateVO);
	}

	@Override
	@Transactional
	public List<StateVO> stateSearch() {
		return stateDAO.stateSearch();
	}

	@Override
	@Transactional
	public StateVO stateSearchById(StateVO stateVO) {
		return stateDAO.stateSearchById(stateVO);
	}

	@Override
	@Transactional
	public List<StateVO> stateSearchByCountry(CountryVO countryVO) {
		return stateDAO.stateSearchByCountry(countryVO);
	}	
}
