package app.modul;

import app.entities.User;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private static UserDB ourInstance = new UserDB();

    public static UserDB getInstance() {
        return ourInstance;
    }

    private UserDB() {
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user1?useSSL=false", "root", "1234");
            if (!connection.isClosed()) {
                System.out.println("Connection Successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int add(User user) {
        int status = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into users (name,age,language) values (?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getLanguage());
            status = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));
                user.setLanguage(resultSet.getString(4));
                list.add(user);
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void deleteUser(int id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from users where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int updateUser(User user) {
        int status = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users set name=?,age=?,language=? where id = " + user.getId());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getLanguage());
            status = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public User getUserById(int id) {
        User user = new User();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from users where id = " + id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));
                user.setLanguage(resultSet.getString(4));
            }
            connection.close();
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
