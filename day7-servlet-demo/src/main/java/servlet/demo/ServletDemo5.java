package servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo5")
public class ServletDemo5 extends MyServlet {
    @Override
    protected void doGet(ServletRequest req, ServletResponse res) {
        System.out.println("ServletDemo5:get。。。。");
    }

    @Override
    protected void doPost(ServletRequest req, ServletResponse res) {
        System.out.println("ServletDemo5:post。。。。");
    }
}
