package sdwz.zj.web.oldservlet;

import com.alibaba.fastjson.JSON;
import sdwz.zj.pojo.Brand;
import sdwz.zj.service.BrandService;
import sdwz.zj.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求数据
        BufferedReader brandReader = req.getReader();
        String brandStr = brandReader.readLine();
        Brand brand = JSON.parseObject(brandStr, Brand.class);

        //添加并获取受影响的行数
        int row = brandService.add(brand);
        System.out.println(row);

        //返回受影响的行数：等于零则添加失败
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(Integer.toString(row));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
