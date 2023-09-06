package servlet.demo;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

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
