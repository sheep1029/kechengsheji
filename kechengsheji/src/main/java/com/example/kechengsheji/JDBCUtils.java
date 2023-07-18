package com.example.kechengsheji;

import java.sql.*;

public class JDBCUtils {// 创建类Conn
    private  Connection con;// 声明Connection对象
    private   PreparedStatement ps;
    private    ResultSet rs;
    private  final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final String  URL ="jdbc:mysql://localhost:3306/stu_course";
    private final String USERNAME = "root";
    private final    String PASSWORD = "123456";

    /* 改 */
    public int update(String sql, Object... objects){
        con = getConnection();
        int rs = 0;
        try {
            ps = con.prepareStatement(sql);
            if(objects.length > 0){
                //有参数
                for(int i=0;i<objects.length;i++){
                    ps.setObject(i+1, objects[i]);
                }
            }
            rs = ps.executeUpdate();
            close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(rs > 0){
            System.out.println("修改成功");
            System.out.println("受影响的行数：" + rs );
        }
        else{
            System.out.println("修改失败");
        }
        return rs;
    }
    public  Connection getConnection() { // 建立返回值为Connection的方法
        try { // 加载数据库驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try { // 通过访问数据库的URL获取数据库连接对象
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("数据库连接成功");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;


        // 按方法要求返回一个Connection对象
    }
    public ResultSet query(String sql, Object... objects){
        con = getConnection();
        try {
            ps = con.prepareStatement(sql);
            if(objects.length > 0){
                //有参数
                for(int i=0;i<objects.length;i++){
                    ps.setObject(i+1, objects[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return rs;
    }



public void close() {
    try {

    if(rs!=null)
    rs.close();
    if(con!=null)
    con.close();
    if(ps!=null)
    ps.close();
    System.out.println("资源关闭成功");
}
catch(SQLException e ){
        e.printStackTrace();
    }


}}
