package com.personreidentification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personreidentification.dao.VideoDAO;
import com.personreidentification.model.LoginVO;
import com.personreidentification.model.VideoVO;
@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoDAO videoDAO;

	@Override
	@Transactional
	public void videoInsert(VideoVO videoVO) {
		videoDAO.videoInsert(videoVO);

	}

	@Override
	@Transactional
	public List<VideoVO> videoSearch() {
		return videoDAO.videoSearch();
	}

	@Override
	@Transactional
	public List<VideoVO> videoSearchByLoginVO(LoginVO loginVO){
		return videoDAO.videoSearchByLoginVO(loginVO);
	}
	
	@Override
	@Transactional
	public VideoVO videoSearchById(VideoVO videoVO){
		return videoDAO.videoSearchById(videoVO);
	}

	@Override
	@Transactional
	public int getNumberOfVideos() {
		return videoDAO.getNumberOfVideos();
	}


}
