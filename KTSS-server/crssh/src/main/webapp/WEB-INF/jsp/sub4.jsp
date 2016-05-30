<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="cn.cqu.knowplants.controller.WebConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<link href="css/Login.css" rel="stylesheet" type="text/css" >
<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"photos"+"/";
%>

</head>
<body class="background">
   
   
  <div>
         <c:forEach var="cls" items="${sub4_pic}">
           <a  href="#">
             <img src=<%=basePath%>${cls.getPictureURL()} alt="Ballade" class="size">
          </a>
           <div align="center">
         <label>图片所属植物: <label class="col"> ${cls.getPlantName()}</label></label>
         </div>
         </c:forEach>
         <div align="center">
        
           
           <br>
             <a href="getAutoRecognizedPictures.do?id=${username}">返回</a>
          </div>
          </div>
   
   
  </body>
</html>