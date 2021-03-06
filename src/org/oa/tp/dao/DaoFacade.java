package org.oa.tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Eugene on 02.06.2015.
 */
public class DaoFacade {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "toor";
    private final AlbumDao albumDao;
    private final AudioDao audioDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;
    private final OrderDao orderDao;
    private Connection connection;
    private Statement statement;

    public DaoFacade() {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection == null) {
            System.exit(1);
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        albumDao = new AlbumDao(connection, statement);
        authorDao = new AuthorDao(connection, statement);
        genreDao = new GenreDao(connection, statement);
        audioDao = new AudioDao(connection, statement);
        orderDao = new OrderDao(connection, statement);
    }

    public AlbumDao getAlbumDao() {
        return albumDao;
    }

    public AudioDao getAudioDao() {
        return audioDao;
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public GenreDao getGenreDao() {
        return genreDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
