package com.personreidentification.service;

import java.util.List;


import com.personreidentification.model.DatasetVO;

public interface DatasetService {
	
	void datasetInsert(DatasetVO datasetVO);
	List<DatasetVO> datasetSearch();
	DatasetVO datasetSearchById(DatasetVO datasetVO);

}
