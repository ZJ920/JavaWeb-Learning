package sdwz.zj.select;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sdwz.zj.mapper.UserMapper;
import sdwz.zj.pojo.User;
import sdwz.zj.util.GetSqlSessionFactory;
import java.io.IOException;
import java.util.List;

public class SelectLogin {
    public static boolean selectLogin(User user) throws IOException {

        SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectLogin(user);

            if (users.size() == 0){
                System.out.println("查询失败...");

                return false;
            }else {
                for (User user1 : users){
                    System.out.println(user1);
                }
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }
}
