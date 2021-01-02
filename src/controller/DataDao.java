package controller;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * @author: Qin
 * @Date: 2021/1/2.
 */
public class DataDao extends DataSource{

    //添加的方法
    public void add(User user) throws ClassNotFoundException, SQLException{
        Connection con = null;
        //  预编译对象
        PreparedStatement ps= null;
        String sql = "insert into user(name,password,score) values(?,?,?)";
        try {
            con = this.getCon();
            ps = con.prepareStatement(sql);
            //    设置占位符对应的参数
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getScore());
            ps.executeUpdate();
        }finally {
            this.close(con, ps, null);
        }
    }
    //修改
    public void update(int score,int id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        //  预编译对象
        PreparedStatement ps= null;
        String sql = "update user set score = ? where id = ?";
        try {
            con = this.getCon();
            ps = con.prepareStatement(sql);
            //    设置占位符对应的参数
            ps.setInt(1, score);
            ps.setInt(2, id);
            ps.executeUpdate();
        }finally {
            this.close(con, ps, null);
        }
    }


//    //删除
//    public void delete(int sid) throws ClassNotFoundException, SQLException {
//        Connection con = null;
//        PreparedStatement ps= null;   //  预编译对象
//        String sql = "delete from Student where stuid = ?";
//        try {
//            con = this.getCon();
//            ps = con.prepareStatement(sql);
//            //    设置占位符对应的参数
//            ps.setInt(1, sid);
//            ps.executeUpdate();
//        }finally {
//            this.close(con, ps, null);
//        }
//    }

    //查询
    public List<User> findAll() throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<User>();
        String sql = "select * from user order by score desc ";
        try {
            con = this.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                User s = new User(rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(s);
            }
        }finally {
            this.close(con, ps, rs);
        }
        return list;
    }
    public User findByName(String name) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user where name = ?";
        User s = null;
        try {
            con = this.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while(rs.next()) {
                s = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        }finally {
            this.close(con, ps, rs);
        }
        return s;
    }
}