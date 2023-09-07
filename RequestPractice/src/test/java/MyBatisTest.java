
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import sdwz.zj.mapper.UserMapper;
import sdwz.zj.pojo.User;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {

    @Test
    public void selectLoginTest() throws IOException {
        User user = new User();
        user.setUserName("zhangsan");
        user.setPassWord("123");

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectLogin(user);

            for (User user1 : users){
                System.out.println(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
