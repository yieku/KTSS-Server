package cn.cqu.knowplants.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cqu.knowplants.domain.PictureBean;

@Service
@Transactional
public class ExpertService extends BaseService {
	
	//得到所有已识别的图片
	 public ArrayList getAllrecognizedPicture() {
		  return picDao.getAllrecognizedPicture();
	  }
	
	 //得到所有未识别的图片
	  public ArrayList getAllUnrecognizedPicture() {
		  return picDao.getAllUnrecognizedPicture();
	  }
	  
	  //更新图片状态
	  public void updatePicture(int pictureID,String plantName,String byWho,String accuracyRate)
	  {
		  PictureBean pic = picDao.get(pictureID);
		  if(pic!=null)
		  {
			  pic.setPlantName(plantName);
			  pic.setRecognizedBy(byWho);
			  pic.setAccuracyRate(accuracyRate);
			  picDao.update(pic);
		  }
	  }
	  
	  

}
