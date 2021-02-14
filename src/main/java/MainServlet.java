import com.gourianova.binocularvision.apps.tetris.BVTetris;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet("/index")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        if (visitCounter == null) {
            visitCounter = 1;
        } else {
            visitCounter++;
        }
        visitCounter--;
        visitCounter--;
        session.setAttribute("visitCounter", visitCounter);
        String username = req.getParameter("username");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("<title>Servlet List of app</title>");
        out.write("</head>");
        out.write("<body>");

        out.write("Done!");

        if (username == null) {

            out.write("<center>"+"<h3>"+"Good day, Anonymous" + "<br>"+"before you'll got a contact, you should register "+"</h3>"+"</center>");
        } else {
            out.write("Good day, " + username + "<br>");
            BVTetris bvTetris=new BVTetris();
            bvTetris.run();
            out.write("Page was visited " +(-visitCounter) + " times.");
            //TODO: to stop the game when leave page or back-press
        }


      //  out.write("<br><img src='logo.jpg'/>");
       //out.write("<a href=\"index.html\">fractal</a>");


        out.write("</body>");
        out.write("</html>");
        out.close();
    }




}