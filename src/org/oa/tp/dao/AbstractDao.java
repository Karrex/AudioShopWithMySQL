package org.oa.tp.dao;

import java.util.Collection;
import java.util.List;

/**
 * Created by Eugene on 02.06.2015.
 */
public interface AbstractDao<T> {
    List<T> loadAll();

    T findById(long objectId);

    boolean delete(int objectId);

    boolean update(T changed);

    boolean add(T item);

    boolean addAll(Collection<T> collection);
}
