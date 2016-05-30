package cn.cqu.knowplants.service;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cqu.knowplants.controller.WebConstants;
import cn.cqu.knowplants.domain.FarmBean;
import cn.cqu.knowplants.domain.PictureBean;
import cn.cqu.knowplants.domain.UpdateInfoBean;

@Service
@Transactional
public class FarmService extends BaseService {
	
	 private String tagPlantName=null;
	 private String tagAccuracyRate=null;
	
	 private String farmID;    //用于记录该图片属于哪个农民的
     private String pictureURL;    //用于记录图片的地址
     
     private String pictureTime;    //用于记录图片的上传时间，根据时间的先后进行显示在屏幕上
     private String plantName;     //这里先假设不确定图片所属植物,那就设为null
     private String byWho;      //识别者，是程序还是专家？
     private String accuracyRate;  //准确率
	
	//增加普通用户名
	public boolean addFarm(String farmID,String farmPassword,String farmPhoneNumber)
	  {
		  FarmBean farmBean = farmDao.get(farmID);
		   
			  if(farmBean!=null)
			  {
				  return false;
			  }
			  farmBean = new FarmBean();
			  farmBean.setFarmID(farmID);
			  farmBean.setFarmPassword(farmPassword);
			  farmBean.setFarmPhoneNumber(farmPhoneNumber);
			  farmDao.save(farmBean);
			  return true;
	  }
	
	
	 //增加图片
	 public void addPicture(Integer pictureID,String pictureURL,String pictureTime,String plantName,String farmID,String recognizedBy,String accuracyRate)
	  {
		  PictureBean pic = new PictureBean();
		  pic.setPictureURL(pictureURL);
		  pic.setPictureTime(pictureTime);
		  pic.setPlantName(plantName);
		  pic.setFarmID(farmID);
		  pic.setRecognizedBy(recognizedBy);
		  pic.setAccuracyRate(accuracyRate);
		  picDao.save(pic);
	  }
	 
	 //按照FarmID获取图片
	 public ArrayList<PictureBean> getPictureByFarmID(String farmID)
	 {
		 return picDao.getByFarmID(farmID);
	 }
	 
	 //按照pictureID获取图片
	 public ArrayList<PictureBean> getPictureByPictureID(int pictureID)
	 {
		return picDao.getPictureByPictureID(pictureID);
		 
	 }
	 
	 //按照pictureURL获取图片
	 public PictureBean getPictureByPictureURL(String pictureURL)
	 {
		 ArrayList<PictureBean> list=picDao.getPictureByPictureURL(pictureURL);
		 return list.get(0);
		 
	 }
	 
	 //按照FarmID获取未识别的图片
	 @SuppressWarnings("unchecked")
	public ArrayList<PictureBean> getAllUnrecognizedPictureByFarmID(String farmID)
	 {
		 return picDao.getAllUnrecognizedPictureByFarmID(farmID);
	 }
	 
	//按照FarmID获取程序自动识别的图片
	 @SuppressWarnings("unchecked")
	public ArrayList<PictureBean> getAllAutoRecognizedPictureByFarmID(String farmID)
	{
		 return picDao.getAllAutoRecognizedPictureByFarmID(farmID);
	}
	 
	//按照FarmID获取专家识别的图片
	 @SuppressWarnings("unchecked")
	public ArrayList<PictureBean> getAllExpertRecognizedPictureByFarmID(String farmID)
	 {
		 return picDao.getAllExpertRecognizedPictureByFarmID(farmID);
	 }
	 
	 //获取picture数据库表中有多少条数据
	 @SuppressWarnings("unchecked")
	public int getCounts()
	{
		 ArrayList<PictureBean> lists=(ArrayList<PictureBean>) picDao.find("from PictureBean where pictureID=(select max(pictureID) from PictureBean)");
		 if(lists.size()>0)
		 {
			 return lists.get(0).getPictureID()+1;
		 }
		 else
		 {
			 return 1;
		 }
	}
	 
	 
	 
