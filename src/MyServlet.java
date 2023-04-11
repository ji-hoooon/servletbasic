import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // http://localhost:8080/hello.do?username=ssar
        System.out.println("request 요청됨");
        System.out.println("getRequestURI : " + req.getRequestURI());
        System.out.println("getContextPath : "+req.getContextPath());
        System.out.println("getMethod : "+req.getMethod());
        System.out.println("getRequestURL : "+req.getRequestURL());
        System.out.println("getQueryString : "+req.getQueryString());
        System.out.println("getParameter : "+req.getParameter("username"));
        System.out.println("getSession().getId() : "+req.getSession().getId());
        System.out.println("getCharacterEncoding : "+req.getCharacterEncoding());
        System.out.println("getContentLength : "+req.getContentLength());
        System.out.println("getContentType : "+req.getContentType());
        System.out.println("Cookie Start ==============================");
        for (Cookie cookie : req.getCookies()) {
            System.out.print(cookie.getName()+" = " + cookie.getValue());
            System.out.print(";");
        }
        System.out.println();
        System.out.println("Cookie End ==============================");
        System.out.println("getProtocol : "+req.getProtocol());
        System.out.println("getServerPort : "+req.getServerPort());
        System.out.println("getLocalAddr(서버 IP) : "+req.getLocalAddr());
        System.out.println("getLocalName(서버 이름) : "+req.getLocalName());
        System.out.println("getRemoteAddr(요청자 IP) : "+req.getRemoteAddr());
        System.out.println("getRemoteUser(요청자 이름) : "+req.getRemoteUser());
        System.out.println("getRemotePort(요청자 포트) : "+req.getRemotePort());
        System.out.println("getLocale : "+req.getLocale());
    }
}
