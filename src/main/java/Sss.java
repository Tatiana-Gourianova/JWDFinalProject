//import javax.faces.context.FacesContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

@WebServlet(urlPatterns = "/sss")

public class Sss extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Sss:Servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Description & contacts</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("  W e&nbsp;&nbsp;r e p r e s e n t&nbsp;&nbsp;t h e&nbsp;&nbsp;s c o p e&nbsp;&nbsp;o f&nbsp;&nbsp;m e d i c a l&nbsp;&nbsp;a p p s&nbsp;&nbsp;f o r&nbsp;&nbsp;t h e&nbsp;&nbsp;t r a i n i n g  a n d&nbsp;&nbsp;r e h a b i l i t a t i o n&nbsp;&nbsp;o f&nbsp;&nbsp;d i s o r d e r s&nbsp;&nbsp;o f&nbsp;&nbsp;b i n o c u l a r&nbsp;&nbsp;" +
                     "&nbsp;&nbsp;( i n c l u d i n g  s t e r e o s c o p i c )&nbsp;&nbsp;a n d&nbsp;&nbsp;m o n o c u l a r&nbsp;&nbsp;v i s i o n" +
                     "&nbsp;&nbsp;( w i t h&nbsp;&nbsp;s t r a b i s m u s&nbsp;&nbsp;a n d&nbsp;&nbsp;a m b l y o p i a ) ,"+
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "&nbsp;&nbsp;t h e&nbsp;&nbsp;p r e v e n t i o n&nbsp;&nbsp;o f&nbsp;&nbsp;t h e s e&nbsp;&nbsp;d i s o r d e r s&nbsp;&nbsp;i n&nbsp;&nbsp;h e a l t h y  i n d i v i d u a l s ,"+
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "&nbsp;&nbsp;a s&nbsp;&nbsp;w e l l&nbsp;&nbsp;a s&nbsp;&nbsp;  d e v e l o p i n g&nbsp;&nbsp;a p p s&nbsp;&nbsp;f o r&nbsp;&nbsp;t h e&nbsp;&nbsp;s t i m u l a t i o n&nbsp;&nbsp;o f&nbsp;&nbsp;s e n s o r y - m o t o r&nbsp;&nbsp;m e c h a n i s m s&nbsp;&nbsp;a n d&nbsp;&nbsp;i m p r o v e&nbsp;&nbsp;c o o r d i n a t i o n&nbsp;&nbsp;a n d&nbsp;&nbsp;l o g i c a l&nbsp;&nbsp;t h i n k i n g&nbsp;&nbsp;i n&nbsp;&nbsp;c h i l d r e n&nbsp;&nbsp;o f&nbsp;&nbsp;p r e s c h o o l&nbsp;&nbsp;a n d&nbsp;&nbsp;s c h o o l&nbsp;&nbsp;a g e"+
                    "D e v e l o p m e n t&nbsp;&nbsp;a p p r o a c h&nbsp;&nbsp;a n d&nbsp;&nbsp;p r i o r i t i e s"+
                    "T e a m&nbsp;&nbsp;o b j e c t i v e s :"+
                    "P e r f o r m&nbsp;&nbsp;l a r g e - s c a l e&nbsp;&nbsp;r e s e a r c h&nbsp;&nbsp;a n d&nbsp;&nbsp;  c e r t i f y&nbsp;&nbsp;i t"+
                    "v s ."+
                    "I n t r o d u c e&nbsp;&nbsp;o u r&nbsp;&nbsp;p r o d u c t&nbsp;&nbsp;a s&nbsp;&nbsp;a&nbsp;&nbsp;m e d i c a l&nbsp;&nbsp;r e m e d y  ");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }



        System.out.println("get method sss servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post method sss servlet");

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();

        String login = null;
        Principal usernamePrincipal = req.getUserPrincipal();
        if (usernamePrincipal != null)
            login = usernamePrincipal.getName();

        printWriter.println(login);
    }
}
