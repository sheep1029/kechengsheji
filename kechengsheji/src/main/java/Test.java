import service.UserService;
import service.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.isRegister("xzs123","123456"));
}}
