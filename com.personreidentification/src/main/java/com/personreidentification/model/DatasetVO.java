package com.personreidentification.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dataset_table")
public class DatasetVO {
	
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="dataset_name")
	private String datasetName;
	
	@Column(name="dataset_description")
	private String datasetDescription;
	
	@Column(name="s3link")
	private String s3link;
	
	@Column(name="dataset_status")
	private boolean datasetStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getDatasetName() {
		return datasetName;
	}

	public void setDatasetName(String datasetName) {
		this.datasetName = datasetName;
	}

	public String getDatasetDescription() {
		return datasetDescription;
	}

	public void setDatasetDescription(String datasetDescription) {
		this.datasetDescription = datasetDescription;
	}

	public String getS3link() {
		return s3link;
	}

	public void setS3link(String s3link) {
		this.s3link = s3link;
	}

	public boolean isDatasetStatus() {
		return datasetStatus;
	}

	public void setDatasetStatus(boolean datasetStatus) {
		this.datasetStatus = datasetStatus;
	}
	
	
}
