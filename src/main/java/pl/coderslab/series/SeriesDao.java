package pl.coderslab.series;

import pl.coderslab.films.Film;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.Arrays;

public class SeriesDao {

    private final String findAll = "SELECT * FROM series";
    private final String DELETE_SERIES_BYID =
            "DELETE FROM users WHERE id = ?;";
    private final String CREATE_SERIES_QUERY =
            "INSERT INTO series(title, type, description, lastEp) VALUES(?, ?, ?, ?)";



    public Series[] seriesAll() {
        Series[] series = new Series[0];
        try (Connection conn = DbUtil.conWorkshop(); PreparedStatement statement = conn.prepareStatement(findAll);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                series = Arrays.copyOf(series, series.length + 1);
                Series series1 = new Series();
                series1.setId(resultSet.getInt("id"));
                series1.setTitle(resultSet.getString("title"));
                series1.setType(resultSet.getString("type"));
                series1.setDescription(resultSet.getString("description"));
                series1.setLastEp(resultSet.getString("lastEp"));
                series[series.length - 1] = series1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return series;
    }
    public void remove(int id) {
        try (Connection conn = DbUtil.conWorkshop(); PreparedStatement statement =
                conn.prepareStatement(DELETE_SERIES_BYID);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Series create(Series series) {
        try (Connection conn = DbUtil.conWorkshop(); PreparedStatement statement =
                conn.prepareStatement(CREATE_SERIES_QUERY, Statement.RETURN_GENERATED_KEYS);) {
            statement.setString(1, series.getTitle());
            statement.setString(2, series.getType());
            statement.setString(3, series.getDescription());
            statement.setString(4, series.getLastEp());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                series.setId(resultSet.getInt(1));
            }
            return series;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

