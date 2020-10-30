package pl.coderslab.users;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class UserDao {
    private final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES(?, ?, ?);";
    private final String DELETE_USER_BYID =
            "DELETE FROM users WHERE id = ?;";
    private final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?;";
    private final String findAll = "SELECT * FROM users";
    private Scanner scan = new Scanner(System.in);

    public void editor(int id, String username, String email, String password) {
        try (Connection conn = DbUtil.conWorkshop();PreparedStatement statement =
                     conn.prepareStatement(UPDATE_USER_QUERY);) {
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        try (Connection conn = DbUtil.conWorkshop(); PreparedStatement statement =
                     conn.prepareStatement(DELETE_USER_BYID);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User[] usersAll() {
        User[] users = new User[0];
        try (Connection conn = DbUtil.conWorkshop();PreparedStatement statement = conn.prepareStatement(findAll);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users = Arrays.copyOf(users, users.length + 1);
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users[users.length - 1] = user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
        return users;
    }

    public User create(User user) {
        try (Connection conn = DbUtil.conWorkshop();PreparedStatement statement =
                conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User read(String param, String query) {
        try (Connection conn = DbUtil.conWorkshop();PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, param);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
