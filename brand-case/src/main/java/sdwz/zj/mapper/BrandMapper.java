package sdwz.zj.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import sdwz.zj.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    /*
    查询所有
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /*
     * 添加
     * */
    int add(Brand brand);

    /*
    * 批量删除
    * */
    int deleteByIds(@Param("ids") int[] ids);

    /*
    * 分页查询
    * */
    @ResultMap("brandResultMap")
    //@ResultMap("brandResultMap"代表要将查询到的数据封装成brand对象返回
    @Select("select * from tb_brand limit #{began},#{size}")
    List<Brand> selectByPage(@Param("began")int began,@Param("size")int size);

    /*
    * 统计数据库数据条数
    * */
    @Select("select count(*) from tb_brand")
    Integer selectTotalCount();

    /*
    * 分页条件查询
    * */
    List<Brand> selectByPageAndCondition(@Param("began")int began,@Param("size")int size,@Param("brand")Brand brand);

    /*
     * 统计数据库数据条数
     * */
    Integer selectTotalCountByCondition(Brand brand);
}
