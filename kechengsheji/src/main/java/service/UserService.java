package service;

public interface UserService {
    /**
     *
     * @param userName 用户名
     * @param password 密码
     * @return 是否可以登录
     */
    Boolean isLogin(String userName ,String password);
    Boolean isRegister(String userName ,String password);
    /**
     *
     * @param userName 用户名
     * @param password 密码
     * @return 是否可以注册
     */
}
