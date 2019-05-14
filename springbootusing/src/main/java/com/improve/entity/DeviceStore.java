package com.improve.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="deviceStore")
public class DeviceStore {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique=true)
	private String assetId;
	
	@Column
	private int count;
}
