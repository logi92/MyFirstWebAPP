<%@ page import="app.entities.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ruslan
  Date: 15.04.2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<div align="center">
    <%
        List<User> list = (List<User>) request.getAttribute("listOfUsers");
        if (!list.isEmpty()) {
            out.println("<table border=\"1\" width=\"600\">\n" +
                    "    <tr><th>id</th><th>Name</th><th>Age</th><th>Language</th></tr>\n");
            for (int i = 0; i < list.size(); i++) {
                out.println("<tr><td>" + list.get(i).getId() + "</td><td>" + list.get(i).getName() + "</td" +
                        "><td>" + list.get(i).getAge() + "</td><td>" + list.get(i).getLanguage() + "</td><td" +
                        "><a href=\"/delete?getId=" + list.get(i).getId() + "\">delete</a></td>" + "" +
                        "<td><a href=\"/update?userId=" + list.get(i).getId() + "\">update</a></td></tr>");
            }
            out.println("</table>");
        }
    %>
</div>
<div>
    <button onclick="location.href='index.jsp'">Back</button>

</div>
</body>
</html>
