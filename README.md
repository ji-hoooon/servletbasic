# 서블릿 기본
- 서블릿은 HttpServlet 클래스를 상속받아서 작성하며, HTTP 요청을 처리하기 위해 service() 메서드를 오버라이딩 한다.
- service() 메서드는 요청 방식(GET, POST 등)에 따라서 적절한 메서드(doGet(), doPost() 등)를 호출한다.
- 즉, service(), doGet(), doPost() 등의 메서드를 오버라이딩하고, 해당 메서드에서 요청 처리 로직을 구현한다. 
- 서블릿에서는 하나의 URL 요청당 하나의 클래스가 필요하지만, 스프링에서는 하나의 클래스 내에서 여러 개의 메서드를 사용해 요청을 처리할 수 있다.

```java
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hello, World!");
    }
}
```

```java
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

- http request header 살펴보기
  - Request method (HTTP 요청 방법)
  - Request URL (HTTP 요청 URL)
  - Request headers (HTTP 요청 헤더)
  - Request body (HTTP 요청 본문)
- http request 정보 tomcat 메서드로 살펴보기
  - 소켓을 만들면 파싱을 직접해야 하지만, 톰캣이 파싱을 하고 파싱한 데이터를 이용한다.
  - 톰캣 메서드로 파싱한 데이터에 접근한다.
  - ```java
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
        System.out.println("getLocale(클라이언트의 지역정보): "+req.getLocale());

- http request body 살펴보기
  - 톰캣이 파싱해서 버퍼에 저장한 데이터를 순차적으로 읽는다.
  - 톰캣 버퍼에 저장된 데이터가 요청의 본문이 된다.
- http response 살펴보기
  - 응답 본문이 있을 경우, 응답 본문의 MIME 타입을 헤더의 CONTENT-TYPE으로 명시해준다.
  - resp.getWriter() 메소드를 이용해 응답 본문을 작성하는 객체를 얻는다.
  - PrintWriter는 BufferedWriter와 OutputStreamWriter의 기능을 모두 수행하는 클래스로 쉽게 버퍼에 쓸 수 있다.
  - 반대로 버퍼를 읽기 위해서 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader("내용"));를 이용한다.
