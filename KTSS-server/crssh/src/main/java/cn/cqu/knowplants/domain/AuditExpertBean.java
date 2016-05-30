package cn.cqu.knowplants.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditExpert")
public class AuditExpertBean {
	
	@Id
	@Column(length=20)
	private String auditExpertID;   //待审核专家用户名
	
	@Column(length=20)
	private String auditExpertPassword;  //待审核专家登陆密码
	
	@Column(length=20)
	private String auditExpertPhone;    //待审核专家电话号码
	
	@Column(length=400)
	private String auditExpertMaterial;  //待审核专家材料，用于证明其是否有资格成为专家
	
	public String getAuditExpertID() {
		return auditExpertID;
	}
	public void setAuditExpertID(String auditExpertID) {
		this.auditExpertID = auditExpertID;
	}
	
	
	public String getAuditExpertPassword() {
		return auditExpertPassword;
	}
	public void setAuditExpertPassword(String auditExpertPassword) {
		this.auditExpertPassword = auditExpertPassword;
	}
	
	
	public String getAuditExpertPhone() {
		return auditExpertPhone;
	}
	public void setAuditExpertPhone(String auditExpertPhone) {
		this.auditExpertPhone = auditExpertPhone;
	}
	
	
	public String getAuditExpertMaterial() {
		return auditExpertMaterial;
	}
	public void setAuditExpertMaterial(String auditExpertMaterial) {
		this.auditExpertMaterial = auditExpertMaterial;
	}
	
	
	

}
