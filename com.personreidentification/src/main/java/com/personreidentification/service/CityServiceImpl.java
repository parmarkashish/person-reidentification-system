package com.personreidentification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personreidentification.dao.CityDAO;
import com.personreidentification.model.CityVO;
import com.personreidentification.model.StateVO;

@Service
public class CityServiceImpl implements CityService {

	@Autowired 
	CityDAO cityDAO;
	
	@Override
	@Transactional
	public void cityInsert(CityVO cityVO) {
		cityDAO.cityInsert(cityVO);
	}

	@Override
	@Transactional
	public List<CityVO> citySearch() {		
		return cityDAO.citySearch();
	}

	@Override
	@Transactional
	public CityVO citySearchById(CityVO cityVO) {
		return cityDAO.citySearchById(cityVO);
	}

	@Override
	@Transactional
	public List<CityVO> citySearchByState(StateVO stateVO) {
		return cityDAO.citySearchByState(stateVO);
	}
}
