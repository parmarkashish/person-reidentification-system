package com.personreidentification.dao;

import java.util.List;

import com.personreidentification.model.CountryVO;

public interface CountryDAO {
	
	void countryInsert(CountryVO countryVO);
	List<CountryVO> countrySearch();
	CountryVO countrySearchById(CountryVO countryVO);
}
