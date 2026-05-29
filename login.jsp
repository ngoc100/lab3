<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>

<style>

body{
    font-family:Arial;
}

.container{
    width:400px;
    margin:50px auto;
    border:1px solid #ddd;
    padding:20px;
}

input{
    width:100%;
    padding:10px;
    margin:10px 0;
}

button{
    width:100%;
    padding:10px;
    background:#0d6efd;
    color:white;
    border:none;
}

.error{
    background:#f8d7da;
    color:#842029;
    padding:10px;
    margin-bottom:10px;
}

</style>
</head>
<body>

<div class="container">

<h2>Đăng Nhập</h2>

<%
String error =
(String)request.getAttribute("error");

if(error != null){
%>

<div class="error">
    <%= error %>
</div>

<%
}
%>

<form action="login" method="post">

<input
type="text"
name="username"
placeholder="Tên đăng nhập"
required>

<input
type="password"
name="password"
placeholder="Mật khẩu"
required>

<button type="submit">
Đăng nhập
</button>

</form>

</div>

</body>
</html>