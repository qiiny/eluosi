package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: Qin
 * @Date: 2021/1/2.
 */
public class DataSource {

    private final String url = "jdbc:mysql://101.37.77.246:3306/MyBatisPlus?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&rewriteBatchedStatements=true";
    private final String user = "root";
    private final String password = "root";

    //定义一个数据库的链接变量用于存放对象
    public Connection getCon() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
    public void close(Connection con, Statement st, ResultSet rs) throws ClassNotFoundException, SQLException{
        if(rs != null) {
            rs.close();
        }
        if(st != null) {
            st.close();
        }
        if(con != null) {
            con.close();
        }
    }
}