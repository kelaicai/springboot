package com.improve.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="verify")
public class Verify {

		@Id
		@GeneratedValue
		private int id;
		
		@Column(unique=true)
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
		
		@Column
		private String isVerified="false"; //申请是否通过
		
		@Column
		private String prograss="begin"; //进度  提交，审核中，成功/失败


		public String getIsVerified() {
			return isVerified;
		}

		public void setIsVerified(String isVerified) {
			this.isVerified = isVerified;
		}

		public String getPrograss() {
			return prograss;
		}

		public void setPrograss(String prograss) {
			this.prograss = prograss;
		}


		
}
