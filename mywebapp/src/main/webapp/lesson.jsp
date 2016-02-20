<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Мой первый EJB</title>
</head>
<body>
${result}
<%= session.getAttribute("result")%>
<br>

<form action="testclient" method="post">
    Enter your name:<input type="text" name="name" value=""/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
