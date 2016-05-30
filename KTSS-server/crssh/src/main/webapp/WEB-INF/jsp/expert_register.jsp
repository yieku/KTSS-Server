<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="cn.cqu.knowplants.controller.WebConstants" %>
<head>
	<title>Login Two</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
	<link href="<%=basePath %>css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath %>css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath %>css/bootstrap-social.css" rel="stylesheet" type="text/css">	
	<link href="<%=basePath %>css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-image-1">
	<div class="container">
		<div class="col-md-12">			
			<form class="form-horizontal templatemo-login-form-2" role="form" action="expert_register.do" name="expert_register_form" method="post">
				<div class="row">
					<div class="col-md-12">
						<h1>专家注册信息</h1>
					</div>
				</div>
				<div class="row">
					<div class="templatemo-one-signin col-md-6">
				        <div class="form-group">
				          <div class="col-md-12">		          	
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-user"></i>
				            	<input type="text" name="auditExpertID" class="form-control" placeholder="用户名（不能含中文）">
				            </div>		            		            		            
				          </div>              
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-lock"></i>
				            	<input type="password" name="auditExpertPassword" class="form-control" placeholder="密码">
				            </div>
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-lock"></i>
				            	<input type="password" name="ensurePassword" class="form-control" id="password" placeholder="确认密码">
				            </div>
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-lock"></i>
				            	<input type="text" name="auditExpertPhone" class="form-control" id="password" placeholder="手机号码">
				            </div>
				          </div>
				        </div>
					</div>
					<div class="templatemo-other-signin col-md-6">
					    <label for="username" class="control-label" style="text-align:center">证明信息</label>
						<textarea rows="8" cols="50" name="auditExpertMaterial" class="form-control">
						</textarea>
					</div>   
				</div>
				<div class="row">
					<div class="col-md-12">
					<h3></h3>
					</div>
				</div>
				<div class="row"  style="margin:auto">
					<div class="col-md-12" style="text-align:center">
						<input type="submit" value="确认提交" class="btn btn-warning" style="width:50%">
					</div>
				</div>
				
			</form>
			<%
			String state="9";
			try{
				state=session.getAttribute(WebConstants.expert_register_state).toString();
				}
			catch(Exception e)
			{
				
			}
			if(state.equals("0")||state.equals("1")||state.equals("2")||state.equals("3")||state.equals("4"))
			{
				session.setAttribute(WebConstants.expert_register_state,"expert_register_state");
				String str=session.getAttribute(WebConstants.expert_register_info).toString();
				%>
				<script>
				var str1='<%=str%>';
				alert(str1);  
				</script>   
				<%  
				}
			%>
			
		</div>
	</div>
	
	
   
	
</body>
</html>