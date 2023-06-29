package Bank;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
	public static Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank"
                    ,"root","");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
