package day2.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MyDemo {
    public static void main(String[] args) throws Exception {
        int id = 4;

        //1. 获取Connection
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5. 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //----------------------------------------------------------------------------------------------------------
        //2. 定义SQL
        String sql = " delete from tb_brand where id = ?";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //----------------------------------------------------------------------------------------------------------

        //4. 设置参数
        pstmt.setInt(1, id);

        //5. 执行SQL
        int count = pstmt.executeUpdate();

        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        if (count > 0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        //7. 释放资源
        pstmt.close();
        conn.close();
    }
}
