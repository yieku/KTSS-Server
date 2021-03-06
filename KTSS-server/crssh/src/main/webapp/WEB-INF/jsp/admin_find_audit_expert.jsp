<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="cn.cqu.knowplants.controller.WebConstants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" >

<%@page import="java.util.ArrayList" %>
<title>main</title>
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
                                    全部待审核专家信息
          </td>
       </tr>
       
       <tr height="30">
          <td align="center"  class="header">
                                   专家用户名
          </td>
          
         
          
          <td align="center"  class="header">
                                  电话
          </td>
          
          <td align="center"  class="header">
                                  证明材料
          </td>
          
          <td align="center"  colspan="2" class="header">
                                  操作
          </td>
       </tr>
          
          <c:forEach var="cls" items="${all_audit_experts}">
     
            <tr height="30">
              <td align="center" class="data">
               <c:out value="${cls.getAuditExpertID()}" />
             
              </td>
              
             
              
              <td align="center" class="data">
              <c:out value="${cls.getAuditExpertPhone()}" />
              
              </td>
              
              <td align="center" class="data">
              <a href="adminFindAuditExpertMaterials.do?id=${cls.getAuditExpertID()}">查看</a>
              </td>
              
              <td align="center" class="data">
              <a href="addAuditExpert.do?id=${cls.getAuditExpertID()}">同意</a>
              </td>
              
              <td align="center" class="data">
               <a href="deleteAuditExpert.do?id=${cls.getAuditExpertID()}">拒绝</a>
              </td>
             </tr>
            </c:forEach>
        
       
       
      </table>
    </div>

</body>
</html>