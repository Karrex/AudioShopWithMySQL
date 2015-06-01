package org.oa.tp.dao;

import org.oa.tp.data.Album;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
            statement.execute("CREATE TABLE test.album\n" +
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
        return null;
    }

    @Override
    public Album findById() {
        return null;
    }

    @Override
    public boolean delete(int objectId) {
        return false;
    }

    @Override
    public boolean update(Album changed) {
        return false;
    }

    @Override
    public boolean add(Album add) {
        return false;
    }

    @Override
    public boolean addAll(Collection<Album> collection) {
        return false;
    }
}
