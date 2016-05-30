<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="cn.cqu.knowplants.controller.WebConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<link href="css/style.css" rel="stylesheet" type="text/css" >
</head>
<body>

    
     <div align="center">
       <table width="600" cellpadding="1" cellspacing="1">
       <tr>
         <td colspan="9" align="right" height="30">
           <a href="#">管理员   你好哈</a>
         </td>
       </tr>
     </table>
     
     <table width="600" cellpadding="1" cellspacing="1">
       <tr> 
          <td colspan="9" align="center" class="title" height="30">
                                    全部未识别图片信息
          </td>
       </tr>
       
       <tr height="30">
          <td align="center"  class="header">
                                   图片ID
          </td>
          
          <td align="center"  class="header">
                                  图片对应的植物名字
          </td>
          
          <td align="center"  class="header">
                                  上传时间
          </td>
          
          <td align="center"  class="header">
                                  上传者
          </td>
          
          <td align="center"  colspan="2" class="header">
                                  操作
          </td>
       </tr>
       
      <c:forEach var="cls" items="${unrecognized_photos}">
            <tr height="30">
              <td align="center" class="data">
              <c:out value="${cls.getPictureID()}" />
              
              </td>
              
              <td align="center" class="data">
              <c:out value="${cls.getPlantName()}" />
              </td>
              
              <td align="center" class="data">
              <c:out value="${cls.getPictureTime()}" />
              </td>
              
              <td align="center" class="data">
               <c:out value="${cls.getFarmID()}" />
              
              </td>
              
              <td align="center" class="data">
              <a href="showUnRecognizedPicture.do?id=${cls.getPictureID()}">查看</a>
              </td>
              
              <td align="center" class="data">
              <a href="deletePicture.do?id=${cls.getPictureID()}&type=<%="2"%> ">删除</a>
              </td>
           </tr>
         </c:forEach>     
             
       
       
      </table>
    </div>
  
</body>
</html>