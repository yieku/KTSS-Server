<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="cn.cqu.knowplants.controller.WebConstants" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/style.css" rel="stylesheet" type="text/css" >
<title>main</title>
</head>
<body>

  
  <div align="center">
      <table width="500" cellpadding="1" cellspacing="1">
         <tr>
            <td colspan="9" align="right" heoght="30">
              <a href="returnToAuditExpert.do">返回</a>
            </td>
         </tr>
      </table>
      
      
      <table width="500" cellpadding="1" cellspacing="1">
          <tr height="30">
            <td align="center" class="header" width="100">待审专家ID: </td>
            <td align="center" class="data">${audit_expert.getAuditExpertID()}</td>
          </tr>
          
          <tr height="200">
            <td align="center" class="header" width="100">证明材料</td>
            <td align="left"  valign="top" class="data">${audit_expert.getAuditExpertMaterial()}</td>
          </tr>
      
      </table>
     </div>
</body>
</html>