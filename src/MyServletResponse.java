import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("*.resp")
public class MyServletResponse extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // http://localhost:8080/hello.resp
        resp.addHeader("metacoding", "youtuber");
        resp.addHeader("Set-Cookie", "password=9999");
        resp.addHeader("Content-Type", "application/x-www-form-urlencoded");
        PrintWriter out = resp.getWriter();
        out.println("username=ssar&email=ssar@nate.com");
    }
}
