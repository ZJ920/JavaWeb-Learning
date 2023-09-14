package sdwz.zj.web;

import com.alibaba.fastjson.JSON;
import sdwz.zj.pojo.Brand;
import sdwz.zj.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brandSelectAllServlet")
public class BrandSelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 调用BrandService完成查询
        List<Brand> brands = BrandService.selectAll();
//        for (Brand brand : brands){
//            System.out.println(brand);
//        }

        //2. 存入request域中
        //req.setAttribute("brands",brands);

        //3. 转发到brand.jsp
        //req.getRequestDispatcher("/jsp/brand.jsp").forward(req,resp);

        //2. 将集合转换为JSON数据   序列化
        String jsonString = JSON.toJSONString(brands);

        //3. 响应数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
