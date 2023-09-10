package sdwz.zj.web.filter;

import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;

        String[] urls = {"/jsp/login.jsp","/img/","/css/","/loginServlet"};

        String url = req.getRequestURL().toString();
        System.out.println("url:"+url);

        for (String u : urls) {
            if(url.contains(u)){
                //找到了
                //放行
                System.out.println("找到了，放行");
                chain.doFilter(request, response);
                //break;
                return;
            }
        }


        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        System.out.println("session："+user);

        if (user != null){
            //已经登录过，放行
            System.out.println("已经登录过，放行");
            chain.doFilter(request, response);
        }else {
            //跳转到登录界面
            System.out.println("跳转到登录界面");
            req.setAttribute("login_msg","请先登录");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req,response);
        }


    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
