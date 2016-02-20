<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP with Servlet example</title>
</head>
<body>
${textA}
<%= session.getAttribute("textA")%>
<br>
${textB}
<%= session.getAttribute("textB")%>
<br>
<br>
</body>
</html>
