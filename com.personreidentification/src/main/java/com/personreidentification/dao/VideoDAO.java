package com.personreidentification.dao;

import java.util.List;

import com.personreidentification.model.LoginVO;
import com.personreidentification.model.VideoVO;

public interface VideoDAO {
	void videoInsert(VideoVO videoVO);
	List<VideoVO> videoSearch();
	public List<VideoVO> videoSearchByLoginVO(LoginVO loginVO);
	public VideoVO videoSearchById(VideoVO videoVO);
	int getNumberOfVideos();
}
