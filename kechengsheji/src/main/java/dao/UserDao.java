package dao;

import entity.User;

public interface UserDao {
    //查询单个

    /**
     *
     * @param username 用户名
     * @param password 密码
     * @return User 对象
     */
    User queryByOne(String username, String password);
    void AddUser(User user);
}
