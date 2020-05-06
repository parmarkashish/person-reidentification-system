package com.personreidentification.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personreidentification.dao.PackageDAO;
import com.personreidentification.model.PackageVO;
@Service
public class PackageServiceImpl implements PackageService {
	@Autowired
	PackageDAO packagesDAO;
	

	@Override
	@Transactional
	public void packageInsert(PackageVO packageVO) {
		packagesDAO.packageInsert(packageVO);
	}

	@Override
	@Transactional
	public List<PackageVO> packageSearch() {
		return packagesDAO.packageSearch();
	}

	@Override
	@Transactional
	public PackageVO packageSearchById(PackageVO packageVO) {
		return packagesDAO.packageSearchById(packageVO);
	}

}
