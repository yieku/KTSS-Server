<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册中转页</title>
<script language="javascript" src="js/judge.js"></script> 
<link href="css/Login.css" rel="stylesheet" type="text/css" >
</head>
<body class="background">
  <form action="true_register.do" method="post">
   <div class="pos">
     <label>请选择要注册的类型</label>
     <br>
     <select name="selectName" id="selectId">
     <option value="1" >普通用户</option>
     <option value="2" >专家</option>
   
     </select>
     <input type="submit" value="确认">
     
    </div>
   </form>
   

</body>
</html>