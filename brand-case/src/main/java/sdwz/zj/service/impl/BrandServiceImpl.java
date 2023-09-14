package sdwz.zj.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sdwz.zj.mapper.BrandMapper;
import sdwz.zj.pojo.Brand;
import sdwz.zj.service.BrandService;
import sdwz.zj.util.SqlSessionFactoryUtils;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }

    @Override
    public int add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //受影响的行数
        int row = mapper.add(brand);

        sqlSession.commit();
        sqlSession.close();
        return row;
    }
}
