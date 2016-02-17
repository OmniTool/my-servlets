package mywebapp.servlets.two;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by OmniTool on 17.02.16.
 *
 * Создайте сервлет, который добавляет cookie в объект ответа, таким образом, хранит его на стороне клиента.
 * Добавьте код в сервлет, который получает и отображает cookie.
 */

@WebServlet("/ServletWithCookie")
public class ServletWithCookie extends HttpServlet{

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();

        out.print("<HEAD><TITLE>");
        out.print("A server-side strategy");
        out.print("</TITLE></HEAD><BODY>");
        out.print("<h1>Servlets & Cookie! ");

        for (Cookie c : cookies) {
            out.print("<br>Cookie : " + c + "<br>Name : " + c.getName() + "<br>Value : " + c.getValue());
        }

        out.print("</h1></BODY>");

        Cookie cookie = new Cookie("kuki", "JavaEEServlets2016");
        resp.addCookie(cookie);

        out.close();
    }
}
