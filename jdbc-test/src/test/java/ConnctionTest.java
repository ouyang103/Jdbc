import com.jdbc.test.JDBCUtils;
import com.jdbc.test.Jdbc;

import java.sql.Connection;

/**
 * @author yufei
 * @create 2018-12-09 17:46
 */
public class ConnctionTest {

    public static void main(String[] args) {

//        try {
//            Connection connection = JDBCUtils.getConnection();
//            System.out.println(connection);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        String sql = "insert into user(id,user_Name) value(1,'李四')";
//        try {
//            Jdbc.update(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String sql = "delete from user where id=?";
//        try {
//            int i = Jdbc.update(sql,1);
//            System.out.println("影响"+i+"行");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String sql = "update user u set u.user_Name=? where id=?";
//        try {
//            Jdbc.update(sql,"张三",1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String sql = "select user_Name from user where id = ?";
        try {
            String list = Jdbc.getList(sql, 1);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
