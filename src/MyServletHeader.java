import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

@WebServlet("*.he")
public class MyServletHeader extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // http://localhost:8080/hello.he
        Enumeration<String> requestHeaderNames = req.getHeaderNames();
        while (requestHeaderNames.hasMoreElements()){
            String headerName = requestHeaderNames.nextElement();
            String value = req.getHeader(headerName);
            System.out.println(headerName+" : "+value);
        }


    }
}
