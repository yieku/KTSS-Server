<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="cn.cqu.knowplants.controller.WebConstants" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>农民主页面</title>

<link href="css/index.css" rel="stylesheet" type="text/css" />
<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"photos"+"/";
%>

</head>
<body>
   
    <script>
    function load()
    {
    	 var myHtml=document.getElementById("content").value;
    	 if(myHtml!="")
    	 {
    		 document.getElementById("shitudiv").innerHTML="图片处理中...（预计时间20秒）";
    	 }	 
    }
    </script>
    
  
 
    <div class="top1">
        <a href="quit.do" class="pos">安全退出</a>
        <img src="images/nav_logo.gif" />
    </div>
     <marquee  class="topcolor">欢迎用户:  ${username}</marquee>
    
    <div class="mainbg">
        <div class="mainwebw">
            
            <div class="pt30" style="text-align:center"><img src="images/hua320.png" /></div>
            <div class="upbg">
                <form id="form3" action="loadPicture.do?username=${username}" method="post" enctype="multipart/form-data" >
                    <input  id="content" class="stuurl" type="file"  name="id" accept="image/*" style="height:32px;" />
                    <span class="stsb">
                    <input  onclick="javascript:load()" type="submit" name="submit2" value="提 交 鉴 定" style="display:block;font-size:14px;text-align:center; vertical-align:middle;padding:9px;cursor:pointer"/>
                    </span>
                </form>
            </div>
            
            <div id="shitudiv" class="divshow" style="text-align:center;"></div>
            <div class="mt20">
               <div class='mb10'><table style='width:100%;'><tr><td class='tdstu'><a href="getAutoRecognizedPictures.do?id=${username}" class='ablock'>程序识别记录</a></td><td class='tdstu  tdstubg'><a href='getExpertRecognizedPictures.do?id=${username}'  class='ablock'>专家鉴定记录</a></td><td class='tdstu'><a href='getUnrecognizedPictures.do?id=${username}'  class='ablock'>未能识别记录</a></td></tr></table></div><div  class='item_list infinite_scroll'></div>
                      
                      
                  <c:forEach var="cls" items="${expert_recognized_photos}">   
	                <div class="img">
                    <a  href="sub5.do?id=${cls.getPictureID()}">
                     <img src=<%=basePath%>${cls.getPictureURL()} alt="Ballade" height=160px>
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