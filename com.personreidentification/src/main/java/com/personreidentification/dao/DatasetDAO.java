package com.personreidentification.dao;

import java.util.List;

import com.personreidentification.model.DatasetVO;

public interface DatasetDAO {
	void datasetInsert(DatasetVO datasetVO);
	List<DatasetVO> datasetSearch();
	DatasetVO datasetSearchById(DatasetVO datasetVO);


}
