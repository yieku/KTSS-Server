package cn.cqu.knowplants.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cqu.knowplants.domain.AuditExpertBean;
import cn.cqu.knowplants.domain.ExpertBean;
import cn.cqu.knowplants.domain.FarmBean;
import cn.cqu.knowplants.domain.PictureBean;
import cn.cqu.knowplants.service.AdminService;
import cn.cqu.knowplants.service.AuditExpertService;
import cn.cqu.knowplants.service.ExpertService;
import cn.cqu.knowplants.service.FarmService;

@Controller
public class MainController {
     
	@Autowired
	AdminService adminService;
	@Autowired
	FarmService farmService;
	@Autowired
	AuditExpertService auditExpertService;
	@Autowired
	ExpertService expertService;
	
	
	
	//按照farmID获取程序自动识别的图片（用于普通用户）
	@RequestMapping(value = "/getAutoRecognizedPictures.do")
	public ModelAndView getAutoRecognizedPicturesByFarmID(HttpSession session,@RequestParam("id") String farmID)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pictures=farmService.getAllAutoRecognizedPictureByFarmID(farmID);
		mv.addObject(WebConstants.auto_recognized_photos,pictures);
		mv.setViewName("farm_find_auto_recognized_pic");
		
		return mv;
	}
	
	
	//按照farmID获取专家识别的图片（用于普通用户）
	@RequestMapping(value = "/getExpertRecognizedPictures.do")
	public ModelAndView getExpertRecognizedPicturesByFarmID(HttpSession session,@RequestParam("id") String farmID)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pictures=farmService.getAllExpertRecognizedPictureByFarmID(farmID);
		mv.addObject(WebConstants.expert_recognized_photos,pictures);
		mv.setViewName("farm_find_expert_recognized_pic");
		
		return mv;
	}
	
	
	//按照farmID获取程序未识别的图片（用于普通用户）
	@RequestMapping(value = "/getUnrecognizedPictures.do")
	public ModelAndView getUnrecognizedPicturesByFarmID(HttpSession session,@RequestParam("id") String farmID)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pictures=farmService.getAllUnrecognizedPictureByFarmID(farmID);
		mv.addObject(WebConstants.farm_unrecognized_photos,pictures);
		mv.setViewName("farm_find_unrecognized_pic");
		
		return mv;
	}
	
	
	
	
	
	
	
	//管理员查找所有已经识别的图片
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/adminFindRecognizedPictures.do")
	public ModelAndView adminFindRecognizedPictures(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pictures=adminService.getAllrecognizedPicture();
		mv.addObject(WebConstants.recognized_photos,pictures);
		mv.setViewName("admin_find_recognized_pictures");
		return mv;
	}
	
	//管理员查找所有未识别的图片
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/adminFindUnRecognizedPictures.do")
	public ModelAndView adminFindUnRecognizedPictures(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pictures=adminService.getAllUnrecognizedPicture();
		mv.addObject(WebConstants.unrecognized_photos,pictures);
		mv.setViewName("admin_find_unrecognized_pictures");
		return mv;
	}
	
	
	//管理员查找所有的普通用户
	@RequestMapping(value = "/adminFindFarm.do")
	public ModelAndView adminFindFarm(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<FarmBean> farms=adminService.getAllFarms();
		mv.addObject(WebConstants.all_farms,farms);
		mv.setViewName("admin_find_farm");
		return mv;
	}
	
	//管理员查找其他信息
	@RequestMapping(value = "/adminFindOtherMessage.do")
	public ModelAndView adminFindOtherMessage(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin_background1");
		return mv;
	}
	
	
	//管理员查找所有的专家
	@RequestMapping(value = "/adminFindExpert.do")
	public ModelAndView adminFindExpert(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<ExpertBean> experts=adminService.getAllExperts();
		mv.addObject(WebConstants.all_experts,experts);
		mv.setViewName("admin_find_expert");
		return mv;
	}
	
	//管理员查找所有的待审核专家
	@RequestMapping(value = "/adminFindAuditExpert.do")
	public ModelAndView adminFindAuditExpert(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<AuditExpertBean> auditExperts=adminService.getAllAuditExperts();
		mv.addObject(WebConstants.all_audit_experts,auditExperts);
		mv.setViewName("admin_find_audit_expert");
		return mv;
	}
	
	//用户使用规则
	@RequestMapping(value = "/userRules.do")
	public ModelAndView userRules(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("user_rules");
		return mv;
	}
	
	//管理员查找待审核专家的审核材料  111
	@ResponseBody
	@RequestMapping(value = "/adminFindAuditExpertMaterials.do")
	public ModelAndView adminFindAuditExpertMaterials(HttpSession session, @RequestParam("id") String ID)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		AuditExpertBean auditExpert=adminService.getAuditExpertID(ID);
		mv.addObject(WebConstants.audit_expert,auditExpert);
		mv.setViewName("admin_find_audit_expert_materials");
		return mv;
	}
	
	//批准待审核专家成为专家  
	@ResponseBody
	@RequestMapping(value = "/addAuditExpert.do")
	public ModelAndView addAuditExpert(HttpSession session,@RequestParam("id") String ID)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		AuditExpertBean auditExpert=adminService.getAuditExpertID(ID);
		if(auditExpert!=null)
		{
			adminService.addExpert(auditExpert.getAuditExpertID(), auditExpert.getAuditExpertPassword(), auditExpert.getAuditExpertPhone(),WebConstants.admin);
			adminService.deleteAuditExpert(ID);
			List<AuditExpertBean> auditExperts=adminService.getAllAuditExperts();
			mv.addObject(WebConstants.all_audit_experts,auditExperts);
			mv.setViewName("admin_find_audit_expert");
		}
		else
		{
			mv.setViewName("unexpected");
		}
		return mv;
	}
	
	//删除待审核专家
	@ResponseBody
	@RequestMapping(value = "/deleteAuditExpert.do")
	public ModelAndView deleteAuditExpert(HttpSession session, @RequestParam("id") String ID)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		adminService.deleteAuditExpert(ID);
		List<AuditExpertBean> auditExperts=adminService.getAllAuditExperts();
		mv.addObject(WebConstants.all_audit_experts,auditExperts);
		mv.setViewName("admin_find_audit_expert");
		return mv;
	}
	
	//返回待审核专家页面
	@ResponseBody
	@RequestMapping(value = "/returnToAuditExpert.do")
	public ModelAndView deleteAuditExpert(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
        List<AuditExpertBean> auditExperts=adminService.getAllAuditExperts();
		mv.addObject(WebConstants.all_audit_experts,auditExperts);
		mv.setViewName("admin_find_audit_expert");
		return mv;
	}
	
	//返回已识别图片界面
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/returnToRecognizedPicture.do",method= RequestMethod.POST)
	public ModelAndView returnToRecognizedPicture(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pictures=adminService.getAllrecognizedPicture();
		mv.addObject(WebConstants.recognized_photos,pictures);
		mv.setViewName("admin_find_recognized_pictures");
		return mv;
	}
	
	//返回未识别图片页面
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/returnToUnRecognizedPicture.do",method= RequestMethod.POST)
	public ModelAndView returnToUnRecognizedPicture(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pictures=adminService.getAllUnrecognizedPicture();
		mv.addObject(WebConstants.unrecognized_photos,pictures);
		mv.setViewName("admin_find_unrecognized_pictures");
		return mv;
	}
	
	
	//显示所有已经识别的图片（用于专家）
	@ResponseBody
	@RequestMapping(value = "/showRecognizedPicture.do")
	public ModelAndView showRecognizedPicture(HttpSession session, @RequestParam("id") int id)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pic=farmService.getPictureByPictureID(id);
		mv.addObject(WebConstants.sub3_pic,pic);
		mv.setViewName("sub3");
		return mv;
		
	}
	
	
	//显示识别的照片
	@ResponseBody
	@RequestMapping(value = "/showExpertRecognizedPicture.do")
	public ModelAndView showExpertRecognizedPicture(HttpSession session, @RequestParam("id") int pictureID)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pic=farmService.getPictureByPictureID(pictureID);
		mv.addObject(WebConstants.sub1_pic,pic);
		mv.setViewName("sub1");
		return mv;
		
	}
	
	
	//显示未识别的照片
	@ResponseBody
	@RequestMapping(value = "/showUnRecognizedPicture.do")
	public ModelAndView showUnRecognizedPicture(HttpSession session, @RequestParam("id") int id)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pic=farmService.getPictureByPictureID(id);
		mv.addObject(WebConstants.sub2_pic,pic);
		mv.setViewName("sub2");
		return mv;
	}
	
	//显示照片
	@ResponseBody
	@RequestMapping(value = "/sub.do")
	public ModelAndView sub(HttpSession session, @RequestParam("id") String pictureID,@RequestParam("url") String url)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject(WebConstants.sub_pictureID,pictureID);
		mv.addObject(WebConstants.sub_pictureURL,url);
		mv.addObject(WebConstants.expert,"专家");
		
		mv.setViewName("sub");
		return mv;
	
	}
	
	//跳转
	@ResponseBody
	@RequestMapping(value = "/sub4.do")
	public ModelAndView sub4(HttpSession session,@RequestParam("id") int id)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<PictureBean> pic=farmService.getPictureByPictureID(id);
		mv.addObject(WebConstants.sub4_pic,pic);
		mv.setViewName("sub4");
		return mv;
	}
	
	//跳转
	@ResponseBody
	@RequestMapping(value = "/sub5.do")
	public ModelAndView sub5(HttpSession session, @RequestParam("id") int id)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<PictureBean> pic=farmService.getPictureByPictureID(id);
		mv.addObject(WebConstants.sub5_pic,pic);
		mv.setViewName("sub5");
		return mv;
	
	}
	
	//跳转
	@ResponseBody
	@RequestMapping(value = "/sub6.do")
	public ModelAndView sub6(HttpSession session,@RequestParam("id") int id)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<PictureBean> pic=farmService.getPictureByPictureID(id);
		mv.addObject(WebConstants.sub6_pic,pic);
		mv.setViewName("sub6");
		
		return mv;
		
	}
	
	
	
	
	
	
	//返回专家主界面1
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/returnToExpertMainPage1.do",method= RequestMethod.POST)
	public ModelAndView returnToExpertMainPage1(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pictures=adminService.getAllUnrecognizedPicture();
		mv.addObject(WebConstants.unrecognized_photos,pictures);
		mv.setViewName("expert_main_page_1");
		return mv;
	}
	
	//返回专家主界面2
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/returnToExpertMainPage2.do",method= RequestMethod.POST)
	public ModelAndView returnToExpertMainPage2(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<PictureBean> pictures=adminService.getAllrecognizedPicture();
		mv.addObject(WebConstants.recognized_photos,pictures);
		mv.setViewName("expert_main_page_2");
		return mv;
	}
	
	
	//返回普通用户主界面
	@ResponseBody
	@RequestMapping(value = "/returnToFarmFindPic.do")
	public ModelAndView returnToFarmFindPic(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		session.setAttribute(WebConstants.load_picture_result,"sucess");
		
		mv.setViewName("farm_find_pic");
		return mv;
	}
	
}
