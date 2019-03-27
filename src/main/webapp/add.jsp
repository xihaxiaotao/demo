<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <c:if test="${user.id==null }">
         <h1>添加信息</h1>
         <form action="UserServlet?opt=add" method="post">
                       编号：<input type="text" name="userCode"><br/>
                       姓名：<input type="text" name="userName"><br/>
                 <input type="submit" value="提交">
         </form>
      </c:if>
      
      
       <c:if test="${user.id!=null }">
         <h1>修改信息</h1>
         <form action="UserServlet?opt=update&id=${user.id }" method="post">
                       编号：<input type="text" name="userCode" value="${user.userCode }"><br/>
                       姓名：<input type="text" name="userName" value="${user.userName }"><br/>
                 <input type="submit" value="提交">
         </form>
      </c:if>
     
      
  </body>
</html>
