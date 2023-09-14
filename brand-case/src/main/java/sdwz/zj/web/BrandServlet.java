package sdwz.zj.web;

import com.alibaba.fastjson.JSON;
import sdwz.zj.pojo.Brand;
import sdwz.zj.service.BrandService;
import sdwz.zj.service.impl.BrandServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("brand查询所有");

        //查询数据
        List<Brand> brands = brandService.selectAll();
        System.out.println("(经过了BrandServlet)查询了所有数据");
        //序列化数据
        String toJSONString = JSON.toJSONString(brands);

        //响应数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(toJSONString);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //System.out.println("brand添加");

        //获取请求数据
        BufferedReader brandReader = req.getReader();
        String brandStr = brandReader.readLine();
        Brand brand = JSON.parseObject(brandStr, Brand.class);

        //添加并获取受影响的行数
        int row = brandService.add(brand);
        System.out.println("(经过了BrandServlet)成功添加了："+row+"条数据");

        //返回受影响的行数：等于零则添加失败
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(Integer.toString(row));

    }
}
