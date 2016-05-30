package cn.cqu.knowplants.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expert")
public class ExpertBean {
	
	@Id
	@Column(length=20)
	private String expertID;   //专家用户名
	@Column(length=20)
	private String expertPassword;   //密码
	
	@Column(length=20)
	private String expertPhoneNumber;  //手机号码
	
	@Column(length=20)
	private String adminID;   //管理员id，记录批准该用户成为专家的管理员id
	
	public String getExpertID() {
		return expertID;
	}
	public void setExpertID(String expertID) {
		this.expertID = expertID;
	}
	
	public String getExpertPassword() {
		return expertPassword;
	}
	public void setExpertPassword(String expertPassword) {
		this.expertPassword = expertPassword;
	}
	
	public String getExpertPhoneNumber() {
		return expertPhoneNumber;
	}
	public void setExpertPhoneNumber(String expertPhoneNumber) {
		this.expertPhoneNumber = expertPhoneNumber;
	}
	
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	

}
