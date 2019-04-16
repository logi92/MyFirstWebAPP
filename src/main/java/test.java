import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class test {
    public static void main(String[] args) {
        Connection connection;
        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user1","root","1234");
            Statement statement = connection.createStatement();
            statement.execute("SELECT * from users where id = 2");
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
