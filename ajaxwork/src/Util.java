import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Util {
    static Dept search(int no) throws Exception{
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        Dept dept=null;
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("driver");
        String username = rb.getString("username");
        String password = rb.getString("password");
        String url = rb.getString("url");
        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            conn= DriverManager.getConnection(url,username,password);
            String sql="select no,name,loc,num from deptdetail where no = ?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,no);
            rs= ps.executeQuery();
            if (rs.next()){
                String name = rs.getString("name");
                String loc = rs.getString("loc");
                int num = rs.getInt("num");
                dept =new Dept(no,name,loc,num);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (rs!=null){
                rs.close();
            }
            if (ps!=null){
                ps.close();
            }
            if (conn!=null){
                conn.close();
            }
        }
        return dept;
    }

    static List<Dept> search() throws Exception{
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        Dept dept=null;
        List<Dept> deptList = new ArrayList<Dept>();
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("driver");
        String username = rb.getString("username");
        String password = rb.getString("password");
        String url = rb.getString("url");

        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            conn= DriverManager.getConnection(url,username,password);
            String sql="select no,name,loc,num from deptdetail";
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                int no = rs.getInt("no");
                String name = rs.getString("name");
                String loc = rs.getString("loc");
                int num = rs.getInt("num");
                dept = new Dept(no,name,loc,num);
                deptList.add(dept);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (rs!=null){
                rs.close();
            }
            if (ps!=null){
                ps.close();
            }
            if (conn!=null){
                conn.close();
            }
        }
        return deptList;
    }
}
