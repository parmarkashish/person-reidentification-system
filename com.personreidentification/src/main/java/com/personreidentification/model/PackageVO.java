package com.personreidentification.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="package_table")
public class PackageVO {
	
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="package_name")
	private String packageName;
	
	@Column(name="package_price")
	private int packagePrice;
	
	@Column(name="package_duartion")
	private int packageDuration;	
	
	@Column(name="package_description")
	private String packageDescription;
	
	@Column(name="package_status")
	private boolean packageStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public int getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(int packagePrice) {
		this.packagePrice = packagePrice;
	}

	public int getPackageDuration() {
		return packageDuration;
	}

	public void setPackageDuration(int packageDuration) {
		this.packageDuration = packageDuration;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public boolean isPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(boolean packageStatus) {
		this.packageStatus = packageStatus;
	}

}
