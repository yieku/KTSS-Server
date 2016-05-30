package cn.cqu.knowplants.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cqu.knowplants.domain.AdminBean;
import cn.cqu.knowplants.domain.AuditExpertBean;
import cn.cqu.knowplants.domain.ExpertBean;
import cn.cqu.knowplants.domain.FarmBean;
import cn.cqu.knowplants.domain.PictureBean;
import cn.cqu.knowplants.domain.UpdateInfoBean;

@Service
@Transactional
public class AdminService extends BaseService {
	
	//获取adminID
	 public AdminBean getAdminID(String adminID)
	 {
		 return adminDao.get(adminID);
	 }
	
	 //通过pictureID删除图片
	  public void  deletePictureByID(int pictureID)
	  {
		   picDao.deleteByID(pictureID);
	  }
	  
	  //得到所有已识别的图片
	  public ArrayList getAllrecognizedPicture() {
		  return picDao.getAllrecognizedPicture();
	  }
	
	  //得到所有未识别的图片
	  public ArrayList getAllUnrecognizedPicture() {
		  return picDao.getAllUnrecognizedPicture();
	  }
	  
	  //获取所有普通用户
	  public List<FarmBean> getAllFarms()
	  {
		  return farmDao.getAll();
	  }
	  
	  //获取所有专家
	  public List<ExpertBean> getAllExperts()
	  {
		  return expDao.getAll();
	  }
	  
	  //获取所有待审核专家
	  public List<AuditExpertBean> getAllAuditExperts()
	  {
		  return audtExpDao.getAll();
	  }
	  
	  //根据farmID获取相应的信息
	  public FarmBean getFarmId(String username)
	  {
		  return farmDao.get(username);
	  }
	  
	  //处理登陆
	  public boolean login(String username,String password,String var)
	  {
		  //处理农民登陆
		  if(var.equals("1"))
		  {
			  FarmBean farm=farmDao.get(username);
			  if(farm!=null)
			  {
				  if(farm.getFarmPassword().equals(password))
				  {
					  return true;
				  }
				  else
				  {
					  return false;
				  }
			  }
			  else
			  {
				  return false;
			  }
			  
		  }
		  
		  //处理专家登陆
		  else if(var.equals("2"))
		  {
			  ExpertBean expert=expDao.get(username);
			  if(expert!=null)
			  {
				  if(expert.getExpertPassword().equals(password))
				  {
					  return true;
				  }
				  else
				  {
					  return false;
				  }
			  }
			  else
			  {
				  return false;
			  }
			  
		  }
		  
		  //处理管理员登陆
		  else
		  {
			  AdminBean admin=adminDao.get(username);
			  if(admin!=null)
			  {
				  if(admin.getAdminPassword().equals(password))
				  {
					  return true;
				  }
				  else
				  {
					  return false;
				  }
			  }
			  else
			  {
				  return false;
			  }
			  
			  
		  }
	  }
	  
	  
	//判断该用户是否有图片已被专家识别，用于非实时消息提醒
		public boolean isUpdate(String farmID)
		{
			UpdateInfoBean update=updateDao.get(farmID);
			boolean flag=false;
		
			if(update!=null)
			{
				flag=true;
			}
			return flag;
			
		}
		
		//用于删除非实时消息提醒
		public void deleteUpdateInfo(String farmID)
		{
			UpdateInfoBean update=updateDao.get(farmID);
			if(update!=null)
			{
				updateDao.remove(update);
			}
			
		}
		
		//用于保存非实时消息提醒
		public void saveUpdateInfo(int pictureID)
		{
			UpdateInfoBean update=new UpdateInfoBean();
			
			PictureBean pic = picDao.get(pictureID);
			if(pic!=null)
			{
				String farmID=pic.getFarmID();
				boolean flag=isUpdate(farmID);
				if(!flag)
				{
					update.setFarmID(farmID);
					updateDao.save(update);
				}
			}
		}
	  
	  
	  //根据待审核专家ID获取相应的信息
	  public AuditExpertBean getAuditExpertID(String auditExpertID)
	  {
		  return audtExpDao.get(auditExpertID);
	  }
	  
	  //根据专家ID获取相应的信息
	  public  ExpertBean getExpertID(String expertID)
	  {
		  return expDao.get(expertID);
	  }
	  
	  //删除待审核专家
	  public void deleteAuditExpert(String auditExpertID)
	  {
		  AuditExpertBean auditExpertBean = audtExpDao.get(auditExpertID);
		  if(auditExpertBean!=null )
		  {
			  audtExpDao.remove(auditExpertBean);
		  }
	  }
	  
	  //增加专家
	  public boolean addExpert(String expertID,String expertPassword,String expertPhoneNumber,String adminID)
	  {
		  ExpertBean expertBean = expDao.get(expertID);
		  {
			  if(expertBean!=null)
			  {
				  return false;
			  }
			  
			  else {
				  expertBean = new ExpertBean();
				  expertBean.setAdminID(adminID);
				  expertBean.setExpertID(expertID);
				  expertBean.setExpertPassword(expertPassword);
				  expertBean.setExpertPhoneNumber(expertPhoneNumber);
				  expDao.save(expertBean);
				  return true;
			}
		  }
	  }
	  
}
