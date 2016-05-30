<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="cn.cqu.knowplants.controller.WebConstants" %>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"photos"+"/";
%>
</head>
<body>

    

  

   
    <div class="top1">
        <a href="login.jsp" class="pos">安全退出</a>
        <img src="images/nav_logo.gif" />
    </div>
    <marquee class="topcolor">欢迎用户   :  ${username} </marquee>
    
    <div class="mainbg">
        <div class="mainwebw">
            
            <div class="pt30" style="text-align:center"><img src="images/hua320.jpg" /></div>
            <div class="upbg">
                <form id="form3" action="loadPicture.do?username=${username}" method="post" enctype="multipart/form-data" >
                    <input   id="content" class="stuurl" type="file"  name="id" accept="image/*" style="height:32px;" />
                    
                    <span class="stsb">
                    <input  onclick="javascript:load()" type="submit" name="submit2" value="提  交  鉴  定" style="display:block;font-size:14px;text-align:center; vertical-align:middle;padding-top:17px;cursor:pointer;font-weight:bolder"/>
                    </span>
                </form>
            </div>
            
            <div id="shitudiv" class="divshow" style="text-align:center;"></div>
            <div class="mt20">
                <div class='stu1'>
                   <div class='stu2'>
                      <div class='a1'><img src=<%=basePath%>${picture_url}  border='0'  height='150px'  width='238px' /></div>
                   </div>
                   <div class='stustyle1'> ${content} </div>
                 </div>
                 
                 <div style='padding:10px 0'><hr class='hr1'><span style=' position:relative;left:45%;top:-9px;background-color:#bce0fe;font-size:14px'>以上为机器识别结果</span></div>
                 <div style='padding:10px 0'><hr class='hr1'><span style=' position:relative;left:50%;top:-9px;background-color:#bce0fe;font-size:14px'><a href="returnToFarmFindPic.do">返回</a></span></div>
            
            
          </div>
     </div>
     
      <script>
      function load()
      {
    	 
      	 var myHtml=document.getElementById("content").value;
      	 if(myHtml!="")
      	 {
      		 document.getElementById("shitudiv").innerHTML="图片处理中...（预计时间20秒）";
      	 }	 
       }
            
      alert("图片识别完"); 
      </script> 
     
</body>
</html>