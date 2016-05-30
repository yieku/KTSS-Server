package cn.cqu.knowplants.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farm")
public class FarmBean {
	@Id
	@Column(length=20)
	private String farmID;    //设置农民用户名
	
	@Column(length=20)
	private String farmPassword;   //设置密码
	
	@Column(length=20)
	private String farmPhoneNumber;  //手机号码
	
	public String getFarmID() {
		return farmID;
	}
	public void setFarmID(String farmID) {
		this.farmID = farmID;
	}
	
	public String getFarmPassword() {
		return farmPassword;
	}
	public void setFarmPassword(String farmPassword) {
		this.farmPassword = farmPassword;
	}
	
	public String getFarmPhoneNumber() {
		return farmPhoneNumber;
	}
	public void setFarmPhoneNumber(String farmPhoneNumber) {
		this.farmPhoneNumber = farmPhoneNumber;
	}
	
}
