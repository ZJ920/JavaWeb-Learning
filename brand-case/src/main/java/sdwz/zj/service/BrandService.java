package sdwz.zj.service;

import sdwz.zj.pojo.Brand;

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

}
