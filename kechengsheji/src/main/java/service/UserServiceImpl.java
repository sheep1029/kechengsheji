package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

import java.sql.SQLException;

public class UserServiceImpl implements UserService{
private UserDao userDao = new UserDaoImpl();

    public Boolean isRegister(String userName, String password) {
//       User user =  userDao.queryByOne(userName,password);
//        if(user.getUserId()!=0){
//            System.out.println("用户名已存在，请重新输入用户名");
//            return false;}
//        else {
//            System.out.println("注册成功");
        try {
             userDao.AddUser(new User(userName,password));
            System.out.println("注册成功");
            return true;
        }
        catch (RuntimeException e){
            System.out.println("用户名已存在，请重新输入用户名");
            return false;
        }}
        public Boolean isLogin(String userName, String password) {
            User user =  userDao.queryByOne(userName,password);
            if(user.getUserId()!=0){
                System.out.println("登录成功");
                return true;}
            else {
                System.out.println("登录失败");
                return false;
            }


    }
}
