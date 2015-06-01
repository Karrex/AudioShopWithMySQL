package org.oa.tp.dao;

import org.oa.tp.data.Order;

import java.util.Collection;
import java.util.List;

/**
 * Created by Eugene on 02.06.2015.
 */
public class OrderDao implements AbstractDao<Order> {
    @Override
    public List<Order> loadAll() {
        return null;
    }

    @Override
    public Order findById() {
        return null;
    }

    @Override
    public boolean delete(int objectId) {
        return false;
    }

    @Override
    public boolean update(Order changed) {
        return false;
    }

    @Override
    public boolean add(Order add) {
        return false;
    }

    @Override
    public boolean addAll(Collection<Order> collection) {
        return false;
    }
}
