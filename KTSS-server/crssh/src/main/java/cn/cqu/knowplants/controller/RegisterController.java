package cn.cqu.knowplants.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.cqu.knowplants.domain.AuditExpertBean;
import cn.cqu.knowplants.domain.ExpertBean;
import cn.cqu.knowplants.domain.FarmBean;
import cn.cqu.knowplants.service.AdminService;
import cn.cqu.knowplants.service.AuditExpertService;
import cn.cqu.knowplants.service.FarmService;
import cn.cqu.knowplants.util.IsChinese;
import cn.cqu.knowplants.util.IsLegalPhone;

 

@Controller
public class RegisterController {

	@Autowired
	AdminService adminService;
	@Autowired
	FarmService farmService;
	@Autowired
	AuditExpertService auditExpertService;
	
	
	
	//处理普通用户注册
	@RequestMapping(value = "/farm_register.do", method= RequestMethod.POST)
	public ModelAndView farmRegister(HttpSession session, @RequestParam("farmID") String farmID, @RequestParam("farmPassword") String farmPassword,@RequestParam("ensurePassword") String ensurePassword,@RequestParam("farmPhoneNumber") String farmPhoneNumber)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
		IsChinese isChin=new IsChinese();
		boolean labelUser=isChin.isChineseChar(farmID);
		
		
		
		
		IsLegalPhone isLegal=new IsLegalPhone();   //判断输入的电话号码是否合法
		boolean flag=isLegal.check(farmPhoneNumber);
		
		
		if(labelUser)
		{
			session.setAttribute(WebConstants.farm_register_state,"0");  //输入不能为空
			session.setAttribute(WebConstants.farm_register_info,"注册信息中用户名不能含\\n中文");
			mv.setViewName("farm_register");
		}
		
		
		else if(farmID==""||farmPassword==""||ensurePassword==""||farmPhoneNumber=="")
		{
			session.setAttribute(WebConstants.farm_register_state,"1");  //输入不能为空
			session.setAttribute(WebConstants.farm_register_info,"你好，输入不能为空");
			mv.setViewName("farm_register");
		}
		else if(flag==false)  //输入的电话号码不合法
		{
			session.setAttribute(WebConstants.farm_register_state,"2"); 
			session.setAttribute(WebConstants.farm_register_info,"你好，输入的电话号码不合法");
			mv.setViewName("farm_register");
		}
		else if(!farmPassword.equals(ensurePassword))  //用户名和密码不一致
		{
			session.setAttribute(WebConstants.farm_register_state,"3"); 
			session.setAttribute(WebConstants.farm_register_info,"你好，两次输入的密码不一致");
			mv.setViewName("farm_register");
		}
		else
		{
			FarmBean farm=adminService.getFarmId(farmID);
			if(farm!=null)    //用户名已被注册
			{
				session.setAttribute(WebConstants.farm_register_state,"4"); 
				session.setAttribute(WebConstants.farm_register_info,"你好，不好意思\\n，该用户已被注册");
				mv.setViewName("farm_register");
			}
			else   //注册成功
			{
				farmService.addFarm(farmID, farmPassword, farmPhoneNumber);
				session.setAttribute(WebConstants.login_state,"4");
				session.setAttribute(WebConstants.login_message,"你好,注册成功\\n欢迎登陆");
				
				mv.setViewName("login");
			}
			
			
		}
		
		return mv;
	}
	
	
	//处理专家注册
	@RequestMapping(value = "/expert_register.do", method= RequestMethod.POST)
	public ModelAndView expertRegister(HttpSession session, @RequestParam("auditExpertID") String auditExpertID, @RequestParam("auditExpertPassword") String auditExpertPassword,@RequestParam("ensurePassword") String ensurePassword,@RequestParam("auditExpertPhone") String auditExpertPhone,@RequestParam("auditExpertMaterial") String auditExpertMaterial)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
		IsChinese isChin=new IsChinese();       //判断即将要注册的用户名是否包含中文
		boolean labelUser=isChin.isChineseChar(auditExpertID);
		
		
		
		
		IsLegalPhone isLegal=new IsLegalPhone();   //判断输入的电话号码是否合法
		boolean flag=isLegal.check(auditExpertPhone);
		
		if(labelUser)
		{
			session.setAttribute(WebConstants.expert_register_state,"0");   
			session.setAttribute(WebConstants.expert_register_info,"用户名中不能含\\n中文");
			mv.setViewName("expert_register");
		}
		
		
		//判断输入是否为空
		else if(auditExpertID==""||auditExpertPassword==""||auditExpertPhone==""||auditExpertMaterial=="")
		{
			session.setAttribute(WebConstants.expert_register_state,"1");   
			session.setAttribute(WebConstants.expert_register_info,"你好，输入不能为空");
			mv.setViewName("expert_register");
		}
		else if(flag==false)  //输入的电话号码不合法
		{
			session.setAttribute(WebConstants.expert_register_state,"2"); 
			session.setAttribute(WebConstants.expert_register_info,"你好，输入的电话号码不合法");
			mv.setViewName("expert_register");
		}
		else if(!auditExpertPassword.equals(ensurePassword))  //用户名和密码不一致
		{
			session.setAttribute(WebConstants.expert_register_state,"3"); 
			session.setAttribute(WebConstants.expert_register_info,"你好，两次输入的密码不一致");
			mv.setViewName("expert_register");
		}
		else
		{
			 AuditExpertBean auditExpert=adminService.getAuditExpertID(auditExpertID); //查看待审核专家表中是否有重名的
			 ExpertBean expert=adminService.getExpertID(auditExpertID);    //查看专家表中是否有重名的
			 if(auditExpert!=null||expert!=null)  //用户名已被注册
			 {
				 session.setAttribute(WebConstants.expert_register_state,"4"); 
				 session.setAttribute(WebConstants.expert_register_info,"你好，不好意思\\n，该用户已被注册");
				 mv.setViewName("expert_register");
			 }
			 else
			 {
				 auditExpertService.addAuditExpert(auditExpertID, auditExpertPassword, auditExpertPhone, auditExpertMaterial);
				 session.setAttribute(WebConstants.login_state,"5");
				 session.setAttribute(WebConstants.login_message,"你好,注册信息提交成功\\n正等待管理员审核....\\n24小时之后有答复");
				 
				 mv.setViewName("login");
			 }
			 
		}
		return mv;
	}
	
}
