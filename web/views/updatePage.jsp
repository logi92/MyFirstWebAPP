<%@ page import="app.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: Ruslan
  Date: 15.04.2019
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("previousUser");

    out.println("<form action=\"/update\" method=\"post\">\n" +
            "    <input type=\"hidden\" name=\"userId\" value=\"" + user.getId() + "\">\n" +
            "    <label>User Name : </label>\n" +
            "    <input type=\"text\" name=\"name\" value = " + user.getName() + ">\n" +
            "    <br>\n" +
            "    <label>User Age : </label>\n" +
            "    <input type=\"number\" name=\"age\" value = " + user.getAge() + ">\n" +
            "    <br>\n" +
            "    <label>User Language : </label>\n" +
            "    <select name = \"language\">\n" +
            "<option>Java</option>\n" +
            "        <option>JavaScript</option>\n" +
            "        <option>PHP</option>\n" +
            "        <option>C++</option>\n" +
            "        <option>C</option>\n" +
            "        <option>C#</option>\n" +
            "        <option>PYTHON</option>\n" +
            "    </select>" +
            "    <br>\n" +
            "    <button type=\"submit\">Save</button>\n" +
            "</form>");
%>
<div>
    <button onclick="location.href='/list'">Back</button>
</div>
</body>
</html>
