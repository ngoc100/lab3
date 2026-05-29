<%@ page import="model.User" %>

<%
User user =
(User) session.getAttribute("user");

if(user == null){
    response.sendRedirect("login");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>

<h2>
Xin chào <%= user.getUsername() %>
</h2>

</body>
</html>