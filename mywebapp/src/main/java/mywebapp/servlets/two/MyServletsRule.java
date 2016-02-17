package mywebapp.servlets.two; /**
 * Created by OmniTool on 16.02.16.
 *
 * Измените ServletsRule.java, перекрыв метод destroy( ), чтобы сохранить значение i в файле, и метод init( ), чтобы восстановить значение.
 */
import javax.servlet.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/MyServletsRule")
public class MyServletsRule extends HttpServlet {
    int i = 0; // "постоянство" сервлета
    String filename = "files/myServletRuleFiles/savedi.txt";

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

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            File file = new File(filename);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String s = reader.readLine();
                if (s != null) {
                    char[] arr = s.toCharArray();
                    StringBuilder sb = new StringBuilder();
                    for (Character c : arr) {
                        if (!Character.isDigit(c))
                            break;
                        sb.append(c);
                    }
                    if (sb.length() != 0)
                        i = Integer.parseInt(sb.toString());
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            File f = new File(filename);
            if (!f.exists()) {
                File dir = f.getParentFile();
                if (!dir.exists())
                    dir.mkdirs();
                f.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(String.valueOf(i));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
