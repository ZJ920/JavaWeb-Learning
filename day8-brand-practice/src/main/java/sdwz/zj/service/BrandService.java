package sdwz.zj.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sdwz.zj.mapper.BrandMapper;
import sdwz.zj.pojo.Brand;
import sdwz.zj.util.SqlSessionFactoryUtils;

import java.util.List;

public class BrandService {
    private static SqlSession sqlSession;

    //查询tb_brand中所有数据
    public static List<Brand> selectAll(){

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

//        for (Brand brand : brands){
//            System.out.println(brand);
//        }
        return brands;
    }
}
