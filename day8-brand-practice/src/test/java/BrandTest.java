import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.testng.annotations.Test;
import sdwz.zj.mapper.BrandMapper;
import sdwz.zj.pojo.Brand;
import sdwz.zj.util.SqlSessionFactoryUtils;

import java.io.IOException;
import java.util.List;


public class BrandTest {

    @Test
    public void selectAllTest() throws IOException {

        //查询tb_brand中所有数据
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

        for (Brand brand : brands) {
            System.out.println(brand);
        }

    }
}
