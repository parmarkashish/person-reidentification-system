package com.personreidentification.service;

import java.util.List;
import com.personreidentification.model.PackageVO;

public interface PackageService {
	
	void packageInsert(PackageVO packageVO);
	List<PackageVO> packageSearch();
	PackageVO packageSearchById(PackageVO packageVO);
}
