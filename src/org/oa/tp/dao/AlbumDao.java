package org.oa.tp.dao;

import org.oa.tp.data.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Eugene on 02.06.2015.
 */
public class AlbumDao implements AbstractDao<Album> {

    private Connection connection;
    private Statement statement;

    public AlbumDao(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS test.album\n" +
                    "(\n" +
                    "    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
                    "    name VARCHAR(20) NOT NULL,\n" +
                    "    year INT NOT NULL\n" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Album> loadAll() {
        List<Album> albums = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.album");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");
                albums.add(new Album(id, name, year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    @Override
    public Album findById(long objectId) {
        Album album = null;
        try {
            ResultSet resultSet = statement.executeQuery("select * from test.album where id = " + objectId);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");
                album = new Album(id, name, year);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    @Override
    public boolean delete(int objectId) {
        try {
            statement.executeUpdate("delete from test.album where id = " + objectId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Album changed) {
        try {
            statement.executeUpdate("update test.album set" +
                    " name = '" + changed.getName() +
                    "', year = '" + changed.getYear() +
                    "' where id = " + changed.getId() + ";");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean add(Album item) {
        try {
            statement.executeUpdate("insert into test.album (name, year)" +
                    "values ('" + item.getName() + "','" + item.getYear()
                    + "')");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<Album> collection) {
        String sqlQuery = "INSERT INTO test.album (name, year)"
                + " VALUES ( ? , ? )";
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            for (Album album : collection) {
                statement.setString(1, album.getName());
                statement.setInt(2, album.getYear());
                statement.executeUpdate();
            }

            connection.commit();
            connection.setAutoCommit(true);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return false;
    }
}
