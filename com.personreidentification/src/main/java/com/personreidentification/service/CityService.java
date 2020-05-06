package com.personreidentification.service;

import java.util.List;

import com.personreidentification.model.CityVO;
import com.personreidentification.model.StateVO;

public interface CityService {

	void cityInsert(CityVO cityVO);
	List<CityVO> citySearch();
	CityVO citySearchById(CityVO cityVO);
	List<CityVO> citySearchByState(StateVO stateVO);
}
