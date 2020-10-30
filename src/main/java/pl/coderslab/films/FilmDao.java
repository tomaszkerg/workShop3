package pl.coderslab.films;

import pl.coderslab.users.User;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.Arrays;

public class FilmDao {

    private final String findAll = "SELECT * FROM films";
    private final String DELETE_FILM_BYID =
            "DELETE FROM films WHERE id = ?;";
    private final String CREATE_FILM_QUERY =
            "INSERT INTO films(title, year, type, description) VALUES(?, ?, ?, ?)";


    public Film[] filmsAll() {
        Film[] films = new Film[0];
        try (Connection conn = DbUtil.conWorkshop(); PreparedStatement statement = conn.prepareStatement(findAll);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                films = Arrays.copyOf(films, films.length + 1);
                Film film = new Film();
                film.setId(resultSet.getInt("id"));
                film.setTitle(resultSet.getString("title"));
                film.setYear(resultSet.getInt("year"));
                film.setType(resultSet.getString("type"));
                film.setDescription(resultSet.getString("description"));
                films[films.length - 1] = film;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
        return films;
    }
    public void remove(int id) {
        try (Connection conn = DbUtil.conWorkshop(); PreparedStatement statement =
                conn.prepareStatement(DELETE_FILM_BYID);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Film create(Film film) {
        try (Connection conn = DbUtil.conWorkshop(); PreparedStatement statement =
                conn.prepareStatement(CREATE_FILM_QUERY, Statement.RETURN_GENERATED_KEYS);) {
            statement.setString(1, film.getTitle());
            statement.setInt(2, film.getYear());
            statement.setString(3, film.getType());
            statement.setString(3, film.getDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                film.setId(resultSet.getInt(1));
            }
            return film;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
