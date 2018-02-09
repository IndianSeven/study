<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/16
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--单个文件上传:<br>--%>
<%--<form action="/upload" method="post" enctype="multipart/form-data">--%>
<%--<input type="file" name="file">--%>
<%--<input type="submit" value="提交上传">--%>
<%--</form>--%>


多文件上传
<form action="/uploads" method="post" enctype="multipart/form-data">
    文件一: <input type="file" name="file"/><br>
    文件二: <input type="file" name="file"/><br>
    文件三: <input type="file" name="file"/><br>
    <input type="submit" value="上传多个文件">
</form>
</body>
</html>
