package sdwz.zj.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*使用：反射机制
*原理：所有Servlet都继承了该类，所以所有请求都将调用该service方法
*作用：根据URL判断需要使用的service方法
* */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        String requestURI = req.getRequestURI();// brand-case/brand/selectAll
        //1.1 截取方法名
        String[] split = requestURI.split("/");
        String methodName = split[split.length-1];
        System.out.println("(经过：BaseServlet)使用了方法："+methodName);

        //2.执行方法
        //2.1 获取方法对象：反射
        //2.1.1获取BrandServlet、UserServlet字节码对象
        Class<? extends BaseServlet> clazz = this.getClass();
        //2.1.2根据字节码对象获取方法对象
        try {
            //getMethod():methodName-方法名称、其余参数-方法参数类型的字节码文件
            //这里将 res、resp 作为 参数 传到对应方法以提供 请求的数据 和 响应的数据
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            /*method：执行的方法
            this：执行方法的实例类对象
            req,resp：请求的数据 和 响应的数据
            */
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
