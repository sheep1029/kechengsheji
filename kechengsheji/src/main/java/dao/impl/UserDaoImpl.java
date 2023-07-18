package dao.impl;

import com.example.kechengsheji.JDBCUtils;
import dao.UserDao;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public User queryByOne(String userName, String password) {
        JDBCUtils jdbc = new JDBCUtils();
        ResultSet rs = null;
        String sql = "select * from user where username = ? and password = ?";
        Object[] param = {userName, password};
        rs = jdbc.query(sql,param);

        User user = new User();

        try {
            while (rs.next()) {
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassWord((rs.getString(3)));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return user;
    }

    @Override
    public void AddUser(User user) {
        JDBCUtils jdbc = new JDBCUtils();
        Object[] obj ={user.getUserName(),user.getPassWord()};
        try {
            jdbc.update("insert into user (username,password)VALUES (?,?)",obj);
        }
        catch (RuntimeException e)
        {
            throw e;
        }

    }


}
