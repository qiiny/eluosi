package test;

import controller.DataDao;
import model.User;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Qin
 * @Date: 2021/1/2.
 */
public class test {
    @Test
    public void test(){
        DataDao dao = new DataDao();
        try {
            List<User> all = dao.findAll();
            System.out.println(all);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
