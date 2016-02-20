package mywebapp.servlets.lesson;

import mywebapp.ejb.lesson.HelloWorldLocal;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestClient extends HttpServlet implements javax.servlet.Servlet {
    @EJB
    private HelloWorldLocal hello;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String result = hello.getMessage(request.getParameter("name"));
            request.getSession().setAttribute("result", result);
            RequestDispatcher rd = request.getRequestDispatcher( "lesson.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
