package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Brand;

import java.util.HashMap;
import java.util.List;

public interface BrandMapper {

    //添加
    void add(Brand brand);

    void add1(HashMap<String,Brand> hashMap);

    List<Brand> selectAll();

    List<Brand> selectById(int id);

    //条件查询
    //#{}中的参数应该：
    //         1.与接口中的参数的注解名相同
    //         2.与对象的成员变量名相同
    //         3.与Map键值名相同
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    //对象
    List<Brand> selectByCondition1(Brand brand);

    //动态条件查询
    List<Brand> selectByCondition2(Brand brand);



}
