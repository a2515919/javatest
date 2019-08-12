package JavaEight;

import java.sql.*;

/**
 * @author ZHOU
 * @since 2019-08-12
 */
public class MySQLDemo {
    static final String JDBC_Driver="com.mysql.jdbc.Driver";
    static final String DB_URL=
            "jdbc:mysql://120.27.241.112:3306/RUNOOB?useUnicode=true&characterEncoding=UTF-8";
    static final String USER="root";
    static final String PASS="123456";
    public static void main(String[] args){
        Connection conn=null;
        Statement stmt=null;
        System.out.println("手动阀");
        try{
            //register the jdbc driver
            Class.forName(JDBC_Driver);
            System.out.println("connection the database");
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("instance the Statement object");
            stmt=conn.createStatement();
            String sql;
            sql="SELECT id,name,url FROM websites";
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt("id");
                String name =rs.getString ("name");
                String url=rs.getString("url");
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
            rs.close();
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
