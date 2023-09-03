import mapper.BrandMapper;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Brand;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MyBatisDemoTest {

    @Test
    public void selectAllTest() throws IOException {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();//
        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brand = brandMapper.selectAll();

        System.out.println(brand);
        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void selectByIdTest() throws IOException {
        int id = 1;
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();//
        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brand = brandMapper.selectById(id);

        System.out.println(brand);
        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void selectByConditionTest() throws IOException {
        int status = 1;
        String companyName = "%" + "华为" +"%";
        String brandName = "%" + "华为" +"%";
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();//
        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brand = brandMapper.selectByCondition(status,companyName,brandName);

        System.out.println(brand);
        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void selectByConditionTest1() throws IOException {
        int status = 1;
        String companyName = "%" + "华为" +"%";
        String brandName = "%" + "华为" +"%";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();//
        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brand1 = brandMapper.selectByCondition1(brand);

        System.out.println(brand1);
        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void selectByConditionTest2() throws IOException {
        int status = 1;
        String companyName = "%" + "华为" +"%";
        String brandName = "%" + "华为" +"%";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();//
        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brand2 = brandMapper.selectByCondition2(brand);

        System.out.println(brand2);
        //4. 释放资源
        sqlSession.close();
    }


    @Test
    public void add() throws IOException {
        int status = 1;
        String companyName = "魅族";
        String brandName = "魅族手机";
        int ordered = 100;
        String description ="魅族手机2023";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();//
        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //向数据库中添加数据
        brandMapper.add(brand);
        //获取id
        Integer id = brand.getId();
        System.out.println(id);
        sqlSession.commit();
        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void add1() throws IOException {
        int status = 1;
        String companyName = "魅族";
        String brandName = "魅族手机";
        int ordered = 100;
        String description ="魅族手机2023";

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setDescription(description);


        HashMap<String,Brand> hashMap = new HashMap<>();
        hashMap.put("brand",brand);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();//
        //3. 执行sql
        //List<User> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //向数据库中添加数据
        brandMapper.add1(hashMap);
        //获取id
        Integer id = brand.getId();
        System.out.println(id);
        sqlSession.commit();
        //4. 释放资源
        sqlSession.close();
    }
}
