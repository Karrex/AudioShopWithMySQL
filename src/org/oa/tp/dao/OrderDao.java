package org.oa.tp.dao;

import org.oa.tp.data.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Eugene on 02.06.2015.
 */
public class OrderDao implements AbstractDao<Order> {

    private Connection connection;
    private Statement statement;

    public OrderDao(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS test.order\n" +
                    "(\n" +
                    "    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
                    "    goods TEXT NOT NULL,\n" +
                    "    dateOrder TEXT NOT NULL,\n" +
                    "    deliveryPeriod TEXT NOT NULL\n" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> loadAll() {
        List<Order> orders = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.`order`");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String goods = resultSet.getString("goods");
                String dateOrder = resultSet.getString("dateOrder");
                String deliveryPeriod = resultSet.getString("deliveryPeriod");
                orders.add(new Order(id, goods, dateOrder, deliveryPeriod));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order findById(long objectId) {
        Order order = null;
        try {
            ResultSet resultSet = statement.executeQuery("select * from `order` where id = " + objectId + ";");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String goods = resultSet.getString("goods");
                String dateOrder = resultSet.getString("dateOrder");
                String deliveryPeriod = resultSet.getString("deliveryPeriod");
                order = new Order(id, goods, dateOrder, deliveryPeriod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return order;
    }

    @Override
    public boolean delete(int objectId) {
        try {
            statement.executeUpdate("delete from `order` where id = " + objectId + ";");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Order changed) {
        try {
            statement.executeUpdate("update `order` set " +
                    "goods = '" + changed.getGoods() +
                    "', dateOrder = '" + changed.getDateOrder() +
                    "', deliveryPeriod = '" + changed.getDeliveryPeriod() +
                    "' where id = " + changed.getId() + ";");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean add(Order item) {
        try {
            statement.executeUpdate("insert into `order` (goods, dateOrder, deliveryPeriod)" +
                    "values ('" + item.getGoods() + "','" + item.getDateOrder() + "','" + item.getDeliveryPeriod()
                    + "')");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<Order> collection) {
        String sqlQuery = "INSERT INTO `order` (goods, dateOrder, deliveryPeriod)"
                + "VALUES ( ? , ? , ?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            for (Order order : collection) {
                preparedStatement.setString(1, order.getGoods());
                preparedStatement.setString(2, order.getDateOrder());
                preparedStatement.setString(3, order.getDeliveryPeriod());
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
