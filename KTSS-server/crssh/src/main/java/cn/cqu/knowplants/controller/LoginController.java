package cn.cqu.knowplants.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.cqu.knowplants.service.AdminService;
import cn.cqu.knowplants.service.FarmService;


 
@Controller
public class LoginController {

	@Autowired
	AdminService adminService;
	
	
	
	
	
	
	//处理普通用户，专家，管理员登陆
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("yourName")String var)
			throws Exception {
		
		ModelAndView mv = new ModelAndView();
		if(username==""||password=="")
		{
			session.setAttribute(WebConstants.login_state,"1");
			session.setAttribute(WebConstants.login_message,"你好，输入不能为空,请确认");
			mv.setViewName("login");
		}
		else
		{
			boolean b=adminService.login(username,password,var);
			if(b)
			{
				if(var.equals("1"))
				{
					session.setAttribute(WebConstants.username, username);
					session.setAttribute(WebConstants.load_picture_result,"success");
					
					boolean flag=false;
					flag=adminService.isUpdate(username);
					if(flag)
					{
						//处理非实时的消息处理
						session.setAttribute(WebConstants.update_info,"yes");
						session.setAttribute(WebConstants.update_info_message,"亲爱的用户,\\n你最近上传的图片已被专家识别，请注意查看");
						adminService.deleteUpdateInfo(username);
					}
					mv.setViewName("farm_find_pic");
				}
				else if(var.equals("2"))
				{
					session.setAttribute(WebConstants.expert, "专家");
					
					mv.setViewName("expert_main_page");
					
				}
				else
				{
					mv.setViewName("admin_main_page");
				}
				
			}
			else
			{
				session.setAttribute(WebConstants.login_state,"2");
				session.setAttribute(WebConstants.login_message,"你好，登陆失败，请检查\\n 用户名和密码是否正确");
				mv.setViewName("login");
			}
			
		}
		return mv;
	}
	
	
	//注册中转页
	@RequestMapping(value ="/register.do")   
	public ModelAndView register(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
		
	}
	
	
	//安全退出
	@RequestMapping(value ="/quit.do")   //注册中转页
	public ModelAndView quit(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		session.setAttribute(WebConstants.username, "username");
		session.setAttribute(WebConstants.expert, "expert");
		session.setAttribute(WebConstants.login_state,"3");
		session.setAttribute(WebConstants.login_message,"你好,安全退出\\n欢迎下次光临");
		
		mv.setViewName("login");
		return mv;
		
	}
	
	
	
	 //跳到注册界面
	@RequestMapping(value = "/true_register.do",method= RequestMethod.POST) 
	public ModelAndView farm_register(HttpSession session,@RequestParam("selectName")String var)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(var.equals("1"))
		{
			mv.setViewName("farm_register");
		}
		else
		{
			mv.setViewName("expert_register");
		}
		return mv;
		
	}
	
	
	//忘记密码时的处理
	@RequestMapping(value = "/forget.do")
	public ModelAndView forget(HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forget");
		return mv;
		
	}
	

}
