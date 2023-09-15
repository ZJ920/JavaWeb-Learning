package sdwz.zj.service;

import org.apache.ibatis.annotations.Param;
import sdwz.zj.pojo.Brand;
import sdwz.zj.pojo.PageBean;

import java.util.List;

public interface BrandService {

    /*
    查询所有
     */
    List<Brand> selectAll();

    /*
     * 添加
     * */
    int add(Brand brand);

    /*
     * 批量删除
     * */
    int deleteByIds(int[] ids);

    /*
    * 分页查询
    * */
    PageBean<Brand> selectByPage(int began, int size);

    /*
     * 分页条件查询
     * */
    PageBean<Brand> selectByPageAndCondition(int began,int size,Brand brand);
}
