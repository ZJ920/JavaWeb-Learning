package sdwz.zj.servlet;

import sdwz.zj.pojo.User;
import sdwz.zj.select.SelectLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet....");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        byte[] bytesUserName = username.getBytes(StandardCharsets.ISO_8859_1);
        username = new String(bytesUserName,StandardCharsets.UTF_8);

//        System.out.println(username);
//        System.out.println(password);

        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);

        boolean login = SelectLogin.selectLogin(user);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        if (login){
            writer.write("<h1>登录成功</h1>");
        }else {
            writer.write("<h1>登录失败</h1>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost....");
        doGet(req,resp);
    }
}
