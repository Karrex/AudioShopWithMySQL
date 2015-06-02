package org.oa.tp.dao;

import org.oa.tp.data.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Eugene on 02.06.2015.
 */
public class GenreDao implements AbstractDao<Genre> {

    private Connection connection;
    private Statement statement;

    public GenreDao(Connection connection, Statement statement) {
        this.statement = statement;
        this.connection = connection;
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS genre " +
                    "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name TEXT NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Genre> loadAll() {
        List<Genre> genres = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM genre");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Genre genre = new Genre(id, name);
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    @Override
    public Genre findById(long objectId) {
        Genre genre = null;
        try {
            ResultSet resultSet = statement.executeQuery("select * from genre where id = " + objectId);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                genre = new Genre(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genre;
    }

    @Override
    public boolean delete(int objectId) {
        try {
            statement.executeUpdate("DELETE FROM genre WHERE id = " + objectId + ";");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Genre changed) {
        try {
            statement.executeUpdate("update genre set "
                    + "name='" + changed.getName()
                    + "' where id = " + changed.getId() + ";");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean add(Genre item) {
        try {
            statement.executeUpdate("insert into genre (name) values ('" + item.getName() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<Genre> collection) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO genre (name) VALUES (?)");
            for (Genre genre : collection) {
                preparedStatement.setString(1, genre.getName());
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
