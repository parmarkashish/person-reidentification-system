package com.personreidentification.model;

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
@Table(name="complain_table")
public class ComplainVO {

	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="complain_subject")
	private String complainSubject;	

	@Column(name="complain_description")
	private String complainDescription;

	@Column(name="complain_status")
	private String complainStatus;
	
	@Column(name="complain_date")
	private String complainDate;
	
	@Column(name="reply")
	private String reply;
	
	@Column(name="reply_date")
	private String replyDate;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="s3link")
	private String s3link;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="login_id")
	private LoginVO loginVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComplainSubject() {
		return complainSubject;
	}

	public void setComplainSubject(String complainSubject) {
		this.complainSubject = complainSubject;
	}

	public String getComplainDescription() {
		return complainDescription;
	}

	public void setComplainDescription(String complainDescription) {
		this.complainDescription = complainDescription;
	}

	public String getComplainStatus() {
		return complainStatus;
	}

	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}

	public String getComplainDate() {
		return complainDate;
	}

	public void setComplainDate(String complainDate) {
		this.complainDate = complainDate;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getS3link() {
		return s3link;
	}

	public void setS3link(String s3link) {
		this.s3link = s3link;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
	

	
	
}
