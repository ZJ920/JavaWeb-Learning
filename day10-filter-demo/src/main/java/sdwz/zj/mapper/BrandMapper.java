package sdwz.zj.mapper;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import sdwz.zj.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    /*
    * 查询所有
    * @return
    * */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /*
    * 添加
    * */
    int add(Brand brand);

}
