package com.personreidentification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personreidentification.dao.DatasetDAO;
import com.personreidentification.model.DatasetVO;
@Service
public class DatasetServiceImpl implements DatasetService {
	
	@Autowired
	private DatasetDAO datasetDAO;

	@Override
	@Transactional
	public void datasetInsert(DatasetVO datasetVO) {
		datasetDAO.datasetInsert(datasetVO);

	}

	@Override
	@Transactional
	public List<DatasetVO> datasetSearch() {
		
		return datasetDAO.datasetSearch();
	}

	@Override
	@Transactional
	public DatasetVO datasetSearchById(DatasetVO datasetVO) {
		
		return datasetDAO.datasetSearchById(datasetVO);
	}

}
