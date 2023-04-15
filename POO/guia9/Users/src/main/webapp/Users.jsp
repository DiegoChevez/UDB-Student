<%@ page import="sv.edu.udb.users.UserDatos" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="sv.edu.udb.users.beans.UserBeans" %><%--
  Created by IntelliJ IDEA.
  User: Erick
  Date: 30/3/2023
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  UserDatos data = new UserDatos();
  ArrayList<UserBeans> lista = (ArrayList<UserBeans>) data.listar();
  for (UserBeans e: lista){

%>


</body>
</html>
