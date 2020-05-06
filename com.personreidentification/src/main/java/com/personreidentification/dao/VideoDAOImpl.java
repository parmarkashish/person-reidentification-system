package com.personreidentification.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personreidentification.model.ComplainVO;
import com.personreidentification.model.DatasetVO;
import com.personreidentification.model.LoginVO;
import com.personreidentification.model.VideoVO;
import com.personreidentification.service.LoginService;
@Repository
public class VideoDAOImpl implements VideoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private LoginService loginService;

	@Override
	public void videoInsert(VideoVO videoVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(videoVO);	

	}

	@Override
	public List<VideoVO> videoSearch() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from VideoVO where video_status=1").list();
	}

	@Override
	public List<VideoVO> videoSearchByLoginVO(LoginVO loginVO) {
		Session session = this.sessionFactory.getCurrentSession();
		List<VideoVO> videoList=session.createQuery("from VideoVO where video_status=1 and loginVO.id="+loginVO.getLoginId()).list();
		return videoList;
		
	}
	
	@Override
	public VideoVO videoSearchById(VideoVO videoVO) {
		Session session = this.sessionFactory.getCurrentSession();
		List<VideoVO> videoList=session.createQuery("from VideoVO where video_status=1 and id="+videoVO.getId()).list();
		return videoList.get(0);
		
	}

	@Override
	public int getNumberOfVideos() {
		LoginVO loginVO=loginService.getLoginVOByUser();
		if(loginVO.getUsername().equals("admin@gmail.com")){
			return videoSearch().size();
		}
		else{
			return videoSearchByLoginVO(loginVO).size();
		}
		
	}

	
}
