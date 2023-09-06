package servlet.demo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        System.out.println("MyServlet.servlet：day7-servlet-demo/src/main/java/servlet/demo/MyServlet.java");

        // 根据请求方式的不同，进行分别的处理

        HttpServletRequest request = (HttpServletRequest) req;

        //1. 获取请求方式
        String method = request.getMethod();
        //2. 判断
        if("GET".equals(method)){
            // get方式的处理逻辑

            doGet(req,resp);
        }else if("POST".equals(method)){
            // post方式的处理逻辑

            doPost(req,resp);
        }
    }
    protected void doPost(ServletRequest req, ServletResponse resp){
        System.out.println("经过doPost：day7-servlet-demo/src/main/java/servlet/demo/MyServlet.java");
    }
    protected void doGet(ServletRequest req, ServletResponse resp){
        System.out.println("经过doGet：day7-servlet-demo/src/main/java/servlet/demo/MyServlet.java");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
