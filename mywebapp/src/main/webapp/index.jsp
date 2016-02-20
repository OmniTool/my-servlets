<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlets + JSP</title>
</head>
<body>
<h1>Немного русского текста тут</h1>
Call the <a href="http://localhost:8080/mywebapp/ServletsRule"/>servlet ServletsRule</a>.
<br>
Call the <a href="http://localhost:8080/mywebapp/EchoForm"/>servlet EchoForm</a>.
<br>
Call the <a href="http://localhost:8080/mywebapp/ThreadServlet"/>servlet ThreadServlet</a>.
<br>
Call the <a href="http://localhost:8080/mywebapp/SessionPeek"/>servlet SessionPeek</a>.
<br>
Call the <a href="http://localhost:8080/mywebapp/MyServletsRule"/>servlet MyServletsRule</a>.
<br>
Call the <a href="http://localhost:8080/mywebapp/ServletWithCookie"/>servlet ServletWithCookie</a>.
<br>
Call the <a href="http://localhost:8080/mywebapp/MySessionPeek"/>servlet MySessionPeek</a>.
<br>
Call the <a href="http://localhost:8080/mywebapp/MyFirstJSP.jsp"/>jsp MyFirstJSP</a>.
<br>
Call the <a href="http://localhost:8080/mywebapp/MyServlet"/>jsp + servlet</a>.
<br>
<br>
<H2>The time in seconds is:
    <%= System.currentTimeMillis()/1000 %></H2>
<br>
</body>
</html>
