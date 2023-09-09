package sdwz.zj.web;

import sdwz.zj.pojo.Brand;
import sdwz.zj.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/brandAddServlet")
public class BrandAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        Integer ordered = Integer.parseInt(req.getParameter("ordered"));
        Integer status = Integer.parseInt(req.getParameter("status"));
        String description = req.getParameter("description");

        BrandService.add(new Brand(null,brandName,companyName,ordered,description,status));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