	 //上传图片
	 @SuppressWarnings("unused")
	public String loadPicture(HttpSession session,HttpServletRequest request, HttpServletResponse response,String username) throws IOException
	 {
		int flag=0;
		String url=null;
		 
		response.setContentType("text/html");
     	 // 设置字符编码为UTF-8, 这样支持汉字显示 
     	response.setCharacterEncoding("UTF-8");
     	request.setCharacterEncoding("UTF-8");
     	
     	int pictureID=getCounts();
     	
  	
       
        
     	Date date=new Date();
     	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     	String time=format.format(date);
     	
     	
         /**


     	 * 首先判断form的enctype是不是multipart/form-data


     	 * 同时也判断了form的提交方式是不是post


     	 * 方法：isMultipartContent(request)


     	*/

  
     	
     	if(ServletFileUpload.isMultipartContent(request))
     	{
     		request.setCharacterEncoding("utf-8");
     		// 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload 
     		DiskFileItemFactory factory = new DiskFileItemFactory();
     		//设置文件存放的临时文件夹，这个文件夹要真实存在
     		File fileDir = new File("F:/");
     		if(fileDir.isDirectory() && fileDir.exists()==false){
     			fileDir.mkdir();
     			}
     		factory.setRepository(fileDir);
     		//设置最大占用的内存
     		factory.setSizeThreshold(1024000);
     		//创建ServletFileUpload对象
     		ServletFileUpload sfu = new ServletFileUpload(factory);
     		sfu.setHeaderEncoding("utf-8");
     		//设置单个文件最大值byte
     		sfu.setFileSizeMax(102400000);
     		//所有上传文件的总和最大值byte
     		sfu.setSizeMax(204800000);
     		List<FileItem> items = null;
     		try
     		{
     			items = sfu.parseRequest(request);
     		
     		}
     		catch (SizeLimitExceededException e) 
     		{ 
     			System.out.println("文件大小超过了最大值");
     		}
     		catch(FileUploadException e) 
     		{ 
     			e.printStackTrace();
     			
     		}
     		//取得items的迭代器
     		Iterator<FileItem> iter = items==null?null:items.iterator();
     		
     		
     		 String path = request.getContextPath();
     		 System.out.println("path: "+path);
     	     String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
     		 System.out.println("这里: "+basePath);
     	     String base1="photos/";
     	     
     	    //图片上传后存放的路径目录
     		File images = new File(base1);
     		if(images.exists()==false){
     			images.mkdirs();
     			
     		}
     		//迭代items
     		while(iter!=null && iter.hasNext())
     		{
     			FileItem item = (FileItem) iter.next();
     			//如果传过来的是普通的表单域
     			if(item.isFormField())
     			{
     				System.out.print("普通的表单域:");
     				
     			}
     			
     			//文件域
     			else if(!item.isFormField())
     			{
     				
     				if(item.getName().equals(""))   //为空
     				{
     					
     				}
     				else
     				{
     					//进行图片的改名
     				   
     				    String fileName=pictureID+item.getName().substring(item.getName().lastIndexOf("."));
     				   
     				    String pre=item.getName().substring(item.getName().lastIndexOf("."));
     				    if(pre.equals(".gif")||pre.equals(".GIF"))  //不支持gif图片
     				    {
     				    	// do nothing
     				    	
     				    }
     				    else
     				    {
     				    //System.out.println("村粗路径"+request.getSession().getServletContext().getRealPath("/") +base1+fileName);
     				    BufferedInputStream in = new BufferedInputStream(item.getInputStream());
     				    BufferedOutputStream out = new BufferedOutputStream( 
     	                new FileOutputStream(new File(request.getRealPath("/")+base1+fileName))); 
     	                Streams.copy(in, out, true); 
     	           
     	                
     	                 //存图片相关信息到数据库中
     	                 farmID=username;    //用于记录该图片属于哪个农民的
     	                 pictureURL=fileName;    //用于记录图片的地址
     	               
     	                 pictureTime=time;    //用于记录图片的上传时间，根据时间的先后进行显示在屏幕上
     	                 plantName=null;     //这里先假设不确定图片所属植物,那就设为null
     	                 byWho=null;      //先设为null
     	                 accuracyRate=null;  //准确率先设为null
     	                 addPicture(1, pictureURL, pictureTime, plantName, farmID, byWho,accuracyRate);
     	                 url=pictureURL;
     				    }
     	                 
     				}
     				
     			}
     	    }
     	}
     	return url;
     }
	 
	 
	 /*查找识别结果，在这里解释一下，之所以让线程睡眠20秒，是因为要等待后台识别程序把结果更新到数据库中，后台的识别程序跟这里是完全隔离的两段程序。
	 他们交互的共同点就只有数据库  */
	 public int findResult(HttpSession session,String pictureURL)
	 {
		 //让本线睡眠，等待后台识别程序的识别结果
		  try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 session.setAttribute(WebConstants.picture_url, "../photos/"+pictureURL);
		 PictureBean picture=new PictureBean();
		 picture=getPictureByPictureURL(pictureURL);
		 int flag=0;
         if(picture!=null)
         {
          	 if(picture.getPlantName()!=null)
          	 {
          		tagPlantName=picture.getPlantName();
          	    tagAccuracyRate=picture.getAccuracyRate();
      	        String context="您上传的图片被识别为：'"+tagPlantName+"' 准确率: "+tagAccuracyRate;
			    session.setAttribute(WebConstants.content, context);
      	     }
      	    else
      	    {
      		    String context="你上传的可能不是树叶特写或者系统识别率过低导致无法识别，已转交专家处理";
          	    session.setAttribute(WebConstants.content, context);
      	    	 
      	    }
      	    flag=2;
      	 }
         else
         {
          	session.setAttribute(WebConstants.load_picture_result,"fail");
      		session.setAttribute(WebConstants.load_picture_result_info,"上传失败");
      		flag=3;
          }
          return flag;
          
	 }
}

     
 
	 
	 

