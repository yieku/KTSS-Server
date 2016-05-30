<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="cn.cqu.knowplants.controller.WebConstants" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农民注册页面</title>
<link href="css/base.css" rel="stylesheet" type="text/css" />
</head>
<body id="login_body">


<section class="reg_box">
	<form class="login-form" action="farm_register.do" method="post">
                   		<div class="logo_icon"></div>
						<div class="logo_text">【会员注册】</div>
       <div class="form_body">
          <div class="control-group">
            <label class="control-label" for="username">用户名</label>
            <div class="controls">
              <input type="text" id="username" class="span3" placeholder="请输入用户名（不能含中文）" nullmsg="请输入用户名（不能含中文）" value="" name="farmID">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputPassword">密 码</label>
            <div class="controls">
              <input type="password" id="inputPassword"  class="span3" placeholder="请输入密码" nullmsg="请填写密码" name="farmPassword">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="repassword">确认密码</label>
            <div class="controls">
              <input type="password" id="repassword" class="span3" placeholder="请再次输入密码" nullmsg="请填确认密码" name="ensurePassword">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputEmail">手机号码</label>
            <div class="controls">
              <input type="text" id="inputEmail" class="span3" placeholder="请输入手机号码" nullmsg="请填写手机号码" value="" name="farmPhoneNumber">
            </div>
          </div>      
          <div class="control-group">
          	<label class="control-label">&nbsp;</label>
            <div class="controls">
              <button type="submit" class="btn btn-large">注 册</button>
            </div>
          </div>
          
      </div>
    </form>
    
     <%
     String state="9";
     try{
        state=session.getAttribute(WebConstants.farm_register_state).toString();
     }
     catch(Exception e)
     {
    	 
     }
	if(state.equals("0")||state.equals("1")||state.equals("2")||state.equals("3")||state.equals("4"))
    {
    	session.setAttribute(WebConstants.farm_register_state, "farm_register_state");
    	String str=session.getAttribute(WebConstants.farm_register_info).toString();
    	%>
    	   <script>
    	   var str1='<%=str%>';
    	   alert(str1);  
    	   </script>   
        
    	<%  
    }
    
	%>
    
    </section>
    
   
   
   
</body>
</html>