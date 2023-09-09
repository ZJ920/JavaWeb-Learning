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

    public static int add(Brand brand){

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int rows = mapper.add(brand);
        int id = brand.getId();

        System.out.println("插入的主键id:"+id);
        System.out.println("受影响的行数:"+rows);

        sqlSession.commit();
        sqlSession.close();

        return rows;
    }
}
