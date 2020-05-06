package com.personreidentification.dao;

import java.util.List;
import com.personreidentification.model.PackageVO;

public interface PackageDAO {
	
	void packageInsert(PackageVO packageVO);
	List<PackageVO> packageSearch();
	PackageVO packageSearchById(PackageVO packageVO);
}
