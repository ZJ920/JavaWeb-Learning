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
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //查询数据
        List<Brand> brands = brandService.selectAll();

        //序列化数据
        String toJSONString = JSON.toJSONString(brands);

        //响应数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(toJSONString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
