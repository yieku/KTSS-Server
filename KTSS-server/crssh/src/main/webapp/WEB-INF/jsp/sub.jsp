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
        
        <script>
        function load()
        {
       	 var name=document.getElementById("name").value;
       	 var rate=document.getElementById("rate").value;
       	 if(name==""||rate=="")
       	 {
       		 alert("输入不能为空");
       		 return false;
       	 }	 
        }
        </script>
    
  
 
   
         <div >
           <a  href="#">
             <img src=<%=basePath%>${sub_pictureURL} alt="Ballade" class="size" >
          </a>
         <div align="center" >
          <form action="RecognizePhotos.do?id=${sub_pictureID}" method="post">
           <label>图片所属植物:</label>
           <input id="name" type="text"  placeholder="不能为空" nullmsg="不能为空" name="plantName" >
           
           <label>准确率:</label>
           <input id="rate" type="text" placeholder="不能为空" nullmsg="不能为空" name="rate">
           <input onclick="javascript:load()" type="submit" value="确认">
           </form>
           <br>
           <form action="returnToExpertMainPage1.do" method="post">
              <input type="submit" value="返回">
           </form>
           
          </div>
        </div>
        
       
       
</body>
</html>