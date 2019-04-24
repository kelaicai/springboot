package com.improve.entity;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.mysql.cj.xdevapi.Result;

@Entity(name="deviceEntity")
public class Device {
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String assetId;
	@Column
	private String gbClass;
	@Column
	private String gbBigClass;
	@Column
	private String assetClass;
	@Column
	private String assetBigClass;
	@Column
	private String assetName;
	@Column
	private int count;
	@Column
	private String area;
	@Column
	private String eduUsing;
	@Column
	private String valueType;
	@Column
	private String fianceType;
	@Column
	private String getMethod;
	@Column
	private String getDate;
	@Column
	private String usingDepartment;
	@Column
	private String typeSpecification;
	@Column
	private String user;
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString()
	{
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("asset_id",this.assetId);
		result.put("gb_class", this.gbClass);
		result.put("gb_big_class",this.gbBigClass);
		result.put("asset_class",this.assetClass);
		result.put("asset_big_class",this.assetBigClass);
		result.put("asset_name",this.assetName);
		result.put("count",this.count);
		result.put("area",this.area);
		result.put("value_type",this.valueType);
		result.put("edu_using",this.eduUsing);
		result.put("finace_date",this.fianceType);
		result.put("get_date",this.getDate);
		result.put("get_method",this.getMethod);
		result.put("using_department",this.usingDepartment);
		result.put("type_specification",this.typeSpecification);
		return result.toString();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssetsId() {
		return assetId;
	}

	public void setAssetsId(String assetId) {
		this.assetId = assetId;
	}

	public String getGbClass() {
		return gbClass;
	}

	public void setGbClass(String gbClass) {
		this.gbClass = gbClass;
	}

	public String getGbBigClass() {
		return gbBigClass;
	}

	public void setGbBigClass(String gbBigClass) {
		this.gbBigClass = gbBigClass;
	}

	public String getAssetsClass() {
		return assetClass;
	}

	public void setAssetsClass(String assetClass) {
		this.assetClass = assetClass;
	}

	public String getAssetsBigClass() {
		return assetBigClass;
	}

	public void setAssetsBigClass(String assetBigClass) {
		this.assetBigClass = assetBigClass;
	}

	public String getAssetsName() {
		return assetName;
	}

	public void setAssetsName(String assetName) {
		this.assetName = assetName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEduUsing() {
		return eduUsing;
	}

	public void setEduUsing(String eduUsing) {
		this.eduUsing = eduUsing;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getFianceType() {
		return fianceType;
	}

	public void setFianceType(String fianceType) {
		this.fianceType = fianceType;
	}

	public String getGetMethod() {
		return getMethod;
	}

	public void setGetMethod(String getMethod) {
		this.getMethod = getMethod;
	}

	public String getGetDate() {
		return getDate;
	}

	public void setGetDate(String getDate) {
		this.getDate = getDate;
	}

	public String getUsingDepartment() {
		return usingDepartment;
	}

	public void setUsingDepartment(String usingDepartment) {
		this.usingDepartment = usingDepartment;
	}

	public String getTypeSpecification() {
		return typeSpecification;
	}

	public void setTypeSpecification(String typeSpecification) {
		this.typeSpecification = typeSpecification;
	}



	
}
