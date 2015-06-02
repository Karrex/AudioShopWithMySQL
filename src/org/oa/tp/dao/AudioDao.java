package org.oa.tp.dao;

import org.oa.tp.data.Audio;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Eugene on 02.06.2015.
 */
public class AudioDao implements AbstractDao<Audio> {

    private Connection connection;
    private Statement statement;

    public AudioDao(Connection connection, Statement statement) {
        this.statement = statement;
        this.connection = connection;
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS audio" +
                    " (id INT PRIMARY KEY AUTO_INCREMENT," +
                    " name TEXT NOT NULL, " +
                    "authorId INTEGER NOT NULL," +
                    " duration INT NOT NULL," +
                    " price INT NOT NULL," +
                    " genreId INT NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Audio> loadAll() {
        List<Audio> audios = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM audio");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int authorId = resultSet.getInt("authorId");
                String name = resultSet.getString("name");
                int duration = resultSet.getInt("duration");
                int price = resultSet.getInt("price");
                int genreId = resultSet.getInt("genreId");
                Audio audio = new Audio(id, name, authorId, duration, price, genreId);
                audios.add(audio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return audios;
    }

    @Override
    public Audio findById(long objectId) {
        Audio audio = null;
        try {
            ResultSet resultSet = statement.executeQuery("select * from audio where id = " + objectId + ";");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int authorId = resultSet.getInt("authorId");
                String name = resultSet.getString("name");
                int duration = resultSet.getInt("duration");
                int price = resultSet.getInt("price");
                int genreId = resultSet.getInt("genreId");
                audio = new Audio(id, name, authorId, duration, price, genreId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return audio;
    }

    @Override
    public boolean delete(int objectId) {
        try {
            statement.executeUpdate("DELETE FROM audio WHERE id = " + objectId + ";");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Audio changed) {
        try {
            statement.executeUpdate("update audio set " +
                    "authorId = '" + changed.getAuthorId() +
                    "', name = '" + changed.getName() +
                    "', duration = '" + changed.getDuration() +
                    "', price = '" + changed.getPrice() +
                    "', genreId = '" + changed.getGenreId() +
                    "' where id = " + changed.getId() + ";");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean add(Audio item) {
        try {
            statement.executeUpdate("insert into audio (name, authorId,  duration, price, genreId)" +
                    "values ('" + item.getName() + "','" + item.getAuthorId() + "','" + item.getDuration()
                    + "','" + item.getPrice() + "','" + item.getGenreId()
                    + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<Audio> collection) {
        String sqlQuery = "INSERT INTO audio (name, authorId,  duration, price, genreId)"
                + "VALUES ( ? , ? , ? , ? , ?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            for (Audio audio : collection) {
                preparedStatement.setString(1, audio.getName());
                preparedStatement.setLong(2, audio.getAuthorId());
                preparedStatement.setInt(3, audio.getDuration());
                preparedStatement.setInt(4, audio.getPrice());
                preparedStatement.setLong(5, audio.getGenreId());
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return false;
        }
        return true;
    }
}
