package com.personreidentification.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="video_table")
public class VideoVO {
	
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="video_name")
	private String videoName;
		
	@Column(name="input_link")
	private String inputLink;
	
	@Column(name="output_link")
	private String outputLink;
	
	@Column(name="video_status")
	private boolean videoStatus;
	
	@Column(name="video_date")
	private Date videoDate;

	@Column(name="upload_date")
	private Date uploadDate;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="login_id")
	private LoginVO loginVO;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getInputLink() {
		return inputLink;
	}

	public void setInputLink(String inputLink) {
		this.inputLink = inputLink;
	}

	public String getOutputLink() {
		return outputLink;
	}

	public void setOutputLink(String outputLink) {
		this.outputLink = outputLink;
	}

	public boolean isVideoStatus() {
		return videoStatus;
	}

	public void setVideoStatus(boolean videoStatus) {
		this.videoStatus = videoStatus;
	}

	public Date getVideoDate() {
		return videoDate;
	}

	public void setVideoDate(Date videoDate) {
		this.videoDate = videoDate;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	
	
	
}
