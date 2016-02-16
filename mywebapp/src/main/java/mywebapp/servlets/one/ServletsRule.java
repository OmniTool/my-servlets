package mywebapp.servlets.one;

/**
 * Created by OmniTool on 16.02.16.
 */
import javax.servlet.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/ServletsRule")
public class ServletsRule extends HttpServlet {
    int i = 0; // "постоянство" сервлета

    public void service(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("<HEAD><TITLE>");
        out.print("A server-side strategy");
        out.print("</TITLE></HEAD><BODY>");
        out.print("<h1>Servlets Rule! " + i++);
        out.print("</h1></BODY>");
        out.close();
    }
}
