package sdwz.zj.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sdwz.zj.mapper.BrandMapper;
import sdwz.zj.pojo.Brand;
import sdwz.zj.pojo.PageBean;
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

    @Override
    public int deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int row = mapper.deleteByIds(ids);

        sqlSession.commit();
        sqlSession.close();

        return row;
    }

    @Override
    public PageBean<Brand> selectByPage(int began, int size) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //查询到的数据
        List<Brand> rows = mapper.selectByPage(began, size);

        //数据库数据总数
        //Integer防止查询不到数据null
        int totalCount = 0 ;
        if (mapper.selectTotalCount() != null){
            totalCount = mapper.selectTotalCount();
        }

        sqlSession.close();

        return new PageBean<>(totalCount,rows);
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int began, int size, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //模糊查询
        if (brand.getCompanyName() != null && brand.getCompanyName().length() > 0){
            brand.setCompanyName("%"+brand.getCompanyName()+"%");
        }
        if (brand.getBrandName() != null && brand.getBrandName().length() > 0){
            brand.setBrandName("%"+brand.getBrandName()+"%");
        }
        System.out.println("(BrandService)brand:"+brand);

        //查询
        List<Brand> rows = mapper.selectByPageAndCondition(began, size, brand);
        //Integer防止查询不到数据null
        int totalCount = 0;
        System.out.println("mapper.selectTotalCountByCondition(brand):"+mapper.selectTotalCountByCondition(brand));
        if (mapper.selectTotalCountByCondition(brand) != null){
            totalCount = mapper.selectTotalCountByCondition(brand);
        }

        sqlSession.close();

        return new PageBean<>(totalCount,rows);
    }
}
