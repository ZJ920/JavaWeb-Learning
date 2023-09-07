package request.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/respdemo4")
public class Demo4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4.doGet.....");
        //重定向
//        resp.setStatus(302);
//        resp.setHeader("Location","/day7-servlet-demo/respdemo5");

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/respdemo5");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
