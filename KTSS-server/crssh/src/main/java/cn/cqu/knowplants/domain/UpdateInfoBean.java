package cn.cqu.knowplants.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//用于非实时消息提醒
@Entity
@Table(name = "updateInfo")
public class UpdateInfoBean {
	
	@Id
	@Column(length=20)
	private String farmID;    //设置农民用户名

	public String getFarmID() {
		return farmID;
	}

	public void setFarmID(String farmID) {
		this.farmID = farmID;
	}
	
	
	
	
	
	

}
