package sdwz.zj.web;

import sdwz.zj.pojo.User;
import sdwz.zj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("已转到LoginServlet");
        //1. 获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取复选框数据
        String remember = req.getParameter("remember");

        //查询用户
        UserService userService = new UserService();
        User user = userService.login(username, password);

        if (user != null){

            System.out.println("登录成功");

            if ("1".equals(remember)) {
                System.out.println("记住密码");
                Cookie cookieUserName = new Cookie("username",username);
                Cookie cookiePassword = new Cookie("password",password);
                cookieUserName.setMaxAge(60*60*24*7);
                cookiePassword.setMaxAge(60*60*24*7);

                resp.addCookie(cookieUserName);
                resp.addCookie(cookiePassword);
            }
            //将登陆成功后的user对象，存储到session
            System.out.println("将登陆成功后的user对象，存储到session");
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            req.getRequestDispatcher("/brandSelectAllServlet").forward(req,resp);
        }else {
            System.out.println("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
