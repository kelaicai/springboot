package com.improve.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity(name="deviceMaintenance")
public class DeviceMaintenance {

	public int getId() {
		return id;
	}


	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Id
	@GeneratedValue
	private int id;  //可作为记录Id
	
	@Column
	private String assetId;
	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	private String assetName;
	
	@Column
	private String maintenancer;
	
	public String getMaintenancer() {
		return maintenancer;
	}


	public void setMaintenancer(String maintenancer) {
		this.maintenancer = maintenancer;
	}

	@Column
	private String date;
	
	@Column
	private String content;
	
	@Column
	private String other;
}
