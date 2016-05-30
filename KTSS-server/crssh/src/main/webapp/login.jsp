<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="cn.cqu.knowplants.controller.WebConstants" %>

<head>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>

    <title>Login Two</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">


	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-social.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">


</head>
<body class="templatemo-bg-image-1">
	<div class="container">
		<div class="liuji" >
			<form class="form-horizontal templatemo-login-form-2" role="form" action="login.do" method="post">
				<div class="row">
					<div class="col-md-12">
						<h1>花千树</h1>
					</div>
				</div>
				<div class="row">
				        <div class="form-group">
				          <div class="col-md-12">
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-user"></i>
				            	<input name="username" type="text" size="30" class="form-control" id="username" placeholder="用户名">

				            </div>
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-lock"></i>
				            	<input name="password" type="password" size="30" class="form-control" id="password" placeholder="密码">

				            </div>
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <div class="templatemo-input-icon-container">
				            	<select name="yourName" id="yourId" class="form-control">
				            	<option value="1" >普通用户</option>
				            	<option value="2" >专家</option>
				            	<option value="3" >超管</option>
				            	</select>
				            </div>
				          </div>

				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <input name="Submit2" type="submit" value="登录" class="btn btn-warning"/>
				          </div>
				        </div>

				        <div class="form-group">
				          	<div class="col-md-12">
				          	    <div style="float:left">
				          	        <a href="forget.do" class="text-center">忘记密码？</a>
				          	    </div>
				        		<div style="float:right">
				        		    <a href="register.do" class="text-center">立即注册</a>
				        		</div>
				       	 	</div>
				    	</div>
					</div>

		   </form>
		</div>
	</div>


</body>
</html>
