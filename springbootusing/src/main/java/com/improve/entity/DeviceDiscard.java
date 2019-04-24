package com.improve.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="deviceDiscard")
public class DeviceDiscard {

		@Id
		@GeneratedValue
		private int id;
		
		@Column
		private String assetId;
		
		
		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getAssetName() {
			return assetName;
		}

		public void setAssetName(String assetName) {
			this.assetName = assetName;
		}

		public String getPetitioner() {
			return petitioner;
		}

		public void setPetitioner(String petitioner) {
			this.petitioner = petitioner;
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

		@Column
		private String assetName;
		
		@Column  //申报人
		private String petitioner;
		
		@Column
		private String reason;
		
		@Column
		private String date;


		
}
