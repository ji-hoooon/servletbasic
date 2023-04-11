import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("*.bu")
public class MyServletBuffer extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // PostMan 으로 Post 요청
        // http://localhost:8080/hello.bu
        // 아파치/톰켓은 TCP에 연결된 소켓으로 정보를 읽어드린다.
        // 읽어 드린 정보를 다시 Servlet.java 파일에 넘겨주는데 크게 두분류로 나뉜다.
        // 1. header 정보, 2. body 정보 (body 정보는 getReader()를 통해서 읽는다.)
        BufferedReader br = req.getReader(); // 이 버퍼는 소켓 버퍼를 읽는게 아니라, 아파치/톰켓이 만든 버퍼에 접근
        StringBuilder sb = new StringBuilder();
        while(true){
            String input = br.readLine();
            if(input == null){
                break;
            }else{
                sb.append(input);
            }
        }
        System.out.println("1. 버퍼에 담긴 http body 데이터");
        System.out.println(sb.toString());
        System.out.println("2. header 정보");
        Enumeration<String> requestHeaderNames = req.getHeaderNames();
        while (requestHeaderNames.hasMoreElements()){
            String headerName = requestHeaderNames.nextElement();
            String value = req.getHeader(headerName);
            System.out.println(headerName+" : "+value);
        }
    }
}
