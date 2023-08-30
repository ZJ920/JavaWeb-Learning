package day2.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC API 详解：Statement
 */
public class JDBCDemo {
    public static void main(String[] args) throws  Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///mybatis?useSSL=false";
        String username = "root";
        String password = "162278";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql = "SELECT * FROM tb_user";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5. 执行sql
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("username");
            int password1 = resultSet.getInt("password");
            String gender = resultSet.getString("gender");
            String addr = resultSet.getString("addr");

            System.out.println(id);
            System.out.println(name);
            System.out.println(password1);
            System.out.println(gender);
            System.out.println(addr);
            System.out.println("--------------------");
        }

        //7. 释放资源
        resultSet.close();
        stmt.close();
        conn.close();

    }

}
