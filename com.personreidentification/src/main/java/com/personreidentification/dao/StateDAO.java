package com.personreidentification.dao;

import java.util.List;

import com.personreidentification.model.CountryVO;
import com.personreidentification.model.StateVO;

public interface StateDAO {
	
	void stateInsert(StateVO stateVO);
	List<StateVO> stateSearch();
	StateVO stateSearchById(StateVO stateVO);
	List<StateVO> stateSearchByCountry(CountryVO countryVO);
	
}
