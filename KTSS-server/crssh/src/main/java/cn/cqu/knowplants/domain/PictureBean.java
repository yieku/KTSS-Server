package cn.cqu.knowplants.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "picture")
public class PictureBean {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int pictureID;  //记录图片的id
	
	
 
	@Column(length=20)
	private String farmID;    //用于记录该图片属于哪个农民的
	
	@Column(length=50)
	private String pictureURL;    //用于记录图片的地址
	
	@Column(length=50)
	private String pictureTime;    //用于记录图片的上传时间，根据时间的先后进行显示在屏幕上
	
	@Column(length=50,nullable=true)
	private String plantName;  //null 表示不确定
	
	
	@Column(length=20,nullable=true)
	private String recognizedBy;  //用来表示是被专家识别的还是程序识别的,如果两者都不是那就为null
	
	@Column(length=20,nullable=true)  //用来表示准确率，可以为NULL，表示识别不了
	private String accuracyRate;
   
	
    
    
	public String getAccuracyRate() {
		return accuracyRate;
	}
	public void setAccuracyRate(String accuracyRate) {
		this.accuracyRate = accuracyRate;
	}
	public int getPictureID() {
		return pictureID;
	}
	public void setPictureID(int pictureID) {
		this.pictureID = pictureID;
	}
	
	
	public String getFarmID() {
		return farmID;
	}
	public void setFarmID(String farmID) {
		this.farmID = farmID;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	public String getPictureTime() {
		return pictureTime;
	}
	
	
	public void setPictureTime(String pictureTime) {
		this.pictureTime = pictureTime;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getRecognizedBy() {
		return recognizedBy;
	}
	public void setRecognizedBy(String recognizedBy) {
		this.recognizedBy= recognizedBy;
	}
    
    
}
