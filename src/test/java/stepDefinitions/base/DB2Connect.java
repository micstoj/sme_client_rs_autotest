package stepDefinitions.base;

import java.sql.*;

public class DB2Connect {
    public Connection ConnectToDb2(String url, String user, String password){
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Please include Classpath Where your DB2 Driver is located");
            e.printStackTrace();
            //return;
        }
        System.out.println("DB2 driver is loaded successfully");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset=null;
        boolean found=false;
        //String url = "jdbc:db2://og-r1.halcom.local:50000/EBSKB";
        //String user="ebank";
        //String password="ebank";
        try {
            conn = DriverManager.getConnection(url,user,password);
            if (conn != null)
            {
                System.out.println("DB2 Database Connected");
            }
            else
            {
                System.out.println("Db2 connection Failed ");
            }
        } catch (SQLException e) {
            System.out.println("DB2 Database connection Failed");
            e.printStackTrace();
            //return;
        }
        return conn;
    }
}
