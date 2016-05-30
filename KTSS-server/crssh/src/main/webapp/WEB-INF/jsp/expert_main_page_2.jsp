<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="cn.cqu.knowplants.controller.WebConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家主界面</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"photos"+"/";
%>

</head>
<body >
    <div class="top1">
       <a href="quit.do" class="pos">安全退出</a>
        <img src="images/nav_logo.gif" />
    </div>
    <marquee class="topcolor">欢迎欢迎</marquee>
    <div class="mainbg">
        <div class="mainwebw">
            <div class="pt30" style="text-align:center"><img src="images/hua320.png" /></div>
            <div id="shitudiv" class="divshow"></div>
            <div class="mt20">
                <div class='mb10'><table style='width:100%;'><tr><td class='tdstu'><a href="expertListAllUnRecognizedPhotos.do" class='ablock'>未识别记录</a></td><td class='tdstu tdstubg'><a href="expertListAllRecognizedPhotos.do" class='ablock'>已识别记录</a></td></tr></table></div><div  class='item_list infinite_scroll'></div>
                  
                  <c:forEach var="cls" items="${recognized_photos}">
	                <div class="img">
                    <a  href="showExpertRecognizedPicture.do?id=${cls.getPictureID()}">
                       <img src=<%=basePath%>${cls.getPictureURL()}  alt="Ballade" width=180px height=160px>
                     </a>
                    <div class="desc"><a href="https://www.baidu.com/s?word=${cls.getPlantName()}"  target="_Blank">${cls.getPlantName()}</a></div>
                   </div>
	             </c:forEach>
		         <br>
                
                <div class="cb"></div>
                <div id="nextstr"></div>
            </div>
            <div style="text-align:center; margin-top:20px">
                <span style="font-family:Arial;">&copy;</span>Copyright @ 2016 cqu Inc. 保留所有权利。
                
            </div>
        </div>

    </div>   
</body>
</html>