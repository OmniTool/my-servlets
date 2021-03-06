package mywebapp.servlets.two;

/**
 * Created by OmniTool on 17.02.16.
 *
 * Создайте сервлет, который изменяет интервал не активности сессии, устанавливая значение 5 секунд, с помощью вызова getMaxInactiveInterval( ).
 * Проверьте, чтобы посмотреть, что сессия в самом деле теряет силу через 5 секунд.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/MySessionPeek")
public class MySessionPeek extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Получаем объект Session до любой
        // посылки клиенту.
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(5);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<HEAD><TITLE> SessionPeek ");
        out.println(" </TITLE></HEAD><BODY>");
        out.println("<h1> SessionPeek </h1>");
        // Простой щетчик обращений для этой сессии.
        Integer ival = (Integer) session.getAttribute("sesspeek.cntr");
        if (ival == null)
            ival = new Integer(1);
        else
            ival = new Integer(ival.intValue() + 1);
        session.setAttribute("sesspeek.cntr", ival);
        out.println("You have hit this page <b>" + ival + "</b> times.<p>");
        out.println("<h2>");
        out.println("Saved Session Data </h2>");
        // Цикл по всем данным сессии:
        Enumeration sesNames = session.getAttributeNames();
        while (sesNames.hasMoreElements()) {
            String name = sesNames.nextElement().toString();
            Object value = session.getAttribute(name);
            out.println(name + " = " + value + "<br>");
        }
        out.println("<h3> Session Statistics </h3>");
        out.println("Session ID: " + session.getId() + "<br>");
        out.println("New Session: " + session.isNew() + "<br>");
        out.println("Creation Time: " + session.getCreationTime());
        out.println("<I>(" + new Date(session.getCreationTime()) + ")</I><br>");
        out.println("Last Accessed Time: " + session.getLastAccessedTime());
        out.println("<I>(" + new Date(session.getLastAccessedTime())
                + ")</I><br>");
        out.println("Session Inactive Interval: "
                + session.getMaxInactiveInterval());
        out.println("Session ID in Request: " + req.getRequestedSessionId()
                + "<br>");
        out.println("Is session id from Cookie: "
                + req.isRequestedSessionIdFromCookie() + "<br>");
        out.println("Is session id from URL: "
                + req.isRequestedSessionIdFromURL() + "<br>");
        out.println("Is session id valid: " + req.isRequestedSessionIdValid()
                + "<br> Waiting.... ");
        out.println("</BODY>");
        out.close();
    }

    public String getServletInfo() {
        return "A session tracking servlet";
    }
}
