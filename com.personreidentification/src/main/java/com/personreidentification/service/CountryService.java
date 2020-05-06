package com.personreidentification.service;

import java.util.List;

import com.personreidentification.model.CountryVO;

public interface CountryService {
	
	void countryInsert(CountryVO countryVO);
	List<CountryVO> countrySearch();
	CountryVO countrySearchById(CountryVO countryVO);
}
