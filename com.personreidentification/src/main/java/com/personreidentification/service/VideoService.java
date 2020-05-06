package com.personreidentification.service;

import java.util.List;

import com.personreidentification.model.LoginVO;
import com.personreidentification.model.VideoVO;

public interface VideoService {
	
	void videoInsert(VideoVO videoVO);
	List<VideoVO> videoSearch();
	List<VideoVO> videoSearchByLoginVO(LoginVO loginVO);
	VideoVO videoSearchById(VideoVO videoVO);
	int getNumberOfVideos();
}
