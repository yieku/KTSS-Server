package cn.cqu.knowplants.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cqu.knowplants.domain.PictureBean;
import cn.cqu.knowplants.service.AdminService;
import cn.cqu.knowplants.service.ExpertService;
import cn.cqu.knowplants.service.FarmService;



@Controller
public class PictureController {
@Autowired
AdminService adminService;
@Autowired
FarmService farmService;
@Autowired
ExpertService expertService;

   

    //删除图片
   @ResponseBody
   @RequestMapping(value = "/deletePicture.do")
    public ModelAndView delete(HttpSession session, @RequestParam("id") String ID, @RequestParam("type") String type)
		throws Exception {
	   ModelAndView mv = new ModelAndView();
	   int pictureID=Integer.parseInt(ID);
	   adminService.deletePictureByID(pictureID);
	   if(type.equals("1"))
	   {
		   @SuppressWarnings("unchecked")
		   List<PictureBean> pictures=adminService.getAllrecognizedPicture();
		   mv.addObject(WebConstants.recognized_photos,pictures);
		   mv.setViewName("admin_find_recognized_pictures");
		   
	   }
	   else
	   {
		   @SuppressWarnings("unchecked")
		   List<PictureBean> pictures=adminService.getAllUnrecognizedPicture();
		   mv.addObject(WebConstants.unrecognized_photos,pictures);
		   mv.setViewName("admin_find_unrecognized_pictures");
		}
	   return mv;
   }
   
   
   //专家识别图片（跟新图片所用）
   @SuppressWarnings("unchecked")
@RequestMapping(value = "/RecognizePhotos.do", method= RequestMethod.POST)
   public ModelAndView recognizedPhoto(HttpSession session, @RequestParam("id") String id,@RequestParam("plantName")  String plantName,@RequestParam("rate")  String accuracyRate)
			throws Exception {
	   ModelAndView mv = new  ModelAndView();
	   int pictureID=Integer.parseInt(id);
	   if(plantName==""||accuracyRate=="")
	   {
		   List<PictureBean> pic=farmService.getPictureByPictureID(pictureID);
		   if(pic.size()>0)
		   {
			   PictureBean picture=pic.get(0);
			   mv.addObject(WebConstants.sub_pictureID,picture.getPictureID());
				mv.addObject(WebConstants.sub_pictureURL,picture.getPictureURL());
				mv.addObject(WebConstants.expert,"专家");
				 mv.setViewName("sub");
		   }
		   else
		   {
			   mv.setViewName("unexpected");
		   }
		  
	   }
	   else
	   {
		   //用于非实时消息提醒
		   adminService.saveUpdateInfo(pictureID);
		   expertService.updatePicture(pictureID,plantName,"专家",accuracyRate);
		   List<PictureBean> pictures=adminService.getAllUnrecognizedPicture();
		   mv.addObject(WebConstants.unrecognized_photos,pictures);
		   mv.setViewName("expert_main_page_1");
	   }
	   return mv;
   }
   
   //专家列出所有的未识别图片
    @SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/expertListAllUnRecognizedPhotos.do")
	public ModelAndView expertListAllUnRecognizedPhotos(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
        List<PictureBean> pictures=adminService.getAllUnrecognizedPicture();
		mv.addObject(WebConstants.unrecognized_photos,pictures);
		mv.setViewName("expert_main_page_1");
		return mv;
	}
    
    //专家列出所有已经识别的图片
    @SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/expertListAllRecognizedPhotos.do")
	public ModelAndView expertListAllRecognizedPhotos(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<PictureBean> pictures=adminService.getAllrecognizedPicture();
		mv.addObject(WebConstants.recognized_photos,pictures);
		mv.setViewName("expert_main_page_2");
		return mv;
	}
    
    
   
   //上传图片
   @ResponseBody
   @RequestMapping(value = "/loadPicture.do", method= RequestMethod.POST)
   public ModelAndView loadPicture(HttpSession session,HttpServletRequest request, HttpServletResponse response,@RequestParam("username") String username) throws IOException
   {
	   
	    ModelAndView mv = new ModelAndView();
	    String url=farmService.loadPicture(session, request, response, username);
	    if(url==null)
	    {
	    	session.setAttribute(WebConstants.load_picture_result,"fail");
     		session.setAttribute(WebConstants.load_picture_result_info,"上传失败\\n本系统暂不支持gif类图片");
     		mv.setViewName("farm_find_pic");
	    }
	    else
	    {
	    	int flag=farmService.findResult(session, url);
	    	if(flag==2)
		    {
		    	mv.setViewName("result");
		    }
		    else 
		    {
		    	mv.setViewName("farm_find_pic");
		    }
	    	
	    }
	    
	    return mv;
   }
   
   
}
