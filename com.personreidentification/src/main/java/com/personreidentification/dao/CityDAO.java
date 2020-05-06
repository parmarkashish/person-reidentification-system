package com.personreidentification.dao;

import java.util.List;

import com.personreidentification.model.CityVO;
import com.personreidentification.model.StateVO;

public interface CityDAO {
	
	void cityInsert(CityVO cityVO);
	List<CityVO> citySearch();
	CityVO citySearchById(CityVO cityVO);
	List<CityVO> citySearchByState(StateVO stateVO);

}