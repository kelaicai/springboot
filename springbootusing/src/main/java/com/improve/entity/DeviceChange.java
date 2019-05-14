package com.improve.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="deviceChange")
public class DeviceChange{

	@Id
	@GeneratedValue
	private int id;
	
	public int getId() {
		return id;
	}

	public void setRecordId(int id) {
		this.id = id;
	}

	@Column(unique=true)
	private String assetId;
	
	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	@Column
	private String assetName;
	
	@Column
	private String reason;
	
	@Column
	private String date;
	
	@Column
	private String proposer;
	
	@Column 
	private String oldPlace;
	@Column 
	private String newPlace;

	public String getOldPlace() {
		return oldPlace;
	}

	public void setOldPlace(String oldPlace) {
		this.oldPlace = oldPlace;
	}

	public String getNewPlace() {
		return newPlace;
	}

	public void setNewPlace(String newPlace) {
		this.newPlace = newPlace;
	}

	public void setId(int id) {
		this.id = id;
	}

}