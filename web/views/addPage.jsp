<%--
  Created by IntelliJ IDEA.
  User: Ruslan
  Date: 15.04.2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<div>
    <form action="/add" method="post">
        <label>Enter The Name : </label>
        <input type="text" name="name">
        <br>
        <label>Enter The Age : </label>
        <input type="number" name="age">
        <br>
        <label>Enter The Language : </label>
        <select name="language">
            <option>Java</option>
            <option>JavaScript</option>
            <option>PHP</option>
            <option>C++</option>
            <option>C</option>
            <option>C#</option>
            <option>PYTHON</option>
        </select>
        <br>
        <button type="submit">Save</button>
    </form>
</div>
<div>
    <button onclick="location.href='index.jsp'">Back</button>
</div>
</body>
</html>