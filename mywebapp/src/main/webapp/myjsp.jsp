<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP with Servlet example</title>
</head>
<body>
${textA}
${textB}
<br>
<%
    Enumeration flds = request.getParameterNames();
    if (!flds.hasMoreElements())
        out.print("No attributes");
    else {
        while (flds.hasMoreElements()) {
            String field = (String) flds.nextElement();
            String value = request.getParameter(field);
            out.print(field + " = " + value + "<br>");
        }
    }
%>

</body>
</html>
