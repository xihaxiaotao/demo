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
    
    <title>My JSP 'index.jsp' starting page</title>
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
     <c:if test="${userList==null }">
         <c:redirect url="UserServlet?opt=list&pageNum=1"></c:redirect>
     </c:if>
     <table border="1">
        <tr><td>编号</td><td>名称</td><td>操作</td></tr>
        <c:forEach var="user" items="${userList }">
           <tr><td>${user.userCode }</td><td>${user.userName }</td>
           <td><a href="add.jsp">添加</a>
           	   <a href="UserServlet?opt=info&id=${user.id }">修改</a>
           	   <a href="UserServlet?opt=delete&id=${user.id }">删除</a></td></tr>
        </c:forEach>
     </table>
     <a href="UserServlet?opt=list&pageNum=1">首页</a> 
     <c:if test="${page.pageNum<=1 }">
         <a href="UserServlet?opt=list&pageNum=1">上一页</a> 
     </c:if>
     <c:if test="${page.pageNum>1 }">
     <a href="UserServlet?opt=list&pageNum=${page.pageNum-1 }">上一页</a> 
     </c:if>
     <c:if test="${page.pageNum<page.pageCount }">
     <a href="UserServlet?opt=list&pageNum=${page.pageNum+1 }">下一页</a>
     </c:if>
     <c:if test="${page.pageNum>=page.pageCount }">
     <a href="UserServlet?opt=list&pageNum=${page.pageCount }">下一页</a>
     </c:if>    
     <a href="UserServlet?opt=list&pageNum=${page.pageCount }">末页</a> 
           当前页码：${page.pageNum }|共${page.pageCount }页
     <h2>${msg }</h2>
  </body>
</html>
